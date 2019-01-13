package com.example.diego.paralimpicos2019v20;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;

public class CalendarioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario);
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
     * Metodo que permite utilizar el boton back del propio celular para generar
     * una salida de la aplicacion mas intuitiva
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
