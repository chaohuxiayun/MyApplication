package com.example.administrator.myapplication;

import android.app.Activity;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * Created by Administrator on 2016/5/27.
 */
public class Activity13 extends BaseActivity {

    String[] operaName = {"最美的不是下雨天", "是和你躲雨的屋檐", "我非薄荷", "为何心凉", "我非柠檬"};
    String[][] peronName = {{"张三1", "李四1", "王五1", "马六1"}, {"张三2", "李四2", "王五2", "马六2"}, {"张三3", "李四3", "王五3", "马六3"}, {"张三4", "李四4", "王五4", "马六4"}, {"张三5", "李四5", "王五5", "马六5"}};
     @Override
     public void initContentView(Bundle savedInstanceState) {
         setContentView(R.layout.activity13_layout);
         ExpandableListView elv = (ExpandableListView) findViewById(R.id.expand1);
       /*  ExpandableListAdapter ela = new ExpandableListAdapter() {

             TextView getTextView(){
                 TextView tv = new TextView(Activity13.this);
                 return tv;

             }
             @Override
             public int getGroupCount() {
                 // TODO Auto-generated method stub
                 return str1.length;
             }

             @Override
             public Object getGroup(int groupPosition) {
                 // TODO Auto-generated method stub
                 return str1[groupPosition];
             }

             @Override
             public long getGroupId(int groupPosition) {
                 // TODO Auto-generated method stub
                 return groupPosition;
             }

             @Override
             public int getChildrenCount(int groupPosition) {
                 // TODO Auto-generated method stub
                 return str2[groupPosition].length;
             }

             @Override
             public Object getChild(int groupPosition, int childPosition) {
                 // TODO Auto-generated method stub
                 return str2[groupPosition][childPosition];
             }

             @Override
             public long getChildId(int groupPosition, int childPosition) {
                 // TODO Auto-generated method stub
                 return childPosition;
             }

             @Override
             public boolean hasStableIds() {
                 // TODO Auto-generated method stub
                 return true;
             }

             @Override
             public View getGroupView(int groupPosition, boolean isExpanded,
                                      View convertView, ViewGroup parent) {
                 // TODO Auto-generated method stub
                 LinearLayout ll = new LinearLayout(
                         Activity13.this);

                 TextView textView = getTextView();
                 textView.setTextColor(Color.BLACK);
                 textView.setText(getGroup(groupPosition).toString());
                 ll.addView(textView);

                 return ll;



             }

             @Override
             public View getChildView(int groupPosition, int childPosition,
                                      boolean isLastChild, View convertView, ViewGroup parent) {
                 // TODO Auto-generated method stub
                 LinearLayout ll = new LinearLayout(
                         Activity13.this);

                 TextView textView = getTextView();
                 textView.setText(getChild(groupPosition, childPosition)
                         .toString());
                 ll.addView(textView);
                 return ll;
             }

             @Override
             public boolean isChildSelectable(int groupPosition,
                                              int childPosition) {
                 // TODO Auto-generated method stub
                 return true;
             }

             @Override
             public boolean areAllItemsEnabled() {
                 // TODO Auto-generated method stub
                 return false;
             }

             @Override
             public long getCombinedChildId(long arg0, long arg1) {
                 // TODO Auto-generated method stub
                 return 0;
             }

             @Override
             public long getCombinedGroupId(long arg0) {
                 // TODO Auto-generated method stub
                 return 0;
             }

             @Override
             public boolean isEmpty() {
                 // TODO Auto-generated method stub
                 return false;
             }

             @Override
             public void onGroupCollapsed(int arg0) {
                 // TODO Auto-generated method stub

             }

             @Override
             public void onGroupExpanded(int arg0) {

             }

             @Override
             public void registerDataSetObserver(DataSetObserver arg0) {
                 // TODO Auto-generated method stub

             }

             @Override
             public void unregisterDataSetObserver(DataSetObserver arg0) {
                 // TODO Auto-generated method stub

             }
         };
         elv.setAdapter(ela);*/
    ExpandableListAdapter ela = new ExpandableListAdapter() {
        @Override
        public void registerDataSetObserver(DataSetObserver observer) {
        }

        @Override
        public void unregisterDataSetObserver(DataSetObserver observer) {
        }

        @Override
        public int getGroupCount() {
            return operaName.length;
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return peronName[groupPosition].length;
        }

        @Override
        public Object getGroup(int groupPosition) {
            return operaName[groupPosition];
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return peronName[groupPosition][childPosition];
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
//                TextView tv = new TextView(Ex13Activity.this);
//                tv.setText(operaName[groupPosition]);
            LayoutInflater li = LayoutInflater.from(Activity13.this);
            View v = li.inflate(android.R.layout.simple_list_item_1, null);
            TextView tv = (TextView) v.findViewById(android.R.id.text1);
            tv.setPadding(90, 0, 0, 0);
            tv.setText(operaName[groupPosition]);
            return v;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            TextView tv = new TextView(Activity13.this);
            tv.setText(peronName[groupPosition][childPosition]);
            return tv;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return false;
        }

        @Override
        public boolean areAllItemsEnabled() {
            return false;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public void onGroupExpanded(int groupPosition) {
        }

        @Override
        public void onGroupCollapsed(int groupPosition) {
        }

        @Override
        public long getCombinedChildId(long groupId, long childId) {
            return childId;
        }

        @Override
        public long getCombinedGroupId(long groupId) {
            return groupId;
        }
    };

    ExpandableListView view = (ExpandableListView) findViewById(R.id.expand1);
         view.setAdapter(ela);
}



}
