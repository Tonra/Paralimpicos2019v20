package com.example.diego.paralimpicos2019v20;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import Service.NotiListAdapter;
import Service.Notification;
import Service.Ranking;

public class RankingActivity extends AppCompatActivity {

    TextView primerLuga;
    TextView segundoLuga;
    TextView tercerLuga;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        //--------------
        primerLuga = (TextView)findViewById(R.id.institucionPrimerLugar);
        segundoLuga= (TextView)findViewById(R.id.institucionSegundoLugar);
        tercerLuga= (TextView)findViewById(R.id.institucionTercerLugar);
        final DatabaseReference mRootReference;
        mRootReference = FirebaseDatabase.getInstance().getReference();
        mRootReference.child("Ranking").addValueEventListener(new ValueEventListener() {
            String a="";
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (final DataSnapshot snapshot:dataSnapshot.getChildren()){
                    mRootReference.child("Ranking").child(snapshot.getKey()).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            Ranking ran= snapshot.getValue(Ranking.class);
                            Log.e("Datos",""+snapshot.getValue());
                            String pLugar=ran.getPrimerLugar();
                            String sLugar=ran.getSegundoLugar();
                            String tLugar=ran.getTercerLugar();

                            primerLuga.setText(pLugar);
                            segundoLuga.setText(sLugar);
                            tercerLuga.setText(tLugar);
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

        //-------------
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

