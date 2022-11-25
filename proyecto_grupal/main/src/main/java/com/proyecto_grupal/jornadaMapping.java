package com.proyecto_grupal;

public class jornadaMapping {

    public jornada_laboral mapjornada( String diaLaboraBD, int horario_entradaBD, int horario_salidaBD, int id_empleadoBD){
        jornada_laboral jornada = new jornada_laboral(diaLaboraBD, horario_entradaBD, horario_salidaBD,id_empleadoBD);
        return jornada;
    }
    
}
