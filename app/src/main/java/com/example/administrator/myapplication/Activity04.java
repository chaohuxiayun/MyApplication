package com.example.administrator.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016/5/26.
 */
public class Activity04 extends Activity{

    ImageView imgview;

    int[] i = {R.drawable.icon_df,R.drawable.icon_df,R.drawable.icon_16,R.drawable.icon_18};
    int a=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity04_layout);

        imgview = (ImageView) findViewById(R.id.a04_layout_img);
        imgview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgview.setImageResource(i[++a%4]);
            }
        });
    }
}
