package com.example.administrator.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.RequestBody;

import java.io.File;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by Administrator on 2016/6/12.
 */
public class Activityupload extends Activity{

    EditText ed1;
    EditText ed2;
    EditText ed3;
    EditText ed4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitylayout);
        ed1 = (EditText) findViewById(R.id.name);
        ed2 = (EditText) findViewById(R.id.id);
        ed3 = (EditText) findViewById(R.id.birth);
        ed4 = (EditText) findViewById(R.id.filename);
        ed4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Activityupload.this,Getupimg.class);
                startActivityForResult(i,0);
            }
        });

    }
    public void upimg(View view) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.1.188:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        UploadimgInterface upi = retrofit.create(UploadimgInterface.class);
        File file = new File(ed4.getText().toString());
        RequestBody requestBody1 =  RequestBody.create(MediaType.parse("multipart/form-data"), file);
        Call<Message> c = upi.uploadStudentInfo(ed2.getText().toString(), ed1.getText().toString(), ed3.getText().toString(), file.getName(),requestBody1 );
        c.enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Response<Message> response, Retrofit retrofit) {
                Message m = response.body();
            }

            @Override
            public void onFailure(Throwable throwable) {
                Log.e("we",throwable.getMessage());
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == 123){
            String birth = data.getStringExtra("birth");
            ed4.setText(birth);
        }
    }
}
