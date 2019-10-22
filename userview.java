package com.example.ksb.petuserreg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Button;

public class userview extends AppCompatActivity {
    private Spinner  spinner;
    Button GO,Back,Cancel,LOGOUT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userview);
        spinner=(Spinner)findViewById(R.id.spinner);
        GO=(Button)findViewById(R.id.button3);
        Back=(Button)findViewById(R.id.button17);
        Cancel=(Button)findViewById(R.id.button16);
        LOGOUT=(Button)findViewById(R.id.button18);
    }
}
