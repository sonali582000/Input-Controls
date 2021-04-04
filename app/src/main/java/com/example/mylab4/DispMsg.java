package com.example.mylab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class DispMsg extends AppCompatActivity {

    private static int SPLASH_TIME_OUT=15000;
    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disp_msg);

        new Handler().postDelayed(new Runnable() {
                                      @Override
                                          public void run() {
                                              Intent homeIntent = new Intent(DispMsg.this,RatingApp.class);
                                              startActivity(homeIntent);
                                              finish();
                                      }
                                  },SPLASH_TIME_OUT);

        t1=findViewById(R.id.textView2);
        t2=findViewById(R.id.textView14);
        t3=findViewById(R.id.textView15);
        t4=findViewById(R.id.textView16);
        t5=findViewById(R.id.textView17);
        t6=findViewById(R.id.textView18);
        t7=findViewById(R.id.textView19);
        t8=findViewById(R.id.textView20);
        t9=findViewById(R.id.textView21);
        t10=findViewById(R.id.textView22);
        t11=findViewById(R.id.textView23);
        t12=findViewById(R.id.textView24);
        t13=findViewById(R.id.textView25);

        Intent intent = getIntent();
        String s1 = intent.getStringExtra("Fname");
        String s2 = intent.getStringExtra("Mname");
        String s3 = intent.getStringExtra("Lname");
        String s4 = intent.getStringExtra("Phone");
        String s5 = intent.getStringExtra("Email");
        String s6 = intent.getStringExtra("Gender");
        String s7 = intent.getStringExtra("Country");
        String s8 = intent.getStringExtra("State");
        String s9 = intent.getStringExtra("Address");
        String s10 = intent.getStringExtra("Dob");
        String s11 = intent.getStringExtra("Eduaction");
        String s12 = intent.getStringExtra("Religion");
        String s13 = intent.getStringExtra("Course");

        t1.setText(s1);
        t2.setText(s2);
        t3.setText(s3);
        t4.setText(s4);
        t5.setText(s5);
        t6.setText(s6);
        t7.setText(s7);
        t8.setText(s8);
        t9.setText(s9);
        t10.setText(s10);
        t11.setText(s11);
        t12.setText(s12);
        t13.setText(s13);
    }
}