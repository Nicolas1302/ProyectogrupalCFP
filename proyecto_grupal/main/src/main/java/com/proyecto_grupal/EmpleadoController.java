package com.proyecto_grupal;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
public class EmpleadoController {

    public void getEmpleado(){
        empleadoService empleadoService = new empleadoService();
        ArrayList<empleado> empleadoBase = empleadoService.getEmpleados();

        JSONObject empleadoss = new JSONObject();

        /*PARA CREAR EMPLEADOS VARIOS DENTRO DEL JSON CON EL GET */
        // ArrayList<empleado> empleados = new ArrayList<empleado>();

        // empleados.add(new empleado("Juan", "Perez", "1999-05-12"));
        // empleados.add(new empleado("Elian", "Zas", "1998-08-19"));
        // empleados.add(new empleado("Nicolas", "Ayala", "1996-08-19"));


        // int x = 0;
        // for(x=0;x<= empleados.size()-1;x++){ 
        //         JSONObject Empleado = new JSONObject();
                
        //         Empleado.put("nombre", empleados.get(x).getNombre());
        //         Empleado.put("apellido", empleados.get(x).getApellido());
        //         Empleado.put("fecha_nacimiento", empleados.get(x).getFecha_nacimiento());

        //         empleadoss.put(x,Empleado);
        //         System.out.println();
        //     }       

        int x = 0;
        while(x < empleadoBase.size() - 1){ 

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
        empleadoService empleadoService = new empleadoService();
        ArrayList<empleado> empleadoBase = empleadoService.getEmpleados();
        JSONParser jsonParser = new JSONParser();
        empleadoBuilder empleadoBuilder = new empleadoBuilder();

        try(FileReader reader = new FileReader("proyecto_grupal/empleados.json")){
            Object obj = jsonParser.parse(reader);
            JSONArray jsonEmpleados = (JSONArray) obj;
            empleado empleado1 = empleadoBuilder.builderEmpleado((JSONObject)jsonEmpleados.get(0));
            System.out.println(empleado1);
            empleadoService.validateAndSaveEmpleado(empleado1);
        } catch (Exception e){
            e.printStackTrace();
        }
    } 
}