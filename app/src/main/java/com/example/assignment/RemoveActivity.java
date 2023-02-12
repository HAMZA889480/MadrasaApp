package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import data.MyDbHandler;

public class RemoveActivity extends AppCompatActivity {

    EditText stu_id;
    Button delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove);

        //Initialize the button and text VIew
        stu_id=(EditText) findViewById(R.id.StudentID);
        delete=(Button) findViewById(R.id.removeButton);

        MyDbHandler db = new MyDbHandler(RemoveActivity.this);
        //Binding the on click Listner with delete button
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Getting the value from EditText
                String delete_id=stu_id.getText().toString();

                if(delete_id.equals(""))
                {
                    Toast.makeText(RemoveActivity.this, "Enter Id", Toast.LENGTH_SHORT).show();

                }
                else
                {
                    Integer result=db.deleteStudent(delete_id);

                    if(result.equals(1))
                    {
                        Toast.makeText(RemoveActivity.this, "Student is deleted", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(RemoveActivity.this, "Student NOT deleted", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}