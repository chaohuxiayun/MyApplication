package com.example.administrator.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016/6/6.
 */
public class Activity34 extends Activity implements GestureDetector.OnGestureListener{

    int count=0;
    int[] s = {R.drawable.icon_41,R.drawable.icon_30,R.drawable.icon_28,R.drawable.icon_18,R.drawable.icon_16};
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity34_layout);
        img = (ImageView) findViewById(R.id.layout34_img1);
        img.setImageResource(s[count]);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

        float x1 = e1.getX();
        float x2 = e2.getX();

        if(x2-x1>80){
            if (!(count>=(s.length-1))){
                count ++;
            }
            img.setImageResource(s[count]);
        }
        if(x1-x2>80){
            if (!(count<=0)){
                count --;
            }
            img.setImageResource(s[count]);
        }
        return false;
    }
}
