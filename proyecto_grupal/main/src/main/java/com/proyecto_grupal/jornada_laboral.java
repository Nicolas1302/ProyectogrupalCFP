package com.proyecto_grupal;

import java.sql.Time;

public class jornada_laboral {

    private String diaLaboral;
    private Time horario_entrada;
    private Time horario_salida;
    private int id_empleado;

    public jornada_laboral(String newDiaLaboral, Time newHorario_entrada, Time newHorario_salida,int newid_empleado){
        this.diaLaboral = newDiaLaboral;
        this.horario_entrada = newHorario_entrada;
        this.horario_salida = newHorario_salida;
        this.id_empleado = newid_empleado;
    }

    public String getDiaLaboral() {
        return this.diaLaboral;
    }

    public Time getHorario_entrada() {
        return this.horario_entrada;
    }

    public Time getHorario_salida() {
        return this.horario_salida;
    }

    public int getid_empleado() {
        return this.id_empleado;
    }

    public void setDiaLaboral(String diaLaboral) {
        this.diaLaboral = diaLaboral;
    }
    public void setHorario_entrada(Time horario_entrada) {
        this.horario_entrada = horario_entrada;
    }
    public void setHorario_salida(Time horario_salida) {
        this.horario_salida = horario_salida;
    }
    public void setHorario_salida(int id_empleado) {
        this.id_empleado = id_empleado;
    }
    
}
