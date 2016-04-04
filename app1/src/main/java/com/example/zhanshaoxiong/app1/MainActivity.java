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
        //������xml�ļ����뵽activity��
        setContentView(R.layout.activity_main);
       /*
       *1.��ʼ����ǰ����ؼ�
       * findViewById����һ��view�Ķ���
       * ��Ҫǿ������ת��
       * 2.����button�ļ�������ͨ��������ʵ�����ǵ��buttonҪ����������
        */
        /*
        *1.�����ڲ���ʵ�ּ���

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //�ڵ�ǰOnclick�����м������Button����
                System.out.println("Button1�������");
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
        *2.����¼��ⲿ���д�� --�Ƚ��ټ�
        * 3���ӿڷ�ʽ

        bt1.setOnClickListener(new MyOnclickListener()
        {
            @Override
            public void onClick(View v) {
                super.onClick(v);
                Toast.makeText(MainActivity.this,"bt1Ҫִ�е��߼�",1).show();
            }
        });
        bt2.setOnClickListener(new MyOnclickListener()
        {
            @Override
            public void onClick(View v) {
                super.onClick(v);
                Toast.makeText(MainActivity.this,"bt2Ҫִ�е��߼�",1).show();
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
����ʹ�ô��ⲿ��ĵ���¼���ִ�д˲���
 */
class MyOnclickListener implements View.OnClickListener{
    @Override
    public void onClick(View v) {
        Log.i("tag","success");
        v.setAlpha(0.5f);//v�������Ķ���
    }
}