package com.example.roman.locmes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.net.Inet4Address;
import java.net.UnknownHostException;

public class NameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        final MainActivity ma=new MainActivity();

        final EditText nick=(EditText)findViewById(R.id.nick);
        final TextView ipv=(TextView)findViewById(R.id.ipv);
        Button start=(Button)findViewById(R.id.start);


        final Intent i=new Intent(NameActivity.this,MainActivity.class);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ma.name=nick.getText().toString();
                System.out.println(ma.name);
                startActivity(i);
            }
        });
    }
}
