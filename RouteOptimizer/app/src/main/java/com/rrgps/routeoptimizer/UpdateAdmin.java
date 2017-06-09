package com.rrgps.routeoptimizer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateAdmin extends AppCompatActivity {

    public static String startLatitudeString;
    public static String startLongitudeString;
    public static String endLatitudeString;
    public static String endLongitudeString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_admin);
    }

    public void nextAction(View view) {
        EditText startLatitude = (EditText)findViewById(R.id.StartLatitudeInput);
        EditText startLongitude = (EditText)findViewById(R.id.StartLongitudeInput);
        EditText endLatitude = (EditText)findViewById(R.id.EndLatitudeInput);
        EditText endLongitude = (EditText)findViewById(R.id.EndLongitudeInput);
        startLatitudeString = startLatitude.getText().toString();
        startLongitudeString = startLongitude.getText().toString();
        endLatitudeString = endLatitude.getText().toString();
        endLongitudeString = endLongitude.getText().toString();
        if(startLatitudeString.equals("") || startLongitudeString.equals("") ||
                endLatitudeString.equals("") || endLongitudeString.equals("")) {
            Toast.makeText(UpdateAdmin.this, R.string.enter_values,
                    Toast.LENGTH_SHORT).show();
        }
        else {
            Intent intent = new Intent(UpdateAdmin.this, UpdateAdmin2.class);
            startActivity(intent);
        }

    }

}
