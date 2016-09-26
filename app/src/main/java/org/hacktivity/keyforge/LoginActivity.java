package org.hacktivity.keyforge;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static org.hacktivity.keyforge.R.id.emailText;
import static org.hacktivity.keyforge.R.id.passwordText;

public class LoginActivity extends Activity {

    private Button onSubmitButton;
    private Intent intent;

    private EditText emailText;
    private EditText passwordText;

    private String email;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        emailText = (EditText) findViewById(R.id.emailText);
        passwordText = (EditText) findViewById(R.id.passwordText);

        email = emailText.getText().toString();
        password = passwordText.getText().toString();

    }

    public void onClickSubmitLogin(View view) {

        // TODO: Share email:password back to main activity

        email = emailText.getText().toString();
        password = passwordText.getText().toString();

        // TODO: NOT PASSING INFORMATION BETWEEN SCREENS!!!

        intent = getIntent();

        intent.putExtra("email", "TEST");
        intent.putExtra("password", password);

        // TODO: check for proper formatting ( @, .com, .org, .net, .etc )
        if ( (email != "") && (password != "") ) {
            setResult(RESULT_OK, intent);
        }
        else {
            setResult(RESULT_CANCELED, intent);
        }

        finish();
    }

}
