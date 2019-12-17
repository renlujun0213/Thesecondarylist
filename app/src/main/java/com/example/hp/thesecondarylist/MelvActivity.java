package com.example.hp.thesecondarylist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;

import java.util.ArrayList;

public class MelvActivity extends AppCompatActivity {

    private static final String TAG = "MelvActivity";
    private ExpandableListView mElv;
    private ArrayList<String> mGroupList;
    private ArrayList<ArrayList<String>> mItemList;
    private ElvFriendAdapter mElvFriendAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elv);
        initData();//自己设置的数据
        initView();
        //listview 二级列表使用的步骤一模一样
        //1.写布局
        //2.找控件
        //3.创建适配器
        //4.setAdapter（）数据
    }

    private void initData() {
        mGroupList = new ArrayList<>();
        mGroupList.add("前任");
        mGroupList.add("现任");
        mGroupList.add("黑名单");

        ArrayList<String> preList = new ArrayList<>();
        preList.add("张三");
        preList.add("翠花");
        preList.add("铁柱");

        ArrayList<String> currentList = new ArrayList<>();
        currentList.add("shidan");

        ArrayList<String> blackList = new ArrayList<>();
        blackList.add("隔壁老王");
        blackList.add("宋大经纪人");

        mItemList = new ArrayList<>();
        mItemList.add(preList);
        mItemList.add(currentList);
        mItemList.add(blackList);
    }

    private void initView() {
        mElv = (ExpandableListView) findViewById(R.id.elv);
        mElvFriendAdapter = new ElvFriendAdapter(this,mGroupList,mItemList);
        mElv.setAdapter(mElvFriendAdapter);

        //监听
        //组项的点击监听
        mElv.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                Log.d(TAG, "onGroupClick: "+mGroupList.get(groupPosition));
                return false;
            }
        });

        //折叠和展开监听
        mElv.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                //展开监听
                Log.d(TAG, "展开: "+mGroupList.get(groupPosition));
            }
        });

        mElv.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                //Collapse折叠的意思，折叠监听
                Log.d(TAG, "折叠: "+mGroupList.get(groupPosition));
            }
        });

        //子项点击监听，isChildSelectable（）必须返回true
        mElv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Log.d(TAG, "onChildClick: "+mItemList.get(groupPosition).get(childPosition));
                return false;
            }
        });
    }
}
