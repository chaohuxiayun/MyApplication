package com.example.administrator.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Administrator on 2016/6/1.
 */
public class Activity24_2 extends BaseActivity{

    EditText edt;

    @Override
    public void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.activity24_2_layout);
        edt = (EditText) findViewById(R.id.layout24_2_edt1);
    }
    public void fangwen(View view){
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(edt.getText().toString().trim()));
        startActivity(i);
    }
}
