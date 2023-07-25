package com.project.guessinggamep3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class splashactivity extends AppCompatActivity {

    private ImageView imageview;
    private TextView textView;
    Animation animationimage,animationtext;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashactivity);

        textView=findViewById(R.id.number);
        imageview=findViewById(R.id.image);

        animationimage= AnimationUtils.loadAnimation(this,R.anim.imageanime);
        animationtext=AnimationUtils.loadAnimation(this,R.anim.textanime);
        imageview.setAnimation(animationimage);
        textView.setAnimation(animationtext);

        new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                startActivity(new Intent(splashactivity.this,MainActivity.class));
                finish();

            }
        }.start();

    }
}