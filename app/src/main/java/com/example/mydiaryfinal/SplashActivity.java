package com.example.mydiaryfinal;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mydiaryfinal.MainActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        // onCreate() : Activity(화면)가 실행될 때 가장 먼저 호출되는 곳!

        // 딜레이를 발생시켜서 (1~2초 가량) - 이후에 MainActivity 로 이동 해야 함.
        new Handler(getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                // 메인 액티비티로 이동하는 구간
                Intent mainIntent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(mainIntent);
                finish();
            }
        }, 2000);   // 딜레이 해주고 싶은 초를 적어야함. (1000 밀리초 = 1초)
    }
}