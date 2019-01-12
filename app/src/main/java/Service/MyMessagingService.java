package Service;


import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import com.example.diego.paralimpicos2019v20.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Calendar;



public class MyMessagingService extends FirebaseMessagingService {

    private DatabaseReference databaseReference;
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        showNotifications(remoteMessage.getNotification().getTitle(),remoteMessage.getNotification().getBody());
    }

    public void showNotifications(String title, String message) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "MyNotifications")
                .setContentTitle(title)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setAutoCancel(true)
                .setContentText(message);

        NotificationManagerCompat manager = NotificationManagerCompat.from(this);
        manager.notify(999, builder.build());

        //ACA SE DEBEN MANDAR LOS MENSAJES A LA BD

        Calendar calendario = Calendar.getInstance();
        int hora = calendario.get(Calendar.HOUR_OF_DAY);
        int minuto = calendario.get(Calendar.MINUTE);
        int segundo = calendario.get(Calendar.SECOND);
        String horaFinal = hora + ":" + minuto + ":" + segundo;


        /*
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference myRef =database.getReference();
        Notification noti=new Notification(0,"titulo","texto","hora");
        myRef.child("Notificacion").push().setValue(noti);
        */

    }

}
