package com.example.administrator.myapplication;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.ArrayMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleAdapter.ViewBinder;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/5/27.
 */
public class Activity13_4 extends BaseActivity{

    List<FoodMap> list = new ArrayList<FoodMap>();
    List<Map<String,Object>> res = new ArrayList<Map<String,Object>>();

    View mView;
    ListView view1 ;
    FoodMap pc;

    TextView result;
    EditText edt;
    ImageView img;

    Handler h = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bundle b = msg.getData();
            String str = (String) b.get("str");

            res.clear();
            Gson gson = new Gson();
            pc = gson.fromJson(str,FoodMap.class);

            getSomthing();



         /* ListView view = (ListView) findViewById(R.id.listview);
            MyAdapter ma = new MyAdapter();
            view.setAdapter(ma);*/



        }
    };

    @Override
    public void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.activity13_4_layout);
        mView = LayoutInflater.from(Activity13_4.this).inflate(R.layout.activity13_4_row_layout,null);
        view1 = (ListView) findViewById(R.id.listview);
        edt = (EditText) findViewById(R.id.inputfoods);
    }
    public void findPhoneCity(View view)
    {

        new Thread(new Runnable() {
            @Override
            public void run() {
                String httpUrl = "http://apis.baidu.com/tngou/cook/name";
                BufferedReader reader = null;
                String result = null;

                try {
                    String t1= URLEncoder.encode(edt.getText().toString().trim(), "utf-8");
                    httpUrl = httpUrl + "?name=" + t1;
                    URL url = new URL(httpUrl);
                    HttpURLConnection connection = (HttpURLConnection) url
                            .openConnection();
                    connection.setRequestMethod("GET");

                    connection.setRequestProperty("apikey",  "562bafef6007883e2e8fffbbdfa9e6ac");
                    connection.connect();
                    InputStream is = connection.getInputStream();
                    reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                    String strRead = null;
                    StringBuffer sbf = new StringBuffer();
                    while ((strRead = reader.readLine()) != null) {
                        sbf.append(strRead);
                        sbf.append("\r\n");
                    }
                    result = sbf.toString();
                    Message m = new Message();
                    Bundle b = new Bundle();
                    b.putSerializable("str",result);
                    m.setData(b);
                    h.sendMessage(m);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /*class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return res.size();
        }

        @Override
        public Object getItem(int position) {
            return res.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater li = LayoutInflater.from(Ex10Activity.this);
            View view = li.inflate(R.layout.ex10_row_layout,null);
            ImageView img = (ImageView) findViewById(R.id.foodPic);
            TextView tv = (TextView) findViewById(R.id.foodName);

            Map<String,Object> obj = res.get(position);
          *//*  img.setImageURI((Uri) obj.get("pic"));*//*

            tv.setText((String) obj.get("message"));
            return view;
        }
    }*/

    public void getSomthing(){
        new Thread(new Runnable() {

            @Override
            public void run() {

                for(FoodMap.TngouBean ft:pc.getTngou()){
                    Map<String ,Object> m = new HashMap<String,Object>();
                    m.put("pic" ,getBitmap("http://tnfs.tngou.net/image"+ft.getImg()));
                    m.put("message",ft.getName()+"----"+ft.getMessage());
                    res.add(m);
                }
                SimpleAdapter sa = new SimpleAdapter(Activity13_4.this,res,R.layout.activity13_4_row_layout,new String[]{"pic","message"},new int[]{R.id.foodPic,R.id.foodName});


                sa.setViewBinder(new ViewBinder() {

                    public boolean setViewValue(View view, Object data,
                                                String textRepresentation) {
                        //判断是否为我们要处理的对象
                        if(view instanceof ImageView  && data instanceof Bitmap){
                            ImageView iv = (ImageView) view;

                            iv.setImageBitmap((Bitmap) data);
                            return true;
                        }else
                            return false;
                    }
                });
                view1.setAdapter(sa);

            }}).start();
    }

    public Bitmap getBitmap(String imageUrl){


        Bitmap mBitmap = null;
        try {
            URL url = new URL(imageUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            InputStream is = conn.getInputStream();
            mBitmap = BitmapFactory.decodeStream(is);


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return mBitmap;
    }
}
