package com.example.a1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity implements SensorEventListener{


    private static final String TAG = "MainActivity";

    private static final int SHAKE_THRESHOLD = 200; // m/S**2
    private long mLastTime;
    private static final int TIME_THRESHOLD = 500;
    private static int SHAKE_COUNT = 0;
    private static int CLEAR_SHAKE_COUNT = 0;


    private SensorManager sensorManager;

    Sensor accelerometer;

    TextView values;
    TextView shake_status;
    TextView shake_count;
    EditText shake_threshold;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        values = (TextView) findViewById(R.id.textView2);
        shake_status = (TextView) findViewById(R.id.textView4);
        shake_count = (TextView) findViewById(R.id.textView7);
        shake_threshold = (EditText) findViewById(R.id.editText);

        Log.d(TAG, "Initializing sensor services");
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

    }

    public void startCount(View view) {
        // after the "button start" is clicked, count start

        sensorManager.registerListener(MainActivity.this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        Log.d(TAG, "Registered accelerometer listener");
    }

    public void onSensorChanged(SensorEvent sensorEvent){

        Log.d(TAG, "X: " + sensorEvent.values[0] + "Y: " + sensorEvent.values[1] + "Z: " + sensorEvent.values[2]);

        values.setText("" + sensorEvent.values[0] + ", " + sensorEvent.values[1] + ", " + sensorEvent.values[2]);

        long curTime = System.currentTimeMillis();

        if ((curTime - mLastTime) > TIME_THRESHOLD) {

            float x = sensorEvent.values[0];
            float y = sensorEvent.values[1];
            float z = sensorEvent.values[2];

            double acc_mag = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2)) - SensorManager.GRAVITY_EARTH;

            if (acc_mag > Integer.parseInt(shake_threshold.getText().toString())) {

                mLastTime = curTime;
                shake_status.setText("shake");
                SHAKE_COUNT++;
                shake_count.setText(" " + SHAKE_COUNT);

            }

            else {

                // mLastShakeTime = curTime;
                shake_status.setText("no shake");
                shake_count.setText(" " + SHAKE_COUNT);
            }
        }

    }

    public void stopCount(View view) {
        // after the "button stop" is clicked, stop counting
        SHAKE_COUNT = CLEAR_SHAKE_COUNT;
        shake_count.setText(" " + SHAKE_COUNT);
        sensorManager.unregisterListener(MainActivity.this);
        Log.d(TAG, "UnRegistered accelerometer listener");
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}


