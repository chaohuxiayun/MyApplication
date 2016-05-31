package com.example.administrator.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Administrator on 2016/5/30.
 */
public class Activity19 extends BaseActivity {

    Button b;
    @Override
    public void initContentView(Bundle savedInstanceState) {

        setContentView(R.layout.activity19_layout1);

    }
    public void jump(View view){
        Intent i = new Intent(Activity19.this,Activity19_2.class);
        startActivity(i);
    }
}
