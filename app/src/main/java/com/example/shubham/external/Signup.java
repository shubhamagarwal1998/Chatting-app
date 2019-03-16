package com.example.shubham.external;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends AppCompatActivity {
EditText t1,t2,t3;
Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
       t1=findViewById(R.id.s_t1);
        t2=findViewById(R.id.s_t2);
        t3=findViewById(R.id.s_t3);
        b1=findViewById(R.id.s_b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyData d=new MyData();
                String str=d.save(t1.getText().toString(),t2.getText().toString(),t3.getText().toString());
                Toast.makeText(Signup.this, ""+str, Toast.LENGTH_SHORT).show();
                Signup.this.finish();
            }
        });

    }
}
