package com.proyecto_grupal;

public class valor_hora {
    private int valorHora;
    private int valorHoraExtra;

    public valor_hora(int newValorHora, int newValorHoraExtra){
        this.valorHora = newValorHora;
        this.valorHoraExtra = newValorHoraExtra;
    }

    public int getvalorHora(){
        return this.valorHora;
    }

    public int getvalorHoraExtra(){
        return this.valorHoraExtra;
    }
}