package com.maintenance.homemaintenance.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.maintenance.homemaintenance.R;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        final ImageView im1 = (ImageView)findViewById(R.id.im1);
        final Animation zoomanimation = AnimationUtils.loadAnimation(getBaseContext(),R.anim.animated_logo);
        im1.startAnimation(zoomanimation);
        zoomanimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationStart(Animation animation){
                TimerTask timerTask = new TimerTask() {
                    @Override
                    public void run() {
                        Intent intent =new Intent(SplashScreenActivity.this,MainActivity.class);
                        startActivity(intent);
                        finish(); }
                };
                Timer timer = new Timer();
                timer.schedule(timerTask,3000);
            }
            public void onAnimationEnd(Animation animation){

            }
            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}