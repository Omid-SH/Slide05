package com.example.slides2;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Slide17_18 extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slide17_18);
        Log.i("TAG", ":))");

        Button btOK = (Button) findViewById(R.id.btOK);
        btOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Slide17_18.this,
                        getString(R.string.hello_world),
                        Toast.LENGTH_LONG)
                        .show();
            }
        });
    }
}
