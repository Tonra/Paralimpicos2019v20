package com.example.diego.paralimpicos2019v20;

public class DataBase {



public DataBase(){

}


    public static boolean consultaCiudad(String ciudad){
        if(ciudad.equalsIgnoreCase("Seleccione una CIUDAD")){
            return true;
        }
        return false;
    }

    public static boolean consultarInstitucion(String institucion){
        if(institucion.equalsIgnoreCase("Seleccione una INSTITUCION")){
            return true;
        }
        return false;
    }

    public static boolean consultarParticipante(String participante){
        if(participante.equalsIgnoreCase("Seleccione un PARTICIPANTE")){
            return true;
        }
        return false;
    }

}
