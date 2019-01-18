package com.example.diego.paralimpicos2019v20;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

public class descripcionParticipante extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion_participante);
    }



    /**
     * Metodo que vuelva al main activity
     */
    public void eventoVolverMain( ) {
        Intent intent = new Intent(this,busquedaActivity.class);
        startActivity(intent);
        finish();
    }

    /**
     * Metodo que utiliza los botones nativos del dispositivos para salir de la app
     * @param keyCode
     * @param event
     * @return
     */
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if(keyCode==event.KEYCODE_BACK){
            eventoVolverMain();
        }
        return super.onKeyDown(keyCode,event);
    }

    public void eventoBack(View view) {
        eventoVolverMain();
    }
}
