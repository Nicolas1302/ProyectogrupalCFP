package com.proyecto_grupal;

import org.json.simple.JSONObject;

public class jornadaBuilder {
    
    public jornada_laboral builderjornada(JSONObject object1){
        
        JSONObject jornada_laboral = (JSONObject) object1.get("6");
        String dialaboral = (String) jornada_laboral.get("dialaboral");
        Long horario_entrada = (Long) jornada_laboral.get("horario_entrada");
        Long horario_salida = (Long) jornada_laboral.get("horario_salida");
        Long id_empleado = (Long) jornada_laboral.get("id_empleado");

        jornada_laboral resultjornada = new jornada_laboral(dialaboral, horario_entrada.intValue() , horario_salida.intValue(),id_empleado.intValue());
        return resultjornada;
    }   
}
