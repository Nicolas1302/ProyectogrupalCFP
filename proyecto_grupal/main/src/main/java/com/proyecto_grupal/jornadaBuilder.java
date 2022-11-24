package com.proyecto_grupal;

import org.json.simple.JSONObject;

public class jornadaBuilder {
    
    public jornada_laboral builderEmpleado(JSONObject object){
        
        JSONObject jornada = (JSONObject) object.get("5");
        String dialaboralString = (String) jornada_laboral.get("dialaboral");
        Integer horario_entrada = (Integer) jornada_laboral.get("horario_entrada");
        Integer horario_salida = (Integer) jornada_laboral.get("horario_salida");
        Integer id_empleado = (Integer) jornada_laboral.get("id_empleado");

        jornada_laboral resultjornada = new jornada_laboral(dialaboral, horario_entrada, horario_salida,id_empleado);
        return resultjornada;
    }   
}
