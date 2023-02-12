package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminActivity extends AppCompatActivity {

    Button add, update, remove, record;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);



        //Initialize the buttons
        add=(Button) findViewById(R.id.btn_add);
        update=(Button) findViewById(R.id.btn_update);
        remove=(Button) findViewById(R.id.btn_delete);
        record=(Button) findViewById(R.id.btn_record);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Move to add activity section
                Intent addIntent=new Intent(getApplicationContext(),AddActivity.class);
                startActivity(addIntent);
            }
        });


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Move to update activity section
                Intent updateIntent=new Intent(getApplicationContext(),UpdateActivity.class);
                startActivity(updateIntent);

            }
        });

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Move to remove activity section
                Intent removeIntent=new Intent(getApplicationContext(),RemoveActivity.class);
                startActivity(removeIntent);

            }
        });

        record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Move to record activity section
                Intent recordIntent=new Intent(getApplicationContext(),RecordActivity.class);
                startActivity(recordIntent);
            }
        });

    }
}