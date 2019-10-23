package com.example.ksb.petcare4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText uname,pswd;
    Button login;
    Dbhandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uname=(EditText)findViewById(R.id.editText);
        pswd=(EditText)findViewById(R.id.editText1);
        login=(Button)findViewById(R.id.button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String name=uname.getText().toString();
                String password=pswd.getText().toString();
                int id= checkUser(new User(name,password));
                if(id==-1)
                {
                    Toast.makeText(MainActivity.this,"Invalid Login Credentials!",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Login Success! "+name,Toast.LENGTH_LONG).show();
                }
            }});
        db=new Dbhandler(MainActivity.this);

        db.addUser(new User("Admin", "Admin"));
        db.addUser(new User("User", "User"));
        db.addUser(new User("sindhuri", "sindri"));
    }
    public int checkUser(User user)
    {
        return db.checkUser(user);
    }
}



