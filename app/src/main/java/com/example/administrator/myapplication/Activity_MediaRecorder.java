package com.example.administrator.myapplication;

import android.app.Activity;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2016/6/8.
 */
public class Activity_MediaRecorder extends Activity implements View.OnClickListener {

    Button start;
    Button stop;
    Button play;
    MediaPlayer ma;

    MediaRecorder mr;
    File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitymr_layout);
        start = (Button) findViewById(R.id.layout_mr_b1);
        stop = (Button) findViewById(R.id.layout_mr_b2);
        play = (Button) findViewById(R.id.layout_mr_b3);
        start.setOnClickListener(this);
        stop.setOnClickListener(this);
        play.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        if(file!=null && file.exists()){
            mr.stop();
            mr.release();
            mr = null;
            ma.stop();
            ma.release();
        }
        super.onDestroy();
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.layout_mr_b1:

                try {
                    file = new File("/mnt/sdcard/sound.amr");
                    mr = new MediaRecorder();
                    mr.setAudioSource(MediaRecorder.AudioSource.MIC);//设置声音的来源
                    mr.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);//设置声音的输出格式
                    mr.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);//设置声音的编码格式
                    mr.setOutputFile(file.getAbsolutePath());
                    mr.prepare();
                    mr.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.layout_mr_b2:
                mr.stop();
                mr.release();
                mr = null;
                break;
            case R.id.layout_mr_b3:
                try{
                    ma = new MediaPlayer();
                    /*ma.setDataSource("/mnt/sdcard/sound.amr");*/
                    ma.setDataSource("/mnt/sdcard/sound.amr");
                    ma.prepare();
                    ma.start();
                }catch (Exception e){

                }

                break;
        }
    }
}
