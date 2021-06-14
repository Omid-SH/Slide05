package com.example.slides2;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class Slide56_57 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slide56_57);

        final ImageView imageView = (ImageView) findViewById(R.id.image_view);

        ToggleButton toggle = (ToggleButton) findViewById(R.id.toggle_button);
        toggle.setOnCheckedChangeListener(new
            CompoundButton.OnCheckedChangeListener() {
              @Override
              public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                  if(isChecked)
                      imageView.setImageResource(R.drawable.ic_on);
                  else
                      imageView.setImageResource(R.drawable.ic_off);
              }
            });

        Switch _switch = (Switch) findViewById(R.id._switch);
        _switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    imageView.setImageResource(R.drawable.ic_on);
                else
                    imageView.setImageResource(R.drawable.ic_off);
            }
        });
    }

}
