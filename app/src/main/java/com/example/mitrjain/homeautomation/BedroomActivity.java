package com.example.mitrjain.homeautomation;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

/**
 * Created by Johns on 9/1/2017.
 */

public class BedroomActivity extends AppCompatActivity {

    Switch master, fans, lights, tv, ac;
    SeekBar ac_seek_bar;
    Integer switchCount = 0;
    TextView temp_text;
    ImageView tv_icon, light_icon, ac_icon;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bedroom_fragment);
        master = (Switch) findViewById(R.id.master_switch);
        fans = (Switch) findViewById(R.id.fans_switch);
        lights = (Switch) findViewById(R.id.lights_switch);
        tv = (Switch) findViewById(R.id.tv_switch);
        ac = (Switch) findViewById(R.id.ac_switch);
        ac_seek_bar = (SeekBar) findViewById(R.id.ac_temp_ctrl);
        temp_text = (TextView) findViewById(R.id.temp_text);
        tv_icon = (ImageView) findViewById(R.id.tv_image);
        light_icon = (ImageView) findViewById(R.id.lights_image);
        ac_icon = (ImageView) findViewById(R.id.ac_icon);
        ac_seek_bar.setBackgroundColor(Color.parseColor("#b2ebf2"));
        temp_text.setBackgroundColor(Color.parseColor("#b2ebf2"));
        temp_text.setTextColor(Color.parseColor("#000000"));
        ac_seek_bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                String text = "Current temperature: " + (i + 16) + " 'C";
                temp_text.setText(text);
                if (i < 4) {
                    temp_text.setBackgroundColor(Color.parseColor("#0288d1"));
                    ac_seek_bar.setBackgroundColor(Color.parseColor("#0288d1"));
                } else if (i >= 4 && i < 8) {
                    temp_text.setBackgroundColor(Color.parseColor("#26c6da"));
                    ac_seek_bar.setBackgroundColor(Color.parseColor("#26c6da"));
                } else if (i >= 8 && i < 14) {
                    temp_text.setBackgroundColor(Color.parseColor("#b2ebf2"));
                    ac_seek_bar.setBackgroundColor(Color.parseColor("#b2ebf2"));
                } else {
                    temp_text.setBackgroundColor(Color.parseColor("#ff9e80"));
                    ac_seek_bar.setBackgroundColor(Color.parseColor("#ff9e80"));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }

    public void switchTrigger(View v) throws Exception {
        Switch s = (Switch) v;
        if (s.getId() == R.id.master_switch) {
            if (master.isChecked()) {
                lights.setChecked(true);
                tv.setChecked(true);
                ac.setChecked(true);
                s = (Switch) findViewById(R.id.ac_switch);
                switchCount = 3;
            } else {

                lights.setChecked(false);
                tv.setChecked(false);
                ac.setChecked(false);
                s = (Switch) findViewById(R.id.ac_switch);
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
        if (tv.isChecked()) {
            tv_icon.setImageResource(R.drawable.led_tv_on);
        } else {
            tv_icon.setImageResource(R.drawable.led_tv);
        }
        if (ac.isChecked()) {
            ac_icon.setImageResource(R.drawable.ac_on);
        } else {
            ac_icon.setImageResource(R.drawable.ac);
        }
        if (lights.isChecked()) {
            light_icon.setImageResource(R.drawable.light_on);
        } else {
            light_icon.setImageResource(R.drawable.light);
        }

        if (s.getId() == R.id.ac_switch) {
            if (s.isChecked()) {
                ac_seek_bar.setVisibility(View.VISIBLE);
                temp_text.setVisibility(View.VISIBLE);
            } else {
                ac_seek_bar.setVisibility(View.GONE);
                temp_text.setVisibility(View.GONE);
            }
        }
        Log.d("CaptiosX", switchCount.toString());

    }

}
