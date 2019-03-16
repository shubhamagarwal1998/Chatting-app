package com.example.shubham.external;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Map;
import java.util.Set;

public class login extends AppCompatActivity {
    EditText t1,t2;
    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sp = getSharedPreferences("wa", MODE_PRIVATE);
        if(!sp.getString("email","invalid").equals("invalid"))
        {
            Intent in=new Intent(login.this,Welcome.class);
            startActivity(in);
        }
        setContentView(R.layout.activity_login);
        t1=findViewById(R.id.l_t1);
        t2=findViewById(R.id.l_t2);
        b1=findViewById(R.id.l_b1);
        b2=findViewById(R.id.l_b2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = MyData.check(t1.getText().toString(), t2.getText().toString());
                if (s.equals("valid")) {
                    SharedPreferences sp = getSharedPreferences("wa", MODE_PRIVATE);
                    SharedPreferences.Editor ed = sp.edit();
                    ed.putString("email",t1.getText().toString());
                    ed.commit();
                    Intent in = new Intent(login.this, Welcome.class);
                    startActivity(in);
                }
                else
                {
                    Toast.makeText(login.this, "Invalid email or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(login.this,Signup.class);
                startActivity(in);
            }
        });
    }
}
