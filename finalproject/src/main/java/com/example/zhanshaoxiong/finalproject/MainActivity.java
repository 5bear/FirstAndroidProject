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
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cal.ExpressionUtil;


public class MainActivity extends Activity {

    private Button startButton,resultButton,doneButton,noanswerButton;
    private ImageView img1,img2,img3,img4;
    private EditText exp;
    private TextView tv1;
    private TextView tvName;
    private int random1;
    private int random2;
    private int random3;
    private int random4;
    private List<String> expList;
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        random1=0;
        random2=0;
        random3=0;
        random4=0;
        mContext=this;
        tvName=(TextView)findViewById(R.id.name);
        startButton=(Button)findViewById(R.id.start_button);//发牌
        resultButton=(Button)findViewById(R.id.button_point);//提示
        doneButton=(Button)findViewById(R.id.result_button);//解答
        noanswerButton=(Button)findViewById(R.id.noanswer_button);//无答案
        exp=(EditText)findViewById(R.id.editText);
        img1=(ImageView)findViewById(R.id.imageView1);
        img2=(ImageView)findViewById(R.id.imageView2);
        img3=(ImageView)findViewById(R.id.imageView3);
        img4=(ImageView)findViewById(R.id.imageView4);
        tv1=(TextView)findViewById(R.id.textViewPoint);
        SharedPreferences sPref=getSharedPreferences("pref",MODE_PRIVATE);
        String name = sPref.getString("name","name" );
         Log.i("name",name);
        tvName.setText(name);
        //???
        noanswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String>str=new ArrayList<String>();

