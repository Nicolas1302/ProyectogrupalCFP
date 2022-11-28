package com.proyecto_grupal;

import org.json.simple.JSONObject;

public class jornadaBuilder {
    
    public jornada_laboral builderJornada(JSONObject object, String x){

        JSONObject jornada_laboral = (JSONObject) object.get(x);
        String diaLaboral = (String) jornada_laboral.get("diaLaboral");
        Integer horario_entrada = (Integer) jornada_laboral.get("horario_entrada");
        Integer horario_salida = (Integer) jornada_laboral.get("horario_salida");
        Integer id_empleado = (Integer) jornada_laboral.get("id_empleado");

        jornada_laboral resultjornada = new jornada_laboral(diaLaboral, horario_entrada.intValue() , horario_salida.intValue(),id_empleado.intValue());
        return resultjornada;
    }   
}
