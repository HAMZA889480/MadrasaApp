package com.example.assignment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import Model.Student;
import data.MyDbHandler;

public class RecordActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    ArrayList<String> Name, Sabak, Sabki, ID;
    MyAdaptor adaptor;
    MyDbHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        db =new MyDbHandler(RecordActivity.this);

        ID=new ArrayList<>();
        Name=new ArrayList<>();
        Sabak=new ArrayList<>();
        Sabki=new ArrayList<>();
        adaptor=new MyAdaptor(this,ID,Name, Sabak, Sabki);

        recyclerView=findViewById(R.id.Recycler_View);


        recyclerView.setAdapter(adaptor);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        displayData();

    }

    private void displayData() {

        Cursor cursor=db.getRecords();

        if(cursor.getCount()==0)
        {
            Toast.makeText(RecordActivity.this, "No Student Added", Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {
            while(cursor.moveToNext())
            {
                ID.add(cursor.getString(0));
                Name.add(cursor.getString(1));
                Sabak.add(cursor.getString(2));
                Sabki.add(cursor.getString(3));




















            }
        }
    }
}