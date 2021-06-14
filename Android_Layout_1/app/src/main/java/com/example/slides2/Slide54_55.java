package com.example.slides2;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Slide54_55 extends AppCompatActivity {
    ConstraintLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slide54_55);
        mainLayout = (ConstraintLayout) findViewById(R.id.main_layout);
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton)view).isChecked();
        if(checked) {
            switch (view.getId()) {
                case R.id.green:
                    mainLayout.setBackgroundResource(R.color.persian_green);
                    break;
                case R.id.white:
                    mainLayout.setBackgroundResource(R.color.celeste);
                    break;
                case R.id.blue:
                    mainLayout.setBackgroundResource(R.color.colorPrimary);
                    break;
            }
        }
    }
}
