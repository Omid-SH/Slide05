package com.example.slides2;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Slide101_102 extends AppCompatActivity {
    private static Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slide101_102);
        Slide101_102.context = getApplicationContext();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.slide101_102_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.new_game :
                Toast.makeText(context, "Start New Game ...", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.help :
            case R.id.live_help :
                if(item.isChecked()) item.setChecked(true);
                else item.setChecked(false);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}