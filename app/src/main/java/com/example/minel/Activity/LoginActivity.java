package com.example.minel.Activity;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.minel.R;

import eightbitlab.com.blurview.BlurView;
import eightbitlab.com.blurview.RenderScriptBlur;

public class LoginActivity extends AppCompatActivity {

    BlurView blurImageView;
    ImageView imageView;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        blurImageView = findViewById(R.id.blurImageView);
        imageView = findViewById(R.id.imageView);
        Glide.with(LoginActivity.this).load(R.drawable.love).into(imageView);

        setBlurBackground();
    }


    private void setBlurBackground() {
        float radius1 = 20f;

        View decorView = getWindow().getDecorView();
        //ViewGroup you want to start blur from. Choose root as close to BlurView in hierarchy as possible.
        ViewGroup rootView = (ViewGroup) decorView.findViewById(android.R.id.content);
        //Set drawable to draw in the beginning of each blurred frame (Optional).
        //Can be used in case your layout has a lot of transparent space and your content
        //gets kinda lost after after blur is applied.
        Drawable windowBackground = decorView.getBackground();

        blurImageView.setupWith(rootView)
                .setFrameClearDrawable(windowBackground)
                .setBlurAlgorithm(new RenderScriptBlur(this))
                .setBlurRadius(radius1)
                .setBlurAutoUpdate(true)
                .setHasFixedTransformationMatrix(true);

            blurImageView.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
            blurImageView.setClipToOutline(true);// Or false if it's in a scrolling container or might be animatedblurImageView.setupWith(rootView)

    }
}
