package com.example.diego.paralimpicos2019v20;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //variable y metodo que realizar el splash para estar x tiempo y cambiar a la main activity
       new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {
                Intent intent =new Intent(SplashActivity.this,Main_Activity.class);
                startActivity(intent);
                finish();
           }
       },1500);
    }
}
