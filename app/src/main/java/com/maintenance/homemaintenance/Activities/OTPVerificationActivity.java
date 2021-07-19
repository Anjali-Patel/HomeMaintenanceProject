package com.maintenance.homemaintenance.Activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

import com.goodiebag.pinview.Pinview;
import com.maintenance.homemaintenance.R;

import java.util.Objects;

public class OTPVerificationActivity extends AppCompatActivity {
TextView mobile_number,count_downCounter;
    public int counter;
    Pinview pinview;
    private static final long START_TIME_IN_MILLIS=200000;
    private CountDownTimer countDownTimer;
    private boolean mTimerRunning;
    private long mTimeLeftInMillis=START_TIME_IN_MILLIS;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_o_t_p_verification);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.verify_otp);
        }
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        mobile_number=findViewById(R.id.mobile_number);
        count_downCounter=findViewById(R.id.count_downCounter);
        pinview=findViewById(R.id.pinview);
        mobile_number.setText("1234567890");
//        new CountDownTimer(5000,1000) {
//            @Override
//            public void onTick(long millisUntilFinished) {
//                count_downCounter.setText(String.valueOf(counter));
//                counter--;
//            }
//            @Override
//            public void onFinish() {
//                count_downCounter.setText("00:00");
//            }
//        }.start();

    }

    public void verify(View view) {

    }
}