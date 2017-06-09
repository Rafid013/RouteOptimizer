package com.rrgps.routeoptimizer;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.database.DatabaseReference;

public class UpdateAdmin2 extends AppCompatActivity {


    Bundle extra;

    String startLatitude;
    String startLongitude;
    String endLatitude;
    String endLongitude;
    RadioGroup radioGroup;
    int severity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_admin2);
        extra = getIntent().getExtras();
        startLatitude = UpdateAdmin.startLatitudeString;
        startLongitude = UpdateAdmin.startLongitudeString;
        endLatitude = UpdateAdmin.endLatitudeString;
        endLongitude = UpdateAdmin.endLongitudeString;
        radioGroup = (RadioGroup)findViewById(R.id.SeverityGroup);
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    public void submitAction(View view) {
        int checked = radioGroup.getCheckedRadioButtonId();
        if(checked == R.id.Low) {
            severity = 200;
        }
        else if(checked == R.id.Medium) {
            severity = 700;
        }
        else if(checked == R.id.High){
            severity = 1500;
        }
        else {
            Toast.makeText(UpdateAdmin2.this, R.string.check_button,
                    Toast.LENGTH_SHORT).show();
            return;
        }
        RoadInfo roadInfo = new RoadInfo(Double.parseDouble(startLatitude), Double.parseDouble(startLongitude),
                Double.parseDouble(endLatitude), Double.parseDouble(endLongitude), severity);
        DatabaseReference roads = StartScreenActivity.roads.push();
        roads.setValue(roadInfo);
        startActivity(new Intent(UpdateAdmin2.this, UI.class));
    }
}
