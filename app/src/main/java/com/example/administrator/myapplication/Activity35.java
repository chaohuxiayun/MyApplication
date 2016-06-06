package com.example.administrator.myapplication;

import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Administrator on 2016/6/6.
 */
public class Activity35 extends BaseActivity{
    @Override
    public void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.activity35_layout);
    }
    public void addges(){
        Intent i = new Intent(Activity35.this,Activity35_1.class);
        startActivity(i);
        finish();
    }
    public void testges(){
        Intent i = new Intent(Activity35.this,Activity35_2.class);
        startActivity(i);
        finish();
    }

}
