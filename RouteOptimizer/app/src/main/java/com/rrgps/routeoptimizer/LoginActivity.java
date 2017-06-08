package com.rrgps.routeoptimizer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void signInAction(View view) {
        EditText email = (EditText) findViewById(R.id.emailText);
        TextView emailError = (TextView) findViewById(R.id.EmailError);
        EditText password = (EditText) findViewById(R.id.passwordText);
        TextView passwordError = (TextView)findViewById(R.id.PasswordError);
        String emailInput = email.getText().toString();
        String passwordInput = password.getText().toString();
        if(emailInput.equals("")){
            //show error
            emailError.setVisibility(View.VISIBLE);
            passwordError.setVisibility(View.INVISIBLE);
        }
        else {
            if (checkEmailExist(emailInput)) {
                emailError.setVisibility(View.INVISIBLE);
                String passForEmail = getPassForEmail(emailInput);
                if (passForEmail.equals(passwordInput)) {
                    Intent intent = new Intent(LoginActivity.this, UI.class);
                    startActivity(intent);
                } else {
                    //show error
                    passwordError.setVisibility(View.VISIBLE);
                }
            } else {
                //show error
                emailError.setVisibility(View.VISIBLE);
                passwordError.setVisibility(View.INVISIBLE);
            }
        }
    }

    public void registerAction(View view) {

    }

    private boolean checkEmailExist(String email) {
        /// database theke nite hobe
        return true;
    }

    private String getPassForEmail(String email) {
        //database theke nite hobe
        return "1";
    }
}