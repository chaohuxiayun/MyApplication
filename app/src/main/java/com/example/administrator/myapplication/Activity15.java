package com.example.administrator.myapplication;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016/5/27.
 */
public class Activity15 extends BaseActivity {

    public int[] a = {R.drawable.icon_df,R.drawable.icon_28,R.drawable.icon_30,R.drawable.icon_df,R.drawable.icon_37};

    public int i = 0;
    int alpha = 255;
    ImageView imgView;
    ImageView imgview2;

    Handler h = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bundle b = msg.getData();
            int x = b.getInt("x");
            int y = b.getInt("y");
            int width = imgView.getRight() -  imgView.getLeft();
            int height = imgView.getBottom() - imgView.getTop();
            if((x+144)> width){
                x = width - 144;
            }
            if((y+144)>height){
                y = height - 144;
            }
            imgView.setDrawingCacheEnabled(true);
            Bitmap bit = Bitmap.createBitmap(imgView.getDrawingCache());
            imgView.setDrawingCacheEnabled(false);
            Bitmap bit2 = Bitmap.createBitmap(bit,x,y,144,144);
            imgview2.setImageBitmap(bit2);
        }
    };

    @Override
    public void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.activity15_layout);
        imgView = (ImageView)findViewById(R.id.myimage);
        imgview2 = (ImageView) findViewById(R.id.myimage2);
        imgView.setImageResource(a[0]);


        imgView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                int x = (int)event.getX();
                int y = (int)event.getY();

                Bundle b = new Bundle();
                b.putInt("x",x);
                b.putInt("y",y);
                Message m = new Message();
                m.setData(b);
                h.sendMessage(m);

                return false;
            }
        });

    }
    public void last(View view){
        imgView.setImageResource(a[Math.abs(--i)%5]);
    }
    public void next(View view){
        imgView.setImageResource(a[Math.abs(++i)%5]);
    }
    public void tjia(View view){
        alpha+=10;
        if(alpha > 255){
            imgView.setImageAlpha(255);
            alpha = 255;
        }else{
            imgView.setImageAlpha(alpha);
        }

    }
    public void tjian(View view){
        alpha-=10;
        if(alpha < 0){
            imgView.setImageAlpha(0);
            alpha=0;
        }else{
            imgView.setImageAlpha(alpha);
        }
    }
}
