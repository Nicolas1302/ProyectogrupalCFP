package com.proyecto_grupal;

public class horarioLaboral {

    private String diaLaboral;
    private String horario_entrada;
    private String horario_salida;

    public horarioLaboral(){
        this.diaLaboral = "L a V";
        this.horario_entrada = "08:00:00";
        this.horario_salida = "17:00:00";
    }

    public String getDiaLaboral() {
        return this.diaLaboral;
    }

    public String getHorario_entrada() {
        return this.horario_entrada;
    }

    public String getHorario_salida() {
        return this.horario_salida;
    }

    public void setDiaLaboral(String diaLaboral) {
        this.diaLaboral = diaLaboral;
    }
    public void setHorario_entrada(String horario_entrada) {
        this.horario_entrada = horario_entrada;
    }
    public void setHorario_salida(String horario_salida) {
        this.horario_salida = horario_salida;
    }
    
}
