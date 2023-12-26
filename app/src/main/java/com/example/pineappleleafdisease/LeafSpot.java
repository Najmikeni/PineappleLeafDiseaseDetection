package com.example.pineappleleafdisease;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LeafSpot extends AppCompatActivity {
    Button homebtn;
    TextView link1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaf_spot);
        final MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.mouse);
        //click on back button
        homebtn = findViewById(R.id.homebtn);
        homebtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                mediaPlayer.start();
                startActivity(new Intent(LeafSpot.this, MainActivity.class));
            }
        });
        //click hyperlink
        link1 =(TextView) findViewById(R.id.link1);
        link1.setMovementMethod(LinkMovementMethod.getInstance());
    }
}

