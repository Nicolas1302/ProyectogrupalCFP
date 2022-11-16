package com.proyecto_grupal;

public class salario {
    private int sueldoNeto;
    private int sueldoBruto;

    public salario(){
        this.sueldoNeto = 40000;
        this.sueldoBruto = 46000;
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
