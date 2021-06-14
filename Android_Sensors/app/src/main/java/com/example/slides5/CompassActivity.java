package com.example.slides5;

import android.content.DialogInterface;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class CompassActivity extends AppCompatActivity implements SensorEventListener {

    private ImageView compassImage;
    private TextView compassText;

    private int tmp;
    private SensorManager mSensorManager;
    private Sensor mRotationV, mAccelerometer, mMagnetometer;
    private float[] rMat = new float[9];
    private float[] orientation = new float[9];
    private float[] mLastAccelerometer = new float[3];
    private float[] mLastMagnetometer = new float[3];

    private boolean haveSensor = false, haveSensor2 = false;
    private boolean mLastAccelerometerSet = false, mLastMagnetometerSet = false;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compass);
        findViews();

        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        start();
    }

    public void findViews() {
        compassText = findViewById(R.id.compass_text);
        compassImage = findViewById(R.id.compass_image);
    }
    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType() == Sensor.TYPE_ROTATION_VECTOR) {
            SensorManager.getRotationMatrixFromVector(rMat, event.values);
            tmp = (int) ((Math.toDegrees(SensorManager.getOrientation(rMat, orientation)[0]) + 360) % 360);
        }
        if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            System.arraycopy(event.values, 0, mLastAccelerometer,0, event.values.length);
            mLastAccelerometerSet = true;
        }
        if(event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
            System.arraycopy(event.values, 0, mLastMagnetometer,0, event.values.length);
            mLastMagnetometerSet = true;
        }

        if(mLastAccelerometerSet && mLastMagnetometerSet) {
            SensorManager.getRotationMatrix(rMat, null, mLastAccelerometer, mLastMagnetometer);
            SensorManager.getOrientation(rMat, orientation);
            tmp = (int) ((Math.toDegrees(SensorManager.getOrientation(rMat, orientation)[0]) + 360) % 360);
        }

        tmp = Math.round(tmp);
        tmp = (tmp + 180)%360;
        compassImage.setRotation(-tmp);

        String where = "NO";

        if (tmp >= 350 || tmp <= 10)
            where = "N";
        if (tmp < 350 && tmp > 280)
            where = "NW";
        if (tmp <= 280 && tmp > 260)
            where = "W";
        if (tmp <= 260 && tmp > 190)
            where = "SW";
        if (tmp <= 190 && tmp > 170)
            where = "S";
        if (tmp <= 170 && tmp > 100)
            where = "SE";
        if (tmp <= 100 && tmp > 80)
            where = "E";
        if (tmp <= 80 && tmp > 10)
            where = "NE";

        compassText.setText(tmp + " " + where);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // no in use
    }


    // this method checks if the device has needed sensors or not
    public void start() {
        if(mSensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR) == null) {
            if(mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) == null ||
                    mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD) == null) {
                noSensor();
            } else {
                mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
                mMagnetometer = mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);

                haveSensor = mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_UI);
                haveSensor2 = mSensorManager.registerListener(this, mMagnetometer, SensorManager.SENSOR_DELAY_UI);
            }
        } else {
            mRotationV = mSensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);
            haveSensor = mSensorManager.registerListener(this, mRotationV, SensorManager.SENSOR_DELAY_UI);
        }
    }

    public void noSensor() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setMessage(getString(R.string.no_sensor_compass))
        .setCancelable(false)
        .setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(haveSensor && haveSensor2) {
            mSensorManager.unregisterListener(this, mAccelerometer);
            mSensorManager.unregisterListener(this, mMagnetometer);
        } else if(haveSensor) {
            mSensorManager.unregisterListener(this, mRotationV);
        }
    }
}
