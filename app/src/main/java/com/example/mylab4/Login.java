package com.example.mylab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    String valFromAct1Uemail1,valFromAct1Pword1;
    EditText e1,e2;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        e1=findViewById(R.id.editText1);
        e2=findViewById(R.id.editText2);
        b1=findViewById(R.id.button1);

        valFromAct1Uemail1=getIntent().getExtras().getString("Username");
        valFromAct1Pword1=getIntent().getExtras().getString("Password");

        //Toast.makeText(this,"Uname="+valFromAct1Uemail1,Toast.LENGTH_SHORT).show();
    }

    public void login(View view)
    {
        String email,pass;
        email=e1.getText().toString();
        pass=e2.getText().toString();

        if(email.equals(""))
        {
            e1.setError("Username field is blank");
        }
        if(pass.equals(""))
        {
            e2.setError("Password field is blank");
        }

        if ( !email.isEmpty() && !pass.isEmpty())
        {
            b1.setEnabled(true);
            if (email.equals(valFromAct1Uemail1) && pass.equals(valFromAct1Pword1)) {
                Intent i = new Intent(this, MyApplication.class);
                startActivity(i);
                finish();
            } else {

                Toast t1 = Toast.makeText(this, "Username or Password is invalid..!!", Toast.LENGTH_SHORT);
                t1.setGravity(Gravity.BOTTOM, 0, 0);
                t1.show();
            }
        }
    }
}