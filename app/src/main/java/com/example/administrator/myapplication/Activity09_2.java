package com.example.administrator.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by hasee on 2016/5/26.
 */
public class Activity09_2 extends BaseActivity {


    @Override
    public void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.activity092_layout);
        TextView edt = (TextView) findViewById(R.id.layout092_edt1);
    }
}
