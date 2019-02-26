package com.example.diego.paralimpicos2019v20;

import android.content.Intent;
import android.content.res.Resources;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CalendarioActivitytabbed extends AppCompatActivity {

    //creacion de variables tipo Spinner
    private Spinner comboLocacion;

    //Creacion de variable tipo RecyclerView
    private RecyclerView rv;

    //Variable para el uso de busqueda
    private List<Actividad> actividades = new ArrayList<>();
    private List<Actividad> actividadesDia = new ArrayList<>();


    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario_activitytabbed);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        //Se crean las actividades
        this.crearActividades();

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
                //Se obtienen las actividades dependiendo del dia
                //Se declaran los días
                String [] dias = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"};
                actividadesDia = getActividadesDia(dias[tab.getPosition()]);
                //Mostrar las actividades del día
                RecyclerView rv = (RecyclerView) findViewById(R.id.rv);
                LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
                rv.setLayoutManager(llm);
                rv.setHasFixedSize(true);
                RVAdapter adapter = new RVAdapter(actividadesDia);
                rv.setAdapter(adapter);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calendario_activitytabbed, menu);
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

        return super.onOptionsItemSelected(item);
    }

    // Metodo que retorna las actvidades dado el día
    public List<Actividad> getActividadesDia(String dia)
    {
        //Crea lista retorno
        List<Actividad> l = new ArrayList<>();
        //Se recorren las actividades
        for(int i = 0; i < this.actividades.size(); i++)
        {
            if(this.actividades.get(i).getDia().equals(dia))
            {
                Actividad a = this.actividades.get(i);
                l.add(a);
            }
        }
        //Se retorna la lista
        return l;
    }

    // Metodo que retorna la lista de locaciones
    public List<Locacion> getLocaciones()
    {
        //Se obtiene la lista de lugares.
        Resources res = getResources();
        String [] locacionAux = res.getStringArray(R.array.spinner_locacion);
        List<Locacion> locaciones = new ArrayList<>();
        for(int i = 0; i < locacionAux.length; i++)
        {
            Locacion l = new Locacion(i, locacionAux[i]);
            locaciones.add(l);
        }

        return locaciones;
    }

    //Metodo que crea las actividades
    public void crearActividades()
    {
        //Se obtienen las locaciones
        List<Locacion> locaciones = this.getLocaciones();
        //El día y horas se trabajaran como String
        String [] dias = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"};

        for(int i = 0; i < 30; i++)
        {
            //Se inicia auxiliar random
            Random r = new Random();
            //Obtener locacion aleatoria.
            Locacion l = locaciones.get(r.nextInt(locaciones.size()));
            //Obtener dia aleatorio.
            String d = dias[r.nextInt(dias.length)];
            //Obtener hora y minuto aleatorio
            int h = r.nextInt(24);
            int m = r.nextInt(60);
            //Nombre de la actividad
            int correlativo = i + 1;
            String nombreA = "Actividad " + correlativo;
            //Crear actividad
            Actividad a = new Actividad(i, nombreA, d, h, m, l);
            this.actividades.add(a);
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_calendario_activitytabbed, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));


            RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.rv);
            LinearLayoutManager llm = new LinearLayoutManager(this.getActivity());
            rv.setLayoutManager(llm);

            Spinner locacion = (Spinner) rootView.findViewById(R.id.cbLocacion);
            ArrayAdapter adapter =ArrayAdapter.createFromResource(this.getActivity(), R.array.spinner_locacion,
                    R.layout.spinner_layout);

            locacion.setAdapter(adapter);

            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 6;
        }
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
