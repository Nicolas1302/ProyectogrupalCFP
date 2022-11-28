package com.proyecto_grupal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class jornadaDTO {
    static final String BD_Conexion = "jdbc:mysql://localhost:3306/";
    static final String Usuario_BD = "root1";
    static final String Contrasena_BD = "root1";
    
    
    public void savejornada_laboral(String diaLaboral, int horario_entrada, int horario_salida, int id_empleado){
        
        try(Connection con = DriverManager.getConnection(BD_Conexion, Usuario_BD, Contrasena_BD);
        Statement stmt = con.createStatement()){
            String query = "INSERT INTO proyectogrupal.jornadalaboral (diaLaboral,horario_entrada,horario_salida,id_empleado) VALUES ('" + diaLaboral + "','" + horario_entrada + "','" + horario_salida + "','" + id_empleado + "');";
            stmt.executeUpdate(query);

            System.out.println("Persistio en base de datos.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
    

    public ArrayList<jornada_laboral> getJornada(){
        jornadaMapping jornadaMapping = new jornadaMapping();
        ArrayList<jornada_laboral> jornada = new ArrayList<jornada_laboral>();
        
        try(Connection con = DriverManager.getConnection(BD_Conexion, Usuario_BD, Contrasena_BD);
        Statement stmt = con.createStatement()){
            String query = "select * from proyectogrupal.jornadaLaboral jl;";
            ResultSet result = stmt.executeQuery(query);
            while(result.next()){
                String diaLaboraBD = result.getString("diaLaboral"); 
                int horario_entradaBD = result.getInt("horario_entrada"); 
                int horario_salidaBD = result.getInt("horario_salida"); 
                int id_empleadoBD = result.getInt("id_empleado"); 
                jornada.add(jornadaMapping.mapjornada(diaLaboraBD, horario_entradaBD, horario_salidaBD,id_empleadoBD));
            }
    
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return jornada;
    }


    public ArrayList<HorasTrabajadas> gethorastrabajadas(){
        jornadaMapping jornadaMapping = new jornadaMapping();
        ArrayList<HorasTrabajadas> horastrabajadas = new ArrayList<HorasTrabajadas>();
        
        try(Connection con = DriverManager.getConnection(BD_Conexion, Usuario_BD, Contrasena_BD);
        Statement stmt = con.createStatement()){
            String query = "select (SUM(horario_salida-horario_entrada)/3600) as total_Horas ,empleado.apellido ,empleado.nombre from proyectogrupal.jornadaLaboral, proyectogrupal.empleado where jornadaLaboral.id_empleado = empleado.id_empleado group by empleado.apellido, empleado.nombre;";
            ResultSet result = stmt.executeQuery(query);
            while(result.next()){
                    
                int horasTrabajadasBD = result.getInt("total_Horas"); 
                String apellidoBD = result.getString("apellido");
                String nombreBD = result.getString("nombre"); 
                
                horastrabajadas.add(jornadaMapping.maphorastrabajadas(horasTrabajadasBD,nombreBD,apellidoBD));
                
            }
    
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return horastrabajadas;
    }


    public void horas(String diaLaboral, int horario_entrada, int horario_salida, int id_empleado){
        
        try(Connection con = DriverManager.getConnection(BD_Conexion, Usuario_BD, Contrasena_BD);
        Statement stmt = con.createStatement()){
            String query = "INSERT INTO proyectogrupal.jornadalaboral (diaLaboral,horario_entrada,horario_salida,id_empleado) VALUES ('" + diaLaboral + "','" + horario_entrada + "','" + horario_salida + "','" + id_empleado + "');";
            stmt.executeUpdate(query);

            System.out.println("Persistio en base de datos.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

            /*select (SUM(horario_salida-horario_entrada)/3600) as total_Horas ,empleado.apellido ,empleado.nombre from jornadaLaboral, empleado  
            where jornadaLaboral.id_empleado = empleado.id_empleado 
            group by empleado.apellido, empleado.nombre*/
}
