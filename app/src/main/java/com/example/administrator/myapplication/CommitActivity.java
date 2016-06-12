package com.example.administrator.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.AndroidCharacter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Administrator on 2016/5/26.
 */
public class CommitActivity extends BaseActivity{

    String[] homework1  = new String[]{"放一个图片","获取手机信息 分辨率 dpi","显示一张图片，点击后显示另一张循环显示","画出一个心"
    ,"画板","霓虹灯闪烁","布局","飞机","联系电话簿","radio","发送短信验证码","弹球游戏","13布局","下拉列表","自动播放图片","菜谱","自动播放图片类"
    ,"局部显示图片","自动搜索","19intent跳转",
            "三个选项卡","actionbar (闪退)","菜单练习","Dialog弹出框"
            ,"国际化","点击按钮发送短信的练习加上打电话的联系；","点击按钮获取联系人信息；","点击按钮打开选择能上网页的APP（包括自己写的Activity），去百度主页"
            ,"横屏和竖屏的时候显示不同的布局；","用异步任务的方法下载资源时显示进度条；"
            ,"下载图片打开","爆炸动画","sd卡文件管理器，图片视屏可以直接打开"
            ,"数据库操作","左划图片变大","添加手势","回到桌面手势","文本框输入汉字，用音频读出来","ContentProvider数据共享"
            ,"电话的监听","短信群发","震动","播放视频","录音播放"
            ,"视屏录制","闹铃","股票","shangchuan"
    };

    Class[] clazz = {Activity02.class,Activity03.class,Activity04.class,Activity05.class,Activity05_2.class,Activity07.class,
            Activity08.class,Activity09_1.class,Activity09_2.class
    ,Activity11.class,Activity12.class,Activity12_1.class,Activity13.class,Activity13_2.class,Activity13_3.class
            ,Activity13_4.class,Activity14.class,
            Activity15.class,Activity15_2.class,Activity19.class,
           Activity20.class,Activity21.class,Activity22.class,Activity23.class,
            Activity23_3.class,Activity24.class,Activity24_1.class,Activity24_2.class,
            Activity26.class,Activity27.class
    ,Activity27_2.class,Activity_boom.class,ActivitySdCardListFiles.class,
            ActivitySQLite01.class,Activity33.class,Activity35_1.class,Activity35_2.class,Activity36.class,ActivityGetTeacher_SQLite.class
        ,Activity_TelephonyManager.class,Activity_SMS.class,Activity_Vibrator.class,ActivityVideo.class,Activity_MediaRecorder.class
            ,ActivityRecordervideo.class,AlarmActivity.class,GetGupiaoActivity.class,Activityupload.class
    };


    ListView lv ;
    @Override
    public void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.commitactivity_layout);
        lv = (ListView) findViewById(R.id.commitlayout_lv1);


        ArrayAdapter a = new ArrayAdapter(this, android.R.layout.simple_list_item_1,homework1);
        lv.setAdapter(a);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(CommitActivity.this,clazz[position]);
                startActivity(i);
            }
        });

    }

    public void setHomework(){
    }
}
