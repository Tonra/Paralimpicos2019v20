package com.example.diego.paralimpicos2019v20;

import android.app.Activity;
import android.app.Dialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class Main_Activity extends AppCompatActivity implements ZXingScannerView.ResultHandler{

    //Variables para uso de la libreria ZXn
    private ZXingScannerView scanner;
    //Variable tipo int que permite saber si la ya obtiene el scaner
    private int scannDeNuevo=0;
    //Variable tio int que permite saber si la camara esta en uso
    private int btnCam=0;

    //variable para jugar con popup
    Dialog myDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Main_Activity.this,Ayudapopup.class));
                //Snackbar.make(view, "Hola soy un virus, no mentira no hago nada", Snackbar.LENGTH_LONG)
                  //      .setAction("Action", null).show();
            }
        });

        /**
         * Permiso para usar la camada si  la version de android es mayor a la api 22
         */
        if (ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT > 22) {
                if (shouldShowRequestPermissionRationale(android.Manifest.permission.CAMERA))
                    Toast.makeText(getApplicationContext(), "Esta aplicaciÃ³n necesita acceder a la cÃ¡mara para funcionar", Toast.LENGTH_SHORT).show();
                requestPermissions(new String[]{android.Manifest.permission.CAMERA},123);
            }
        }

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel=new NotificationChannel("MyNotifications","MyNotifications",NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService((NotificationManager.class));
            manager.createNotificationChannel(channel);
        }

        FirebaseMessaging.getInstance().subscribeToTopic("general")
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        String msg = "";
                        if (!task.isSuccessful()) {
                            msg = "Error";
                        }
                       // Toast.makeText(Main_Activity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.contactos) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Evento que ingresa a la actividad FAQ para
     * @param item
     */
    public final void EventoFaq(MenuItem item) {
        Intent intent = new Intent(this,FaqActivity.class);
        startActivity(intent);
        finish();
    }


    /**
     * Evento que se encarga de mostrar los contactos disponibles por deporte
     * @param item
     */
    public void eventoContacto(MenuItem item) {
        Intent intent = new Intent (this, ContactoActivity.class);
        startActivity(intent);
        finish();
    }


    /**
     * Metodo que ingresa a la busqueda manual
     * @param view
     */
    public void eventoBusqueda(View view){
        Toast toast1 = Toast.makeText(getApplicationContext(), "bandera 1", Toast.LENGTH_SHORT);
        toast1.setGravity(Gravity.CENTER,0,0);
        toast1.show();

        Intent intent = new Intent(this,busquedaActivity.class);
        startActivity(intent);
        finish();
    }



    /**
     * Metodo que ingresa a la actividad actividades/cronograma general
     * @param view
     */
    public void eventoActividades(View view) {
        // Intent intent = new Intent (this,CalendarioActivity.class);
        Intent intent = new Intent (this,CalendarioActivitytabbed.class);
        startActivity(intent);
        finish();
    }



    /**
     * Evento que genera en enlace a la actividad de charlas
     * @param view
     */
    public void eventoCharla(View view) {
        //Intent intent = new Intent (this,CharlaActivity.class);
        Intent intent = new Intent (this,CharlaActivitytabbed.class);
        startActivity(intent);
        finish();
    }



    /**
     * Metodo que genera enlace a la actividad ranking
     * @param view
     */
    public void eventoRanking(View view) {
        Intent intent = new Intent(this,RankingActivity.class);
        startActivity(intent);
        finish();
    }



    /**
     * Metodo que genera enlace para ver las notificaciones
     * @param view
     */
    public void eventoNotificaciones(View view) {
        Intent intent = new Intent(this,NotificationActivity.class);
        startActivity(intent);
        finish();
    }



    /**
     * Metodo que inicia el main_activity
     */
    public void mainBack(){
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

            if(btnCam==1 ){
                btnCam=0;
                finish();
                mainBack();
            }else{
                AlertDialog ayuda = new AlertDialog.Builder(this).create();
                ayuda.setMessage("¿Desea salir de la aplicación?");
                ayuda.setButton(DialogInterface.BUTTON_POSITIVE,"Si",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        System.exit(0);
                    }
                });

                ayuda.setButton(DialogInterface.BUTTON_NEGATIVE,"No",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                ayuda.show();
            }

        }


        return super.onKeyDown(keyCode,event);
    }


    // INICIO EVENTOS DE CAMARA
    // INICIO EVENTOS DE CAMARA
    // INICIO EVENTOS DE CAMARA

    /**
     * Evento que realiza un scanner para conseguir identificar a participante
     * @param view
     */
    public void eventoQr(View view) {

        scanner= new ZXingScannerView(this);
        setContentView(scanner);
        scanner.setResultHandler(this);
        scanner.startCamera();
        btnCam=1;


    }

    /**
     * Evento que se encarga de capturar el còdigo scaneado
     * @param result
     */
    @Override
    public void handleResult(Result result) {
        Log.v("HandleResult",result.getText());
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(result.getText());
        AlertDialog alertDialog =builder.create();
        //alertDialog.show();
        btnCam=1;
        AlertDialog ayuda = new AlertDialog.Builder(this).create();
        ayuda.setTitle("Código scaneado");
        ayuda.setMessage(result.getText());
        ayuda.setButton(DialogInterface.BUTTON_POSITIVE,"Volver a menu",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                btnCam=0;
                scanner.stopCamera();
                finish();
                mainBack();
            }
        });

        ayuda.setButton(DialogInterface.BUTTON_NEUTRAL,"Buscar participante",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                btnCam=0;
                scanner.stopCamera();
                finish();
                mainBack();
                Toast toast1 = Toast.makeText(getApplicationContext(), "Evento a la espera", Toast.LENGTH_SHORT);
                toast1.show();

            }

        });
        ayuda.setButton(DialogInterface.BUTTON_NEGATIVE,"Buscar nuevo participante",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                btnCam=1;
                scannDeNuevo=1;
                resumeCamara(scanner);
            }

        });


        ayuda.show();
        //Ayuda a cancelar el alert dialog para poder ver la camara y scanear nuevamente
        if (scannDeNuevo==1 ){
            alertDialog.cancel();
            //scanner.resumeCameraPreview(this);
        }
    }


    /**
     * ZXIng puede volver a scanear sin salir de la camara
     * @param scanner
     */
    public void resumeCamara(ZXingScannerView scanner){
        scannDeNuevo=0;
        //btnCam=0;
        scanner.resumeCameraPreview(this);
    }



    //////////////////////////
    @Override
    protected void onResume() {
        super.onResume();
        if(btnCam==1){
            scanner.startCamera();
        }

    }
    @Override
    protected void onPause() {
        super.onPause();

    }
    @Override
    protected void onStop() {
        super.onStop();
    }


}
