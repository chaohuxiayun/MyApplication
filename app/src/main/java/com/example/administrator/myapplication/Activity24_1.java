package com.example.administrator.myapplication;

import android.app.Activity;
import android.content.CursorLoader;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/5/31.
 */
public class Activity24_1 extends BaseActivity{

    TextView tv1;
    TextView tv2;

    @Override
    public void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.activity24_1_layout);
        tv1 = (TextView) findViewById(R.id.layout24_1_tv1);
        tv2 = (TextView) findViewById(R.id.layout24_1_tv2);

        Button btn = (Button) findViewById(R.id.layout24_1_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_GET_CONTENT);
                i.setType("vnd.android.cursor.item/phone");//MIME类型
                startActivityForResult(i,0);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 0 && resultCode== Activity.RESULT_OK)
        {
            Uri uri = data.getData();
            CursorLoader cl = new CursorLoader(this,uri,null,null,null,null);
            Cursor c = cl.loadInBackground();
            if(c.moveToFirst())
            {
                String contactId = c.getString(c.getColumnIndex(ContactsContract.Contacts._ID));
                String name = c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                String phone = "";

                Cursor phoneC = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,ContactsContract.CommonDataKinds.Phone.CONTACT_ID+" = "+contactId,null,null);
                while(phoneC.moveToNext())
                {
                    phone = phone + " " + phoneC.getString(phoneC.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                }

                phoneC.close();

                tv1.setText(name);
                tv2.setText(phone);
            }
            c.close();
        }
    }

    public void getlianxiren(View view){

    }

}
