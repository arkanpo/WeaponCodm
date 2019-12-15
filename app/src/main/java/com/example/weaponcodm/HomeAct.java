package com.example.weaponcodm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class HomeAct extends AppCompatActivity {
    Animation btt;
    LinearLayout assaults,lmg,sniper,shotgun,smg;

    CarouselView carouselView;
    int[] sampleImages = {R.drawable.baner1, R.drawable.baner2, R.drawable.baner3, R.drawable.baner4, R.drawable.baner5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        carouselView = findViewById(R.id.carousel);
        btt = AnimationUtils.loadAnimation(this,R.anim.btt);
        assaults = findViewById(R.id.assaults);
        lmg = findViewById(R.id.lmg);
        sniper = findViewById(R.id.sniper);
        shotgun = findViewById(R.id.shotgun);
        smg = findViewById(R.id.smg);

        assaults.startAnimation(btt);
        lmg.startAnimation(btt);
        sniper.startAnimation(btt);
        shotgun.startAnimation(btt);
        smg.startAnimation(btt);

        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(sampleImages[position]);
            }
        });

        assaults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abc = new Intent(HomeAct.this,ListWeapon.class);
                abc.putExtra("jenis_senjata","Assaults");
                startActivity(abc);
            }
        });

        lmg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abc = new Intent(HomeAct.this,ListWeapon.class);
                abc.putExtra("jenis_senjata","LMG");
                startActivity(abc);
            }
        });

        sniper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abc = new Intent(HomeAct.this,ListWeapon.class);
                abc.putExtra("jenis_senjata","SNIPER");
                startActivity(abc);
            }
        });

        shotgun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abc = new Intent(HomeAct.this,ListWeapon.class);
                abc.putExtra("jenis_senjata","SHOTGUN");
                startActivity(abc);
            }
        });

        smg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abc = new Intent(HomeAct.this,ListWeapon.class);
                abc.putExtra("jenis_senjata","SMG");
                startActivity(abc);
            }
        });

    }
}
