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
        ArrayList<jornada_laboral> SueldoBrutoBase = jornadaService.getJornada();
        JSONObject jornadass = new JSONObject();
        int x = 0;
        while(x < SueldoBrutoBase.size() ){ 
            JSONObject jornada = new JSONObject();           
            jornada.put("diaLaboral", SueldoBrutoBase.get(x).getDiaLaboral());
            jornada.put("horario_entrada", SueldoBrutoBase.get(x).getHorario_entrada());
            jornada.put("horario_salida",SueldoBrutoBase.get(x).getHorario_salida());
            jornada.put("id_empleado",SueldoBrutoBase.get(x).getid_empleado());           
            jornadass.put(x,jornada);          
            x++;
        }
        JSONArray SueldoBrutoList = new JSONArray();
        SueldoBrutoList.add(jornadass);
        try(FileWriter file = new FileWriter("JornadasBase.json")){
            file.write(SueldoBrutoList.toJSONString());
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



    

    public void getSueldo(){
        ArrayList<HorasTrabajadas> SueldoBrutoBase = jornadaService.gethorastrabajadas();
        JSONObject Sueldoss = new JSONObject();
        int x = 0;
        while(x < SueldoBrutoBase.size() ){ 
            JSONObject Sueldo = new JSONObject();           
            Sueldo.put("Sueldo Bruto", SueldoBrutoBase.get(x).gettotal_horas());
            Sueldo.put("Apellido", SueldoBrutoBase.get(x).getapellido());
            Sueldo.put("nombre",SueldoBrutoBase.get(x).getnombre());                      
            Sueldoss.put(x,Sueldo);            
            x++;
        }
        JSONArray SueldoBrutoList = new JSONArray();
        SueldoBrutoList.add(Sueldoss);

        try(FileWriter file = new FileWriter("SueldoBrutoBase.json")){
            file.write(SueldoBrutoList.toJSONString());
            file.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    
}
