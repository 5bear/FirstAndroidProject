package com.example.zhanshaoxiong.app1;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends Activity {

    private Button bt1;
    private Button bt2;
    private CheckBox cb1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //将布局xml文件引入到activity中
        setContentView(R.layout.activity_main);
       /*
       *1.初始化当前所需控件
       * findViewById返回一个view的对象
       * 需要强制类型转换
       * 2.设置button的监听器，通过监听器实现我们点击button要操作的事情
        */
        /*
        *1.匿名内部类实现监听

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //在当前Onclick方法中监听点击Button动作
                System.out.println("Button1被点击了");
            }
        }); */
        bt1=(Button)findViewById(R.id.button1);
        bt2=(Button)findViewById(R.id.button2);
        cb1=(CheckBox)findViewById(R.id.checkBox);
        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });
        /*
        *2.点击事件外部类的写法 --比较少见
        * 3。接口方式

        bt1.setOnClickListener(new MyOnclickListener()
        {
            @Override
            public void onClick(View v) {
                super.onClick(v);
                Toast.makeText(MainActivity.this,"bt1要执行的逻辑",1).show();
            }
        });
        bt2.setOnClickListener(new MyOnclickListener()
        {
            @Override
            public void onClick(View v) {
                super.onClick(v);
                Toast.makeText(MainActivity.this,"bt2要执行的逻辑",1).show();
            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
/*
所有使用此外部类的点击事件都执行此操作
 */
class MyOnclickListener implements View.OnClickListener{
    @Override
    public void onClick(View v) {
        Log.i("tag","success");
        v.setAlpha(0.5f);//v代表点击的对象
    }
}