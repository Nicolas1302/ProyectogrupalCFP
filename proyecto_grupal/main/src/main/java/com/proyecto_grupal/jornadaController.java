package com.proyecto_grupal;

import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class jornadaController {
    
    public static void main( String[] args ){
        jornadaService jornadaService = new jornadaService();
        ArrayList<jornada_laboral> jornadaBase = jornadaService.getJornada();

        int x = 0;
        while(x < jornadaBase.size() - 1){ 
            JSONObject Jornada = new JSONObject();
            Jornada.put("diaLaboral", jornadaBase.get(x).getDiaLaboral());
            Jornada.put("horario_entrada", jornadaBase.get(x).getHorario_entrada());
            Jornada.put("horario_salida",jornadaBase.get(x).getHorario_salida());
            Jornada.put("id_empleado",jornadaBase.get(x).getid_empleado());
            Jornada.put(x,Jornada);
            x++;
        }
        JSONParser jsonParser = new JSONParser();
        jornadaBuilder jornadaBuilder = new jornadaBuilder();

        try(FileReader reader = new FileReader("./proyecto_grupal/jornada.json")){
            ArrayList<jornada_laboral> jornadas = new ArrayList<jornada_laboral>();
            Object obj = jsonParser.parse(reader);
            JSONArray jsonJornadas = (JSONArray) obj;
            for (x = 0; x < jsonJornadas.size(); x++){
                jornada_laboral jornada1 = jornadaBuilder.builderJornada((JSONObject)jsonJornadas.get(x),"" + x);
                System.out.println(jornada1);
                System.out.println(x);
                jornadas.add(jornada1);
                }
    
                int indice = 0;
            while(indice < jornadas.size()){
            jornadaService.validateAndsavejornada_laboral(jornadas.get(indice));
            indice++;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}