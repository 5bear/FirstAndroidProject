package com.example.zhanshaoxiong.finalproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import HttpConnect.HttpConnect;


public class loginActivity extends Activity {
    private Context mContext;
    private Button LoginBtn;
    private EditText Name;
    private EditText Pwd;
    private HttpConnect httpConnect;
    private String username;
    private String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
        android.os.NetworkOnMainThreadException
        solution1:
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads().
                detectDiskWrites().detectNetwork().penaltyLog().build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectLeakedSqlLiteObjects().
                detectLeakedClosableObjects().penaltyLog().penaltyDeath().build());
        solution2:
        使用Thread、Runnable、Handler (推荐使用)
        在Runnable中做HTTP请求，不用阻塞UI线程～
        new Thread(runnable).start();
        Runnable runnable = new Runnable(){
        @Override
        public void run() {
            //
            // TODO: http request.
            //
            Map map=new HashMap();
            map.put("username",username);
            map.put("password",password);
            String result= null;
            try {
                result = httpConnect.sendPost("http://121.40.144.218:8080/Sign/loginCheck",map);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Log.i("result", result);
        }
    };
                */


        httpConnect=new HttpConnect();
        setContentView(R.layout.activity_login);
        username="";
        password="";
        LoginBtn= (Button) findViewById(R.id.loginBtn);
        Name=(EditText)findViewById(R.id.name);
        Pwd=(EditText)findViewById(R.id.pwd);
        mContext=this;
        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                将用户名密码存储
                 */
                username=Name.getText().toString();
                password=Pwd.getText().toString();

                new Thread(runnable).start();

                SharedPreferences sPref=getSharedPreferences("pref",MODE_PRIVATE);
                SharedPreferences.Editor editor=sPref.edit();
                editor.putString("name",username);
                editor.putString("pwd",password);
                editor.commit();
                Intent intent=new Intent();
                intent.setClass(mContext,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    Runnable runnable = new Runnable(){
        @Override
        public void run() {
            //
            // TODO: http request.
            //
            Map map=new HashMap();
            map.put("username",username);
            map.put("password",password);
            String result= null;
            try {
                result = httpConnect.sendPost("http://121.40.144.218:8080/Sign/loginCheck",map);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Log.i("result", result);
        }
    };
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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
