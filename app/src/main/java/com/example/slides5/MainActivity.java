package com.example.slides5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getAllSensors (View view) {
        Intent intent = new Intent(MainActivity.this, GetAllSensorsActivity.class);
        MainActivity.this.startActivity(intent);
    }

    public void shakeDetect (View view) {
        Intent intent = new Intent(MainActivity.this, ShakeDetectActivity.class);
        MainActivity.this.startActivity(intent);
    }

    public void compass (View view) {
        Intent intent = new Intent(MainActivity.this, CompassActivity.class);
        MainActivity.this.startActivity(intent);
    }
}
