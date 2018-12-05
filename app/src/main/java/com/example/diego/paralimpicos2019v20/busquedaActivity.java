package com.example.diego.paralimpicos2019v20;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class busquedaActivity extends AppCompatActivity {

    //creacion de variables tipo Spinner
    Spinner comboCiuidad;
    Spinner comboInstitucion;
    Spinner comboParticipante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busqueda);

        //Referencias a variables tipo Spinner
        comboCiuidad=(Spinner)findViewById(R.id.ciudad);
        comboInstitucion=(Spinner)findViewById(R.id.institucion);
        comboParticipante=(Spinner)findViewById(R.id.participante);

        //Carga de adapter en los spinner
        ArrayAdapter<CharSequence> adapter =ArrayAdapter.createFromResource(this,R.array.spinner_test,
                android.R.layout.simple_spinner_item);
        comboCiuidad.setAdapter(adapter);

        ArrayAdapter<CharSequence> adapter2 =ArrayAdapter.createFromResource(this,R.array.spinner_test,
                android.R.layout.simple_spinner_item);
        comboInstitucion.setAdapter(adapter2);

        ArrayAdapter<CharSequence> adapter3 =ArrayAdapter.createFromResource(this,R.array.spinner_test,
                android.R.layout.simple_spinner_item);
        comboParticipante.setAdapter(adapter3);

        /**
         * Metodos para seleccionar el items escogido de los spinner
         */
        comboCiuidad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        comboInstitucion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        comboParticipante.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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
