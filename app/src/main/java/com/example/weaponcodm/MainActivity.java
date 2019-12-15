package com.example.weaponcodm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Animation logosplash;
    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logosplash = AnimationUtils.loadAnimation(this,R.anim.logosplash);
        logo = findViewById(R.id.logo);

        logo.startAnimation(logosplash);


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent abc = new Intent(MainActivity.this, HomeAct.class);
                startActivity(abc);
                finish();

            }
        },2000);


    }
}
