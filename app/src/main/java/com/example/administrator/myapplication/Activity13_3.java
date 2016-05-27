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
public class Activity13_3 extends BaseActivity{

    public int[] a = {R.drawable.icon_df,R.drawable.icon_28,R.drawable.icon_30,R.drawable.icon_df,R.drawable.icon_37};
    AdapterViewFlipper ada ;

    @Override
    public void initContentView(Bundle savedInstanceState) {

        setContentView(R.layout.activity13_3_layout);
        ada = (AdapterViewFlipper) findViewById(R.id.layout13_3_ada1);

        BaseAdapter bad = new BaseAdapter() {
            @Override
            public int getCount() {
                return a.length;
            }

            @Override
            public Object getItem(int position) {
                return a[position];
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                ImageView img = new ImageView(Activity13_3.this);
                img.setImageResource(a[position]);
                return img;
            }
        };
        ada.setAdapter(bad);
        ada.setFlipInterval(1000); //设置图片切换时间
        ada.startFlipping();
    }

    public void pre(View view){
        ada.stopFlipping();
        ada.showPrevious();
    }
    public void next(View view){
        ada.stopFlipping();
        ada.showNext();
    }
    public void autoplay(View view){
        ada.startFlipping();
    }

}
