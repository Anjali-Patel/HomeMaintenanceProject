package com.maintenance.homemaintenance.Activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.maintenance.homemaintenance.R;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.sign_in);
        }
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public void signIn(View view) {
    }

    public void register(View view) {
        Intent intent= new Intent(LoginActivity.this,RegistrationActivity.class);
        startActivity(intent);
    }

    public void forgotPassword(View view) {
        Intent intent= new Intent(LoginActivity.this,ForgotPasswordActivity.class);
        startActivity(intent);
    }
}