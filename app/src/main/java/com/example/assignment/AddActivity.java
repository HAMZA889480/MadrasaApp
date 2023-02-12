package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Model.Student;
import data.MyDbHandler;

public class AddActivity extends AppCompatActivity {

    EditText FName, LName;
    Button add_student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        add_student=(Button) findViewById(R.id.add_btn);
        FName= (EditText) findViewById(R.id.FirstName);
        LName= (EditText) findViewById(R.id.LastName);

        add_student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String fName=FName.getText().toString();
                String lName=LName.getText().toString();

                if(fName.equals("") || lName.equals(""))
                {
                    Toast.makeText(AddActivity.this, "Provide Details", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    MyDbHandler db =new MyDbHandler(AddActivity.this);

                    String fullName=fName+" "+lName;
                    Student student=new Student(fullName, "0","0");

                    //adding student to database
                    db.addStudent(student);
                }

            }
        });

    }




    //Creating object of student

}