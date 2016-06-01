package com.example.administrator.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;

/**
 * Created by Administrator on 2016/5/26.
 */
public class Activity05 extends Activity{

    DisplayMetrics dm ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dm = getResources().getDisplayMetrics();
        MyView m = new MyView(this,dm.widthPixels,dm.heightPixels);
        setContentView(m);
        m.setOnTouchListener(m);
    }
}
