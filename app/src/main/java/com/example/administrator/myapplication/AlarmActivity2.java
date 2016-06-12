package com.example.administrator.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

/**
 * Created by Administrator on 2016/6/8.
 */
public class AlarmActivity2 extends Activity {

    MediaPlayer m ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        m = MediaPlayer.create(this,R.raw.bomb);

        m.setLooping(true);
        m.start();
        new AlertDialog.Builder(AlarmActivity2.this)
        .setTitle("闹铃")
        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                m.stop();
                AlarmActivity2.this.finish();
            }
        });
    }
}
