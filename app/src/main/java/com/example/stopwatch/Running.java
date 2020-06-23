package com.example.stopwatch;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.fonts.SystemFonts;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class Running extends AppCompatActivity {

    Button start,end,reset;
    ImageView anchor;
    Animation round;
    Chronometer timer;
    boolean running;
    long pauseOff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_running);

        start = findViewById(R.id.button3);
        end = findViewById(R.id.button4);
        reset = findViewById(R.id.button5);
        anchor = findViewById(R.id.anchor);
        timer = findViewById(R.id.timer);

        round = AnimationUtils.loadAnimation(this,R.anim.round);
        timer.setBase(SystemClock.elapsedRealtime());
        reset.setVisibility(View.INVISIBLE);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!running) {
                    anchor.startAnimation(round);
                    timer.setBase(SystemClock.elapsedRealtime() - pauseOff);
                    timer.start();
                    running = true;
                }
                reset.setVisibility(View.INVISIBLE);
            }
        });

        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(running) {
                    anchor.clearAnimation();
                    timer.stop();
                    pauseOff = SystemClock.elapsedRealtime() - timer.getBase();
                    running = false;
                }
                reset.setVisibility(View.VISIBLE);
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    anchor.clearAnimation();
                    timer.setBase(SystemClock.elapsedRealtime());
                    pauseOff = 0;
                    reset.setVisibility(View.INVISIBLE);
            }
        });
    }
}