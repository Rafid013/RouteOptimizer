package com.rrgps.routeoptimizer;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class UpdateAdmin2 extends AppCompatActivity {


    Bundle extra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_admin2);
        extra = getIntent().getExtras();
    }
    public void submitAction(View view) {
        String startLatitude = extra.getString("sla");
        String startLongitude = extra.getString("slo");
        String endLatitude = extra.getString("ela");
        String endLongitude = extra.getString("elo");
        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.SeverityGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if(checkedId == R.id.Low) {
                    //System.out.println("LOW");
                    
                }
                else if(checkedId == R.id.Medium) {
                    //System.out.println("MEDIUM");
                }
                else {
                    //System.out.println("HIGH");
                }
            }
        });
    }
}
