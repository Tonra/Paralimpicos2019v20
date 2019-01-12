package com.example.diego.paralimpicos2019v20;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import Service.Notification;
import Service.NotiListAdapter;

public class NotificationActivity extends AppCompatActivity  {

    private ListView notificacion;
    private NotiListAdapter adapter;
    private List<Notification> notiList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        notificacion=(ListView)findViewById(R.id.listaDeNoti);
        notiList =new ArrayList<>();

        //DE ACA SE BORRA PARA CARGAR LOS DATOS EN LA BD
        int id=0;
        String titulo="titulo de prueba";
        String texto="texto de notificacion";
        Calendar calendario = Calendar.getInstance();
        int hora=calendario.get(Calendar.HOUR_OF_DAY);
        int minuto=calendario.get(Calendar.MINUTE);
        int segundo=calendario.get(Calendar.SECOND);
        String horaFinal=hora+":"+minuto+":"+segundo;
        //ACA SE CARGAN LOS DATOS A EL ARRAYLIST

        final DatabaseReference mRootReference;
        mRootReference = FirebaseDatabase.getInstance().getReference();
        mRootReference.child("Notificacion").addValueEventListener(new ValueEventListener() {
            String a="";
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (final DataSnapshot snapshot:dataSnapshot.getChildren()){
                     mRootReference.child("Notificacion").child(snapshot.getKey()).addValueEventListener(new ValueEventListener() {
                         @Override
                         public void onDataChange(DataSnapshot dataSnapshot) {
                             Notification noti= snapshot.getValue(Notification.class);
                             Log.e("Datos",""+snapshot.getValue());
                             String hora = noti.getHora();
                             String id=noti.getId();
                             String texto=noti.getTexto();
                             String titulo=noti.getTitulo();
                             notiList.add(new Notification(hora,id,titulo,texto));
                             
                            // llenarLista(hora,id,texto,titulo);
                             adapter= new NotiListAdapter(getApplicationContext(),notiList);
                             notificacion.setAdapter(adapter);
                         }

                         @Override
                         public void onCancelled(DatabaseError databaseError) {

                         }
                     });
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



        //ACA SE DEBEN LEER LOS MENSAJES EN LA BD Y CARGARLOS A LA LISTA

        notificacion.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"" + view.getTag(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Evento que vuelte a la main activity
     */
    public void eventoVolverMain( ) {
        Intent intent = new Intent(this,Main_Activity.class);
        startActivity(intent);
        finish();
    }

    /**
     * Meotod que permite utilizar el boton back del propio celular para generar
     * una salida de la aplicaicon mas intuitiva
     * @param keyCode
     * @param event
     * @return
     */
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if(keyCode==event.KEYCODE_BACK){
            eventoVolverMain( );
        }
        return super.onKeyDown(keyCode,event);
    }

    public void eventoBack(View view) {
        eventoVolverMain();
    }

}
