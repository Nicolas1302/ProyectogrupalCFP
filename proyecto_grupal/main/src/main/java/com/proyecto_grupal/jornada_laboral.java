package com.proyecto_grupal;

public class jornada_laboral {

    private String diaLaboral;
    private int horario_entrada;
    private int horario_salida;

    public jornada_laboral(String newDiaLaboral, int newHorario_entrada, int newHorario_salida){
        this.diaLaboral = newDiaLaboral;
        this.horario_entrada = newHorario_entrada;
        this.horario_salida = newHorario_salida;
    }

    public String getDiaLaboral() {
        return this.diaLaboral;
    }

    public int getHorario_entrada() {
        return this.horario_entrada;
    }

    public int getHorario_salida() {
        return this.horario_salida;
    }

    public void setDiaLaboral(String diaLaboral) {
        this.diaLaboral = diaLaboral;
    }
    public void setHorario_entrada(int horario_entrada) {
        this.horario_entrada = horario_entrada;
    }
    public void setHorario_salida(int horario_salida) {
        this.horario_salida = horario_salida;
    }
    
}
