package com.proyecto_grupal;

import java.sql.Date;

public class EmpleadoMapping {
    
    public empleado mapEmpleado(String nombreBD, String apellidoBD, Date fechaNacimientoBD){
        empleado empleado = new empleado(nombreBD, apellidoBD, fechaNacimientoBD.toString());
        return empleado;
    }
}
