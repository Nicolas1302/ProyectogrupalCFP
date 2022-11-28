package com.proyecto_grupal;



public class jornada_laboral {

    private String diaLaboral;
    private int horario_entrada;
    private int horario_salida;
    private int id_empleado;

    public jornada_laboral(String newdiaLaboral, int newHorario_entrada, int newHorario_salida,int newid_empleado) {
        this.diaLaboral = newdiaLaboral;
        this.horario_entrada = newHorario_entrada;
        this.horario_salida = newHorario_salida;
        this.id_empleado = newid_empleado;
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

    public int getid_empleado() {
        return this.id_empleado;
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
    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }
    public String toString(){
        return this.diaLaboral + " " + this.horario_entrada +" " +this.horario_salida +" "+this.id_empleado +" ";
    }


    
}
