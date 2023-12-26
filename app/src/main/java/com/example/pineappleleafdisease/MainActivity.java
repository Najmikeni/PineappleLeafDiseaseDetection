// Muhammad Najmi bin Hasnol Mizam (2020853514)
package com.example.pineappleleafdisease;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pineappleleafdisease.ml.PineappleV4;
import com.example.pineappleleafdisease.ml.PineappleV5;
import com.example.pineappleleafdisease.ml.PineappleV6;
import com.example.pineappleleafdisease.ml.PineappleV7;
import com.example.pineappleleafdisease.ml.PineappleV8;
import com.example.pineappleleafdisease.ml.PineappleV83;
import com.example.pineappleleafdisease.ml.PineappleV84;
import com.example.pineappleleafdisease.ml.PineappleV9;
import com.google.firebase.firestore.FirebaseFirestore;

import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.image.TensorImage;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
public class MainActivity extends AppCompatActivity {
    //declaration
    Button explainBtn;
    Button homeBtn;
    ImageView imageView;
    ImageView imageView2;
    ImageView imageView3;
    TextView result;
    TextView confidence;
    TextView hint;
    TextView severityMessage;
    Bitmap image;
    int imageSize = 270;
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = MediaPlayer.create(this,R.raw.mouse);
        //find the item and make it a variable
        explainBtn = findViewById(R.id.explainBtn);
        homeBtn = findViewById(R.id.homeBtn);
        result = findViewById(R.id.result);
        confidence = findViewById(R.id.confidence);
        hint = findViewById(R.id.hint);
        severityMessage = findViewById(R.id.severityMessage);
        imageView = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        //explanation button invisible if no image
        explainBtn.setVisibility(View.INVISIBLE);
        //click on explanation button
        explainBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(result.getText().toString().equals("Mealybug Wilt")){
                    mediaPlayer.start();
                    startActivity(new Intent(MainActivity.this, MealybugWilt.class));
                }
                else if(result.getText().toString().equals("Leaf Spot")){
                    mediaPlayer.start();
                    startActivity(new Intent(MainActivity.this, LeafSpot.class));
                }
                else if(result.getText().toString().equals("Pink Disease")){
                    mediaPlayer.start();
                    startActivity(new Intent(MainActivity.this, PinkDisease.class));
                }
            }
        });
        //click on home button
        homeBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                mediaPlayer.start();
                startActivity(new Intent(MainActivity.this, HomePage.class));
            }
        });
    }
    //method to classify the image from gallery/camera
    public void classifyImage(Bitmap image){
        try {
            PineappleV84 model = PineappleV84.newInstance(getApplicationContext());

            // Creates inputs
            TensorBuffer inputFeature0 = TensorBuffer.createFixedSize(new int[]{1, imageSize, imageSize, 3}, DataType.FLOAT32);

            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(4 * imageSize * imageSize * 3);
            byteBuffer.order(ByteOrder.nativeOrder());

            int[] intValues = new int[imageSize * imageSize];
            image.getPixels(intValues, 0, image.getWidth(), 0, 0, image.getWidth(), image.getHeight());
            int pixel = 0;
            //iterate over each pixel and extract RGB values & add the values individually to the byte buffer
            for(int i = 0; i < imageSize; i ++){
                for(int j = 0; j < imageSize; j++){
                    int val = intValues[pixel++]; // RGB
                    byteBuffer.putFloat(((val >> 16) & 0xFF) * (1.f / 255.f));
                    byteBuffer.putFloat(((val >> 8) & 0xFF) * (1.f / 255.f));
                    byteBuffer.putFloat((val & 0xFF) * (1.f / 255.f));
                }
            }
            inputFeature0.loadBuffer(byteBuffer);
            // Runs model and gets result
            PineappleV84.Outputs outputs = model.process(inputFeature0);
            TensorBuffer outputFeature0 = outputs.getOutputFeature0AsTensorBuffer();
            float[] confidences = outputFeature0.getFloatArray();
            String[] classes = {"Leaf Spot", "Mealybug Wilt", "Pink Disease"};
            float threshold = 0.6f;
            int maxPos = -1;
            float maxConfidence = 0;

            for (int i = 0; i < confidences.length; i++) {
                if (confidences[i] > maxConfidence) {
                    maxConfidence = confidences[i];
                    maxPos = i;
                }
            }
            String resultText;
            String confidenceText = "";
            String[] severityMessages = {
                    "The disease is detected at a mild severity level.",
                    "The disease is detected at a moderate severity level.",
                    "The disease is detected at a severe severity level."
            };

            int severityLevel = -1;
            float maxConfidencePercentage = maxConfidence * 100; // Convert maxConfidence to percentage

            if (maxPos != -1 && maxConfidence >= threshold) {
                // Determine the severity level based on the confidence value
                if (maxConfidence >= 0.6 && maxConfidence < 0.7) {
                    severityLevel = 0; // Mild severity
                } else if (maxConfidence >= 0.7 && maxConfidence < 0.8) {
                    severityLevel = 1; // Moderate severity
                } else if (maxConfidence >= 0.8) {
                    severityLevel = 2; // Severe severity
                }
                resultText = classes[maxPos];
                confidenceText = String.format("%.0f%%", maxConfidencePercentage);
            } else {
                resultText = "Unknown";
                confidenceText = "\t\tPlease take another picture\n\t\t or select an image with\n\t\tthe disease more closer.";
            }

            // Set the severity level message
            if (severityLevel != -1) {
                severityMessage.setVisibility(View.VISIBLE);
                severityMessage.setText(severityMessages[severityLevel]);
            } else {
                severityMessage.setVisibility(View.INVISIBLE);
            }

            result.setText(resultText);
            confidence.setText(confidenceText);
            if (resultText.equals("Unknown")) {
                explainBtn.setVisibility(View.INVISIBLE);
            } else {
                explainBtn.setVisibility(View.VISIBLE);
            }
            hint.setVisibility(View.INVISIBLE);

            // Releases model resources if no longer used
            model.close();
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace(); // Print the error to the console for debugging purposes
            // show an error message to the user
            Toast.makeText(this, "Error: Unable to process the image", Toast.LENGTH_SHORT).show();
        }
    }

    //click on camera button
    public void cameraBtnClicked(View view) {
            if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                mediaPlayer = MediaPlayer.create(this,R.raw.mouse);
                mediaPlayer.start();
                startActivityForResult(cameraIntent, 3);
            } else {
                requestPermissions(new String[]{Manifest.permission.CAMERA}, 100);
            }
    }
    //click on open gallery button
    public void galleryBtnClicked(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        mediaPlayer = MediaPlayer.create(this,R.raw.mouse);
        mediaPlayer.start();
        startActivityForResult(intent, 1);
    }
    //method to get the image and resize it into the desire size
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode == RESULT_OK){
            if(requestCode == 3){
                image = (Bitmap) data.getExtras().get("data");
                int dimension = Math.min(image.getWidth(), image.getHeight());
                image = ThumbnailUtils.extractThumbnail(image, dimension, dimension);
                imageView.setImageBitmap(image);

                image = Bitmap.createScaledBitmap(image, imageSize, imageSize, false);
                classifyImage(image);
            }
            else if(requestCode == 1){
                if(data!=null) {
                    Uri dat = data.getData();
                    try {
                        image = MediaStore.Images.Media.getBitmap(this.getContentResolver(), dat);
                        imageView.setImageBitmap(image);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    image = Bitmap.createScaledBitmap(image, imageSize, imageSize, false);
                    classifyImage(image);
                }
            }
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}