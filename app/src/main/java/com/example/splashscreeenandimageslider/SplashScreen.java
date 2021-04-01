package com.example.splashscreeenandimageslider;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {
    Animation topAnim,bottomAnim,shakeAnim;
    ImageView imageView;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        topAnim= AnimationUtils.loadAnimation(this,R.anim.top_anim);
        bottomAnim= AnimationUtils.loadAnimation(this,R.anim.bottom_anim);
        shakeAnim= AnimationUtils.loadAnimation(this,R.anim.shake);

        imageView=findViewById(R.id.simg);
        textView=findViewById(R.id.s_txt);

        imageView.setAnimation(topAnim);
        textView.setAnimation(bottomAnim);

    }
}