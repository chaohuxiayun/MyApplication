package com.example.administrator.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by Administrator on 2016/5/27.
 */
public class Activity12 extends BaseActivity{

    Timer t;

    Button btn;

    int count = 10;

    Handler h = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            btn.setText("还有"+ msg.what);
            if(msg.what == 0){
                btn.setEnabled(true);
                btn.setText("点击发送短信");
                count = 10;
                t.cancel();
            }
        }
    };

    @Override
    public void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.activity12_layout);
        btn = (Button) findViewById(R.id.layout12_btn1);

    }
    public void sendMessage(View view){
        btn.setEnabled(false);
        t  = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                Message m = new Message();
                m.what = count --;;
                h.sendMessage(m);
            }
        },1000,1000);
    }
}
