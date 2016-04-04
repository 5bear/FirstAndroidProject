package com.example.zhanshaoxiong.finalproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class rankListActivity extends Activity implements AdapterView.OnItemClickListener,AbsListView.OnScrollListener {
    private ListView rkList;
    private ArrayAdapter<String> arr_adapter;
    private SimpleAdapter sim_adapter;
    private List<Map<String,Object>> data_list;
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank_list);
        mContext=this;
        data_list=new ArrayList<Map<String,Object>>();
        rkList=(ListView)findViewById(R.id.rkList);
        String []arr_data={"GridView","Spinner","ProgressBar","WebView"};
        arr_adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arr_data);
       // sim_adapter=new SimpleAdapter(this,getData_list(),R.layout.item,new String[]{"pic","text"},new int[]{R.id.pic,R.id.text});
        //rkList.setAdapter(arr_adapter);
        rkList.setOnItemClickListener(this);
        rkList.setAdapter(arr_adapter);
    }
   private List<Map<String,Object>> getData_list(){
       for(int i=0;i<10;i++){
           Map<String,Object>map=new HashMap<String,Object>();
           map.put("pic",R.mipmap.ic_launcher);
           map.put("text","内容"+i);
           data_list.add(map);
       }
       return data_list;
   }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
       switch (position){
           case 0:
               Intent intent=new Intent();
               intent.setClass(mContext,GridViewActivity.class);
               startActivity(intent);
               break;
           case 1:
               intent=new Intent();
               intent.setClass(mContext,SpinnerActivity.class);
               startActivity(intent);
               break;
           case 2:
               intent=new Intent();
               intent.setClass(mContext, ProgressBarActivity.class);
               startActivity(intent);
               break;
           case 3:
               intent=new Intent();
               intent.setClass(mContext, WebViewActivity.class);
               startActivity(intent);
               break;
       }
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        switch(scrollState){
            case SCROLL_STATE_FLING://用户手指离开屏幕，仍然继续滑动
                break;
            case SCROLL_STATE_IDLE://已停止滑动
                break;
            case SCROLL_STATE_TOUCH_SCROLL://用户手指未离开屏幕，继续花滑动
                break;
        }

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

    }
}
