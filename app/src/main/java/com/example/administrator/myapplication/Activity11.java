package com.example.administrator.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/5/27.
 */
public class Activity11 extends BaseActivity{

    public RadioGroup rg;
    public RadioButton rb1;
    public RadioButton rb2;
    public RadioButton rb3;

    String sex;

    @Override
    public void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.activity11_layout);

        rg = (RadioGroup) findViewById(R.id.layout11_radiogroup1);
        rb1 = (RadioButton) findViewById(R.id.layout11_radio1);
        rb2 = (RadioButton) findViewById(R.id.layout11_radio2);
        rb3 = (RadioButton) findViewById(R.id.layout11_radio3);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.layout11_radio1){
                    sex = rb1.getText().toString().trim();
                }else if(checkedId == R.id.layout11_radio2){
                    sex = rb2.getText().toString().trim();
                }else if(checkedId == R.id.layout11_radio3){
                    sex = rb3.getText().toString().trim();
                }
                Toast.makeText(Activity11.this, "你选的是"+ sex, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
