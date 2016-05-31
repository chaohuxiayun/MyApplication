package com.example.administrator.myapplication;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Administrator on 2016/5/31.
 */
public class Activity19_3 extends BaseActivity{

    String birth;

    @Override
    public void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.activity19_layout3);
    }
    public void xuanze(View view){
        DatePickerDialog dpm;
        Calendar d = Calendar.getInstance(Locale.CHINA);
        Date date = new Date();
        d.setTime(date);
        int year = d.get(Calendar.YEAR);
        int month = d.get(Calendar.MONTH);
        int day = d.get(Calendar.DAY_OF_MONTH);
        dpm = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                birth = year + "-" + (monthOfYear+1) + "-" + dayOfMonth;
                Intent i = new Intent();
                i.putExtra("birth",birth);
                setResult(123,i);
                finish();
            }
        }, year, month, day);
        dpm.show();

    }
}
