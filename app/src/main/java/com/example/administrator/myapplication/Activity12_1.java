package com.example.administrator.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Administrator on 2016/5/31.
 */
public class Activity12_1 extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyView m = new MyView(this,400,300);
        setContentView(m);
}
}
