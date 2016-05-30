package com.example.administrator.myapplication;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Administrator on 2016/5/30.
 */
public class Activity27 extends BaseActivity{

    TextView result ;
    EditText url;


    @Override
    public void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.activity27_layout);
        result = (TextView) findViewById(R.id.layout27_result);
        url = (EditText) findViewById(R.id.urlTxt);
    }

    public void getResources(View view){
        MyTask m = new MyTask(this);
        try {
            m.execute(new URL(url.getText().toString()));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    //异步任务下载资源时显示进度条
    class MyTask extends AsyncTask<URL,Integer,String>{

        ProgressDialog pd;
        Context ctx;
        int pdnum = 0;

        public MyTask(Context ctx){
            this.ctx = ctx;
        }


        @Override
        protected String doInBackground(URL... params) {

            StringBuilder sb = new StringBuilder();
            try{
                URLConnection urlConnection = params[0].openConnection();
                BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"UTF-8"));
                String str = null;
                while((str = br.readLine())!=null)
                {
                    sb.append(str + "\n");
                    pdnum++;
                    publishProgress(pdnum);
                }
            }catch(Exception e){
                Log.e("",e.getMessage());
            }

            return sb.toString();
        }

        @Override
        protected void onPreExecute() {

            pd = new ProgressDialog(ctx);
            pd.setTitle("下载进度");
            pd.setMessage("正在下载，请等待!");
            pd.setMax(500);
            pd.setCancelable(false);
            pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            pd.setIndeterminate(false);
            pd.show();

        }

        @Override
        protected void onPostExecute(String s) {
            String sdf = "";
            if(s == null || s.equals("")){
                sdf = "jkhk";
            }else{
                sdf = "qwewqeqw";
            }
            result.setText(sdf);
            pd.dismiss();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            pd.setProgress(values[0]);
        }
    }

}
