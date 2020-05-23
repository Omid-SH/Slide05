package com.example.slides5;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class ShakeDetectActivity extends AppCompatActivity implements SensorEventListener {

    private Sensor mySensor;
    private SensorManager mySensorManager;

    private float mAccelerometerData;
    private float mAccelerometerDataCurrent;
    private float mAccelerometerDataLast;

    private ConstraintLayout layout;
    private TextView shakeText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shake_detect);
        getViews();

        mySensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mAccelerometerData = 10f;
        mAccelerometerDataCurrent = SensorManager.GRAVITY_EARTH;
        mAccelerometerDataLast = SensorManager.GRAVITY_EARTH;

        // Accelerometer sensor
        assert mySensorManager != null;
        mySensor = mySensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mySensorManager.registerListener(this, mySensor, SensorManager.SENSOR_STATUS_ACCURACY_HIGH);

    }

    private void getViews() {
        shakeText = findViewById(R.id.shake_text);
        layout = findViewById(R.id.shake_layout);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float x = event.values[0];
        float y = event.values[1];
        float z = event.values[2];

        mAccelerometerDataLast = mAccelerometerDataCurrent;
        mAccelerometerDataCurrent = (float) Math.sqrt((double) (x * x + y * y + z * z));
        float delta = mAccelerometerDataCurrent - mAccelerometerDataLast;
        mAccelerometerData = mAccelerometerData * 0.9f + delta;

        if(mAccelerometerData < 1) {
            shakeText.setText(getString(R.string.shake_text_0));
            layout.setBackgroundColor(getColor(R.color.colorAccent));
        }
        else if (mAccelerometerData < 3) {
            shakeText.setText(getString(R.string.shake_text_1));
            layout.setBackgroundColor(getColor(R.color.colorPrimaryLight));
        }
        else if (mAccelerometerData < 6) {
            shakeText.setText(getString(R.string.shake_text_2));
            layout.setBackgroundColor(getColor(R.color.colorPrimary));
        }
        else {
            shakeText.setText(getString(R.string.shake_text_3));
            layout.setBackgroundColor(getColor(R.color.colorPrimaryDark));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Not in use
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mySensorManager.unregisterListener(this);
    }

}
