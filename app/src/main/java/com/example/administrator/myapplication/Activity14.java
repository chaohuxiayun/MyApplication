package com.example.administrator.myapplication;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016/5/27.
 */
public class Activity14 extends BaseActivity {

    int[] i={R.drawable.icon_16,R.drawable.icon_28,R.drawable.icon_30,R.drawable.icon_34,R.drawable.icon_37};

    AdapterViewFlipper adapterViewFlipper;
    @Override
    public void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.activity14_layout);
        adapterViewFlipper= (AdapterViewFlipper) findViewById(R.id.myadp);
        BaseAdapter b=new BaseAdapter() {
            @Override
            public int getCount() {
                return i.length;
            }

            @Override
            public Object getItem(int position) {
                return i[position];
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ImageView iv=new ImageView(Activity14.this);
                iv.setImageResource(i[position]);
                return iv;
            }
        };
        adapterViewFlipper.setAdapter(b);
        adapterViewFlipper.setFlipInterval(1000);
        adapterViewFlipper.startFlipping();
    }




    public void last(View s){

        adapterViewFlipper.showPrevious();
        adapterViewFlipper.stopFlipping();
    }
    public void next(View s){

        adapterViewFlipper.showNext();
        adapterViewFlipper.stopFlipping();
    }
    public void auto(View s){

        adapterViewFlipper.startFlipping();
    }
}
