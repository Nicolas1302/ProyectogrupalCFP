package com.proyecto_grupal;

import java.sql.Time;
import java.util.Map;


public class DemoBD {
    public static void main( String[] args ){

        empleadoDTO empleadoDTO = new empleadoDTO();
        
        
        /*LIAN
        jornadalaboral.add(new jornadalaboral(lunes, 9:00:00, 18:00:00, 6));
        jornadalaboral.add(new jornadalaboral(martes, 10:00:00, 18:00:00, 6));
        jornadalaboral.add(new jornadalaboral(miercoles, 9:00:00, 16:00:00, 6));
        jornadalaboral.add(new jornadalaboral(jueves, 9:00:00, 18:00:00, 6));
        jornadalaboral.add(new jornadalaboral(viernes, 9:00:00, 18:00:00, 6)); 
        POLY
        "Paula", "Dominguez", "22/05/1984"
        JornadaLaboral.add(new jornada_laboral("Lunes",09:00:00,21:00:00));
        JornadaLaboral.add(new jornada_laboral("Martes",09:00:00,21:00:00));   
        JornadaLaboral.add(new jornada_laboral("Miercoles",09:00:00,18:00:00));
        JornadaLaboral.add(new jornada_laboral("Jueves",09:00:00,21:00:00));
        JornadaLaboral.add(new jornada_laboral("Viernes",09:00:00,21:00:00));
        ariel
        empleados.add(new empleado("Ariel", "Cook", "13/05/1997"));
        JornadaLaboral.add(new jornada_laboral("Lunes", 09:00:00, 18:00:00));
        JornadaLaboral.add(new jornada_laboral("Martes", 09:00:00, 20:00:00));
        JornadaLaboral.add(new jornada_laboral("Miercoles", 09:00:00, 21:00:00));
        JornadaLaboral.add(new jornada_laboral("Jueves", 09:00:00, 18:00:00));
        JornadaLaboral.add(new jornada_laboral("Viernes", 09:00:00, 19:00:00));
        OSCAR 
        empleados.add(new empleado("Oscar", "Esquivel", "24/05/1990"));
        JornadaLaboral.add(new jornada_laboral("Lunes", 09:00:00, 20:00:00));
        JornadaLaboral.add(new jornada_laboral("Martes", 09:00:00, 21:00:00));
        JornadaLaboral.add(new jornada_laboral("Miercoles", 09:00:00, 20:00:00));
        JornadaLaboral.add(new jornada_laboral("Jueves", 09:00:00, 18:00:00));
        JornadaLaboral.add(new jornada_laboral("Viernes", 09:00:00, 18:00:00));
        ALEX
        empleados.add(new empleado("Alex", "Stephan", "07/12/1993"));
        JornadaLaboral.add(new jornada_laboral("Lunes", 09:00:00, 18:00:00));
        JornadaLaboral.add(new jornada_laboral("Martes", 09:00:00, 18:00:00));
        JornadaLaboral.add(new jornada_laboral("Miercoles", 09:00:00, 18:00:00));
        JornadaLaboral.add(new jornada_laboral("Jueves", 09:00:00, 20:00:00));
        JornadaLaboral.add(new jornada_laboral("Viernes", 09:00:00, 20:00:00));
        
        AGREGO LOS eMPLEADOS A LA bASE DE DATOS
        empleadoDTO.saveEmpleado("nicolas", "ayala","1992-06-30");
        empleadoDTO.saveEmpleado("Elian", "Zás", "1995-09-19");
        empleadoDTO.saveEmpleado("Paula", "Dominguez", "1984-05-22");
        empleadoDTO.saveEmpleado("Ariel", "Cook", "1997-05-13");
        empleadoDTO.saveEmpleado("Oscar", "Esquivel", "1990-05-24");
        empleadoDTO.saveEmpleado("Alex", "Stephan", "1993-12-07");
        */

        empleadoDTO.savejornada_laboral("lunes", Time.valueOf("9:00:00"), Time.valueOf("20:00:00"), 1);
        empleadoDTO.savejornada_laboral("lunes", Time.valueOf("9:00:00"), Time.valueOf("18:00:00"), 2);
        empleadoDTO.savejornada_laboral("lunes", Time.valueOf("09:00:00"), Time.valueOf("21:00:00"), 3);
        empleadoDTO.savejornada_laboral("lunes", Time.valueOf("9:00:00"), Time.valueOf("18:00:00"), 4);
        empleadoDTO.savejornada_laboral("lunes", Time.valueOf("9:00:00"), Time.valueOf("18:00:00"), 5);
        empleadoDTO.savejornada_laboral("lunes", Time.valueOf("9:00:00"), Time.valueOf("18:00:00"), 6);
        



        //LO MAPEO Y LE DOY FORMA PARA USARLO EN JAVA
        Map<Integer,empleado> empleadoBase = empleadoDTO.getEmpleado();
        
        for(int x = 1;x < empleadoBase.size() + 1;x++){
            System.out.println(empleadoBase.get(x).toString());
        }
        

        

        
        //this.horario_salida =Time.valueOf("23:00:00"); formato agregar hora
    }
} 