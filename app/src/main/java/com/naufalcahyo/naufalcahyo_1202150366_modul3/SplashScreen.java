package com.naufalcahyo.naufalcahyo_1202150366_modul3;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

public class SplashScreen extends Activity { // activity saja agar bisa full screen tidak pakai bar

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        //untuk membuat splash screen fullscreen tanpa tool bar (bar notif diatas device).
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        final Thread thread = new Thread(){
            public void run(){
                try{
                    //durasi 400 ms / 4  detik
                    sleep(4000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    //menjalankan splash screen kemudian pindah ke Home
                    startActivity(new Intent(SplashScreen.this, Login.class));
                    finish();
                }
            }
        };
        //jalankan thread
        thread.start();
        //munculin toast nama_nim
        Toast.makeText(this, "Naufal Cahyo_1202150366", Toast.LENGTH_LONG).show();
    }
}
