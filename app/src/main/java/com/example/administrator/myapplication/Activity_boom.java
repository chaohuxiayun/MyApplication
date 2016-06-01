package com.example.administrator.myapplication;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;



/**
 * Created by Administrator on 2016/6/1.
 */
public class Activity_boom extends Activity {

    ImageView img ;
   LinearLayout layout;
    AnimationDrawable anim ;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boom_layout);
        img = (ImageView) findViewById(R.id.layout_boom_img1);
        layout = (LinearLayout) findViewById(R.id.layout_boom_layout1);
        anim = (AnimationDrawable) img.getBackground();
        mp = MediaPlayer.create(this,R.raw.bomb);
        layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                start();
                return false;
            }
        });

    }



    public void start(){
        anim.start();
        mp.start();
    }
}
