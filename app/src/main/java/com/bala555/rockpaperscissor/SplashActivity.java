package com.bala555.rockpaperscissor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread thread = new Thread(){

            @Override
            public void run() {
                try {
                    sleep(2500);
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    finish();
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };

        thread.start();
    }
}