                expList=Calculate(random1+1,random2+1,random3+1,random4+1);
                for(int i=0;i<expList.size();i++)
                {
                    str.add(expList.get(i));
                }
                expList=Calculate(random1+1,random2+1,random4+1,random3+1);
                for(int i=0;i<expList.size();i++)
                {
                    str.add(expList.get(i));
                }
                expList= Calculate(random1+1,random3+1,random4+1,random2+1);
                for(int i=0;i<expList.size();i++)
                {
                    str.add(expList.get(i));
                }
                expList=Calculate(random1+1,random3+1,random2+1,random4+1);
                for(int i=0;i<expList.size();i++)
                {
                    str.add(expList.get(i));
                }
                expList= Calculate(random1+1,random4+1,random2+1,random3+1);
                for(int i=0;i<expList.size();i++)
                {
                    str.add(expList.get(i));
                }
                expList=Calculate(random1+1,random4+1,random3+1,random2+1);
                for(int i=0;i<expList.size();i++)
                {
                    str.add(expList.get(i));
                }
                expList=Calculate(random2+1,random1+1,random3+1,random4+1);
                for(int i=0;i<expList.size();i++)
                {
                    str.add(expList.get(i));
                }
                expList=Calculate(random2+1,random1+1,random4+1,random3+1);
                for(int i=0;i<expList.size();i++)
                {
                    str.add(expList.get(i));
                }
                expList= Calculate(random2+1,random3+1,random1+1,random4+1);
                for(int i=0;i<expList.size();i++)
                {
                    str.add(expList.get(i));
                }
                expList= Calculate(random2+1,random3+1,random4+1,random1+1);
                for(int i=0;i<expList.size();i++)
                {
                    str.add(expList.get(i));
                }
                expList=Calculate(random2+1,random4+1,random3+1,random1+1);
                for(int i=0;i<expList.size();i++)
                {
                    str.add(expList.get(i));
                }
                expList= Calculate(random2+1,random4+1,random1+1,random3+1);
                for(int i=0;i<expList.size();i++)
                {
                    str.add(expList.get(i));
                }
                expList=Calculate(random3+1,random1+1,random2+1,random4+1);
                for(int i=0;i<expList.size();i++)
                {
                    str.add(expList.get(i));
                }
                expList=Calculate(random3+1,random1+1,random4+1,random2+1);
                for(int i=0;i<expList.size();i++)
                {
                    str.add(expList.get(i));
                }
                expList=Calculate(random3+1,random2+1,random4+1,random1+1);
                for(int i=0;i<expList.size();i++)
                {
                    str.add(expList.get(i));
                }
                expList=Calculate(random3+1,random2+1,random1+1,random4+1);
                for(int i=0;i<expList.size();i++)
                {
                    str.add(expList.get(i));
                }
                expList=Calculate(random3+1,random4+1,random1+1,random2+1);
                for(int i=0;i<expList.size();i++)
                {
                    str.add(expList.get(i));
                }
                expList=  Calculate(random3+1,random4+1,random2+1,random1+1);
                for(int i=0;i<expList.size();i++)
                {
                    str.add(expList.get(i));
                }
                expList= Calculate(random4+1,random1+1,random2+1,random3+1);
                for(int i=0;i<expList.size();i++)
                {
                    str.add(expList.get(i));
                }
                expList=Calculate(random4+1,random1+1,random3+1,random2+1);
                for(int i=0;i<expList.size();i++)
                {
                    str.add(expList.get(i));
                }
                expList=Calculate(random4+1,random2+1,random3+1,random1+1);
                for(int i=0;i<expList.size();i++)
                {
                    str.add(expList.get(i));
                }
                expList=Calculate(random4+1,random2+1,random1+1,random3+1);
                for(int i=0;i<expList.size();i++)
                {
                    str.add(expList.get(i));
                }
                expList=  Calculate(random4+1,random3+1,random1+1,random2+1);
                for(int i=0;i<expList.size();i++)
                {
                    str.add(expList.get(i));
                }
                expList=Calculate(random4+1,random3+1,random2+1,random1+1);
                for(int i=0;i<expList.size();i++)
                {
                    str.add(expList.get(i));
                }
                if(str.size()==0&&random1!=0&&random2!=0&&random3!=0&&random4!=0)//success
                {
                    Intent intent=new Intent();
                    intent.setClass(mContext,SuccessActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Intent intent=new Intent();
                    intent.setClass(mContext,failActivity.class);
                    startActivity(intent);
                }
            }
        });
        //??????
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String expression=exp.getText().toString();
                double result=0;
                boolean flag=false;
                try {
                    ExpressionUtil cal = new ExpressionUtil();
                     result = cal.eval(expression);
                    flag = isAllDigitRight(expression);
                   Log.i("result",new Double(result).toString());
                    Log.i("expression",expression);
                    if(flag)
                       Log.i("flag","true");
                    else
                        Log.i("flag","false");
                }catch(Exception exption){
                    Intent intent=new Intent();
                    intent.setClass(mContext,failActivity.class);
                    startActivity(intent);
                }

                boolean f=false;
                if(random1!=0||random2!=0||random3!=0||random4!=0)
                    f=true;
                if(result==(double)24&&flag==true&&f)//Success
                {
                    Intent intent=new Intent();
                    intent.setClass(mContext,SuccessActivity.class);
                    startActivity(intent);
                }
                else //fail
                {
                    Intent intent=new Intent();
                    intent.setClass(mContext,failActivity.class);
                    startActivity(intent);
                }
            }
        });
        //????
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.setText("");
               int[]pkList={R.mipmap.pk1,R.mipmap.pk2,R.mipmap.pk3,R.mipmap.pk4,R.mipmap.pk5,R.mipmap.pk6,R.mipmap.pk7,R.mipmap.pk8,R.mipmap.pk9,R.mipmap.pk10,R.mipmap.pk11,R.mipmap.pk12,R.mipmap.pk13};
                random1=new Random().nextInt(13);
                img1.setImageResource(pkList[random1]);
                random2=new Random().nextInt(13);
                while(random1==random2)
                    random2=new Random().nextInt(13);
                img2.setImageResource(pkList[random2]);
               random3=new Random().nextInt(13);
                while(random3==random2||random3==random1)
                    random3=new Random().nextInt(13);
                img3.setImageResource(pkList[random3]);
               random4=new Random().nextInt(13);
                while(random4==random3||random4==random2||random4==random1)
                    random4=new Random().nextInt(13);
                img4.setImageResource(pkList[random4]);

            }
        });
        //?????
        resultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* String expression=exp.getText().toString();
                ExpressionUtil cal=new ExpressionUtil();
                double result=cal.eval(expression);*/
               /*
                     **?ж????????????????
               for (int i=0;i<expression.length();i++)
                {
                    System.out.println(expression.charAt(i)+","+random1+","+random2+","+random3+","+random4);
                    if((expression.charAt(i)-'0')==random1)
                        System.out.println("success");
                    if((expression.charAt(i)-'0')!=(random1+1)&&(expression.charAt(i)-'0')!=(random2+1)&&(expression.charAt(i)-'0')!=(random3+1)&&(expression.charAt(i)-'0')!=(random4+1))
                    {
                        tv1.setText("fail");
                        return ;
                    }
                }*/
                 /*
                if(result==24) {
                    tv1.setText("success!");
                }
                else
                    tv1.setText("fail");*/
                List<String>str=new ArrayList<String>();

                expList=Calculate(random1+1,random2+1,random3+1,random4+1);
                for(int i=0;i<expList.size();i++)
                {
                    str.add(expList.get(i));
                }
                expList=Calculate(random1+1,random2+1,random4+1,random3+1);
                for(int i=0;i<expList.size();i++)
                {
                    str.add(expList.get(i));
                }
                expList= Calculate(random1+1,random3+1,random4+1,random2+1);
                for(int i=0;i<expList.size();i++)
                {
                    str.add(expList.get(i));
                }
                expList=Calculate(random1+1,random3+1,random2+1,random4+1);
                for(int i=0;i<expList.size();i++)
                {
                    str.add(expList.get(i));
                }
                expList= Calculate(random1+1,random4+1,random2+1,random3+1);
                for(int i=0;i<expList.size();i++)
                {
                    str.add(expList.get(i));
                }
                expList=Calculate(random1+1,random4+1,random3+1,random2+1);
                for(int i=0;i<expList.size();i++)
                {
                    str.add(expList.get(i));
                }
                expList=Calculate(random2+1,random1+1,random3+1,random4+1);
                for(int i=0;i<expList.size();i++)
                {
                    str.add(expList.get(i));
                }
                expList=Calculate(random2+1,random1+1,random4+1,random3+1);
                for(int i=0;i<expList.size();i++)
                {
                    str.add(expList.get(i));
                }
                expList= Calculate(random2+1,random3+1,random1+1,random4+1);
                for(int i=0;i<expList.size();i++)
                {
                    str.add(expList.get(i));
                }
                expList= Calculate(random2+1,random3+1,random4+1,random1+1);
                for(int i=0;i<expList.size();i++)
                {
                    str.add(expList.get(i));
                }
                expList=Calculate(random2+1,random4+1,random3+1,random1+1);
                for(int i=0;i<expList.size();i++)
                {
                    str.add(expList.get(i));
                }
                expList= Calculate(random2+1,random4+1,random1+1,random3+1);
                for(int i=0;i<expList.size();i++)
                {
                    str.add(expList.get(i));
                }
                expList=Calculate(random3+1,random1+1,random2+1,random4+1);
                for(int i=0;i<expList.size();i++)
                {
                    str.add(expList.get(i));
                }
                expList=Calculate(random3+1,random1+1,random4+1,random2+1);
                for(int i=0;i<expList.size();i++)
                {
                    str.add(expList.get(i));
                }
                expList=Calculate(random3+1,random2+1,random4+1,random1+1);
                for(int i=0;i<expList.size();i++)
                {
                    str.add(expList.get(i));
                }
                expList=Calculate(random3+1,random2+1,random1+1,random4+1);
                for(int i=0;i<expList.size();i++)
                {
                    str.add(expList.get(i));
                }
                expList=Calculate(random3+1,random4+1,random1+1,random2+1);
                for(int i=0;i<expList.size();i++)
                {
                    str.add(expList.get(i));
                }
                expList=  Calculate(random3+1,random4+1,random2+1,random1+1);
                for(int i=0;i<expList.size();i++)
                {
                    str.add(expList.get(i));
                }
                expList= Calculate(random4+1,random1+1,random2+1,random3+1);
                for(int i=0;i<expList.size();i++)
                {
                    str.add(expList.get(i));
                }
                expList=Calculate(random4+1,random1+1,random3+1,random2+1);
                for(int i=0;i<expList.size();i++)
                {
                    str.add(expList.get(i));
                }
                expList=Calculate(random4+1,random2+1,random3+1,random1+1);
                for(int i=0;i<expList.size();i++)
                {
                    str.add(expList.get(i));
                }
                expList=Calculate(random4+1,random2+1,random1+1,random3+1);
                for(int i=0;i<expList.size();i++)
                {
                    str.add(expList.get(i));
                }
                expList=  Calculate(random4+1,random3+1,random1+1,random2+1);
                for(int i=0;i<expList.size();i++)
                {
                    str.add(expList.get(i));
                }
                expList=Calculate(random4+1,random3+1,random2+1,random1+1);
                for(int i=0;i<expList.size();i++)
                {
                    str.add(expList.get(i));
                }
                String result;
                if(random1==0&&random2==0&&random3==0&&random4==0)
                    result="Please enter your answer";
                else {
                    if (str.size() == 0)
                        result = "No Answer!";
                    else {
                        result = "example:" + str.get(new Random().nextInt(str.size()));
                    }
                }
            tv1.setText(result);

            }
        });
    }
    /*
    ?ж?????????????24?????????
     */
    public List<String> Calculate(int a,int b,int c,int d)
    {
        List<String> list=new ArrayList<String>();
        String exp;
        if (a+b+c+d==24)
        {
            StringBuffer sb = new StringBuffer();
            sb.append(a);
            sb.append('+');
            sb.append(b);
            sb.append('+');
            sb.append(c);
            sb.append('+');
            sb.append(d);
            exp=sb.toString();
            list.add(exp);
        }
        else if (a+b+c-d==24)
        {
            StringBuffer sb = new StringBuffer();
            sb.append(a);
            sb.append('+');
            sb.append(b);
            sb.append('+');
            sb.append(c);
            sb.append('-');
            sb.append(d);
            exp=sb.toString();
            list.add(exp);
        }
        else if ((a+b)*(c+d)==24)
        {
            StringBuffer sb = new StringBuffer();
            sb.append('(');
            sb.append(a);
            sb.append('+');
            sb.append(b);
            sb.append(')');
            sb.append('*');
            sb.append('(');
            sb.append(c);
            sb.append('+');
            sb.append(d);
            sb.append(')');
            exp=sb.toString();
            list.add(exp);
        }
        else if ((a-b)*(c+d)==24)
        {
            StringBuffer sb = new StringBuffer();
            sb.append('(');
            sb.append(a);
            sb.append('-');
            sb.append(b);
            sb.append(')');
            sb.append('*');
            sb.append('(');
            sb.append(c);
            sb.append('+');
            sb.append(d);
            sb.append(')');
            exp=sb.toString();
            list.add(exp);
        }
        else if ((a-b)*(c-d)==24)
        {
            StringBuffer sb = new StringBuffer();
            sb.append('(');
            sb.append(a);
            sb.append('-');
            sb.append(b);
            sb.append(')');
            sb.append('*');
            sb.append('(');
            sb.append(c);
            sb.append('-');
            sb.append(d);
            sb.append(')');
            exp=sb.toString();
            list.add(exp);
        }
        else if ((a+b+c)*d==24)
        {
            StringBuffer sb = new StringBuffer();
            sb.append('(');
            sb.append(a);
            sb.append('+');
            sb.append(b);
             sb.append('+');
            sb.append(c);
            sb.append(')');
            sb.append("*");
            sb.append(d);
            exp=sb.toString();
            list.add(exp);
        }
        else if ((a-b-c)*d==24)
        {
            StringBuffer sb = new StringBuffer();
            sb.append('(');
            sb.append(a);
            sb.append('-');
            sb.append(b);
            sb.append('-');
            sb.append(c);
            sb.append(')');
            sb.append("*");
            sb.append(d);
            exp=sb.toString();
            list.add(exp);
        }
        else if ((a+b-c)*d==24)
        {
            StringBuffer sb = new StringBuffer();
            sb.append('(');
            sb.append(a);
            sb.append('+');
            sb.append(b);
            sb.append('-');
            sb.append(c);
            sb.append(')');
            sb.append("*");
            sb.append(d);
            exp=sb.toString();
            list.add(exp);
        }
        else if ((double)((a*b*c)/(float)d)==24)
        {
            StringBuffer sb = new StringBuffer();
            sb.append('(');
            sb.append(a);
            sb.append('*');
            sb.append(b);
            sb.append('*');
            sb.append(c);
            sb.append(')');
            sb.append("/");
            sb.append(d);
            exp=sb.toString();
            list.add(exp);
        }
        else if ((a*b)*(c+d)==24)
        {
            StringBuffer sb = new StringBuffer();
            sb.append('(');
            sb.append(a);
            sb.append('*');
            sb.append(b);
            sb.append(')');
            sb.append('*');
            sb.append('(');
            sb.append(c);
            sb.append('+');
            sb.append(d);
            sb.append(')');
            exp=sb.toString();
            list.add(exp);
        }
        else if ((a*b)*(c-d)==24)
        {
            StringBuffer sb = new StringBuffer();
            sb.append('(');
            sb.append(a);
            sb.append('*');
            sb.append(b);
            sb.append(')');
            sb.append('*');
            sb.append('(');
            sb.append(c);
            sb.append('-');
            sb.append(d);
            sb.append(')');
            exp=sb.toString();
            list.add(exp);
        }
        else if ((a*b)*c-d==24)
        {
            StringBuffer sb = new StringBuffer();
            sb.append('(');
            sb.append(a);
            sb.append('*');
            sb.append(b);
            sb.append(')');
            sb.append('*');
            sb.append(c);
            sb.append('-');
            sb.append(d);
            exp=sb.toString();
            list.add(exp);
        }
        else if ((a*b)*c+d==24)
        {
            StringBuffer sb = new StringBuffer();
            sb.append('(');
            sb.append(a);
            sb.append('*');
            sb.append(b);
            sb.append(')');
            sb.append('*');
            sb.append(c);
            sb.append('+');
            sb.append(d);

            exp=sb.toString();
            list.add(exp);
        }
        else if (a*b*c*d==24)
        {
            StringBuffer sb = new StringBuffer();

            sb.append(a);
            sb.append('*');
            sb.append(b);
            sb.append('*');
            sb.append(c);
            sb.append('*');
            sb.append(d);

            exp=sb.toString();
            list.add(exp);
        }
        else if ((double)(a+b)+(c/(float)d)==24)
        {
            StringBuffer sb = new StringBuffer();
            sb.append('(');
            sb.append(a);
            sb.append('+');
            sb.append(b);
            sb.append(')');
            sb.append('+');
            sb.append("(");
            sb.append(c);
            sb.append('/');
            sb.append(d);
            sb.append(')');
            exp=sb.toString();
            list.add(exp);
        }
        else if ((double)(a+b)*(c/(float)d)==24)
        {
            StringBuffer sb = new StringBuffer();
            sb.append('(');
            sb.append(a);
            sb.append('*');
            sb.append(b);
            sb.append(')');
            sb.append('*');
            sb.append('(');
            sb.append(c);
            sb.append('/');
            sb.append(d);
            sb.append(')');
            exp=sb.toString();
            list.add(exp);
        }
        else if ((a*b)+c+d==24)
        {
            StringBuffer sb = new StringBuffer();
            sb.append('(');
            sb.append(a);
            sb.append('*');
            sb.append(b);
            sb.append(')');
            sb.append('+');
            sb.append(c);
            sb.append('+');
            sb.append(d);

            exp=sb.toString();
            list.add(exp);
        }
        else if ((a*b)+c-d==24)
        {
            StringBuffer sb = new StringBuffer();
            sb.append('(');
            sb.append(a);
            sb.append('*');
            sb.append(b);
            sb.append(')');
            sb.append('+');
            sb.append(c);
            sb.append('-');
            sb.append(d);

            exp=sb.toString();
            list.add(exp);
        }
        else if ((double)(a*b)-(c/(float)d)==24)
        {
            StringBuffer sb = new StringBuffer();
            sb.append('(');
            sb.append(a);
            sb.append('*');
            sb.append(b);
            sb.append(')');
            sb.append('-');
            sb.append('(');
            sb.append(c);
            sb.append('/');
            sb.append(d);
            sb.append(')');
            exp=sb.toString();
            list.add(exp);
        }
        else if ((double)(a*b)+(c/(float)d)==24)
        {
            StringBuffer sb = new StringBuffer();
            sb.append('(');
            sb.append(a);
            sb.append('*');
            sb.append(b);
            sb.append(')');
            sb.append('+');
            sb.append('(');
            sb.append(c);
            sb.append('/');
            sb.append(d);
            sb.append(')');
            exp=sb.toString();
            list.add(exp);
        }
        else if ((a*b)-c-d==24)
        {
            StringBuffer sb = new StringBuffer();
            sb.append('(');
            sb.append(a);
            sb.append('*');
            sb.append(b);
            sb.append(')');
            sb.append('-');
            sb.append(c);
            sb.append('-');
            sb.append(d);

            exp=sb.toString();
            list.add(exp);
        }
        else if ((a*b)+(c*d)==24)
        {
            StringBuffer sb = new StringBuffer();
            sb.append('(');
            sb.append(a);
            sb.append('*');
            sb.append(b);
            sb.append(')');
            sb.append('+');
            sb.append('(');
            sb.append(c);
            sb.append('*');
            sb.append(d);
            sb.append(')');
            exp=sb.toString();
            list.add(exp);
        }
        else if ((a*b)-(c*d)==24)
        {
            StringBuffer sb = new StringBuffer();
            sb.append('(');
            sb.append(a);
            sb.append('*');
            sb.append(b);
            sb.append(')');
            sb.append('-');
            sb.append('(');
            sb.append(c);
            sb.append('*');
            sb.append(d);
            sb.append(')');
            exp=sb.toString();
            list.add(exp);
        }
        else if ((double)(a*b)/(float)(c*d)==24)
        {
            StringBuffer sb = new StringBuffer();
            sb.append('(');
            sb.append(a);
            sb.append('*');
            sb.append(b);
            sb.append(')');
            sb.append('/');
            sb.append('(');
            sb.append(c);
            sb.append('*');
            sb.append(d);
            sb.append(')');
            exp=sb.toString();
            list.add(exp);
        }
        else if ((double)(a*b)/(float)(c-d)==24)
        { StringBuffer sb = new StringBuffer();
            sb.append('(');
            sb.append(a);
            sb.append('*');
            sb.append(b);
            sb.append(')');
            sb.append('/');
            sb.append('(');
            sb.append(c);
            sb.append('-');
            sb.append(d);
            sb.append(')');
            exp=sb.toString();
            list.add(exp);}
        else if ((double)(a*b)/(float)(c+d)==24)
        {
            StringBuffer sb = new StringBuffer();
            sb.append('(');
            sb.append(a);
            sb.append('*');
            sb.append(b);
            sb.append(')');
            sb.append('/');
            sb.append('(');
            sb.append(c);
            sb.append('+');
            sb.append(d);
            sb.append(')');
            exp=sb.toString();
            list.add(exp);
        }

        return list;
    }
    //???????????????е?????
    public static List<String> expList(String exp)
    {
        List<String> expList=new ArrayList<String>();
        int i=0;
        while(i<exp.length())
        {
            String digit = null;
            if(exp.charAt(i)=='0'||exp.charAt(i)=='1'||exp.charAt(i)=='2'||exp.charAt(i)=='3'||exp.charAt(i)=='4'||exp.charAt(i)=='5'||exp.charAt(i)=='6'||exp.charAt(i)=='7'||exp.charAt(i)=='8'||exp.charAt(i)=='9')
            {
                int j=i+1;
                if(j<exp.length())
                {
                    if(exp.charAt(j)=='0'||exp.charAt(j)=='1'||exp.charAt(j)=='2'||exp.charAt(j)=='3'||exp.charAt(j)=='4'||exp.charAt(j)=='5'||exp.charAt(j)=='6'||exp.charAt(j)=='7'||exp.charAt(j)=='8'||exp.charAt(j)=='9')
                    {
                        digit=exp.substring(i,j+1);
                        i=j;
                    }
                    else
                    {
                        digit=exp.substring(i,i+1);

                    }
                }
                else
                    digit=exp.substring(i,i+1);
            }
            i++;
            //System.out.println(digit);
            if(digit!=null)
                expList.add(digit);
        }
        return expList;
    }
    //?ж?????????????? ??????????
    public boolean isAllDigitRight(String exp)
    {
       List<String> expList=expList(exp);
        for(int i=0;i<expList.size();i++)
        {
            if(Integer.parseInt(expList.get(i))!=random1+1&&Integer.parseInt(expList.get(i))!=random2+1&&Integer.parseInt(expList.get(i))!=random3+1&&Integer.parseInt(expList.get(i))!=random4+1)
                return false;
        }
        return true;
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
