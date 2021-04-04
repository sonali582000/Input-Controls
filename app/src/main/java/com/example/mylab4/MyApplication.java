package com.example.mylab4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.Serializable;
import java.util.Calendar;

import java.util.ArrayList;

public class MyApplication extends AppCompatActivity {

    Spinner sp1,sp2;
    ArrayList<String> a1;
    ArrayAdapter<String> ap1;
    String gender;
    String dob;
    StringBuilder compl;
    ArrayList<String> arrayList_animals,arrayList_birds,arrayList_flowers;
    ArrayAdapter<String> ap2;
    ArrayList<String> nResult;

    EditText edate;
    EditText ename,emname,elname,ephone,eemail,eaddress,eeducattion,ereligion;
    RadioButton rd1,rd2;
    DatePickerDialog datePicker;
    DatePickerDialog.OnDateSetListener setListener;

    CheckBox checkBox1,checkBox2,checkBox3,checkBox4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_application);

        sp1=(Spinner)findViewById(R.id.sp1);
        sp2=(Spinner)findViewById(R.id.sp2);

        ename=findViewById(R.id.editText1);
        emname=findViewById(R.id.editText2);
        elname=findViewById(R.id.editText3);
        ephone=findViewById(R.id.editText4);
        eemail=findViewById(R.id.editText5);
        eaddress=findViewById(R.id.editText6);
        eeducattion=findViewById(R.id.editText7);
        ereligion=findViewById(R.id.editText8);

        rd1=findViewById(R.id.radioButton1);
        rd2=findViewById(R.id.radioButton2);

        checkBox1=findViewById(R.id.cb1);
        checkBox2=findViewById(R.id.cb2);
        checkBox3=findViewById(R.id.cb3);
        checkBox4=findViewById(R.id.cb4);
        nResult = new ArrayList<>();

        checkBox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox1.isChecked())
                    nResult.add("Class 10th");
                else
                    nResult.remove("Class 10th");
            }
        });

        checkBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox2.isChecked())
                    nResult.add("Class 12th");
                else
                    nResult.remove("Class 12th");
            }
        });

        checkBox3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox3.isChecked())
                    nResult.add("Under Graduated");
                else
                    nResult.remove("Under Graduated");
            }
        });

        checkBox4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox4.isChecked())
                    nResult.add("Post Graduated");
                else
                    nResult.remove("Post Graduated");
            }
        });


        edate = (EditText) findViewById(R.id.date);


                Calendar calendar=Calendar.getInstance();
                int years=calendar.get(Calendar.YEAR);
                int month=calendar.get(Calendar.MONTH);
                int day=calendar.get(Calendar.DAY_OF_MONTH);

              edate.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      DatePickerDialog datePickerDialog =new DatePickerDialog
                              (MyApplication.this, new DatePickerDialog.OnDateSetListener() {
                                  @Override
                                  public void onDateSet(DatePicker view, int year, int month, int day) {

                                      month=month+1;
                                      String date=day+"/"+month+"/"+year;
                                      edate.setText(date);
                                      dob=date;
                                  }
                              },years,month,day);
                      datePickerDialog.show();
                  }
              });



        a1=new ArrayList<>();
        a1.add("India");
        a1.add("United State");
        a1.add("Turkey");

        ap1=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,a1);
        sp1.setAdapter(ap1);

        arrayList_animals=new ArrayList<>();
        arrayList_animals.add("Gujarat");
        arrayList_animals.add("Maharastra");
        arrayList_animals.add("Karnataka");
        arrayList_animals.add("Kerela");
        arrayList_animals.add("Tamil Nadu");

        arrayList_birds=new ArrayList<>();
        arrayList_birds.add("California");
        arrayList_birds.add("Alaska");
        arrayList_birds.add("Florida");


        arrayList_flowers=new ArrayList<>();
        arrayList_flowers.add("Istanbul");
        arrayList_flowers.add("Izmir");
        arrayList_flowers.add("Bursa");
        arrayList_flowers.add("Konya");


        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                {
                    ap2=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_animals);
                }
                if(position==1)
                {
                    ap2=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_birds);
                }
                if(position==2)
                {
                    ap2=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_flowers);
                }

                sp2.setAdapter(ap2);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }


    public void mylab(View view) {

        String fname,lname,mname,phone,email,address,education,religion;
        fname=ename.getText().toString();
        lname=elname.getText().toString();
        mname=emname.getText().toString();
        phone=ephone.getText().toString();
        email=eemail.getText().toString();
        address=eaddress.getText().toString();
        education=eeducattion.getText().toString();
        religion=ereligion.getText().toString();

        if(fname.equals(""))
        {
            ename.setError("Name field is blank");
        }
        if(lname.equals(""))
        {
            elname.setError("Last name field is blank");
        }
        if(mname.equals(""))
        {
            emname.setError("Middle name field is blank");
        }
        if(phone.equals(""))
        {
            ephone.setError("Phone number field is blank");
        }
        if(email.equals(""))
        {
            eemail.setError("Email field is blank");
        }
        if(address.equals(""))
        {
            eaddress.setError("Address field is blank");
        }
        if(religion.equals(""))
        {
            ereligion.setError("Religion field is blank");
        }
        if(education.equals(""))
        {
            eeducattion.setError("Education field is blank");
        }




        if(rd1.isChecked())
        {
            gender=rd1.getText().toString();
        }
        else if(rd2.isChecked())
        {
            gender=rd2.getText().toString();
        }


        StringBuilder sb1=new StringBuilder();
        for (String s: nResult)
            sb1.append(s).append("\n");

        compl=sb1;

        String spinner1,spinner2;

        spinner1=sp1.getSelectedItem().toString();
        spinner2=sp2.getSelectedItem().toString();

       // Toast.makeText(this,"Value"+spinner1+" "+spinner2+" "+fname+" "+gender+dob+sb1,Toast.LENGTH_SHORT).show();

        Intent i=new Intent(this,DispMsg.class);
        i.putExtra("Fname",fname);
        i.putExtra("Lname",lname);
        i.putExtra("Mname",mname);
        i.putExtra("Phone",phone);
        i.putExtra("Email",email);
        i.putExtra("Address",address);
        i.putExtra("Eduaction",education);
        i.putExtra("Religion",religion);
        i.putExtra("Gender",gender);
        i.putExtra("Country",spinner1);
        i.putExtra("State",spinner2);
        i.putExtra("Dob",dob);
        i.putExtra("Course", (Serializable) compl);
        startActivity(i);
    }
}