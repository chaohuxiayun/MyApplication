package com.example.administrator.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.baidu.tts.client.SpeechSynthesizer;
import com.baidu.tts.client.TtsMode;

/**
 * Created by Administrator on 2016/6/6.
 */
public class Activity36 extends BaseActivity {
    EditText ed;
    SpeechSynthesizer speechSynthesizer;

    @Override
    public void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.activity36_layout);
        ed = (EditText) findViewById(R.id.layout36_ed1);
        speechSynthesizer = SpeechSynthesizer.getInstance();
        speechSynthesizer.setContext(this);
        speechSynthesizer.setAppId("8224604");
        speechSynthesizer.setApiKey("hNV2qvnZG7pvLspli84TnY2z", "a858a5f0f2ca8c0460d602ad9fd9d24d");
        speechSynthesizer.initTts(TtsMode.ONLINE);

    }
    public void readed1(View view){
            speechSynthesizer.speak(ed.getText().toString().trim());
    }
}
