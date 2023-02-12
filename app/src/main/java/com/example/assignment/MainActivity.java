package com.example.assignment;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import data.MyDbHandler;

public class MainActivity extends AppCompatActivity {

    EditText loginText, passwordText;
    Button btn_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginText=(EditText) findViewById(R.id.login);
        passwordText=(EditText) findViewById(R.id.password);

        btn_login=(Button)findViewById(R.id.buttonLogin);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userName=loginText.getText().toString();
                String password=passwordText.getText().toString();

                if(userName.equals("admin") && password.equals("admin")) {
                    Toast.makeText(MainActivity.this, "Admin Login", Toast.LENGTH_SHORT).show();
                    Intent adminIntent=new Intent(getApplicationContext(),AdminActivity.class);
                    startActivity(adminIntent);
                }
                else if(userName.equals("parent") && password.equals("parent"))
                {
                    Toast.makeText(MainActivity.this, "Parent Login", Toast.LENGTH_SHORT).show();
                    Intent parentIntent=new Intent(getApplicationContext(),ParentActivity.class);
                    startActivity(parentIntent);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Invalid Login", Toast.LENGTH_SHORT).show();
                }
            }

        });




    }
}