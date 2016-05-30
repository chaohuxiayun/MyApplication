package com.example.administrator.myapplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.view.MotionEvent;
import android.view.WindowManager;

/**
 * Created by hasee on 2016/5/26.
 */
public class View091 extends ImageView {

    private float lastX = 0;
    private float lastY = 0;

    float dx;
    float dy;

    Timer t;
    boolean flag = false;


    List<Zidan> list = new ArrayList<Zidan>();

    Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
            R.drawable.ic_launcher);
    Bitmap bitback = BitmapFactory.decodeResource(getResources(),
            R.drawable.back);
    int width = bitback.getWidth();
    int height = bitback.getHeight();


    WindowManager wm = (WindowManager) getContext().getSystemService(
            Context.WINDOW_SERVICE);

    // 屏幕的宽高
/*	int width = wm.getDefaultDisplay().getWidth();
	int height = wm.getDefaultDisplay().getHeight();

	private int screenWidth = width; // 屏幕宽度
	private int screenHeight = height; // 屏幕高度
*/
    public View091(Context context) {
        super(context);
        new Thread(new Runnable(){
            @Override
            public void run() {
                while(true){
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    setZidan();
                    for(Zidan z :list){
                        z.setY(z.getY() - 150);
                    }
                }

            }
        }).start();
    }

    public View091(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p = new Paint();
        canvas.drawBitmap(Bitmap.createBitmap(bitback,0,0,width,height),0,0,p);
        canvas.drawBitmap(bitmap, lastX, lastY, p);
        p.setStrokeWidth(8);
        for(Zidan z : list){
            canvas.drawLine(z.getX(), z.getY(), z.getX(), z.getY() - z.getSize(), p);
        }
		/*canvas.drawLine(lastX, lastY, lastX, 0, p);*/
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        float x = event.getX();
        float y = event.getY();
        if(getLeft()<x && getRight()>x && getTop()<y && getBottom()>y){
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    dx = x - lastX;
                    dy = y - lastY;

                case MotionEvent.ACTION_MOVE:
                case MotionEvent.ACTION_UP:
                    lastX = x - dx;
                    lastY = y - dy;
                    invalidate();
                    break;
                default:
                    break;
            }
        }
        return true;
    }

    public void setZidan(){
        Zidan zd = new Zidan();
        zd.setX(lastX);
        zd.setY(lastY);
        zd.setSize(20);
        list.add(zd);
    }
}
