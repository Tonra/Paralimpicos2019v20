package com.example.diego.paralimpicos2019v20;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

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

        int id=0;

        String titulo="titulo de prueba";
        String texto="texto de notificacion";
        Calendar calendario = Calendar.getInstance();
        int hora=calendario.get(Calendar.HOUR_OF_DAY);
        int minuto=calendario.get(Calendar.MINUTE);
        int segundo=calendario.get(Calendar.SECOND);
        String horaFinal=hora+":"+minuto+":"+segundo;

        notiList.add(new Notification(id,titulo,texto,horaFinal));
        //SE CARGAN A LA LISTA

        adapter= new NotiListAdapter(getApplicationContext(),notiList);
        notificacion.setAdapter(adapter);
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
