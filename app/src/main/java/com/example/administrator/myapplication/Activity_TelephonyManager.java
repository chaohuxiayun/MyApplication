package com.example.administrator.myapplication;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.widget.Toast;

import com.baidu.tts.client.SpeechSynthesizer;
import com.baidu.tts.client.TtsMode;

/**
 * Created by Administrator on 2016/6/7.
 */
public class Activity_TelephonyManager extends Activity {

    TelephonyManager tmanager;
    SpeechSynthesizer speechSynthesizer;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nothing_layout);
        tmanager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        speechSynthesizer = SpeechSynthesizer.getInstance();
        speechSynthesizer.setContext(this);
        speechSynthesizer.setAppId("8224604");
        speechSynthesizer.setApiKey("hNV2qvnZG7pvLspli84TnY2z", "a858a5f0f2ca8c0460d602ad9fd9d24d");
        speechSynthesizer.initTts(TtsMode.ONLINE);
        mp = MediaPlayer.create(this,R.raw.bomb);
        PhoneStateListener pl = new PhoneStateListener(){
            @Override
            public void onCallStateChanged(int state, String incomingNumber) {
                switch(state){
                    case TelephonyManager.CALL_STATE_IDLE:
                        break;
                    case  TelephonyManager.CALL_STATE_OFFHOOK:
                        speechSynthesizer.speak("你挂了");
                        Toast.makeText(Activity_TelephonyManager.this, "挂断", Toast.LENGTH_SHORT).show();
                        mp.stop();
                        break;
                    case TelephonyManager.CALL_STATE_RINGING:
                        speechSynthesizer.speak(incomingNumber+"来电话了");
                        Toast.makeText(Activity_TelephonyManager.this, "来电话了", Toast.LENGTH_SHORT).show();
                        mp.start();
                        break;

                    default:
                        break;
                }
                super.onCallStateChanged(state, incomingNumber);
            }
        };
        tmanager.listen(pl,PhoneStateListener.LISTEN_CALL_STATE);
    }
}
