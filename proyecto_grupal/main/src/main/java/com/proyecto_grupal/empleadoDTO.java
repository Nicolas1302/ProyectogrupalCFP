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

        public void saveEmpleado(String nombre, String apellido,String fecha_nacimiento, Integer id_sueldo){

            try(Connection con = DriverManager.getConnection(BD_Conexion, Usuario_BD, Contrasena_BD);
            Statement stmt = con.createStatement()){
                String query = "INSERT INTO proyectogrupal.empleado (nombre,apellido,fecha_nacimiento,id_sueldo) VALUES ('" + nombre + "','" + apellido + "','" + fecha_nacimiento + "','" + id_sueldo + "');";
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
        
            try(Connection con = DriverManager.getConnection(BD_Conexion, Usuario_BD, Contrasena_BD);
            Statement stmt = con.createStatement()){
                String query = "select * from proyectogrupal.empleado e;";//nombre de base es proyectogrupal tabla empleado
                ResultSet result = stmt.executeQuery(query);
                while(result.next()){ //Con el While le damos un Formato en java con los resultados que nos trae de la tabla
                    String nombreBD = result.getString("nombre"); //formato nombre
                    String apellidoBD = result.getString("apellido"); //formato apellido
                    String fechaNacimientoBD = result.getString("fecha_nacimiento"); //formato fecha_fabricacion
                    empleados.add(empleadoMapping.mapAuto(nombreBD, apellidoBD, fechaNacimientoBD));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return empleados;
        }
            //VOID PARA DESPUES LLAMARLO EN DEMODB
    public void saveValorHora(int valorHora, int valorHoraExtra){
        try(Connection con = DriverManager.getConnection(BD_Conexion, Usuario_BD, Contrasena_BD);
        Statement stmt = con.createStatement()){
            String query = "INSERT INTO proyectogrupal.valor_hora (valorHora,valorHoraExtra) VALUES ('" + valorHora + "','" + valorHoraExtra + "');";
            stmt.executeUpdate(query); 

            System.out.println("Persistio en base de datos.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //VOID PARA DESPUES LLAMARLO EN DEMODB
    public void getValorHora(){

        try(Connection con = DriverManager.getConnection(BD_Conexion, Usuario_BD, Contrasena_BD);
        Statement stmt = con.createStatement()){
            String query = "select * from proyectogrupal.valor_hora e;";
            ResultSet result = stmt.executeQuery(query);
            while(result.next()){ 
                int id_hora = result.getInt("id_hora");
                int valorHora = result.getInt("valorHora"); 
                int valorHoraExtra = result.getInt("valorHoraExtra"); 
                System.out.println("Valor Hora: " + valorHora + 
                " Valor Hora Extra : " + valorHoraExtra +
                " id_hora: " + id_hora);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
