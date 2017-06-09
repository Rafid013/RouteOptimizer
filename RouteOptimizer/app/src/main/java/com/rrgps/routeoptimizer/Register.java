package com.rrgps.routeoptimizer;

        import android.content.Intent;
        import android.support.annotation.NonNull;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.Toast;

        import com.google.android.gms.tasks.OnCompleteListener;
        import com.google.android.gms.tasks.Task;
        import com.google.firebase.auth.AuthResult;
        import com.google.firebase.auth.FirebaseAuth;
        import com.google.firebase.auth.FirebaseUser;

public class Register extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = LoginActivity.mAuth;
        mAuthListener = LoginActivity.mAuthListener;
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

    public void createAccount(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Toast.makeText(Register.this, R.string.auth_failed,
                                    Toast.LENGTH_SHORT).show();
                        }
                        else {
                            startActivity(new Intent(Register.this, UI.class));
                        }
                    }
                });
    }

    public void userRegisterAction(View view) {
        EditText email = (EditText)findViewById(R.id.EmailText);
        EditText password = (EditText)findViewById(R.id.PasswordText);
        EditText confirmPassword = (EditText)findViewById(R.id.ConfirmPasswordText);
        if((password.getText().toString()).equals(confirmPassword.getText().toString())) {
            createAccount(email.getText().toString(), password.getText().toString());
        }
        else {
            //show error
        }
    }
}