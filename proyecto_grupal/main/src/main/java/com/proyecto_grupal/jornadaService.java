package com.proyecto_grupal;

public class jornadaService {

    empleadoDTO JornadaDTO = new empleadoDTO();

    public void validateAndSaveEmpleado(jornada_laboral jornada){
        if(jornada.getHorario_entrada() < 1669280400 ){
            System.out.println("ERROR: A partir de la 09:00 puede darce Entrada");
            System.out.println("hora actual es:  " + (jornada.getHorario_entrada() - 1669248000)/3600 +" HS");
        }else if(jornada.getHorario_salida() > 1669323600){
            System.out.println("ERROR: Exede el horario extra permitido.");
        }else {
            JornadaDTO.savejornada_laboral(jornada.getDiaLaboral(), jornada.getHorario_entrada() , jornada.getHorario_salida(), jornada.getid_empleado()); 
            System.out.println("OK");
        }
    }

    /*public void validateAndSaveJornada(jornada_laboral jornada){
        if(jornada.getHorario_salida() > 1669150800){
            System.out.println("ERROR: Exede el horario extra permitido.");
        } else {
            JornadaDTO.savejornada_laboral(jornada.getDiaLaboral(), jornada.getHorario_entrada() , jornada.getHorario_salida(), jornada.getid_empleado()); 
            System.out.println("OK");
        }
    } */
    
}
