package com.example.administrator.myapplication;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

/**
 * Created by Administrator on 2016/5/27.
 */
public class Activity15_2 extends BaseActivity{

    AutoCompleteTextView act ;
    String[] str = new String[]{"aas","asd","sdd","gdd","gdf","sdf","bvc","bvx"};

    @Override
    public void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.activity15_2_layout);
        act = (AutoCompleteTextView) findViewById(R.id.layout15_2_act);
        ArrayAdapter ad = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,str);
        act.setAdapter(ad);
    }
}
