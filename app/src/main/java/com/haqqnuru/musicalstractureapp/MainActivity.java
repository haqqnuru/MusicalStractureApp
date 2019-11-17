package com.haqqnuru.musicalstractureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Modifying contents of text view
        TextView highlife = findViewById(R.id.highLife);
        TextView reggae = findViewById(R.id.reggae);
        TextView gospel = findViewById(R.id.gospel);

        // setting click listener to the highlife text view
        highlife.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // passing intent to Highlife Activity
                Intent intent = new Intent(MainActivity.this, HighLifeActivity.class);
                startActivity(intent);
            }
        });

        // setting click listener to the reggae text view
        reggae.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // passing intent to Reggae Activity
                Intent intent = new Intent(MainActivity.this, ReggaeActivity.class);
                startActivity(intent);
            }
        });

        // setting click listener to the gospel text view
        gospel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // passing intent to Gospel Activity
                Intent intent = new Intent(MainActivity.this, GospelActivity.class);
                startActivity(intent);
            }
        });
    }
}
