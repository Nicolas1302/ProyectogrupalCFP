package com.proyecto_grupal;

import java.util.ArrayList;

public class empleadoService {

    empleadoDTO EmpleadoDTO = new empleadoDTO();

    public ArrayList<empleado> getEmpleados(){
        ArrayList<empleado> empleados = EmpleadoDTO.getEmpleado ();
        System.out.println("");
        System.out.println("Se Obtuvo los Datos de  Empleados de la Base de Datos en JSON empleadosBase.json");
        System.out.println("");
        return empleados;
    }
    
    public void validateAndSaveEmpleado(empleado empleado){
        if(empleado.getNombre() == null ){
            System.out.println("ERROR: coloque el Nombre");
        }if(empleado.getApellido() == null ){
            System.out.println("ERROR: coloque el apellido");
        } else {
            EmpleadoDTO.saveEmpleado(empleado.getNombre(), empleado.getApellido(), empleado.getFecha_nacimiento());
            System.out.println("OK");
        }
    }
    
}