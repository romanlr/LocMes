package com.example.roman.locmes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    String screen;
    String nscreen;
    String name;
    Boolean Sr;


    Thread get;
    Thread Send;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tw=(TextView)findViewById(R.id.tw);
        EditText et=(EditText)findViewById(R.id.ET);

        Server server=new Server();
        Client client=new Client();

        if (Sr=true){
            try {
                final Server.Seerver cl=server.new Seerver(et,tw);
                get=new Thread(cl.Get);
                Send=new Thread(cl.Send);
                System.out.println(name);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            final Client.Cllient cl;
            try {
                cl = client.new Cllient(et,tw);
                get=new Thread(cl.Get);
                Send=new Thread(cl.Send);
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println(Sr+"  "+client.host);
        }
       get.start();
        Button send = (Button) findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                runOnUiThread(Send);
            }
        });

    }
}
