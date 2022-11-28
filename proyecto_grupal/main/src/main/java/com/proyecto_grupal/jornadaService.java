package com.proyecto_grupal;

import java.util.ArrayList;

public class jornadaService {

    jornadaDTO JornadaDTO = new jornadaDTO();

    public ArrayList<jornada_laboral> getJornada(){
        ArrayList<jornada_laboral> Jornadas = JornadaDTO.getJornada();
        return Jornadas;
    }

    

    public ArrayList<HorasTrabajadas> gethorastrabajadas(){
        ArrayList<HorasTrabajadas> horas = JornadaDTO.gethorastrabajadas();
        return horas;
    }

    public void horasExtras(HorasTrabajadas hora){
        int horaextra = 0;
        if(hora.gettotal_horas()>18){
            horaextra = ((hora.gettotal_horas() - 18) * 5000) + (18 * 3000);
            
        }
        
        
    }



    public void validateAndSaveEmpleado(jornada_laboral jornada){
        if(jornada.getHorario_entrada() < 1669280400 ){  //fecha en Segundos tomada del Dia 2022-11-24
            System.out.println("ERROR: A partir de la 09:00 puede darce Entrada");
            System.out.println("hora actual es:  " + (jornada.getHorario_entrada() - 1669248000)/3600 +" HS");
        }if(jornada.getHorario_salida() > 1669323600){
            System.out.println("ERROR: Exede el horario extra permitido.");
        }else {
            JornadaDTO.savejornada_laboral(jornada.getDiaLaboral(), jornada.getHorario_entrada() , jornada.getHorario_salida(), jornada.getid_empleado()); 
            System.out.println("OK");
        }
    }

    
    
}
