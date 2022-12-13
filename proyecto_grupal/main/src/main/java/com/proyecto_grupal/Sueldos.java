package com.proyecto_grupal;

public class Sueldos {
    private int SueldoBruto;
    private int SueldoNeto;
    private int id_empleado;

    public Sueldos( int newSueldoBruto , int newSueldoNeto, int newid_empleado){
        this.SueldoBruto = newSueldoBruto;
        this.SueldoNeto = newSueldoNeto;
        this.id_empleado = newid_empleado;
    }

    public int getSueldoBruto(){
        return SueldoBruto;
    }

    public int getSueldoNeto(){
        return SueldoNeto;
    }

    public int getid_empleado(){
        return id_empleado;
    }

    public String toString (){
        return this.SueldoBruto + " " + this.SueldoNeto +" " +this.id_empleado+" ";
    }


}
