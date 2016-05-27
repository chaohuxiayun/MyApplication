package com.example.administrator.myapplication;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.FrameLayout;

import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by hasee on 2016/5/26.
 */
public class Activity07 extends BaseActivity {
    int[] a = { R.id.layout07_frame1, R.id.layout07_frame2, R.id.layout07_frame3, R.id.layout07_frame4, R.id.layout07_frame5};
    int[] color = {Color.RED,Color.BLUE,Color.GREEN,Color.YELLOW, Color.DKGRAY};
    Timer t ;
    int b = 0;

    Handler h = new Handler(){
        public void handleMessage(Message msg) {
            for(int i=0;i<5;i++){
                FrameLayout fl = (FrameLayout)findViewById(a[i]);
                fl.setBackgroundColor(color[(msg.what+i)%5]);
            }
        };
    };




    @Override
    public void initContentView(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity07_layout);
            t = new Timer();
            t.schedule(new TimerTask() {
                @Override
                public void run() {
                    b++;
                    Message m = new Message();
                    m.what = b;
                    h.sendMessage(m);
                }
            }, 100, 1000);
        }

}
