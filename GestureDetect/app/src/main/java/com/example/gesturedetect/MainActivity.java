package com.example.gesturedetect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;


public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    TextView display;
    private GestureDetectorCompat mDetector;
    private static final int SWIPE_DISTANCE_THRESHOLD = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = (TextView) findViewById(R.id.textView2);

        // mDetector = new GestureDetectorCompat(this,this);

    }

    public boolean onTouchEvent(MotionEvent event){
        if (this.mDetector.onTouchEvent(event)) {
            return true;
        }
        return super.onTouchEvent(event);
    }


    @Override
    public boolean onDown(MotionEvent e) {
        // display.setText("Down detected!");
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

        // display.setText("Show press detected!");

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        display.setText("Single tap detected!");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        //display.setText("Scroll!");
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        display.setText("Long press detected!");
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        //display.setText("Fling!");

        if (e1.getX() - e2.getX() > SWIPE_DISTANCE_THRESHOLD) {

            display.setText("Right to left swipe detected!");
            return true;
        }

        else if (e2.getX() - e1.getX() > SWIPE_DISTANCE_THRESHOLD) {

            display.setText("Left to right swipe detected!");
            return true;

        }

        if (e1.getY() - e2.getY() > SWIPE_DISTANCE_THRESHOLD) {

            display.setText("Bottom to top swipe detected!");
            return true;

        }

        else if (e2.getY() - e1.getY() > SWIPE_DISTANCE_THRESHOLD) {

            display.setText("Top to bottom swipe detected!");
            return true;
            
        }


        return false;
    }

    public void startDetect(View view) {


        mDetector = new GestureDetectorCompat(this,this);

    }


    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        display.setText("Double tap detected!");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        return false;
    }
}
