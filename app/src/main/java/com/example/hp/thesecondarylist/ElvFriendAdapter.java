package com.example.hp.thesecondarylist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.GZIPOutputStream;

/**
 * Created by hp on 2019/12/17.
 */

public class ElvFriendAdapter extends BaseExpandableListAdapter {

    //Activity页面穿过来的三个参数
    private final MelvActivity mContext;
    private final ArrayList<String> mGroupList;
    private final ArrayList<ArrayList<String>> mItemList;
    public ElvFriendAdapter(MelvActivity melvActivity, ArrayList<String> groupList,
                            ArrayList<ArrayList<String>> itemList) {
        this.mContext = melvActivity;
        this.mGroupList = groupList;
        this.mItemList = itemList;

    }

    /*
    * 获取组的个数
    * */
    @Override
    public int getGroupCount() {
        return mGroupList.size();
    }

    //获取组内的成员个数
    @Override
    public int getChildrenCount(int groupPosition) {
        return mItemList.get(groupPosition).size();
    }

    //获取组项的内容
    @Override
    public Object getGroup(int groupPosition) {
        return mGroupList.get(groupPosition);
    }

    //获取子项的内容
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mItemList.get(groupPosition).get(childPosition);
    }

    //获取组项的id
    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    //获取子项的id
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    //是否有固定id 用来做局部刷新用的，在这不用
    @Override
    public boolean hasStableIds() {
        return false;
    }

    //获取组项视图 自己写layout
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        //获取自己写的group视图
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.group_elv, null, false);
        //拿到textview组件
        TextView tv = inflate.findViewById(R.id.group_tv1);
//        给组件设置内容
        tv.setText(mGroupList.get(groupPosition));
        return inflate;
    }

    //获取子项视图 自己写layout
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_elv, null, false);
        TextView tv = inflate.findViewById(R.id.item_tv1);
        tv.setText(mItemList.get(groupPosition).get(childPosition));
        return inflate;

    }

    //子项是否可以被选中
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
    }
}
