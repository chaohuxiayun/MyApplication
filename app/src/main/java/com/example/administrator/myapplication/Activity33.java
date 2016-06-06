package com.example.administrator.myapplication;

import android.gesture.Gesture;
import android.gesture.GestureOverlayView;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/6/6.
 */
public class Activity33 extends BaseActivity implements GestureDetector.OnGestureListener {

    GestureOverlayView gesture;
    GestureDetector de;
    ImageView img ;
    Bitmap bit ;
    TextView tv;
    @Override
    public void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.activity33_layout);
        img = (ImageView) findViewById(R.id.layout33_img1);
        bit = BitmapFactory.decodeResource(getResources(),R.drawable.airplane);
        img.setImageBitmap(bit);
        tv = (TextView) findViewById(R.id.layout33_tv1);
        de = new GestureDetector(this,this);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return de.onTouchEvent(event);
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

        Matrix m = new Matrix();

        int x1  = (int) e1.getX();
        int x2 = (int) e2.getX();
        velocityX = velocityX>4000?4000:velocityX;
        velocityX = velocityX<-4000?-4000:velocityX;
        float scale=1;
        scale = scale + scale*velocityX/4000f;
        scale = scale >0.01?scale:0.01f;



            m.setScale(scale,scale);
            Bitmap b = Bitmap.createBitmap(bit,0,0,bit.getWidth(),bit.getHeight(),m,true);
            img.setImageBitmap(b);






        return true;
    }
}
