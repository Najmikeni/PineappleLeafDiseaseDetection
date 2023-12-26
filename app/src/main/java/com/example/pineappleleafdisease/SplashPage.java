package com.example.pineappleleafdisease;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
public class SplashPage extends AppCompatActivity {
    //variable
    private MediaPlayer ost, sound;
    Animation topAnim, bottomAnim;
    ImageView start,pine1,pine2,pine3;
    TextView welcome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_page);
        //animations
        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        //hooks
        welcome = findViewById(R.id.welcome);
        start = findViewById(R.id.starttt);
        pine1 = findViewById(R.id.pine1);
        pine2 = findViewById(R.id.pine2);
        pine3 = findViewById(R.id.imageView6);
        welcome.setAnimation(topAnim);
        start.setAnimation(bottomAnim);
        pine1.setAnimation(bottomAnim);
        pine2.setAnimation(bottomAnim);
        pine3.setAnimation(bottomAnim);

        ost = MediaPlayer.create(this,R.raw.ost);
        ost.start();
        ost.setVolume(0.1f, 0.2f);
    }
    //click on button
    public void startBtnClicked(View v) {
        Intent homepage = new Intent(SplashPage.this, HomePage.class);
        // start the homepage activity
        sound = MediaPlayer.create(this,R.raw.mouse);
        sound.start();
        startActivity(homepage);
    }
    //for landscape mode
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        setContentView(R.layout.activity_splash_page);
        super.onConfigurationChanged(newConfig);
    }
}



