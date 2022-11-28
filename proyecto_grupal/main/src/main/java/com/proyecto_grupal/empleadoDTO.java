package com.proyecto_grupal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class empleadoDTO {
    static final String BD_Conexion = "jdbc:mysql://localhost:3306/";
    static final String Usuario_BD = "root";
    static final String Contrasena_BD = "root";

        public void saveEmpleado(String nombre, String apellido,String fecha_nacimiento){

            try(Connection con = DriverManager.getConnection(BD_Conexion, Usuario_BD, Contrasena_BD);
            Statement stmt = con.createStatement()){
                String query = "INSERT INTO proyectogrupal.empleado (nombre,apellido,fecha_nacimiento) VALUES ('" + nombre + "','" + apellido + "','" + fecha_nacimiento + "');";
                stmt.executeUpdate(query); //crear base de Datos con nombre:proyectogrupal

                System.out.println("Persistio en base de datos.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        /*Creamos un Arraylist que obtendrá los empleados que creemos en DemoEmpleado*/
        public ArrayList<empleado> getEmpleado(){
        EmpleadoMapping empleadoMapping = new EmpleadoMapping();
        ArrayList<empleado> empleados = new ArrayList<empleado>();
        //Map<Integer,empleado> empleadosMap = new HashMap<Integer,empleado>();
        
            try(Connection con = DriverManager.getConnection(BD_Conexion, Usuario_BD, Contrasena_BD);
            Statement stmt = con.createStatement()){
                String query = "select * from proyectogrupal.empleado e;";//nombre de base es proyectogrupal tabla empleado
                ResultSet result = stmt.executeQuery(query);
                while(result.next()){ //Con el While le damos un Formato en java con los resultados que nos trae de la tabla
                    //int id_empleado = result.getInt("id_empleado");
                    String nombreBD = result.getString("nombre"); //formato nombre
                    String apellidoBD = result.getString("apellido"); //formato apellido
                    java.sql.Date fechaNacimientoBD = result.getDate("fecha_nacimiento"); //formato fecha_fabricacion
                    empleados.add(empleadoMapping.mapEmpleado(nombreBD, apellidoBD, fechaNacimientoBD));
                    //empleadosMap.put(id_empleado,empleadoMapping.mapEmpleado(nombreBD, apellidoBD, fechaNacimientoBD));    
                }
                //System.out.println(empleadosMap.get(1) );
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return empleados;
        }

}
