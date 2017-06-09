package com.rrgps.routeoptimizer;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class StartScreenActivity extends FragmentActivity {

    public static FirebaseDatabase database = FirebaseDatabase.getInstance();
    public static DatabaseReference roads = database.getReference().child("Roads");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
        new CountDownTimer(3000, 1000){
            @Override
            public void onTick(long millisUntilFinished){

            }

            @Override
            public void onFinish(){
                Intent intent = new Intent(StartScreenActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        }.start();
    }
}
