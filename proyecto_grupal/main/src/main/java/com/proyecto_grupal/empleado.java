package com.proyecto_grupal;

import java.sql.Date;

public class empleado {
    private String nombre;
    private String apellido;
    private String fecha_nacimiento;

    public empleado(String newNombre, String newApellido, String newfecha_nacimiento){
        this.nombre = newNombre;
        this.apellido = newApellido;
        this.fecha_nacimiento = newfecha_nacimiento ;
    }
    
    

    public String getNombre() {
        return this.nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public String getFecha_nacimiento() {
        return this.fecha_nacimiento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String toString(){
        return this.nombre + " " + this.apellido +" " +this.fecha_nacimiento+" ";
    }
}
