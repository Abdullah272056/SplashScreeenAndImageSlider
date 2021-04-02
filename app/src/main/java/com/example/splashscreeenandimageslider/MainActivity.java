package com.example.splashscreeenandimageslider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
ViewFlipper flipper;
TextView textView;
Button button;
int value=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
        flipper=findViewById(R.id.viewFlipperId);
        button=findViewById(R.id.buttonId);
        textView=findViewById(R.id.textViewId);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value++;
                if (value==10){
                    Intent intent=new Intent(MainActivity.this,SplashScreen.class);
                     startActivity(intent);
                }
                textView.setText(String.valueOf(value));

            }
        });
        int imageArray[]={R.drawable.download,R.drawable.download1,R.drawable.download2,R.drawable.images,
                R.drawable.images1,R.drawable.images2,R.drawable.images3,R.drawable.images4,R.drawable.images5};

for (int i=0;i<imageArray.length;i++){
    showImage(imageArray[i]);
}

    }

    public void showImage(int image){
        ImageView imageView=new ImageView(this);
        imageView.setBackgroundResource(image);
        flipper.addView(imageView);
        flipper.setAutoStart(true);
        flipper.setFlipInterval(3000);
//       Animation topAnim= AnimationUtils.loadAnimation(this,R.anim.top_anim);
//        //flipper.setAnimation(topAnim);
        flipper.setInAnimation(this,android.R.anim.slide_in_left);
        flipper.setOutAnimation(this,android.R.anim.slide_out_right);

       // flipper.setInAnimation(this,android.R.anim.fade_in);
        //flipper.setOutAnimation(this,android.R.anim.fade_out);
//        flipper.setOutAnimation(this,R.anim.top_anim);
//        flipper.setOutAnimation(this,R.anim.bottom_anim);
    }
}