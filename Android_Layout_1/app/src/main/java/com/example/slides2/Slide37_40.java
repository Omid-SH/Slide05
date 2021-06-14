package com.example.slides2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Slide37_40 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slide37_40);

        Button pokerButton = (Button) findViewById(R.id.poker_mood);
        pokerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), "Think better and choose again :))", Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }

    public void goodMoodMessage(View view) {
        Toast toast = Toast.makeText(getApplicationContext(), "Perfect", Toast.LENGTH_LONG);
        toast.show();
    }

    public void badMoodMessage(View view) {
        Toast toast = Toast.makeText(getApplicationContext(), "Just take a little rest :)", Toast.LENGTH_LONG);
        toast.show();
    }
}