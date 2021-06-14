package com.example.slides2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Slide115_122 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slide115_122);
    }

    public void showCustomDialog (View view) {
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogLayout = inflater.inflate(R.layout.custom_dialog, null);
        final EditText filename = dialogLayout.findViewById(R.id.file_name);
        new AlertDialog.Builder(this)
                .setTitle("Select your postal address")
                .setMessage("Select your postal address. This address will be toasted.")
                .setPositiveButton("Set", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), filename.getText().toString(), Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Do nothing
                    }
                })
                .setView(dialogLayout)
                .show();
    }
}
