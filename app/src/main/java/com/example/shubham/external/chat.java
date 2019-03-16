package com.example.shubham.external;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class chat extends AppCompatActivity {
LinearLayout ll;
Button b1;
EditText t;
String sender,rec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        ll=findViewById(R.id.c_ll);
        b1=findViewById(R.id.c_b1);
        t=findViewById(R.id.c_t1);
        SharedPreferences sp=getSharedPreferences("wa",MODE_PRIVATE);
        sender=sp.getString("email","");
        Intent in=getIntent();
        rec=in.getStringExtra("friend");
        MyData d=new MyData();
        String str=d.dispchat(sender,rec);
        String chat[]=str.split(";");
        for(int i=0;i<chat.length-1;i++)
        {
            String c[]=chat[i].split(",");
            if(c[0].equals(sender))
            {
                TextView tv=new TextView(chat.this);
                tv.setText(c[2]);
                tv.setTextSize(24);
                tv.setTextColor(Color.BLUE);
                ll.addView(tv);
            }
            else
            {
                TextView tv=new TextView(chat.this);
                tv.setText(c[2]);
                tv.setTextSize(24);
                tv.setTextColor(Color.RED);
                ll.addView(tv);
            }

        }

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyData.savechat(sender,rec,t.getText().toString());
                TextView tv=new TextView(chat.this);
                tv.setText(t.getText().toString());
                tv.setTextSize(24);
                tv.setTextColor(Color.BLUE);
                ll.addView(tv);
            }
        });

    }
}
