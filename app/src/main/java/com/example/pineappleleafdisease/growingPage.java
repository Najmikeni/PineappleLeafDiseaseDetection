package com.example.pineappleleafdisease;
// Muhammad Najmi bin Hasnol Mizam (2020853514)
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class growingPage extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    Dialog dialog1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_growing_page);
        dialog1 = new Dialog(this);
        dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }
    //click on back arrow button
    public void backHome(View v) {
        Intent page = new Intent(growingPage.this, HomePage.class);
        // start the home activity
        mediaPlayer = MediaPlayer.create(this,R.raw.mouse);
        mediaPlayer.start();
        startActivity(page);
    }
    //click on tips 1
    public void showPopup(View v){
        mediaPlayer = MediaPlayer.create(this,R.raw.mouse);
        mediaPlayer.start();
        TextView close;
        dialog1.setContentView(R.layout.activity_popup1);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // 0.26s = 260ms
                dialog1.show();
            }
        }, 260);
        close = (TextView) dialog1.findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add delay before dismissing the dialog
                Handler closeHandler = new Handler();
                closeHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dialog1.dismiss();
                    }
                }, 160);
            }
        });
    }
    //click on tips 2
    public void showPopup2(View v){
        mediaPlayer = MediaPlayer.create(this,R.raw.mouse);
        mediaPlayer.start();
        TextView close;
        dialog1.setContentView(R.layout.activity_popup2);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // 0.26s = 260ms
                dialog1.show();
            }
        }, 260);
        close = (TextView) dialog1.findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add delay before dismissing the dialog
                Handler closeHandler = new Handler();
                closeHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dialog1.dismiss();
                    }
                }, 160);
            }
        });
    }
    //click on tips 3
    public void showPopup3(View v){
        mediaPlayer = MediaPlayer.create(this,R.raw.mouse);
        mediaPlayer.start();
        TextView close;
        dialog1.setContentView(R.layout.activity_popup3);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // 0.26s = 260ms
                dialog1.show();
            }
        }, 260);
        close = (TextView) dialog1.findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add delay before dismissing the dialog
                Handler closeHandler = new Handler();
                closeHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dialog1.dismiss();
                    }
                }, 160);
            }
        });
    }
    //click on tips 4
    public void showPopup4(View v){
        mediaPlayer = MediaPlayer.create(this,R.raw.mouse);
        mediaPlayer.start();
        TextView close;
        dialog1.setContentView(R.layout.activity_popup4);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // 0.26s = 260ms
                dialog1.show();
            }
        }, 260);
        close = (TextView) dialog1.findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add delay before dismissing the dialog
                Handler closeHandler = new Handler();
                closeHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dialog1.dismiss();
                    }
                }, 160);
            }
        });
    }
    //click on tips 5
    public void showPopup5(View v){
        mediaPlayer = MediaPlayer.create(this,R.raw.mouse);
        mediaPlayer.start();
        TextView close;
        dialog1.setContentView(R.layout.activity_popup5);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // 0.26s = 260ms
                dialog1.show();
            }
        }, 260);
        close = (TextView) dialog1.findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add delay before dismissing the dialog
                Handler closeHandler = new Handler();
                closeHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dialog1.dismiss();
                    }
                }, 160);
            }
        });
    }
    //click on tips 6
    public void showPopup6(View v){
        mediaPlayer = MediaPlayer.create(this,R.raw.mouse);
        mediaPlayer.start();
        TextView close;
        dialog1.setContentView(R.layout.activity_popup6);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // 0.26s = 260ms
                dialog1.show();
            }
        }, 260);
        close = (TextView) dialog1.findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add delay before dismissing the dialog
                Handler closeHandler = new Handler();
                closeHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dialog1.dismiss();
                    }
                }, 160);
            }
        });
    }
}

