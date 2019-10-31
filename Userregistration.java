package com.example.ksb.petcare5;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.content.Context;
import android.app.AlertDialog.Builder;

public class Userregistration extends AppCompatActivity implements View.OnClickListener {
    EditText userid,name,age,phone,email,username,password,address;
    Button next,back;
    SQLiteDatabase db;
    RadioButton r1,r2;
    RadioGroup g1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userregistration);
        userid=(EditText)findViewById(R.id.editText15);
        name=(EditText)findViewById(R.id.editText16);
        age=(EditText)findViewById(R.id.editText17);
        phone=(EditText) findViewById(R.id.editText19);
        address=(EditText) findViewById(R.id.editText18);
        email=(EditText) findViewById(R.id.editText20);
        username=(EditText) findViewById(R.id.editText21);
        password=(EditText)findViewById(R.id.editText22);
        next=(Button)findViewById(R.id.button16);

        r1=(RadioButton)findViewById(R.id.radioButton);
        r2=(RadioButton)findViewById(R.id.radioButton1);
        g1=(RadioGroup)findViewById(R.id.radioGroup);
        next.setOnClickListener(this);
        db=openOrCreateDatabase("UserDB", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS user(userid VARCHAR PRIMARY KEY,name VARCHAR,age INTEGER,adress VARCHAR,phone INTEGER,email VARCHAR,username VARCHAR,password VARCHAR);");
    }



    @Override
    public void onClick(View v) {
        if (v == next) {
            // Checking for empty fields
            if (userid.getText().toString().trim().length() == 0 ||name.getText().toString().trim().length() == 0 ||
                    age.getText().toString().trim().length() == 0 ||address.getText().toString().trim().length() == 0 ||phone.getText().toString().trim().length() == 0 || email.getText().toString().trim().length() == 0 || username.getText().toString().trim().length() == 0 || password.getText().toString().trim().length() == 0) {
                showMessage("Error", "Please enter all values");
                return;
            }
            db.execSQL("INSERT INTO user VALUES('" + userid.getText() + "','" + name.getText() + "','" + age.getText() +
                    "','" + phone.getText() + "','" + phone.getText() + "','" + email.getText() + "','" + username.getText() + "','" + password.getText() + "');");
            showMessage("Success", "Registration successful");
            clearText();
        }}
        public void showMessage(String title,String message)
        {
            Builder builder=new Builder(this);
            builder.setCancelable(true);
            builder.setTitle(title);
            builder.setMessage(message);
            builder.show();
        }
        public void clearText()
        {
            userid.setText("");
            name.setText("");
            age.setText("");
            address.setText(" ");
            phone.setText("");
            email.setText("");
            username.setText("");
            password.setText("");
            name.requestFocus();
        }




    }

