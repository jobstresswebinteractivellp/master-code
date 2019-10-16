package com.example.ksb.petuserreg;


import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.content.Intent;

public class MainActivity extends Activity implements OnClickListener
{
    EditText name,age,phone,email,username,password;
    Button register,viewall;
    SQLiteDatabase db;
    RadioButton r1,r2;
    RadioGroup g1;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=(EditText)findViewById(R.id.editText);
        age=(EditText)findViewById(R.id.editText2);
        phone=(EditText) findViewById(R.id.editText4);
        email=(EditText) findViewById(R.id.editText5);
        username=(EditText) findViewById(R.id.editText6);
        password=(EditText)findViewById(R.id.editText7);
        register=(Button)findViewById(R.id.button);
        r1=(RadioButton)findViewById(R.id.radioButton);
        r2=(RadioButton)findViewById(R.id.radioButton2);
        g1=(RadioGroup)findViewById(R.id.radioGroup);
        viewall=(Button)findViewById(R.id.button2);
        register.setOnClickListener(this);
        viewall.setOnClickListener(this);


        // Creating database and table
        db=openOrCreateDatabase("UserDB", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS user(name VARCHAR,age INTEGER,phone INTEGER,email VARCHAR,username VARCHAR,password VARCHAR);");
    }

    public void onClick(View view) {
        // Inserting a record to the Student table
        if (view == register) {
            // Checking for empty fields
            if (name.getText().toString().trim().length() == 0 ||
                    age.getText().toString().trim().length() == 0 || phone.getText().toString().trim().length() == 0 || email.getText().toString().trim().length() == 0 || username.getText().toString().trim().length() == 0 || password.getText().toString().trim().length() == 0) {
                showMessage("Error", "Please enter all values");
                return;
            }
            db.execSQL("INSERT INTO user VALUES('" + name.getText() + "','" + age.getText() +
                    "','" + phone.getText() + "','" + email.getText() + "','" + username.getText() + "','" + password.getText() + "');");
            showMessage("Success", "Registration successful");
            clearText();
        }
        // Deleting a record from the Student table


        if (view ==viewall){

        Cursor c=db.rawQuery("SELECT * FROM user", null);
        if(c.getCount()==0)
        {
            showMessage("Error", "No records found");
            return;
        }
        StringBuffer buffer=new StringBuffer();
        while(c.moveToNext())
        {
            buffer.append("name: "+c.getString(0)+"\n");
            buffer.append("age: "+c.getString(1)+"\n");
            buffer.append("phone: "+c.getString(2)+"\n\n");
            buffer.append("email: "+c.getString(3)+"\n\n");
            buffer.append("username: "+c.getString(4)+"\n\n");
            buffer.append("password: "+c.getString(5)+"\n\n");
        }
        showMessage("user Details", buffer.toString());
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
        name.setText("");
        age.setText("");
        phone.setText("");
        email.setText("");
        username.setText("");
        password.setText("");
        name.requestFocus();
    }
}
