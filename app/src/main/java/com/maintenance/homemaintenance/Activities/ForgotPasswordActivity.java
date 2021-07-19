package com.maintenance.homemaintenance.Activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.maintenance.homemaintenance.R;

import java.util.Objects;

public class ForgotPasswordActivity extends AppCompatActivity {
Spinner email_mobile_spinner;
    static  String [] mobileEmailArray = {"Mobile Number","Email"};
String selectedData="";
TextInputLayout email_layout,mobile_layout;
boolean flag=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.forgot_password);
        }
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        email_layout=findViewById(R.id.email_layout);
        mobile_layout=findViewById(R.id.mobile_layout);
        email_mobile_spinner=findViewById(R.id.email_mobile_spinner);
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,mobileEmailArray);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        email_mobile_spinner.setAdapter(aa);
        email_mobile_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                selectedData = mobileEmailArray[position];
                    if (mobileEmailArray[position].equalsIgnoreCase("Email")) {
                        email_layout.setVisibility(View.VISIBLE);
                        mobile_layout.setVisibility(View.GONE);

                    }  if(mobileEmailArray[position].equalsIgnoreCase("Mobile Number")){
                        email_layout.setVisibility(View.GONE);
                        mobile_layout.setVisibility(View.VISIBLE);

                    }


            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }

    public void proceed(View view) {

    }
}