package com.example.materialsidenavui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;

public class ScheduleTrialActivity extends AppCompatActivity {

    Button bt_mon,bt_tue,bt_wed,bt_thu,bt_fri,bt_sat,bt_selected;
    boolean isSelected=false;
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time_table_schedule_trial);

        bt_mon=findViewById(R.id.bt_mon);
        bt_tue=findViewById(R.id.bt_tue);
        bt_wed=findViewById(R.id.bt_wed);
        bt_thu=findViewById(R.id.bt_thu);
        bt_fri=findViewById(R.id.bt_fri);
        bt_sat=findViewById(R.id.bt_sat);



        getSelected(0, bt_mon);
        bt_mon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSelected(1,bt_mon);

//                isSelected=true;
//                setSelected(0);
            }
        });

        bt_tue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSelected(1,bt_tue);
            }
        });

        bt_wed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSelected(2,bt_wed);
            }
        });

        bt_thu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSelected(3,bt_thu);
            }
        });

        bt_fri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSelected(4,bt_fri);
            }
        });

        bt_sat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSelected(5,bt_sat);
            }
        });
    }

    private void getSelected(int i, Button bt) {

        if (isSelected)
        {
            bt_selected.setBackgroundResource(R.drawable.background_schedule);
            bt_selected.setTextColor(this.getResources().getColor(R.color.white));
            position=i;
            bt_selected=bt;
            bt.setBackgroundResource(R.drawable.background_schedule_selected);
            bt.setTextColor(this.getResources().getColor(R.color.colorAccent));
        }
        else
        {
            position=i;
            bt_selected=bt;
            isSelected=true;
            bt.setBackgroundResource(R.drawable.background_schedule_selected);
            bt.setTextColor(this.getResources().getColor(R.color.colorAccent));
        }

    }
}