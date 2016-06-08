package com.example.administrator.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/6/7.
 */
public class SmsReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")){
            abortBroadcast();
            StringBuilder sb = new StringBuilder();
            Bundle b = intent.getExtras();
            if(b != null){
                Object[] pdus = (Object[]) b.get("pdus");
                SmsMessage[] sms = new SmsMessage[pdus.length];
                for(int i=0;i<pdus.length;i++){
                    sms[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                }
                for(SmsMessage s:sms){
                    sb.append("来信者");
                    sb.append(s.getDisplayOriginatingAddress());
                    sb.append("内容");
                    sb.append(s.getDisplayMessageBody());
                }
                Toast.makeText(context, sb.toString(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
