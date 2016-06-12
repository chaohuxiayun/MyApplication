package com.example.administrator.myapplication;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.GsonConverterFactory;


/**
 * Created by Administrator on 2016/6/12.
 */

public class GetGupiaoActivity extends Activity{

    EditText ed1;
    EditText ed2;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitygupiao_layout);
        ed1 = (EditText) findViewById(R.id.gupiao_ed1);
        ed2 = (EditText) findViewById(R.id.gupiao_ed2);
        tv = (TextView) findViewById(R.id.gupiao_tv);
    }

    public void getgupiao(View view){
        Retrofit retrofit = new  Retrofit.Builder().baseUrl("http://apis.baidu.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GetGuPiaoInterface gupiao  = retrofit.create(GetGuPiaoInterface.class);
        Call<GuPiao> c = gupiao.getgupiao("ccf924cd1c2bd7e36b3f4aa01f2457c9",ed1.getText().toString(),ed2.getText().toString());
       /* c.enqueue(new Callback<GuPiao>() {
            @Override
            public void onResponse(Call<GuPiao> call, Response<GuPiao> response) {
                GuPiao g = response.body();
                tv.setText(g.getStockinfo().getCurrentPrice()+""+g.getStockinfo().getClosingPrice());

            }

            @Override
            public void onFailure(Call<GuPiao> call, Throwable t) {

            }
        });*/
        c.enqueue(new Callback<GuPiao>() {
            @Override
            public void onResponse(Response<GuPiao> response, Retrofit retrofit) {
                GuPiao g = response.body();
                if(g == null){
                    Log.e("12313","sdfgs");
                }else{
                    Log.e("12313","1111111111111");
                }
               /* Log.e("12313",g.getStockinfo().getName());
                tv.setText(g.getStockinfo().getCurrentPrice()+""+g.getStockinfo().getClosingPrice());*/
            }

            @Override
            public void onFailure(Throwable throwable) {

            }
        });
    }

}

