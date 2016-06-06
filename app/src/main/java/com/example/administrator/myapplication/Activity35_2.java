package com.example.administrator.myapplication;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.Prediction;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/6/6.
 */
public class Activity35_2 extends Activity{

    GestureOverlayView geso;
    GestureLibrary gl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity35_2_layout);
        gl = GestureLibraries.fromFile("/mnt/sdcard/mygestures");
        if(gl.load()){
            Toast.makeText(Activity35_2.this, "手势文件加载成功", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(Activity35_2.this, "手势文件加载失败", Toast.LENGTH_SHORT).show();
        }
        geso = (GestureOverlayView) findViewById(R.id.layout35_2_ges);
        geso.addOnGesturePerformedListener(new GestureOverlayView.OnGesturePerformedListener() {
            @Override
            public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture) {
                ArrayList<Prediction> p = gl.recognize(gesture);
                ArrayList<String> result = new ArrayList<String>();
                for(Prediction pr:p){
                    if(pr.score >5){
                        result.add("与"+pr.name+"相似度"+pr.score);
                    }
                }
                if(result.size()>0){
                    new AlertDialog.Builder(Activity35_2.this)
                            .setMessage(result.get(0))
                            .setNegativeButton("取消",null)
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(Activity35_2.this, "将回到桌面", Toast.LENGTH_SHORT).show();
                                    Intent i = new Intent(Intent.ACTION_MAIN);
                                    i.addCategory(Intent.CATEGORY_HOME);
                                    startActivity(i);
                                }
                            })
                            .show();
                }
            }
        });

    }
}
