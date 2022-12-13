package com.proyecto_grupal;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class EmpleadoController {

    empleadoService empleadoService = new empleadoService();

    public void getEmpleado(){ 
        ArrayList<empleado> empleadoBase = empleadoService.getEmpleados();
        JSONObject empleadoss = new JSONObject();

        int x = 0;
        while(x < empleadoBase.size()){ 
            JSONObject Empleado = new JSONObject();         
            Empleado.put("nombre", empleadoBase.get(x).getNombre());
            Empleado.put("apellido", empleadoBase.get(x).getApellido());
            Empleado.put("fecha_nacimiento",empleadoBase.get(x).getFecha_nacimiento());
            
            empleadoss.put(x,Empleado);
            System.out.println();
            x++;
        }

        JSONArray EmpleadosList = new JSONArray();

        EmpleadosList.add(empleadoss);

        try(FileWriter file = new FileWriter("EmpleadosBase.json")){
            file.write(EmpleadosList.toJSONString());
            file.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void postEmpleado(){
        
        JSONParser jsonParser = new JSONParser();
        empleadoBuilder empleadoBuilder = new empleadoBuilder();

        try(FileReader reader = new FileReader("proyecto_grupal/empleados.json")){
            Object obj = jsonParser.parse(reader);
            JSONArray jsonEmpleados = (JSONArray) obj;
            empleado empleado1 = empleadoBuilder.builderEmpleado((JSONObject)jsonEmpleados.get(0));
            System.out.println(empleado1);
            empleadoService.validateAndSaveEmpleado(empleado1);
        }catch(Exception e){
            e.printStackTrace();
        }    
    }
}