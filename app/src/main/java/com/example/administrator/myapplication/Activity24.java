package com.example.administrator.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Administrator on 2016/5/31.
 */
public class Activity24 extends BaseActivity{

    EditText edt1;
    EditText edt2;
    EditText edt3;

    @Override
    public void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.activity24_layout);
        edt1 = (EditText) findViewById(R.id.layout24_edt1);
        edt2 = (EditText) findViewById(R.id.layout24_edt2);
        edt3 = (EditText) findViewById(R.id.layout24_edt3);
    }
    public void sendshortmessage(View view){
        String message = "smsto:" + edt2.getText().toString().trim();
        Uri uri = Uri.parse(message);
        Intent it = new Intent(Intent.ACTION_SENDTO);
        it.setData(uri);
        it.putExtra("sms_body", "能发短信吗？");
        startActivity(it);


    }
    public void callsomeone(View view ){
        String tel = "tel:" + edt1.getText().toString().trim();
        Intent i = new Intent();
        i.setAction(Intent.ACTION_DIAL);
        i.setData(Uri.parse(tel));
        startActivity(i);
    }

    public void sendmail(View view){
        String mail = "mailto:" + edt3.getText().toString().trim();
        Intent i = new Intent();
        i.setAction(Intent.ACTION_SENDTO);
        i.setData(Uri.parse(mail));
        startActivity(i);
    }
}
