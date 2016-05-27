package com.example.administrator.myapplication;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/5/26.
 */


public class Activity03 extends Activity{

    DisplayMetrics dm = getResources().getDisplayMetrics();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int width = dm.widthPixels;
        int  height = dm.heightPixels;
        int dpi = dm.densityDpi;
        TextView t = (TextView) findViewById(R.id.a01_text1);
        t.setText("宽"+width+" 高"+height+" dpi"+dpi);
    }
}
