package com.example.minel.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.minel.R;

public class SplashActivity extends AppCompatActivity {

    /** Duration of wait **/
    private final int SPLASH_DISPLAY_LENGTH = 1000;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        imageView = findViewById(R.id.imageView);
        Glide.with(SplashActivity.this).load(R.drawable.love).into(imageView);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run()
            {
                Intent in = new Intent(SplashActivity.this,LoginActivity.class);
                startActivity(in);
                finish();

            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}
