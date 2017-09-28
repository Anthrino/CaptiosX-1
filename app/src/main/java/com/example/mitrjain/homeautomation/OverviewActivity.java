package com.example.mitrjain.homeautomation;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;

public class OverviewActivity extends AppCompatActivity {

    Switch master, lights_switch1, lights_switch2, lights_switch3;
    Integer switchCount = 0;
    ImageView light_icon1, light_icon2, light_icon3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);
        master = (Switch) findViewById(R.id.master_switch);
        lights_switch1 = (Switch) findViewById(R.id.lights_switch1);
        lights_switch2 = (Switch) findViewById(R.id.lights_switch2);
        lights_switch3 = (Switch) findViewById(R.id.lights_switch3);
        light_icon1 = (ImageView) findViewById(R.id.lights_image1);
        light_icon2 = (ImageView) findViewById(R.id.lights_image2);
        light_icon3 = (ImageView) findViewById(R.id.lights_image3);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
        public boolean onOptionsItemSelected(MenuItem item)
        {
            switch(item.getItemId())
            {
                case android.R.id.home:
                    onBackPressed();
                    break;
                default: System.out.println("Nothing");
            }
            return true;
        }


    public void switchTrigger(View v) throws Exception {
        Switch s = (Switch) v;
        if (s.getId() == R.id.master_switch) {
            if (master.isChecked()) {
                lights_switch1.setChecked(true);
                lights_switch2.setChecked(true);
                lights_switch3.setChecked(true);
                switchCount = 3;
            } else {
                lights_switch1.setChecked(false);
                lights_switch2.setChecked(false);
                lights_switch3.setChecked(false);
                switchCount = 0;
            }
        } else {
            if (s.isChecked())
                switchCount++;
            else
                switchCount--;
            if (switchCount == 3) {
                master.setChecked(true);
                //switchTrigger(master);
            } else {
                master.setChecked(false);
            }
        }
        if (lights_switch3.isChecked()) {
            light_icon3.setImageResource(R.drawable.light_on);
        } else {
            light_icon3.setImageResource(R.drawable.light);
        }
        if (lights_switch1.isChecked()) {
            light_icon1.setImageResource(R.drawable.light_on);
        } else {
            light_icon1.setImageResource(R.drawable.light);
        }
        if (lights_switch2.isChecked()) {
            light_icon2.setImageResource(R.drawable.light_on);
        } else {
            light_icon2.setImageResource(R.drawable.light);
        }

        Log.d("CaptiosX", switchCount.toString());

    }

}
