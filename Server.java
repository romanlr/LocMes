package com.example.roman.locmes;

import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by roman on 18.04.17.
 */

public class Server extends MainActivity{


   public class Seerver extends Thread{

       TextView tw;
       EditText et;
       Socket socket=null;
       ServerSocket ss;

       int port= 1701;
       public Seerver(EditText et,TextView tw)throws IOException{
           ss=new ServerSocket(port);
           this.tw=tw;
           this.et=et;
       }

       Runnable Get = new Runnable() {

           @Override
           public void run() {
               try {
                   socket=ss.accept();
                   BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                   while (true) {
                       nscreen=br.readLine();
                       screen=screen+"\n"+nscreen;
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
                   PrintWriter pw=new PrintWriter(socket.getOutputStream());
                   nscreen=et.getText().toString();
                   pw.println("\n"+name+"\n");
                   pw.flush();
                   pw.println(nscreen);
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