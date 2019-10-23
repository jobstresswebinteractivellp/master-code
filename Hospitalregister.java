package com.example.ksb.petcare4;

import android.app.AlertDialog;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;


public class Hospitalregister extends AppCompatActivity implements OnClickListener {
    EditText hosid,hosname,location,phoneno,email,username,password ;
    Button reg1;
    SQLiteDatabase db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospitalregister);
        reg1 = (Button) findViewById(R.id.button4);

        hosid = (EditText) findViewById(R.id.editText3);
        hosname = (EditText) findViewById(R.id.editText4);
        location = (EditText) findViewById(R.id.editText5);
        phoneno = (EditText) findViewById(R.id.editText6);
        email = (EditText) findViewById(R.id.editText7);
        password = (EditText) findViewById(R.id.editText9);
        username = (EditText) findViewById(R.id.editText8);
        reg1.setOnClickListener(this);

        db = openOrCreateDatabase("Docdb", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS hos(hosid INTEGER PRIMARY KEY,hosname VARCHAR,location VARCHAR,phoneno INTEGER,email VARCHAR,username VARCHAR,password VARCHAR);");
    }
    public void onClick(View view) {
        if (view == reg1) {
            if (hosname.getText().toString().trim().length() == 0 || location.getText().toString().trim().length() == 0 || phoneno.getText().toString().trim().length() == 0 || email.getText().toString().trim().length() == 0 || username.getText().toString().trim().length() == 0||password.getText().toString().trim().length() == 0) {
                showMessage("Error", "Please enter all values");
                return;

            }
            db.execSQL("INSERT INTO hos VALUES('" + hosname.getText() + "','" + location.getText() + "','" + phoneno.getText() + "','" + email.getText() + "','" + username.getText() + "','" + password.getText() + "');");
            showMessage("Success", " registered");
            clearText();
        }

    }

    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }
    public void clearText ()
    {
        hosname.setText(" ");
        location.setText(" ");
        phoneno.setText(" ");
        email.setText(" ");
        username.setText(" ");
        password.setText(" ");

    }

}


