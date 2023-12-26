// Muhammad Najmi bin Hasnol Mizam (2020853514)
package com.example.pineappleleafdisease;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
public class HomePage extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
    }
    //click on pineapple in general button
    public void pineapple_General(View v) {
        Intent page = new Intent(HomePage.this, PineappleGeneral.class);
        // start the pineapple activity
        mediaPlayer = MediaPlayer.create(this,R.raw.mouse);
        mediaPlayer.start();
        startActivity(page);
    }
    //click on get pineapple leaf disease button
    public void pld_info(View v) {
        Intent page = new Intent(HomePage.this, PineappleLeafDisease.class);
        // start the main activity
        mediaPlayer = MediaPlayer.create(this,R.raw.mouse);
        mediaPlayer.start();
        startActivity(page);
    }
    //click on get growing pineapple button
    public void growingPineapple(View v) {
        Intent page = new Intent(HomePage.this, growingPage.class);
        // start the main activity
        mediaPlayer = MediaPlayer.create(this,R.raw.mouse);
        mediaPlayer.start();
        startActivity(page);
    }
    //click on get detection button
    public void getDetection(View v) {
        Intent page = new Intent(HomePage.this, MainActivity.class);
        // start the main activity
        mediaPlayer = MediaPlayer.create(this,R.raw.mouse);
        mediaPlayer.start();
        startActivity(page);
    }
    //click on get faq button
    public void getFAQ(View v) {
        Intent page = new Intent(HomePage.this, FAQPage.class);
        // start the main activity
        mediaPlayer = MediaPlayer.create(this,R.raw.mouse);
        mediaPlayer.start();
        startActivity(page);
    }
}

