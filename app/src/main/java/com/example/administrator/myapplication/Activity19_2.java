package com.example.administrator.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Administrator on 2016/5/31.
 */
public class Activity19_2 extends BaseActivity{

    EditText edt;

    @Override
    public void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.activity19_layout2);
        edt = (EditText) findViewById(R.id.layout19_2_edt);
    }
    public void jump2(View view ){
        Intent i = new Intent(Activity19_2.this,Activity19_3.class);
        startActivityForResult(i,0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == 123){
            String birth = data.getStringExtra("birth");
            edt.setText(birth);
        }
    }
}
