package com.proyecto_grupal;

public class EmpleadoMapping {
    
    public empleado mapAuto(String nombreBD, String apellidoBD, String fechaNacimientoBD){
        empleado empleado = new empleado(nombreBD, apellidoBD, fechaNacimientoBD);
        return empleado;
    }
}
