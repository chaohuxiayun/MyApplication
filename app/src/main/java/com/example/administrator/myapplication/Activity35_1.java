package com.example.administrator.myapplication;

import android.app.Activity;
import android.content.DialogInterface;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016/6/6.
 */
public class Activity35_1 extends Activity {

    GestureOverlayView ges;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity35_1_layout);
        ges = (GestureOverlayView) findViewById(R.id.layout35_1_ges);
        ges.setGestureColor(Color.RED);
        ges.setGestureStrokeWidth(5);
        ges.addOnGesturePerformedListener(new GestureOverlayView.OnGesturePerformedListener() {
            @Override
            public void onGesturePerformed(GestureOverlayView overlay, final Gesture gesture) {
                View saveDialog = getLayoutInflater().inflate(R.layout.activity35_1_save_layout,null);
                ImageView iv = (ImageView) saveDialog.findViewById(R.id.layout35_1_save_show);
                final EditText ed = (EditText) saveDialog.findViewById(R.id.layout35_1_save_ed);
                Bitmap bit = gesture.toBitmap(128,128,10,0xffff0000);

                iv.setImageBitmap(bit);
                new AlertDialog.Builder(Activity35_1.this)
                        .setView(saveDialog)
                        .setPositiveButton("保存", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                GestureLibrary gl = GestureLibraries.fromFile("/mnt/sdcard/mygestures1");
                                gl.addGesture(ed.getText().toString(),gesture);
                                gl.save();
                            }
                        }).setNegativeButton("取消",null)
                        .show();
            }
        });
    }



}
