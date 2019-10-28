package com.example.ksb.petcare4;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.widget.Spinner;

public class DoctorUpdate extends AppCompatActivity implements View.OnClickListener {
    EditText docid, docname, qualification, avday, avltime, fee;
    Button update, logout, hme, back;
    private Spinner spinner1;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_update);
        docid= (EditText) findViewById(R.id.editText21);
        docname = (EditText) findViewById(R.id.editText16);
        qualification = (EditText) findViewById(R.id.editText17);
        avday = (EditText) findViewById(R.id.editText18);
        avltime = (EditText) findViewById(R.id.editText19);
        fee = (EditText) findViewById(R.id.editText20);
        update= (Button) findViewById(R.id.button22);
        hme=(Button) findViewById(R.id.button19);
        update.setOnClickListener(this);
        hme.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==update) {
            if (docid.getText().toString().trim().length() == 0) {
                showMessage("error", "please enter the id");
                return;
            }
            Cursor c = db.rawQuery("SELECT * FROM doctor WHERE docid='" + docid.getText() + "'", null);
            if (c.moveToFirst()) {
                db.execSQL("UPDATE doctor SET Docname='" + docname.getText() + "',Qualification='" + qualification.getText() + "',Avalday='" + avday.getText() + "',Avaltime='" + avltime.getText() + "',Fee='" + fee.getText() + "' WHERE docid='" + docid.getText() + "'");
                showMessage("success", "Record modified");

            } else {
                showMessage("error", "invalid rollno");
            }
            clearText();

        }
        if(v==hme)
        {
            Intent intent=new Intent(DoctorUpdate.this,Hospitalhome.class);
            startActivity(intent);
        }
        }
    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }

    public void clearText() {
        docid.setText(" ");
        docname.setText(" ");
        qualification.setText(" ");
        avday.setText(" ");
        avltime.setText(" ");
        fee.setText(" ");

    }

    }

