package com.example.pineappleleafdisease;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class DiseasePage extends AppCompatActivity {

    Button contBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease_page);

         final MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.mouse);

        //click on home button
        contBtn = findViewById(R.id.continueBtn);
        contBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                mediaPlayer.start();
                startActivity(new Intent(DiseasePage.this, HomePage.class));
            }
        });
    }
}
