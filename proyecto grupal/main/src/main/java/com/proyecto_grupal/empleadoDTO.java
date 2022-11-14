package com.proyecto_grupal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class empleadoDTO {
    static final String BD_Conexion = "jdbc:mysql://localhost:3306/";
    static final String Usuario_BD = "root1";
    static final String Contrasena_BD = "root1";
    
    //VOID PARA DESPUES LLAMARLO EN DEMOBD
    public void saveEmpleado(String nombre, String apellido,String fecha_nacimiento, int id_sueldo){

        try(Connection con = DriverManager.getConnection(BD_Conexion, Usuario_BD, Contrasena_BD);
        Statement stmt = con.createStatement()){
            String query = "INSERT INTO proyectogrupal.empleado (nombre,apellido,fecha_nacimiento,id_sueldo) VALUES ('" + nombre + "','" + apellido + "','" + fecha_nacimiento + "','" + id_sueldo + "');";
            stmt.executeUpdate(query); //crear base de Datos con nombre:proyectogrupal
    
            System.out.println("Persistio en base de datos.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

        //VOID PARA DESPUES LLAMARLO EN DEMODB
        public void getEmpleado(){
            //llamamos a la tabla autos de la base de datos en el DBEAVER(poo.autos)
            try(Connection con = DriverManager.getConnection(BD_Conexion, Usuario_BD, Contrasena_BD);
            Statement stmt = con.createStatement()){
                String query = "select * from proyectogrupal.empleado e;";//nombre de base es proyectogrupal tabla empleado
                ResultSet result = stmt.executeQuery(query);
                while(result.next()){ //Con el While le damos un Formato en java con los resultados que nos trae de la tabla
                    String nombreBD = result.getString("nombre"); //formato nombre
                    String apellidoBD = result.getString("apellido"); //formato apellido
                    Date fechaNacimientoBD = result.getDate("fecha_nacimiento"); //formato fecha_fabricacion
                    int id_sueldoBD = result.getInt("id_sueldo");
                    System.out.println("puertas: " + nombreBD + //imprimimos los Formatos
                    " marca: " + apellidoBD +
                    " fechaFabricacion: " + fechaNacimientoBD +
                    " id_sueldo: " + id_sueldoBD);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
}
