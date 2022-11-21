package com.proyecto_grupal;

import java.util.ArrayList;

public class DemoBD {
    public static void main( String[] args ){

        empleadoDTO empleadoDTO = new empleadoDTO();
        ArrayList<empleado> empleadoBase = empleadoDTO.getEmpleado();

        System.out.println(empleadoBase);
    }
} 