package com.example.diego.paralimpicos2019v20;

import android.util.Log;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MiFarebaseMessagingService extends FirebaseMessagingService {

    public static final String TAG="NOTICIAS";
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        String from = remoteMessage.getFrom().toString();
        Log.d(TAG,"Mensaje recivido de: " + from);

        if(remoteMessage.getNotification()!=null ){
            Log.d(TAG,"Notificación " +remoteMessage.getNotification().getBody());
            Toast toast1 = Toast.makeText(getApplicationContext(),
                    "Toast por defecto", Toast.LENGTH_SHORT);
            toast1.show();
        }
    }

}