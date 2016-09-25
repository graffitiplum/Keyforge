/* BlumBlumShub.java: implementation of the Blum Blum Shub PRNG

  Copyright 2016 Graffiti Plum.

*/

package org.hacktivity.keyforge;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import java.security.*;
import javax.crypto.*;

import org.hacktivity.Base64;
import org.hacktivity.BlumBlumShub;

import java.security.MessageDigest;

public class MainActivity extends AppCompatActivity {

    private Button forgeButton;
    private EditText showPassword;
    private BlumBlumShub bbs;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        forgeButton = (Button) findViewById(R.id.forgebutton);
        showPassword = (EditText) findViewById(R.id.showpassword);

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

        //progressDialog = ProgressDialog.show(MainActivity.this,"Loading...",
             //   "Loading application View, please wait...", false, false);

        // TODO: THREADS???
        bbs = new BlumBlumShub(2310);

        //progressDialog.dismiss();

    }

    public void onClickForge(View view) throws NoSuchAlgorithmException {

        // TODO: organize this.
        MessageDigest md = MessageDigest.getInstance("SHA-224");;

        //String pass = Base64.encodeBytes(bbs.randBytes(6));
        md.update(bbs.randBytes(16384));

        showPassword.setText(Base64.encodeBytes(md.digest()).substring(0,8));
    }

}
