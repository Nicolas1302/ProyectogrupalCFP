package com.proyecto_grupal;



import java.io.FileReader;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;



public class EmpleadoController {
    public static void main( String[] args ){

       
        empleadoService empleadoService = new empleadoService();

        JSONParser jsonParser = new JSONParser();
        empleadoBuilder empleadoBuilder = new empleadoBuilder();

        try(FileReader reader = new FileReader("empleados.json")){
            Object obj = jsonParser.parse(reader);
            JSONArray jsonEmpleados = (JSONArray) obj;
            empleado empleado = empleadoBuilder.builderEmpleado((JSONObject)jsonEmpleados.get(0));
            System.out.println(empleado);
            
            
            empleadoService.validateAndSaveEmpleado(empleado);

        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
}

