package com.example.administrator.myapplication;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Administrator on 2016/5/26.
 */
public class Activity05 extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyView m = new MyView(this);
        setContentView(m);
        m.setOnTouchListener(m);
    }
}
