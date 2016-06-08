package com.example.administrator.myapplication;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Button;

import java.util.Calendar;

/**
 * Created by Administrator on 2016/6/8.
 */
public class AlarmActivity extends Activity {

    Button setTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Calendar c = Calendar.getInstance();
        int min = c.get(Calendar.MINUTE);
        if(min == 20){

        }
    }
}
