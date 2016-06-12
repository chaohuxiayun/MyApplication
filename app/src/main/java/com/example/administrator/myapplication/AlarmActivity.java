package com.example.administrator.myapplication;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by Administrator on 2016/6/8.
 */
public class AlarmActivity extends Activity {

    Button setTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settime_layout);



        setTime = (Button) findViewById(R.id.settime_b1);
        setTime.setOnClickListener(new View.OnClickListener() {
            Calendar c = Calendar.getInstance();
            @Override
            public void onClick(View v) {
                new TimePickerDialog(AlarmActivity.this, 0, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Intent i = new Intent(AlarmActivity.this,AlarmActivity2.class);
                        PendingIntent pi =  PendingIntent.getActivity(AlarmActivity.this,0,i,0);
                        Calendar c1 = Calendar.getInstance();
                        c1.setTimeInMillis(System.currentTimeMillis());
                        c1.set(Calendar.HOUR,hourOfDay);
                        c1.set(Calendar.MINUTE,minute);
                        AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);
                        manager.set(AlarmManager.RTC_WAKEUP,c1.getTimeInMillis(),pi);
                        Toast.makeText(AlarmActivity.this, "闹铃设置成功", Toast.LENGTH_SHORT).show();
                    }
                },c.get(Calendar.HOUR_OF_DAY),c.get(Calendar.MINUTE),false).show();
            }
        });

    }
}
