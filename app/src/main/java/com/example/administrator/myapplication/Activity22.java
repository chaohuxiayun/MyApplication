package com.example.administrator.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.TextView;

import java.util.zip.Inflater;

/**
 * Created by Administrator on 2016/5/31.
 */
public class Activity22 extends BaseActivity{

    TextView tv;

    @Override
    public void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.activity22_layout);

        tv = (TextView) findViewById(R.id.layout22_tv1);
        registerForContextMenu(tv);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        SubMenu sub = menu.addSubMenu("改变字体大小");
        sub.add(0,1,0,"10号字");
        sub.add(0,2,0,"12号字");
        sub.add(0,3,0,"14号字");
        sub.add(0,4,0,"16号字");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case 1:
                tv.setTextSize(10);
                break;
            case 2:
                tv.setTextSize(12*3);
                break;
            case 3:
                tv.setTextSize(14*3);
                break;
            case 4:
                tv.setTextSize(16*3);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        menu.add(0,1,0,"red");
        menu.add(0,2,0,"blue");
        menu.add(0,3,0,"yellow");

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case 1:
                tv.setTextColor(Color.RED);
                break;
            case 2:
                tv.setTextColor(Color.BLUE);
                break;
            case 3:
                tv.setTextColor(Color.YELLOW);
                break;
        }
        return super.onContextItemSelected(item);
    }

    public void change(View view){

        PopupMenu pup = new PopupMenu(this,view);
        getMenuInflater().inflate(R.menu.toolbar_menu,pup.getMenu());
        pup.show();
    }
}
