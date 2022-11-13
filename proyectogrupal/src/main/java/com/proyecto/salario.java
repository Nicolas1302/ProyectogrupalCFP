package com.proyecto;

public class salario {
    private int sueldoNeto;
    private int sueldoBruto;

    public salario(){
        this.sueldoNeto = 40000;
        this.sueldoBruto = 46000;
    }

    public int getSueldoBruto() {
        return sueldoBruto;
    }
    public int getSueldoNeto() {
        return sueldoNeto;
    }
    public void setSueldoBruto(int sueldoBruto) {
        this.sueldoBruto = sueldoBruto;
    }
    public void setSueldoNeto(int sueldoNeto) {
        this.sueldoNeto = sueldoNeto;
    }    
}
