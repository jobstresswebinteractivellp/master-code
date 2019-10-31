package com.example.ksb.petcare5;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.AlertDialog.Builder;
import android.app.PendingIntent;
import android.graphics.BitmapFactory;

import android.content.Intent;
import android.support.v4.app.NotificationCompat;

public class Addnotify extends AppCompatActivity {
    EditText ed1,ed2,ed3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addnotify);
        ed1=(EditText)findViewById(R.id.editText23);
        ed2=(EditText)findViewById(R.id.editText24);
        ed3=(EditText)findViewById(R.id.editText25);
        Button b1=(Button)findViewById(R.id.button18);
        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(Addnotify.this);
                builder.setSmallIcon(android.R.drawable.ic_dialog_alert);
                Intent intent=new Intent(Addnotify.this,HospitalHome.class);
               // startActivity(intent);
                PendingIntent pendingIntent = PendingIntent.getActivity(Addnotify.this, 0, intent, 0);
                builder.setContentIntent(pendingIntent);
                builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
                builder.setContentTitle("Notifications Title");
                builder.setContentText("Your notification content here.");
                builder.setSubText("Tap to view the website.");

                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                // Will display the notification in the notification bar
                notificationManager.notify(1, builder.build());
            }
        });
    }


}




