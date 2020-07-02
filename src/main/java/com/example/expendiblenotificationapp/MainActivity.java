package com.example.expendiblenotificationapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final String CHENNEL_ID = "Personal_Notification";
    public static final int NOTIFICATION_ID = 001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Get_Notification(View view) {

        CreateNotificationChennel();

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHENNEL_ID);
        builder.setSmallIcon(R.drawable.ic_sms);
        builder.setContentTitle("Simple Notification");
        builder.setContentText("This is simple notification");
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);

//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cover);
//        builder.setLargeIcon(bitmap);
//        builder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap).bigLargeIcon(null));

        builder.setStyle(new NotificationCompat.BigTextStyle().bigText(getString(R.string.notification_text)));

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(NOTIFICATION_ID, builder.build());
    }

    private void CreateNotificationChennel() {

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            CharSequence name = "Personal Notification";
            String description = "This is personal notification";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel notificationChannel = new NotificationChannel(CHENNEL_ID, name, importance);
            notificationChannel.setDescription(description);

            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);


        }
        }
}