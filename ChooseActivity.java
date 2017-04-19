package com.example.roman.locmes;

import android.content.Intent;
import android.support.annotation.BoolRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ChooseActivity extends AppCompatActivity {

    public Boolean Server;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        final EditText ip=(EditText)findViewById(R.id.ip);
        Button connect=(Button)findViewById(R.id.connect);
        Button server=(Button)findViewById(R.id.server);

        final Intent i=new Intent(ChooseActivity.this,NameActivity.class);
        final MainActivity ma=new MainActivity();


        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ma.Sr=false;
                Client c=new Client();
                c.host=ip.getText().toString();
                System.out.println(c.host+"\n"+ma.Sr.toString());
                startActivity(i);
            }
        });

        server.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ma.Sr=true;
                startActivity(i);
            }
        });
    }
}
