package com.example.administrator.myapplication;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

/**
 * Created by Administrator on 2016/6/3.
 */
public class ActivitySQLite01 extends BaseActivity{

    StudentHelper helper;
    ListView lv;

    @Override
    public void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.activitysqlite01_layout);
        lv = (ListView) findViewById(R.id.layout_sqlite01_lv1);
        helper = new StudentHelper(this,"student.db",null,Contants.Version);
        Cursor c = helper.getReadableDatabase().query("student",null,null,null,null,null,null);
        SimpleCursorAdapter sca = new SimpleCursorAdapter(this,R.layout.activitysqlit01_listview_layout,c,new String[]{"pic","name","age"},new int[]{R.id.layout_sqlit01_iv1,R.id.layout_sqlit01_tv1,R.id.layout_sqlit01_tv2},0);
        lv.setAdapter(sca);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


            }

            });
    }
}
