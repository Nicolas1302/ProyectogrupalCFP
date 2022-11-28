package com.proyecto_grupal;

import java.util.ArrayList;

public class jornadaService {

    jornadaDTO JornadaDTO = new jornadaDTO();

    public ArrayList<jornada_laboral> getJornada(){
        ArrayList<jornada_laboral> jornadas = JornadaDTO.getJornada();
        return jornadas;
    }

    public void validateAndsavejornada_laboral(jornada_laboral jornada){
        if(jornada.getHorario_entrada() < 1669280400 ){
            System.out.println("ERROR: A partir de las 09:00 puede darse Entrada");
            System.out.println("Hora actual:  " + (jornada.getHorario_entrada() - 1669248000)/3600 +" HS");
        }if(jornada.getHorario_salida() > 1669323600){
            System.out.println("ERROR: Excede el horario extra permitido.");
        }else {
            JornadaDTO.savejornada_laboral(jornada.getDiaLaboral(), jornada.getHorario_entrada() , jornada.getHorario_salida(), jornada.getid_empleado()); 
            System.out.println("OK");
        }
    }
}
