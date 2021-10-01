package com.alpsu.guess_the_number;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class AnimationActivity extends AppCompatActivity {

    ImageView imageNumber;
    TextView txtGuess;
    Animation imageAnimation, txtAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        imageNumber = findViewById(R.id.imageNumber);
        txtGuess = findViewById(R.id.txtGuess);
        imageAnimation = AnimationUtils.loadAnimation(this,R.anim.image_animation);
        txtAnimation = AnimationUtils.loadAnimation(this,R.anim.text_animation);
        imageNumber.setAnimation(imageAnimation);
        txtGuess.setAnimation(txtAnimation);
        // When the time is over(5sec) main activity will open.
        new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                startActivity(new Intent(AnimationActivity.this,MainActivity.class));
                finish();
            }
        }.start();
    }
}