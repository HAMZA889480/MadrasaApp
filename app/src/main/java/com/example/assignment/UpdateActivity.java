package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Model.Student;
import data.MyDbHandler;

public class UpdateActivity extends AppCompatActivity {

    EditText stu_id,f_name,prev_sabak,prev_sabaki, newFName, newSabak, newSabki;
    Button search_btn, update_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        MyDbHandler db = new MyDbHandler(UpdateActivity.this);

        //Initiaze the Text Edits and Button
        stu_id=(EditText) findViewById(R.id.StudentID);
        f_name=(EditText) findViewById(R.id.FName);
        prev_sabak=(EditText) findViewById(R.id.PSabak);
        prev_sabaki=(EditText) findViewById((R.id.PSabaki));
        newFName=(EditText) findViewById(R.id.UpdatedFName);
        newSabak=(EditText) findViewById(R.id.UpdateSabak);
        newSabki=(EditText) findViewById(R.id.UpdateSabaki);


        search_btn=(Button) findViewById(R.id.btn_search);

        update_btn=(Button) findViewById(R.id.UpdateBtn);

        search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Student_ID=stu_id.getText().toString();

                if(!(f_name.getText().toString().equals("")))   //Field are NOT empty
                {
                    //Clear the text Fields
                    f_name.setText("");
                    prev_sabaki.setText("");
                    prev_sabaki.setText("");
                }

                if(Student_ID.equals(""))
                {
                    Toast.makeText(UpdateActivity.this, "Enter Id", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Student result=db.getData(Student_ID);

                   if(result.getName().equals(""))
                   {
                       //No Record Found
                       Toast.makeText(UpdateActivity.this, "No Record!!", Toast.LENGTH_SHORT).show();
                   }
                   else
                   {
                       //Record is Displayed
                       f_name.setText(result.getName());
                       prev_sabak.setText(result.getSabak());
                       prev_sabaki.setText(result.getSabki());
                   }


                }
            }
        });


        update_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(newFName.getText().toString().equals("") && newSabak.getText().toString().equals("")
                    && newSabki.getText().toString().equals(""))
                {
                    //if ALL text field are empty
                    Toast.makeText(UpdateActivity.this, "Provide update details!!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String F_NAME=newFName.getText().toString();
                    String Sabak=newSabak.getText().toString();
                    String Sabki=newSabki.getText().toString();

                    Student UpStudent=new Student();
                    UpStudent.setId(stu_id.getText().toString());
                    if(F_NAME.equals(""))
                    {
                        //Store previous name
                        F_NAME=f_name.getText().toString();

                        UpStudent.setName(F_NAME);
                        UpStudent.setSabak(Sabki);
                        UpStudent.setSabki(Sabak);

                    }
                    else if(Sabak.equals(""))
                    {
                        Sabak=prev_sabak.getText().toString();

                        UpStudent.setName(F_NAME);
                        UpStudent.setSabak(Sabki);
                        UpStudent.setSabki(Sabak);
                    }
                    else if(Sabki.equals(""))
                    {
                        Sabki=prev_sabaki.getText().toString();

                        UpStudent.setName(F_NAME);
                        UpStudent.setSabak(Sabki);
                        UpStudent.setSabki(Sabak);
                    }
                    else if(F_NAME.equals("") && Sabak.equals(""))
                    {
                        F_NAME=f_name.getText().toString();
                        Sabak=prev_sabak.getText().toString();

                        UpStudent.setName(F_NAME);
                        UpStudent.setSabak(Sabki);
                        UpStudent.setSabki(Sabak);
                    }
                    else if(F_NAME.equals("") && Sabki.equals(""))
                    {
                        F_NAME=f_name.getText().toString();
                        Sabki=prev_sabaki.getText().toString();

                        UpStudent.setName(F_NAME);
                        UpStudent.setSabak(Sabki);
                        UpStudent.setSabki(Sabak);
                    }
                    else if(Sabak.equals("") && Sabki.equals(""))
                    {
                        Sabki=prev_sabaki.getText().toString();
                        Sabak=prev_sabak.getText().toString();

                        UpStudent.setName(F_NAME);
                        UpStudent.setSabak(Sabki);
                        UpStudent.setSabki(Sabak);
                    }
                    else
                    {
                        UpStudent.setName(F_NAME);
                        UpStudent.setSabak(Sabki);
                        UpStudent.setSabki(Sabak);
                    }



                    //Call the db function to update
                    db.updateStudent(UpStudent);

                    Toast.makeText(UpdateActivity.this, "Record Updated!!", Toast.LENGTH_SHORT).show();


                        //Clear the text Fields
                        newFName.setText("");
                        newSabak.setText("");
                        newSabki.setText("");

                }

            }
        });


    }
}