package com.example.pineappleleafdisease;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class FAQPage extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq_page);
    }
    //click on return button
    public void returnHome(View v) {
        Intent page = new Intent(FAQPage.this, HomePage.class);
        // start the homepage activity
        mediaPlayer = MediaPlayer.create(this,R.raw.mouse);
        mediaPlayer.start();
        startActivity(page);
    }
}

