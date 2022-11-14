package com.proyecto_grupal;

public class DemoBD {
    public static void main( String[] args ){
        
        empleadoDTO Empleado = new empleadoDTO();

        Empleado.saveEmpleado("adrian","ferre","2022-04-12",1);
        Empleado.getEmpleado();
    }
}
