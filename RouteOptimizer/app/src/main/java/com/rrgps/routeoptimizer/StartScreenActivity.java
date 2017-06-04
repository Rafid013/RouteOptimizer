package com.rrgps.routeoptimizer;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

public class StartScreenActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
        //display the logo during 5 seconds,
        new CountDownTimer(3000, 1000){
            @Override
            public void onTick(long millisUntilFinished){

            }

            @Override
            public void onFinish(){
                Intent intent = new Intent(StartScreenActivity.this, MapsActivity.class);
                startActivity(intent);
            }
        }.start();
    }
}
