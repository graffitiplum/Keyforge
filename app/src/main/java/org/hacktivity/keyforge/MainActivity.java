/* BlumBlumShub.java: implementation of the Blum Blum Shub PRNG

  Copyright 2016 Graffiti Plum.

*/

package org.hacktivity.keyforge;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.hacktivity.BlumBlumShub;
import org.hacktivity.Base64;

public class MainActivity extends AppCompatActivity {

    private Button forgeButton;
    private EditText showPassword;
    private BlumBlumShub bbs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        forgeButton = (Button) findViewById(R.id.forgebutton);
        showPassword = (EditText) findViewById(R.id.showpassword);

        // TODO: make this happen in the background or display a "loading" page.
        bbs = new BlumBlumShub(4096);

        // Check if no view has focus:
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }


    /*
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );
    */

    }

    public void onClickForge(View view) {
        String pass = Base64.encodeBytes(bbs.randBytes(6));
        showPassword.setText(pass);
    }

}
