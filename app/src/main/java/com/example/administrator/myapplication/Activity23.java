package com.example.administrator.myapplication;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Administrator on 2016/5/30.
 */
public class Activity23 extends BaseActivity{

    AlertDialog ad;
    ProgressDialog pd;
    TimePickerDialog tpm;
    DatePickerDialog dpm;
    int ps = 0;

    Handler h = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            super.handleMessage(msg);
            ps += 10;
            pd.setProgress(ps);
            if (ps >= 100)
            {
                pd.dismiss();
            }
        }
    };

    @Override
    public void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.activity23_layout);
    }

    public void dia1(View view){
        ad = new AlertDialog.Builder(this)
             .setTitle("这是一个简单的对话框")
                .setMessage("信息")
                .setIcon(R.drawable.icon_16)
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Activity23.this, "嗯", Toast.LENGTH_SHORT).show();
                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Activity23.this, "哼", Toast.LENGTH_SHORT).show();
                    }
                })
                .create();
        ad.show();
    }
    public void dia2(View view){

        (new Thread()
        {
            @Override
            public void run()
            {
                for (int i = 0; i < 10; i++)
                {
                    h.sendMessage(new Message());
                    try
                    {
                        sleep(1000);
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }

            }
        }).start();


            pd = new ProgressDialog(this);
        pd.setTitle("我是进度条");
        pd.setIcon(R.drawable.icon_28);
        pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        pd.setIndeterminate(false);
        pd.show();

    }
    public void dia3(View view){
        Calendar d = Calendar.getInstance(Locale.CHINA);
        Date date = new Date();
        d.setTime(date);
        int year = d.get(Calendar.YEAR);
        int month = d.get(Calendar.MONTH);
        int day = d.get(Calendar.DAY_OF_MONTH);
        dpm = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

            }
        }, year, month, day);
        dpm.show();
    }
    public void dia4(View view){
        Calendar d = Calendar.getInstance(Locale.CHINA);
        Date date = new Date();
        d.setTime(date);
        int hour = d.get(Calendar.HOUR_OF_DAY);
        int min = d.get(Calendar.MINUTE);
        int sec = d.get(Calendar.SECOND);
        tpm = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

            }
        },hour,min,true);
        tpm.show();

    }

}
