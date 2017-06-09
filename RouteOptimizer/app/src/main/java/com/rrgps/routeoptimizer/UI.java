package com.rrgps.routeoptimizer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;


public class UI extends AppCompatActivity {

    private FirebaseAuth mAuth;
    //private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);
        mAuth = LoginActivity.mAuth;
    }

    public void showCurr(View v){
        startActivity(new Intent(UI.this, MapsActivity.class));
    }

    public void logOutAction(View v) {
        try {
            mAuth.signOut();
            startActivity(new Intent(UI.this, LoginActivity.class));
        } catch (Exception e) {
            Toast.makeText(UI.this, R.string.log_out_failed,
                    Toast.LENGTH_SHORT).show();
        }
    }

    public void provideInfoAction(View view) {
        startActivity(new Intent(UI.this, UpdateAdmin.class));
    }
}
