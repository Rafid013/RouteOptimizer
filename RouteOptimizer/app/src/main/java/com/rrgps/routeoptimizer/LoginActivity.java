package com.rrgps.routeoptimizer;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    public static FirebaseAuth mAuth;
    public static FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user != null) {
                    startActivity(new Intent(LoginActivity.this, UI.class));
            }
                else {

                }
            }
        };
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if(mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
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
            /*if (checkEmailExist(emailInput)) {
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
            }*/
            signIn(emailInput, passwordInput);
        }
    }

    public void registerAction(View view) {
        startActivity(new Intent(LoginActivity.this, Register.class));
    }

    /*private boolean checkEmailExist(String email) {
        /// database theke nite hobe
        return true;
    }

    private String getPassForEmail(String email) {
        //database theke nite hobe
        return "1";
    }*/

    public void signIn(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Toast.makeText(LoginActivity.this, R.string.sign_in_failed,
                                    Toast.LENGTH_SHORT).show();
                        }
                        else {
                            startActivity(new Intent(LoginActivity.this, UI.class));
                        }
                    }
                });
    }
}