package com.example.roman.locmes;

import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by roman on 07.04.17.
 */

public class Client extends MainActivity {

    String host;
    int port=1701;
    String screen;
    String nscreen;



    public class Cllient extends Thread {
        Socket socket=null;
        EditText et;
        TextView tw;

        Cllient(EditText et, TextView tw) throws IOException {
            socket=new Socket(host,port);
            this.et = et;
            this.tw=tw;
        }

        Runnable Get = new Runnable() {

            @Override
            public void run() {
                try {

                    BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    while (true) {
                        nscreen=br.readLine();
                        screen=screen+nscreen;
                        runOnUiThread(set);
                    }
                } catch (IOException e) {
                    System.out.println("no");;
                }

            };
        };
        Runnable Send=new Runnable() {
            @Override
            public void run() {
                try {
                    PrintWriter pw =new PrintWriter(socket.getOutputStream());
                    nscreen="\n"+name+":\n"+et.getText().toString();
                    pw.println(nscreen);
                    pw.flush();
                    pw.flush();
                    et.setText(null);
                    screen=screen+nscreen;
                    runOnUiThread(set);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable set=new Runnable() {
            @Override
            public void run() {
                tw.setText(screen);
            }
        };
    }



}