package com.proyecto_grupal;

import java.util.ArrayList;

public class DemoBD {
    public static void main( String[] args ){

        empleadoDTO empleadoDTO = new empleadoDTO();

        //empleadoDTO.saveEmpleado("nicolas", "ayala", "1992-06-30");

        ArrayList<empleado> empleadoBase = empleadoDTO.getEmpleado();

        

        

        System.out.println(empleadoBase);
        //this.horario_salida =Time.valueOf("23:00:00"); formato agregar hora
    }
} 