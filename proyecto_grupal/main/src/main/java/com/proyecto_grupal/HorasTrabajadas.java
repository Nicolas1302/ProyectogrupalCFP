package com.proyecto_grupal;

public class HorasTrabajadas {
    private int total_horas;
    private String apellido;
    private String nombre;

    public HorasTrabajadas( int newtotal_horas , String newapellido, String newnombre){
        this.total_horas = newtotal_horas;
        this.apellido = newapellido;
        this.nombre = newnombre;
    }

    public int gettotal_horas(){
        return total_horas;
    }

    public String getapellido(){
        return apellido;
    }

    public String getnombre(){
        return nombre;
    }

    public String toString(){
        return this.total_horas + " " + this.apellido +" " +this.nombre+" ";
    }


}
