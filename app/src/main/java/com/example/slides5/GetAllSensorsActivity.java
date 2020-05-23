package com.example.slides5;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class GetAllSensorsActivity extends AppCompatActivity {

    private TextView sensorNumbers, temperature, light, pressure, humidity, heartRate;
    private SensorManager mSensorManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_all_sensors);
        getViews();
        setSensors();
    }

    private void getViews() {
        sensorNumbers = findViewById(R.id.sensors_number);
        temperature = findViewById(R.id.temperature);
        light = findViewById(R.id.light);
        pressure = findViewById(R.id.pressure);
        humidity = findViewById(R.id.humidity);
        heartRate = findViewById(R.id.heart_rate);
    }

    private void setSensors() {
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> deviceSensors = mSensorManager.getSensorList(Sensor.TYPE_ALL);
        sensorNumbers.setText(getString(R.string.all_sensors , deviceSensors.size()));
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        Sensor mTemperatureSensor, mLightSensor, mPressureSensor, mHumiditySensor, mHeartRateSensor;

        mTemperatureSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        mLightSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        mPressureSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
        mHumiditySensor = mSensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);

        if(Build.VERSION.SDK_INT > 20)
            mHeartRateSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_HEART_RATE);
        else
            mHeartRateSensor = null;

        if (mTemperatureSensor != null)
            mSensorManager.registerListener(mTemperatureSensorListener, mTemperatureSensor, SensorManager.SENSOR_DELAY_NORMAL);
        else
            temperature.setText(getString(R.string.temperature_false));

        if (mLightSensor != null)
            mSensorManager.registerListener(mLightSensorListener, mLightSensor, SensorManager.SENSOR_DELAY_NORMAL);
        else
            light.setText(getString(R.string.light_false));

        if (mPressureSensor != null)
            mSensorManager.registerListener(mPressureSensorListener, mPressureSensor, SensorManager.SENSOR_DELAY_NORMAL);
        else
            pressure.setText(getString(R.string.pressure_false));

        if (mHumiditySensor != null)
            mSensorManager.registerListener(mHumiditySensorListener, mHumiditySensor, SensorManager.SENSOR_DELAY_NORMAL);
        else
            humidity.setText(getString(R.string.humidity_false));

        if (mHeartRateSensor != null)
            mSensorManager.registerListener(mHeartRateSensorListener, mHeartRateSensor, SensorManager.SENSOR_DELAY_NORMAL);
        else
            heartRate.setText(getString(R.string.heart_rate_false));

    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(mTemperatureSensorListener);
        mSensorManager.unregisterListener(mLightSensorListener);
        mSensorManager.unregisterListener(mPressureSensorListener);
        mSensorManager.unregisterListener(mHumiditySensorListener);
        mSensorManager.unregisterListener(mHeartRateSensorListener);
    }

    public SensorEventListener mTemperatureSensorListener = new SensorEventListener() {

        @Override
        public void onSensorChanged(SensorEvent event) {
            temperature.setText(getString(R.string.temperature_true, event.values[0]));
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
            Log.d("MY_APP", sensor.toString() + " - " + accuracy);
        }
    };

    public SensorEventListener mLightSensorListener = new SensorEventListener() {

        @Override
        public void onSensorChanged(SensorEvent event) {
            light.setText(getString(R.string.light_true, event.values[0]));
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
            Log.d("MY_APP", sensor.toString() + " - " + accuracy);
        }
    };

    public SensorEventListener mPressureSensorListener = new SensorEventListener() {

        @Override
        public void onSensorChanged(SensorEvent event) {
            pressure.setText(getString(R.string.pressure_true, event.values[0]));
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
            Log.d("MY_APP", sensor.toString() + " - " + accuracy);
        }
    };

    public SensorEventListener mHumiditySensorListener = new SensorEventListener() {

        @Override
        public void onSensorChanged(SensorEvent event) {
            humidity.setText(getString(R.string.humidity_true, event.values[0]));
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
            Log.d("MY_APP", sensor.toString() + " - " + accuracy);
        }
    };

    public SensorEventListener mHeartRateSensorListener = new SensorEventListener() {

        @Override
        public void onSensorChanged(SensorEvent event) {
            heartRate.setText(getString(R.string.heart_rate_true, event.values[0]));
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
            Log.d("MY_APP", sensor.toString() + " - " + accuracy);
        }
    };

}
