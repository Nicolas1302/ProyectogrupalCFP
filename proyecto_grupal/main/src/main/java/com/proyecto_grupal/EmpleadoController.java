package com.proyecto_grupal;

import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
public class EmpleadoController {
    public static void main( String[] args ){
        
        empleadoService empleadoService = new empleadoService();
        ArrayList<empleado> empleadoBase = empleadoService.getEmpleados();

        int x = 0;
        while(x < empleadoBase.size() - 1){ 
            JSONObject Empleado = new JSONObject();
            Empleado.put("Nombre", empleadoBase.get(x).getNombre());
            Empleado.put("Apellido", empleadoBase.get(x).getApellido());
            Empleado.put("FechaNacimiento",empleadoBase.get(x).getFecha_nacimiento());
            Empleado.put(x,Empleado);
            x++;
        }

        JSONParser jsonParser = new JSONParser();
        empleadoBuilder empleadoBuilder = new empleadoBuilder();

        try(FileReader reader = new FileReader("empleados.json")){
            ArrayList<empleado> empleados = new ArrayList<empleado>();
            Object obj = jsonParser.parse(reader);
            JSONArray jsonEmpleados = (JSONArray) obj;
            for (x = 0; x < jsonEmpleados.size(); x++){
                empleado empleado1 = empleadoBuilder.builderEmpleado((JSONObject)jsonEmpleados.get(x),"" + x);
                System.out.println(empleado1);
                System.out.println(x);
                empleados.add(empleado1);
                }
    
                int indice = 0;
            while(indice < empleados.size()){
            empleadoService.validateAndSaveEmpleado(empleados.get(indice));
            indice++;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}