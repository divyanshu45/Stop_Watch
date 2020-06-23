package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mainText, subtext;
    Button btn;
    ImageView img;
    Animation atg, sub_anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainText = findViewById(R.id.textView);
        subtext = findViewById(R.id.textView2);
        btn = findViewById(R.id.button1);
        img = findViewById(R.id.imageView);

        atg = AnimationUtils.loadAnimation(this,R.anim.alpha);
        sub_anim = AnimationUtils.loadAnimation(this,R.anim.sub_anim);

        img.startAnimation(atg);
        mainText.startAnimation(sub_anim);
        subtext.startAnimation(sub_anim);
        btn.startAnimation(sub_anim);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this,Running.class);
                in.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(in);
            }
        });

    }
}