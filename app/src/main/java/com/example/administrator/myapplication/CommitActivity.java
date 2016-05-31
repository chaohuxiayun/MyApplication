package com.example.administrator.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.AndroidCharacter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Administrator on 2016/5/26.
 */
public class CommitActivity extends BaseActivity{


    Class[] clazz = {Activity02.class,Activity03.class,Activity04.class,Activity05.class,Activity07.class,Activity08.class,Activity09_1.class,Activity09_2.class
    ,Activity11.class,Activity12.class,Activity12_1.class,Activity13.class,Activity13_2.class,Activity13_3.class,Activity13_4.class,Activity14.class,Activity15.class,Activity15_2.class,Activity19.class
            ,Activity19_2.class,Activity19_3.class,Activity20.class,Activity21.class,Activity22.class,Activity23.class,Activity23_3.class,Activity24.class,Activity24_1.class,Activity26.class,Activity27.class
    };
    String[] homework = new String[clazz.length];
    ListView lv ;
    @Override
    public void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.commitactivity_layout);
        lv = (ListView) findViewById(R.id.commitlayout_lv1);
        setHomework();
        ArrayAdapter a = new ArrayAdapter(this, android.R.layout.simple_list_item_1,homework);
        lv.setAdapter(a);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(CommitActivity.this,clazz[position]);
                startActivity(i);
            }
        });

    }

    public void setHomework(){
        for(int i = 0 ;i<clazz.length;i++){
            homework[i] = "作业"+i+"";
        }
    }
}
