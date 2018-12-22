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
        ArrayAdapter<CharSequence> adapter =ArrayAdapter.createFromResource(this,R.array.spinner_ciudades,
                R.layout.spinner_layout);
        comboCiuidad.setAdapter(adapter);

        ArrayAdapter<CharSequence> adapter2 =ArrayAdapter.createFromResource(this,R.array.spinner_institucion,
                R.layout.spinner_layout);
        comboInstitucion.setAdapter(adapter2);

        ArrayAdapter<CharSequence> adapter3 =ArrayAdapter.createFromResource(this,R.array.spinner_participante,
                R.layout.spinner_layout);
        comboParticipante.setAdapter(adapter3);

        /**
         * Metodos para seleccionar el items escogido de los spinner
         */
        comboCiuidad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if(DataBase.consultaCiudad(comboCiuidad.getSelectedItem().toString())==true){
                            buscarCiudad=comboCiuidad.getSelectedItem().toString();
                    }else{
                        buscarCiudad=comboCiuidad.getSelectedItem().toString();
                    }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                buscarCiudad=comboCiuidad.getSelectedItem().toString();
            }
        });

        //PARTE BUSCAR INSTITUCION
        comboInstitucion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(DataBase.consultarInstitucion(comboInstitucion.getSelectedItem().toString())==true){
                    buscarInstitucion=comboInstitucion.getSelectedItem().toString();
                }else{
                    buscarInstitucion=comboCiuidad.getSelectedItem().toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                buscarInstitucion=comboCiuidad.getSelectedItem().toString();
            }
        });

        //PARTE BUSCAR PARTICIPANTE
        comboParticipante.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(DataBase.consultarParticipante(comboParticipante.getSelectedItem().toString())==true){
                    buscarParticipante=comboParticipante.getSelectedItem().toString();
                }else{
                    buscarParticipante=comboParticipante.getSelectedItem().toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                buscarParticipante=comboParticipante.getSelectedItem().toString();
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

    public void eventoBuscar(View view) {
        if(DataBase.consultaCiudad(buscarCiudad)==false){
            Toast toast1 = Toast.makeText(getApplicationContext(),"Ingrese una ciudad valida", Toast.LENGTH_SHORT);
            toast1.show();
        }else{
            if (DataBase.consultarInstitucion(buscarInstitucion)==false){
                Toast toast2 = Toast.makeText(getApplicationContext(),"Ingrese una institución valida", Toast.LENGTH_SHORT);
                toast2.show();
            }
        }
    }

}
