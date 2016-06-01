package com.example.administrator.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.InputEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Toast;


/**
 * Created by Administrator on 2016/5/26.
 */
public abstract class BaseActivity  extends AppCompatActivity{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initContentView(savedInstanceState);
       /* toolbar = new Toolbar(this);*/
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        toolbar.setNavigationIcon(R.drawable.icon_16); //设置图标
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
//设置toolbar后调用setDisplayHomeAsUpEnabled
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BaseActivity.this, "你点箭头了", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(BaseActivity.this,CommitActivity.class);
                startActivity(i);
            }
        });

    }

    public abstract void initContentView(Bundle savedInstanceState);


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
   /*     SubMenu submenu = menu.addSubMenu("选择字体大小");
       submenu.add(0,0x111,0,"10号字");
       submenu.add(0,0x112,1,"12号字");
       submenu.add(0,0x113,2,"14号字");
       submenu.add(0,0x114,3,"16号字");

        menu.add(0,1,0,"这是一个菜单项");*/
        MenuInflater inf = new MenuInflater(this);
        inf.inflate(R.menu.toolbar_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.normal_btn:
                new AlertDialog.Builder(this)
                        .setTitle("关于我们" )
                        .setMessage("by xiayun " )
                        .setPositiveButton("确定" ,  null )
                        .show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
