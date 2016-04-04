package com.example.zhanshaoxiong.finalproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class WebViewActivity extends Activity {

    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        init();
    }
   private void init(){
       webView=(WebView)findViewById(R.id.webView);
       //覆盖webview默认通过第三方或者是系统浏览器打开网页的行为，使得网页可以在webview中打开
       webView.loadUrl("http://www.baidu.com");
       WebSettings webSettings=webView.getSettings();
       webSettings.setJavaScriptEnabled(true);
       webView.setWebViewClient(new WebViewClient() {
           @Override
           public boolean shouldOverrideUrlLoading(WebView view, String url) {
               //返回值是trur的时候控制网页在webview中打开，如果是false，调用系统浏览器或者第三方浏览器去打开
               view.loadUrl(url);
               return true;
           }
       });
       //webviewClient帮助webview去处理一些页面控制和请求通知
   }
    //改写物理按键返回的逻辑

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            if(webView.canGoBack())
                webView.goBack();//返回上一页面
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_web_view, menu);
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
