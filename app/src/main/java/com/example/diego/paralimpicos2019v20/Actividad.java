package com.example.diego.paralimpicos2019v20;

import java.time.LocalDate;
import java.util.List;

public class Actividad {

    private int id;
    private String nombre;
    private String dia;
    private LocalDate horaInicio;
    private int horaAux;
    private int minutoAux;
    private String horarioAux;
    private List<String> participantes;
    private Locacion locacion;

    public Actividad()
    {

    }

    public Actividad(int id, String nombre, String dia, LocalDate horaInicio, Locacion locacion)
    {
        this.id = id;
        this.nombre = nombre;
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.locacion = locacion;
    }

    public Actividad(int id, String nombre, String dia, int horaAux, int minutoAux, Locacion locacion)
    {
        this.id = id;
        this.nombre = nombre;
        this.dia = dia;
        this.horaAux = horaAux;
        this.minutoAux = minutoAux;
        this.locacion = locacion;
        if (horaAux<10){
            if(minutoAux<10){
                this.horarioAux = "0" + horaAux + ":" + "0" + minutoAux;
            }else {
                this.horarioAux = "0" + horaAux + ":" + minutoAux;
            }
        }else{
            if(minutoAux<10){
                this.horarioAux = horaAux + ":" + "0" + minutoAux;
            }else {
                this.horarioAux = horaAux + ":" + minutoAux;
            }
        }

    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDia() { return dia; }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public LocalDate getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalDate horaInicio) {
        this.horaInicio = horaInicio;
    }

    public List<String> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<String> participantes) {
        this.participantes = participantes;
    }

    public Locacion getLocacion() {
        return locacion;
    }

    public void setLocacion(Locacion locacion) {
        this.locacion = locacion;
    }

    public int getHoraAux() {
        return horaAux;
    }

    public void setHoraAux(int horaAux) {
        this.horaAux = horaAux;
    }

    public int getMinutoAux() {
        return minutoAux;
    }

    public void setMinutoAux(int minutoAux) {
        this.minutoAux = minutoAux;
    }

    public String getHorarioAux() {
        return horarioAux;
    }

    public void setHorarioAux(String horarioAux) {
        this.horarioAux = horarioAux;
    }
}
