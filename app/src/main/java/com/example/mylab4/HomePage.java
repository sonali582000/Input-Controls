package com.example.mylab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;

public class HomePage extends AppCompatActivity {

    EditText e1,e2,e3,e4;
    Button b1;
    AwesomeValidation aweVal;
    String Uemail,Pword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        e1=findViewById(R.id.editText1);
        e2=findViewById(R.id.editText2);
        e3=findViewById(R.id.editText3);
        e4=findViewById(R.id.editText4);
        b1=findViewById(R.id.button1);

        aweVal =new AwesomeValidation(ValidationStyle.BASIC);
        aweVal.addValidation(this,R.id.editText2,".{6,}",R.string.wrongpassword);
        aweVal.addValidation(this,R.id.editText3,R.id.editText2,R.string.passwordisnotcorrect);


    }

    public void submit(View view) {
        if(aweVal.validate())
        {

        }
        else
        {

        }

        e4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(Patterns.EMAIL_ADDRESS.matcher(e4.getText().toString()).matches())
                {
                    b1.setEnabled(true);
                }
                else
                {
                    b1.setEnabled(false);
                    e4.setError("Invalid Email Address");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        String name, pass, cpass, email;
        name = e1.getText().toString();
        pass = e2.getText().toString();
        cpass = e3.getText().toString();
        email = e4.getText().toString();

        if (name.equals("")) {
            b1.setEnabled(false);
            e1.setError("Name field is blank");
        }
        if(pass.equals(""))
        {
            b1.setEnabled(false);
            e2.setError("Password field is blank");
        }
        if(cpass.equals(""))
        {
            b1.setEnabled(false);
            e3.setError("Confirm Password field is blank");
        }
        if(email.equals(""))
        {
            b1.setEnabled(false);
            e4.setError("Email field is blank");
        }

        if (!name.isEmpty() && !pass.isEmpty() && !cpass.isEmpty() && !email.isEmpty()) {
            if(aweVal.validate())
            {
                Intent i = new Intent(this, LaunchIronMan.class);
                Uemail=e4.getText().toString();
                Pword=e3.getText().toString();
                i.putExtra("Username",Uemail);
                i.putExtra("Password",Pword);
                startActivity(i);
                finish();
            }

        }

    }


}