package com.example.mylab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class LaunchIronMan extends AppCompatActivity {

    String valFromAct1Uemail,valFromAct1Pword;
    String u1,p1;
    private static int SPLASH_TIME_OUT=3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_iron_man);
        valFromAct1Uemail=getIntent().getExtras().getString("Username");
        valFromAct1Pword=getIntent().getExtras().getString("Password");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(LaunchIronMan.this,Login.class);
                u1=valFromAct1Uemail;
                p1=valFromAct1Pword;
                i.putExtra("Username",u1);
                i.putExtra("Password",p1);
                startActivity(i);
                finish();
            }
        },SPLASH_TIME_OUT);

    }
}