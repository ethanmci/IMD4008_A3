package com.example.imd4008_a3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {

    ScrollView todoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        todoView = findViewById(R.id.todoView);

        //todoView.addView(new CardView);
    }
}