/* BlumBlumShub.java: implementation of the Blum Blum Shub PRNG

  Copyright 2016 Graffiti Plum.

*/

package org.hacktivity.keyforge;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.security.*;
import javax.crypto.*;

import org.hacktivity.Base64;
import org.hacktivity.BlumBlumShub;

import java.security.MessageDigest;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button forgeButton;
    private EditText etEmail;

    private ArrayList<String> pwList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent loginIntent = new Intent(this, LoginActivity.class);
        String email="";
        String password="";
        int result=1;

        forgeButton = (Button) findViewById(R.id.forgebutton);

        //TextView tvPassword = (TextView) findViewById(R.id.tvPassword)

        startActivityForResult(loginIntent, result);

        // Set view back to main activity
        setContentView(R.layout.activity_main);

        etEmail = (EditText) findViewById(R.id.etEmail);


        Intent intent = getIntent();
        email = loginIntent.getStringExtra("email");
        password = loginIntent.getStringExtra("password");

        etEmail.setText(email);
        //tvPassword.setText(password);
        //pwList.add(email);

    }

    public void onClickForge(View view) throws NoSuchAlgorithmException {

        // TODO: On Click, create dialog for password creation

        BlumBlumShub bbs;

        bbs = new BlumBlumShub(2310);

        // TODO: organize, embellish this.
        MessageDigest md = MessageDigest.getInstance("SHA-224");
        ;

        //String pass = Base64.encodeBytes(bbs.randBytes(6));
        md.update(bbs.randBytes(16384));

        etEmail.setText(Base64.encodeBytes(md.digest()).substring(0,8));
    }

}
