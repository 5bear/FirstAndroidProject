package com.example.zhanshaoxiong.finalproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GridViewActivity extends Activity implements AdapterView.OnItemClickListener {

    private GridView gridView;
    private List<Map<String,Object>>dataList;
    private SimpleAdapter simpleAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        gridView= (GridView) findViewById(R.id.gridView);
        dataList=new ArrayList<>();
        simpleAdapter=new SimpleAdapter(this,getData(),R.layout.item,new String[]{"pic","text"},new int[]{R.id.pic,R.id.text});
        gridView.setAdapter(simpleAdapter);
        /*
        1 准备数据源
        2 新建适配器
        3 加载适配器
        4 配置事件监听器
         */
    }
   public List<Map<String,Object>>getData(){
       for(int i=0;i<10;i++){
           Map<String,Object>map=new HashMap<String,Object>();
           map.put("pic",R.mipmap.ic_launcher);
           map.put("text","内容"+i);
           dataList.add(map);
       }
       return dataList;
   }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_grid_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
