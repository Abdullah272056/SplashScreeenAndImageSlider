package com.example.splashscreeenandimageslider;

import androidx.annotation.NonNull;
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

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
ViewFlipper flipper;
TextView textView;
Button button;
int value=0;

// fireBase  image slider

    ImageSlider imageSlider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
        flipper=findViewById(R.id.viewFlipperId);
        button=findViewById(R.id.buttonId);
        textView=findViewById(R.id.textViewId);
        imageSlider=findViewById(R.id.image_slider);

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
        // beald in
        final List<SlideModel>imageList=new ArrayList<>();
//        imageList.add(new SlideModel("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__340.jpg", "The animal population decreased by 58 percent in 42 years.", ScaleTypes.FIT));
//        imageList.add(new SlideModel("https://i.pinimg.com/564x/5a/19/ae/5a19aedd954743acb95b1786068f7b3b.jpg", "Elephants and tigers may become extinct.", ScaleTypes.FIT));
//        imageList.add(new SlideModel("https://c4.wallpaperflare.com/wallpaper/500/442/354/outrun-vaporwave-hd-wallpaper-thumb.jpg", "And people do that.", ScaleTypes.FIT));

        imageSlider.setImageList(imageList);

        FirebaseDatabase.getInstance().getReference().child("Slider").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot data:snapshot.getChildren())
                    imageList.add(new SlideModel(data.child("url").getValue().toString(), data.child("title").getValue().toString(), ScaleTypes.FIT));
                imageSlider.setImageList(imageList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        int imageArray[]={R.drawable.download,R.drawable.download1,R.drawable.download2,R.drawable.images,
                R.drawable.images1,R.drawable.images2,R.drawable.images3,R.drawable.images4,R.drawable.images5};
        // image pass
for (int i=0;i<imageArray.length;i++){
    showImage(imageArray[i]);
}

    }


   // local image slide
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