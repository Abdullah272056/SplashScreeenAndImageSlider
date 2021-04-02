package com.example.splashscreeenandimageslider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {
    Animation topAnim,bottomAnim,shakeAnim,rotate;
    ImageView imageView;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        topAnim= AnimationUtils.loadAnimation(this,R.anim.top_anim);
        bottomAnim= AnimationUtils.loadAnimation(this,R.anim.bottom_anim);
        shakeAnim= AnimationUtils.loadAnimation(this,R.anim.shake);
        rotate= AnimationUtils.loadAnimation(this,R.anim.rotate);

        imageView=findViewById(R.id.simg);
        textView=findViewById(R.id.s_txt);

        imageView.setAnimation(topAnim);
        textView.setAnimation(rotate);


        new Handler().postDelayed(new Runnable() {
                                      @Override
                                      public void run() {
                                          Intent intent=new Intent(SplashScreen.this,MainActivity.class);
                                          startActivity(intent);
                                          finish();

                                      }

                                  },
                3000);

    }

}