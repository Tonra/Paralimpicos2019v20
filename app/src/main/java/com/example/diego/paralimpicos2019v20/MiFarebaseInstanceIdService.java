package com.example.diego.paralimpicos2019v20;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MiFarebaseInstanceIdService extends FirebaseMessagingService {

    public static final String TAG="NOTICIA";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        showNotification(remoteMessage.getNotification().getTitle(),
                remoteMessage.getNotification().getBody());
    }

    private void showNotification(String title, String body) {
        NotificationManager nm = (NotificationManager) getSystemService(
                Context.NOTIFICATION_SERVICE);
        String notId="com.example.diego.";

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel nc =new NotificationChannel(NotificationChannel.DEFAULT_CHANNEL_ID,
                    "Notificación",NotificationManager.IMPORTANCE_DEFAULT);

            nc.setDescription("NOTIFICACION!");
            nc.enableLights(true);
            nc.setVibrationPattern(new long [] {0,1000,500,10000});
            nc.setLightColor(Color.RED);

            nm.createNotificationChannel(nc);
        }

        NotificationCompat.Builder nb = new NotificationCompat.Builder(this,NOTIFICATION_SERVICE);
    }

    @Override
    public void onNewToken(String s) {
        super.onNewToken(s);
        Log.d("TOKENFIREFASE",s);
    }
}
