package com.example.administrator.myapplication;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by Administrator on 2016/5/27.
 */
public class Activity13_2 extends BaseActivity{

    String[] str = {"小学","中学","高中","大专","本科","研究生","博士"};

    @Override
    public void initContentView(Bundle savedInstanceState) {

        setContentView(R.layout.activity132_layout);
        Spinner spinner = (Spinner) findViewById(R.id.layout132_spinner1);
        ArrayAdapter aa = new ArrayAdapter<String>(Activity13_2.this, android.R.layout.simple_expandable_list_item_1,str);
        spinner.setAdapter(aa);
    }
}
