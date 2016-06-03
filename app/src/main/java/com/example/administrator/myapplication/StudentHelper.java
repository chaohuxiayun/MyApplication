package com.example.administrator.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2016/6/3.
 */
public class StudentHelper extends SQLiteOpenHelper{

    public String create_sql = "create table student(_id int primary key,pic int,name varchar(40),age int )";

    public StudentHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(create_sql);
        ContentValues c = new ContentValues();
        c.put("_id",1);
        c.put("pic",R.drawable.icon_34);
        c.put("name","大娃");
        c.put("age",12);
        db.insert("student",null,c);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
