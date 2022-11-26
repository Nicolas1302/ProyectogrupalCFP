package com.proyecto_grupal;

import org.json.simple.JSONObject;

public class empleadoBuilder {
    
    public empleado builderEmpleado(JSONObject object, String x){
        
        JSONObject empleado = (JSONObject) object.get(x);
        String nombre = (String) empleado.get("nombre");
        String apellido = (String) empleado.get("apellido");
        String fecha_nacimiento = (String) empleado.get("fecha_nacimiento");

        empleado resultEmpleado = new empleado(nombre, apellido, fecha_nacimiento);
        return resultEmpleado;
        
    }
           
        
        
}
    

