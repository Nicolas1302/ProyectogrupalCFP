package com.proyecto_grupal;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class jornadaController {
       
    jornadaService jornadaService = new jornadaService();
    
    
    public void getjornada(){
        ArrayList<jornada_laboral> JornadaBase = jornadaService.getJornada();
        JSONObject sueldoss = new JSONObject();
        int x = 0;
        while(x < JornadaBase.size() ){ 
            JSONObject jornada = new JSONObject();           
            jornada.put("diaLaboral", JornadaBase.get(x).getDiaLaboral());
            jornada.put("horario_entrada", JornadaBase.get(x).getHorario_entrada());
            jornada.put("horario_salida",JornadaBase.get(x).getHorario_salida());
            jornada.put("id_empleado",JornadaBase.get(x).getid_empleado());           
            sueldoss.put(x,jornada);          
            x++;
        }
        JSONArray JornadaList = new JSONArray();
        JornadaList.add(sueldoss);
        try(FileWriter file = new FileWriter("JornadasBase.json")){
            file.write(JornadaList.toJSONString());
            file.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    
    
    public void postJornada(){
        JSONParser jsonParser = new JSONParser();
        jornadaBuilder jornadaBuilder = new jornadaBuilder();

        try(FileReader reader = new FileReader("proyecto_grupal/jornada.json")){
            Object obj = jsonParser.parse(reader);
            JSONArray jsonJornada = (JSONArray) obj;
            jornada_laboral jornadalaboral = jornadaBuilder.builderjornada((JSONObject)jsonJornada.get(0));
            System.out.println(jornadalaboral);
            jornadaService.validateAndSaveJornada(jornadalaboral);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void getSueldos(){
        ArrayList<Sueldos> SueldoBase = jornadaService.getSueldo();
        JSONObject sueldoss = new JSONObject();
        int x = 0;
        while(x < SueldoBase.size() ){ 
            JSONObject sueldo = new JSONObject();           
            sueldo.put("SueldoBruto", SueldoBase.get(x).getSueldoBruto());
            sueldo.put("SueldoNeto", SueldoBase.get(x).getSueldoNeto());
            sueldo.put("id_empleado",SueldoBase.get(x).getid_empleado());           
            sueldoss.put(x,sueldo);          
            x++;
        }
        JSONArray SueldoList = new JSONArray();
        SueldoList.add(sueldoss);
        try(FileWriter file = new FileWriter("SueldoBase.json")){
            file.write(SueldoList.toJSONString());
            file.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }



    

    

    
}
