package com.proyecto_grupal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class jornadaDTO {
    static final String BD_Conexion = "jdbc:mysql://localhost:3306/";
    static final String Usuario_BD = "root1";
    static final String Contrasena_BD = "root1";

    public void saveJornada(String diaLaboral, Date horario_entrada, Date horario_salida, int id_empleado){

        try(Connection con = DriverManager.getConnection(BD_Conexion, Usuario_BD, Contrasena_BD);
        Statement stmt = con.createStatement()){
            String query = "INSERT INTO proyectogrupal.jornadalaboral (diaLaboral,horario_entrada,horario_salida,id_empleado) VALUES ('" + diaLaboral + "','" + horario_entrada + "','" + horario_salida + "','" + id_empleado + "');";
            stmt.executeUpdate(query); //crear base de Datos con nombre:proyectogrupal

            System.out.println("Persistio en base de datos.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public ArrayList<jornadaDTO> getArrayList(){
            jornadaMapping JornadaMapping = new jornadaMapping();
            ArrayList<jornadaDTO> jornada = new ArrayList<jornadaDTO>();
            
                try(Connection con = DriverManager.getConnection(BD_Conexion, Usuario_BD, Contrasena_BD);
                Statement stmt = con.createStatement()){
                    String query = "select * from proyectogrupal.jornadalaboral e;";
                    ResultSet result = stmt.executeQuery(query);
                    while(result.next()){ 

                        String diaLaboraBD = result.getString("Día"); 
                        java.sql.Time horario_entradaBD = result.getTime("Horario de entrada");
                        java.sql.Time horario_salidaBD = result.getTime("Horario de salida");
                        int id_empleadoBD = result.getInt("0");
                         
                        jornada.add(JornadaMapping.mapjornada(diaLaboraBD, horario_entradaBD, horario_salidaBD,id_empleadoBD));
                            
                    }
        
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return jornada;
            }
        }
    
}
