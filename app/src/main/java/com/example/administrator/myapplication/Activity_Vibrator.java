package com.example.administrator.myapplication;

import android.app.Activity;
import android.app.Service;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;

/**
 * Created by Administrator on 2016/6/7.
 */
public class Activity_Vibrator extends Activity{

    Vibrator vibrator;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vibrator_layout);
        mp = MediaPlayer.create(this,R.raw.pfdsj43);
        vibrator = (Vibrator) getSystemService(Service.VIBRATOR_SERVICE);
    }
    public void startvibrator(View view){
        mp.start();
        vibrator.vibrate(new long[]{0,400,800,1200},0);
    }
    public void stopvibrator(View view){
        vibrator.cancel();
        mp.stop();
    }
}
