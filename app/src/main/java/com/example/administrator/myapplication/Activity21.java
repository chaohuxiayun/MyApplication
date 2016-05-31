package com.example.administrator.myapplication;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Administrator on 2016/5/31.
 */
public class Activity21 extends Activity {
    ActionBar ab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity21_layout);
        ab = getActionBar();
/*        ab.setDisplayShowHomeEnabled(false);
        ab.setDisplayHomeAsUpEnabled(true);*/
        ab.setTitle("这是一个actionbar");
    }

    public void show(View view){
        ab.show();
    }

    public void hide(View view){
        ab.hide();
    }


}
