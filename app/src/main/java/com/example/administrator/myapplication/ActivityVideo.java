package com.example.administrator.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.File;

/**
 * Created by Administrator on 2016/6/8.
 */
public class ActivityVideo extends Activity{

    VideoView vv ;
    MediaController mc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityvideo_layout);
        vv = (VideoView) findViewById(R.id.layout_video);
        mc = new MediaController(this);
        File video = new File("/mnt/sdcard/mm.mp4");
        if(video.exists()){
            vv.setVideoPath(video.getAbsolutePath());
            vv.setMediaController(mc);
            mc.setMediaPlayer(vv);
            vv.requestFocus();

        }
    }
}
