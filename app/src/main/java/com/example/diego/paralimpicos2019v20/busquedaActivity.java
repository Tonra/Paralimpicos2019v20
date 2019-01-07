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
import android.widget.Toast;

public class busquedaActivity extends AppCompatActivity {

    //creacion de variables tipo Spinner
    Spinner comboCiuidad;
    Spinner comboInstitucion;
    Spinner comboParticipante;

    //Variable para el uso de busqueda
    String buscarCiudad;
    String buscarInstitucion;
    String buscarParticipante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busqueda);

        //Referencias a variables tipo Spinner
        comboCiuidad=(Spinner)findViewById(R.id.ciudad);
        comboInstitucion=(Spinner)findViewById(R.id.institucion);
        comboParticipante=(Spinner)findViewById(R.id.participante);

        //Carga de adapter en los spinner
        ArrayAdapter adapter =ArrayAdapter.createFromResource(this,R.array.spinner_ciudades,
                R.layout.spinner_layout);
        comboCiuidad.setAdapter(adapter);

        ArrayAdapter adapter2 =ArrayAdapter.createFromResource(this,R.array.spinner_defecto_institucion,
                R.layout.spinner_layout);
        comboInstitucion.setAdapter(adapter2);

        ArrayAdapter adapter3 =ArrayAdapter.createFromResource(this,R.array.spinner_defecto_participante,
                R.layout.spinner_layout);
        comboParticipante.setAdapter(adapter3);

        /**
         * Metodos para seleccionar el items escogido de los spinner
         */
        comboCiuidad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(DataBase.consultaCiudad((String) parent.getItemAtPosition(position))==true) {
                    buscarCiudad= (String) parent.getItemAtPosition(position);
                }else{
                    buscarCiudad= (String) parent.getItemAtPosition(position);
                    ArrayAdapter adapter2 =ArrayAdapter.createFromResource(busquedaActivity.this,R.array.spinner_institucion,
                            R.layout.spinner_layout);
                    comboInstitucion.setAdapter(adapter2);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //PARTE BUSCAR INSTITUCION
        comboInstitucion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(DataBase.consultarInstitucion((String) parent.getItemAtPosition(position))==true) {
                    buscarInstitucion= (String) parent.getItemAtPosition(position);
                }else{
                    buscarInstitucion= (String) parent.getItemAtPosition(position);
                    ArrayAdapter adapter3 =ArrayAdapter.createFromResource(busquedaActivity.this,R.array.spinner_participante,
                            R.layout.spinner_layout);
                    comboParticipante.setAdapter(adapter3);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //PARTE BUSCAR PARTICIPANTE
        comboParticipante.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(DataBase.consultarParticipante((String) parent.getItemAtPosition(position))==true) {
                    buscarParticipante= (String) parent.getItemAtPosition(position);
                }else{
                    buscarParticipante= (String) parent.getItemAtPosition(position);

                }
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

    /**
     * Evento que llama a eventoVolverMain
     * @param view
     */
    public void eventoBack(View view) {
        eventoVolverMain();
    }


    /**
     * Evento que valida si es que se selecciono una ciudad/institucion o participante
     * @param view
     */
    public void eventoBuscar(View view) {
        if(DataBase.consultaCiudad(buscarCiudad)){
            Toast toast1 = Toast.makeText(getApplicationContext(),"Seleccione una ciudad correcta", Toast.LENGTH_SHORT);
            toast1.show();
        }else{
            if(DataBase.consultarInstitucion(buscarInstitucion)){
                Toast toast1 = Toast.makeText(getApplicationContext(),"Seleccione una institución correcta", Toast.LENGTH_SHORT);
                toast1.show();
            }else{
                if (DataBase.consultarParticipante(buscarParticipante)){
                    Toast toast1 = Toast.makeText(getApplicationContext(),"Seleccione un participante correcto", Toast.LENGTH_SHORT);
                    toast1.show();
                }
            }
        }
    }

}
