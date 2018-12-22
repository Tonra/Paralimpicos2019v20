package com.example.diego.paralimpicos2019v20;

public class DataBase {



public DataBase(){

}


    public static boolean consultaCiudad(String ciudad){
        if(ciudad.equalsIgnoreCase("Seleccione una ciudad")){
            return false;
        }
        return true;
    }

    public static boolean consultarInstitucion(String institucion){
        if(institucion.equalsIgnoreCase("Selecciona una institución")){
            return false;
        }
        return true;
    }

    public static boolean consultarParticipante(String participante){
        if(participante.equalsIgnoreCase("Selecciona un participante")){
            return false;
        }
        return true;
    }

}
