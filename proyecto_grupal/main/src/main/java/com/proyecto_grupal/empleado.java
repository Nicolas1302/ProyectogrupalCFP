package com.proyecto_grupal;



public class empleado {
    private String nombre;
    private String apellido;
    private String fecha_nacimiento;

    public empleado(){
        this.nombre = "Thiago";
        this.apellido = "Moreno";
        this.fecha_nacimiento = "1984-04-14";
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
    
}
