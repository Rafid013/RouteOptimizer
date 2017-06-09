package com.rrgps.routeoptimizer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class UpdateAdmin extends AppCompatActivity {

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
        String startLatitudeString = startLatitude.getText().toString();
        String startLongitudeString = startLongitude.getText().toString();
        String endLatitudeString = endLatitude.getText().toString();
        String endLongitudeString = endLongitude.getText().toString();
        Bundle bundle = new Bundle();
        bundle.putString("sla", startLatitudeString);
        bundle.putString("slo", startLongitudeString);
        bundle.putString("ela", endLatitudeString);
        bundle.putString("elo", endLongitudeString);
        Intent intent = new Intent(UpdateAdmin.this, UpdateAdmin2.class);
        startActivity(intent);
    }

}
