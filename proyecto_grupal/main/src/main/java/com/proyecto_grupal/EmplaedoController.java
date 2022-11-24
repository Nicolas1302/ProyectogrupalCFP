package com.proyecto_grupal;

//import java.io.FileWriter;
//import java.io.IOException;

//import javax.tools.JavaFileObject;

import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

//import com.mysql.cj.xdevapi.JsonArray;

public class EmplaedoController {
    public static void main( String[] args ){

        /*JavaFileObject empleado = new JSONObject();

        JsonArray empleadosList = new JsonArray();

        empleadosList.add(empleado);
        
        try(FileWriter file = new FileWriter("empleados.json")){
            file.write(empleadosList.toJSONString());
            file.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
        

        JSONObject empleados = new JSONObject();

        JSONArray empleadosList = new JSONArray();

        empleadosList.add(empleados);

        try(FileWriter file = new FileWriter("empleados.json")){
            file.write(empleadosList.toJSONString());
            file.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
        */
        empleadoService empleadoService = new empleadoService();

        JSONParser jsonParser = new JSONParser();
        empleadoBuilder empleadoBuilder = new empleadoBuilder();

        try(FileReader reader = new FileReader("proyecto_grupal/empleados.json")){
            Object obj = jsonParser.parse(reader);
            JSONArray jsonEmpleados = (JSONArray) obj;
            //for(int x = 1 ; x < jsonEmpleados.size();x++){
            empleado empleado = empleadoBuilder.builderEmpleado((JSONObject)jsonEmpleados.get(0));
            System.out.println(empleado);
            //}
            
            empleadoService.validateAndSaveEmpleado(empleado);

        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
}

