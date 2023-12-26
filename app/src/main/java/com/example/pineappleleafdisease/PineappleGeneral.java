// Muhammad Najmi bin Hasnol Mizam (2020853514)
package com.example.pineappleleafdisease;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PineappleGeneral extends AppCompatActivity {
    Button homeBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pineapple_general);

        final MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.mouse);

        //click on home button
        homeBtn = findViewById(R.id.gohome);
        homeBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                mediaPlayer.start();
                startActivity(new Intent(PineappleGeneral.this, HomePage.class));
            }
        });
    }
}

