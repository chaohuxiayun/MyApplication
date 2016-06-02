package com.example.administrator.myapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/6/2.
 */
public class Activity31 extends BaseActivity{

    EditText ed1;
    EditText ed2;
    RadioGroup rg;
    RadioButton rb;
    Button btn;

    SharedPreferences sp;
    SharedPreferences.Editor ed;

    boolean flag = false;

    @Override
    public void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.activity06_2_layout);
        sp = getSharedPreferences("login",MODE_PRIVATE);
        ed = sp.edit();
        ed.putString("name","admiin");
        ed.putString("pw","admin");
        boolean tflag = sp.getBoolean("flag",false);
        if(tflag){
                Toast.makeText(Activity31.this, "登录成功" + sp.getString("name","123"), Toast.LENGTH_SHORT).show();

        }else{
            ed1 = (EditText) findViewById(R.id.layout06_2_edt1);
            ed2 = (EditText) findViewById(R.id.layout06_2_edt2);
            rg = (RadioGroup) findViewById(R.id.layout06_2_rg1);
            rb = (RadioButton) findViewById(R.id.layout06_2_rb1);
            btn = (Button) findViewById(R.id.layout06_2_btn1);

            rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    if(rb.isChecked()){
                        flag = true;
                    }
                }
            });


            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String name = ed1.getText().toString().trim();
                    String pw = ed2.getText().toString().trim();
                    if(name.equals(sp.getString("name","#$%") )&& pw.equals(sp.getString("pw","@#￥"))){
                        Toast.makeText(Activity31.this, "登录成功" + sp.getString("name","123"), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }
}
