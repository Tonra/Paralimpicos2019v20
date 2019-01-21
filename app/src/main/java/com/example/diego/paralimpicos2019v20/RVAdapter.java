package com.example.diego.paralimpicos2019v20;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ActividadViewHolder> {

    public static class ActividadViewHolder extends RecyclerView.ViewHolder {

        public CardView cv;
        public TextView nombre;
        public TextView horario;


        ActividadViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.rv);
            //cva = CardViewActividades
            nombre = (TextView) itemView.findViewById(R.id.rvANombre);
            horario = (TextView) itemView.findViewById(R.id.rvAHorario);
        }
    }

    List<Actividad> actividades;

    RVAdapter(List<Actividad> actividades){
        this.actividades = actividades;
    }

    @Override
    public int getItemCount() {
        return actividades.size();
    }

    @Override
    public ActividadViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.calendario_cv_layout, viewGroup, false);
        ActividadViewHolder avh = new ActividadViewHolder(v);
        return avh;
    }

    @Override
    public void onBindViewHolder(ActividadViewHolder actividadViewHolder, int i) {
        actividadViewHolder.nombre.setText(actividades.get(i).getNombre());
        actividadViewHolder.horario.setText(actividades.get(i).getHorarioAux());
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


}
