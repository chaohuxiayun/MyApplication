package com.example.administrator.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.File;

/**
 * Created by Administrator on 2016/6/8.
 */
public class Activity_openvedio extends Activity{

    VideoView vv ;
    ImageView iv;
    MediaController mc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ov_layout);
        vv = (VideoView) findViewById(R.id.layout_ov_vv);
        iv = (ImageView) findViewById(R.id.layout_ov_iv);
        mc = new MediaController(this);
        Intent i = getIntent();
        Log.e("123",i.getData().toString());
        Toast.makeText(Activity_openvedio.this, i.getData().toString(), Toast.LENGTH_SHORT).show();
        if (i.getData().toString().contains(".png")){
            iv.setImageURI(i.getData());
        }else{
            vv.setMediaController(mc);
            mc.setMediaPlayer(vv);
            vv.setVideoURI(i.getData());
            vv.requestFocus();
        }



    }
}
