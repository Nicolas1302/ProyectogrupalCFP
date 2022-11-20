package com.proyecto_grupal;

public class salario {
    private int sueldoNeto;
    private int sueldoBruto;

    public salario(int newSueldoNeto, int newSueldoBruto){
        this.sueldoNeto = newSueldoNeto;
        this.sueldoBruto = newSueldoBruto;
    }

    public int getSueldoBruto() {
        return this.sueldoBruto;
    }
    public int getSueldoNeto() {
        return this.sueldoNeto;
    }
    public void setSueldoBruto(int sueldoBruto) {
        this.sueldoBruto = sueldoBruto;
    }
    public void setSueldoNeto(int sueldoNeto) {
        this.sueldoNeto = sueldoNeto;
    }    
}
