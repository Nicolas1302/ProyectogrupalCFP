package com.proyecto_grupal;

public class jornadaService {

    empleadoDTO JornadaDTO = new empleadoDTO();

    public void validateAndSaveEmpleado(jornada_laboral jornada){
        if(jornada.getHorario_entrada() < 1669278600 ){
            System.out.println("ERROR: A partir de la 08:30 puede darce Entrada");
            System.out.println("hora actual es:  " + (jornada.getHorario_entrada() - 1669248000)/3600 +" HS");
        } else {
            JornadaDTO.savejornada_laboral(jornada.getDiaLaboral(), jornada.getHorario_entrada() , jornada.getHorario_salida(), jornada.getid_empleado()); 
            System.out.println("OK");
        }
    }
    
}
