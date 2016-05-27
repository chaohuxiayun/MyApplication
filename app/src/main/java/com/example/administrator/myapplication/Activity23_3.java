package com.example.administrator.myapplication;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/5/27.
 */
public class Activity23_3 extends  BaseActivity{

    TextView tv ;
    ImageView img;

    @Override
    public void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.activity23_3_layout);
        tv = (TextView) findViewById(R.id.layout_23_3_tv1);
       tv.setText(R.string.resource_name);
        img = (ImageView) findViewById(R.id.layout_23_3_img1);
        img.setImageResource(R.drawable.icon_df);
    }
}
