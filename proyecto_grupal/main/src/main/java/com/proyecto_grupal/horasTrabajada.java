package com.proyecto_grupal;

public class horasTrabajada {
    private int horastrabajadas;
    private int id_usuario;

    public horasTrabajada(int newhorastrabajadas, int newid_usuario){
        this.horastrabajadas = newhorastrabajadas;
        this.id_usuario = newid_usuario;
    }

    public int gethorasTrabajadas(){
        return horastrabajadas;
    }

    public int getid_usuario(){
        return id_usuario;
    }

    public String toString (){
        return this.horastrabajadas + " " + this.id_usuario +" " ;
    }
}
