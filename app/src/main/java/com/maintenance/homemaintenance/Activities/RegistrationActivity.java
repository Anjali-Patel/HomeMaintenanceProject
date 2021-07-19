package com.maintenance.homemaintenance.Activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.maintenance.homemaintenance.R;

import java.util.Objects;

public class RegistrationActivity extends AppCompatActivity {
Spinner find_us;
    static  String [] findUsArray = {"How did you find us","Mplus Website","Word of Mouth","Google","Socila Media(Facbook/LinkedIn/Twitter)","Advertisement","Vehicles","Customer Referral","Radio","Event","Building Staff Recommendation","Others"};
String selectedData="";
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.sign_up);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        find_us=findViewById(R.id.find_us);
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,findUsArray);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        find_us.setAdapter(aa);
        find_us.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                selectedData = findUsArray[position];



            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });




    }
    public void signIn(View view) {
        Intent intent= new Intent(RegistrationActivity.this,LoginActivity.class);
        startActivity(intent);
    }
    public void registerCustomer(View view) {
        Intent intent= new Intent(RegistrationActivity.this,OTPVerificationActivity.class);
        startActivity(intent);
    }
}