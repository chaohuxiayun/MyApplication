package com.example.administrator.myapplication;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AlertDialog;
import android.telephony.SmsManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/6/7.
 */
public class Activity_SMS extends Activity {

    EditText numbers,content;
    Button select,send;
    SmsManager smsManager;
    ArrayList<String> sendlist = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms_layout);
        numbers = (EditText) findViewById(R.id.l_sms_ed1);
        content = (EditText) findViewById(R.id.l_sms_ed2);
        select = (Button) findViewById(R.id.l_sms_b1);
        send = (Button) findViewById(R.id.l_sms_b2);


        smsManager = SmsManager.getDefault();


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //循环遍历数组，向其中每一条号码发送短信
                for(String num:sendlist){
                    //向号码为num的电话发送短信
                    PendingIntent pi = PendingIntent.getActivity(Activity_SMS.this,0,new Intent(),0);
                    smsManager.sendTextMessage(num,null,content.getText().toString(),pi,null);
                }
                Toast.makeText(Activity_SMS.this, "短信发送完成", Toast.LENGTH_SHORT).show();
            }
        });

        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //从手机中查询所有的联系人
                final Cursor cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null);
                BaseAdapter ba = new BaseAdapter() {
                    @Override
                    public int getCount() {
                        return 0;
                    }

                    @Override
                    public Object getItem(int position) {
                        return null;
                    }

                    @Override
                    public long getItemId(int position) {
                        return 0;
                    }

                    @Override
                    public View getView(int position, View convertView, ViewGroup parent) {

                        cursor.moveToPosition(position);
                        CheckBox rb = new CheckBox(Activity_SMS.this);
                        String number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)).replace("-","").replace(" ","");
                        rb.setText(number);
                        if(isChecked(number)){
                            rb.setChecked(true);
                        }
                        return rb;
                    }
                };
                View selectView = getLayoutInflater().inflate(R.layout.activity_sms_layout_listview,null);
                final ListView lv = (ListView) selectView.findViewById(R.id.layout_fromteachersqlite_result_lv1);
                lv.setAdapter(ba);
                new AlertDialog.Builder(Activity_SMS.this).setView(selectView)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        sendlist.clear();
                        for(int i = 0;i<lv.getCount();i++){
                            CheckBox cb = (CheckBox) lv.getChildAt(i);
                            if(cb.isChecked()){
                                sendlist.add(cb.getText().toString());

                            }
                        }
                        numbers.setText(sendlist.toString());
                    }
                }).show();
            }
        });

    }

    public boolean isChecked(String number){
        for(String s1:sendlist){
            if(s1.equals(number)){
                return true;

            }

        }
        return false;
    }


}
