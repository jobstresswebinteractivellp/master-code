package com.example.ksb.petcare3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Spinner;
import android.view.View;

public class userhome extends AppCompatActivity implements View.OnClickListener{
    Spinner spinner;
    Button GO,CHAT,NOTIFICATION,LOGOUT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userhome);
        spinner = (Spinner) findViewById(R.id.spinner);
        GO = (Button) findViewById(R.id.button5);
        CHAT = (Button) findViewById(R.id.button6);
        NOTIFICATION = (Button) findViewById(R.id.button7);
        LOGOUT = (Button) findViewById(R.id.button8);
        LOGOUT.setOnClickListener(this);
    }
    public void onClick(View v) {
        if(v==LOGOUT)
        {

            Intent intent=new Intent(userhome.this,MainActivity.class);
            startActivity(intent);
        }

    }
}
