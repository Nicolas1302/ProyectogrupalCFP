package com.proyecto_grupal;

public class DemoBD {
    public static void main( String[] args ){

        empleadoDTO Empleado = new empleadoDTO();

        Empleado.getValorHora();
        Empleado.saveValorHora(3000,5000);
        Empleado.saveSueldo(10000,150000);
        Empleado.getSueldo();
        Empleado.saveEmpleado("Juan", "Domínguez", "1992-02-05", 2);
        Empleado.getEmpleado();
    }
} 