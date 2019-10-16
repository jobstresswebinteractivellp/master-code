package com.example.ksb.petcare;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Context;
import android.app.AlertDialog.Builder;
import android.view.View.OnClickListener;
import android.database.Cursor;
import android.content.Intent;


public class HospitalRegister extends AppCompatActivity implements OnClickListener {
    EditText hosname, location, phone, email, username, password;
    Button reg;
    SQLiteDatabase db;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_register);
        reg = (Button) findViewById(R.id.button16);
        hosname = (EditText) findViewById(R.id.editText15);
        location = (EditText) findViewById(R.id.editText20);
        phone = (EditText) findViewById(R.id.editText16);
        email = (EditText) findViewById(R.id.editText3);
        username = (EditText) findViewById(R.id.editText4);
        password = (EditText) findViewById(R.id.editText5);
        reg.setOnClickListener(this);


        db = openOrCreateDatabase("Hosdb", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS hospital(Hosname VARCHAR,Location VARCHAR,Phone INTEGER,Email VARCHAR,Username VARCHAR,Password VARCHAR);");
    }
            public void onClick(View v) {
                if (v == reg) {
                    if (hosname.getText().toString().trim().length() == 0 || location.getText().toString().trim().length() == 0 || phone.getText().toString().trim().length() == 0 || email.getText().toString().trim().length() == 0 || username.getText().toString().trim().length() == 0 || password.getText().toString().trim().length() == 0) {
                        showMessage("Error", "Please enter all values");
                        return;

                    }
                    db.execSQL("INSERT INTO hospital VALUES('" + hosname.getText() + "','" + location.getText() + "','" + phone.getText() + "','" + email.getText() + "','" + username.getText() + "','" + password.getText() + "');");
                    showMessage("Success", " registered");
                    clearText();
                }



            }

            public void showMessage(String title, String message) {
                Builder builder = new Builder(this);
                builder.setCancelable(true);
                builder.setTitle(title);
                builder.setMessage(message);
                builder.show();

            }
                public void clearText ()
                {
                    hosname.setText(" ");
                    location.setText(" ");
                    phone.setText(" ");
                    email.setText(" ");
                    username.setText(" ");
                    password.setText(" ");
        }

}
