package com.example.shubham.external;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Welcome extends AppCompatActivity {
 LinearLayout ll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ll=findViewById(R.id.w_ll);
        String uu=MyData.dispuser();
        String user[]=uu.split(",");
        for(int i=0;i<=user.length-1;i++)
        {
            TextView tv= new TextView(Welcome.this);
            tv.setText(user[i]);
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TextView tv=(TextView)v;
                    String str=tv.getText().toString();
                    Toast.makeText(Welcome.this, ""+str, Toast.LENGTH_SHORT).show();
                    Intent in =new Intent(Welcome.this,chat.class);
                    in.putExtra("friend",str);
                    startActivity(in);
                }
            });
            ll.addView(tv);
        }
    }
}
