package com.example.administrator.myapplication;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Administrator on 2016/6/2.
 */
public class Activity27_2 extends BaseActivity{

    TextView result ;
    EditText ed;
    Button btn;
    ImageView img;

    Handler h = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                result.setText("下载完成");
            }
            if(msg.what == 2){
                result.setText("图片不存在，先下载");
            }
            if(msg.what == 4){
                result.setText("图片不存在，先下载");
            }
            try{
                if(msg.what == 3){
                    /*new FileInputStream("oneimg.png")*/
                    Bitmap bit = BitmapFactory.decodeStream(openFileInput("oneimg.png"));
                    img.setImageBitmap(bit);
                }
            }catch (Exception e){

            }


        }
    };


    @Override
    public void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.activity27_2_layout);

        result = (TextView) findViewById(R.id.layout27_2_result);
        ed = (EditText) findViewById(R.id.urlTxt2);
        img = (ImageView) findViewById(R.id.layout27_2_img1);


    }

    public void getResources2(View view){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    StringBuilder sb = new StringBuilder();
                    URL url = new URL(ed.getText().toString().trim());
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setConnectTimeout(3000);
                    conn.setRequestMethod("GET");
                    InputStream is = conn.getInputStream();
                    FileOutputStream fos ;

                    if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){

                        File sddir = Environment.getExternalStorageDirectory();

                        fos = new FileOutputStream(sddir.getCanonicalPath() +"/oneimg.png");

                    }else{
                        fos = openFileOutput("oneimg.png",MODE_WORLD_WRITEABLE);
                    }
                    byte[] b = new byte[1024];
                    int read = 0;
                    while((read = is.read(b)) > 0){
                        fos.write(b,0,read);
                        sb.append(b.toString());
                    }
                    fos.flush();
                    fos.close();
                    is.close();
                    Message m = new Message();
                    m.what = 1;
                    h.sendMessage(m);
                }catch (Exception e){
                    Log.e("1123",e.getMessage());
                }
            }
        }).start();
    }

    public  void openimg(View view){
        File file = new File("/mnt/sdcard/oneimg.png");
       /* try{*/
            if(!file.exists()){
                Message m = new Message();
                m.what = 4;
                h.sendMessage(m);
            }else{
                Message m = new Message();
                m.what = 3;
                h.sendMessage(m);
            }
     /*   }catch (IOException e){

        }*/

    }

    /*public void getResources(View view){
        MyTask m = new MyTask(this);
        try {
            m.execute(new URL(url.getText().toString()));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    //异步任务下载资源时显示进度条
    class MyTask extends AsyncTask<URL,Integer,String> {

        ProgressDialog pd;
        Context ctx;
        int pdnum = 0;

        String sdf = "";

        public MyTask(Context ctx){
            this.ctx = ctx;

        }


        @Override
        protected String doInBackground(URL... params) {


            HttpURLConnection conn = (HttpURLConnection) Uri(url.getText().toString()).openConnection();
            conn.setConnectTimeout(3000);
            conn.setRequestMethod("GET");


            sdf ="4";
            try{
                URLConnection urlConnection = params[0].openConnection();
                sdf ="41";

               InputStream is = (urlConnection.getInputStream());
                FileOutputStream os;
                sdf ="42";
                if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
                    File sddir = Environment.getExternalStorageDirectory();
                    os = ctx.openFileOutput(sddir.getCanonicalPath() +"oneimg.png",MODE_WORLD_WRITEABLE);
                }else{
                    os = ctx.openFileOutput("oneimg.png",MODE_WORLD_WRITEABLE);
                }
                sdf ="43";
                sdf = "3";
                byte[] b = new byte[1024];
                int hashead =0;
                while((hashead = is.read(b))>0){
                    os.write(b,0,hashead);
                    pdnum++;
                    publishProgress(pdnum);
                }
                os.flush();
                os.close();
                is.close();
                return "已读完，请查看";
            }catch(Exception e){
                Log.e("",e.getMessage());
                Log.e("","看这里");
            }

            return null;
        }

        @Override
        protected void onPreExecute() {

            pd = new ProgressDialog(ctx);
            pd.setTitle("下载进度");
            pd.setMessage("正在下载，请等待!");
            pd.setMax(100);
            pd.setCancelable(false);
            pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            pd.setIndeterminate(false);
            pd.show();

        }

        @Override
        protected void onPostExecute(String s) {

            *//*if(s == null || s.equals("")){
                    sdf = "1";
            }else{
                sdf = "2";
            }*//*
            result.setText(sdf);
            pd.dismiss();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            result.setText("你已经读到了第" + values[0] + "行");
            pd.setProgress(values[0]);
        }
    }*/

}
