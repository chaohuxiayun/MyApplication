package com.example.administrator.myapplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
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
    Timer t1;
    boolean flag = true;
    Matrix m;


    List<Zidan> list = new ArrayList<Zidan>();

    Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
            R.drawable.ic_launcher);
    Bitmap bitback = BitmapFactory.decodeResource(getResources(),
            R.drawable.back);
    Bitmap bit3 ;
    int width ;
    int height ;

    DisplayMetrics dm;
    float sw;
    float sh;

    Handler h = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            invalidate();
        }
    };

    // 屏幕的宽高
/*	int width = wm.getDefaultDisplay().getWidth();
	int height = wm.getDefaultDisplay().getHeight();

	private int screenWidth = width; // 屏幕宽度
	private int screenHeight = height; // 屏幕高度
*/
    public View091(Context context) {
        super(context);
        t = new Timer();
        t1 = new Timer();
        m = new Matrix();
        dm = getResources().getDisplayMetrics();
        sw = dm.widthPixels;
        sh = dm.heightPixels;
       width = bitback.getWidth();
        height = bitback.getHeight();
        m.postScale(1.4f,1.8f);
         bit3 = Bitmap.createBitmap(bitback,0,0,width,height,m,true);
    }



    public View091(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p = new Paint();

        canvas.drawBitmap(bit3,0,0,p);
        canvas.drawBitmap(bitmap, lastX, lastY, p);
//
        p.setStrokeWidth(10);
        p.setColor(Color.WHITE);
        for(Zidan z : list){
            z.setY(z.getY()-50);
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
                    if(flag){
                        refresh();
                        flag = false;
                    }
                    addZidan();
                case MotionEvent.ACTION_MOVE:
                    lastX = x - dx;
                    lastY = y - dy;
                    break;
                case MotionEvent.ACTION_UP:
                    t.cancel();
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

    public void addZidan(){
        t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                    setZidan();
                }
        },0,300);

    }
    public void refresh(){
        t1 = new Timer();
        t1.schedule(new TimerTask() {
            @Override
            public void run() {
                h.sendMessage(new Message());
            }
        },0,300);
    }

}
