package com.example.administrator.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by Administrator on 2016/6/7.
 */
public class Service01 extends Service {

    public int count;
    public boolean flag = true ;

    public MyBinder binder = new MyBinder();

    public class MyBinder extends Binder{
        public int getCount(){
            return count;
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(flag){
                    count++;
                    try {
                        Thread.sleep(1000);
                    }catch(Exception e){

                    }
                }
            }
        }).start();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }
}
