package com.proyecto_grupal;

import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class jornadaController {
    public static void main( String[] args ){
        jornadaService jornadaService = new jornadaService();

        JSONParser jsonParser = new JSONParser();
        jornadaBuilder jornadaBuilder = new jornadaBuilder();

        try(FileReader reader = new FileReader("proyecto_grupal/jornada.json")){
            Object obj = jsonParser.parse(reader);
            JSONArray jsonJornada = (JSONArray) obj;
            jornada_laboral jornadalaboral = jornadaBuilder.builderjornada((JSONObject)jsonJornada.get(0));
            System.out.println(jornadalaboral);
            
            
            jornadaService.validateAndSaveEmpleado(jornadalaboral);

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
