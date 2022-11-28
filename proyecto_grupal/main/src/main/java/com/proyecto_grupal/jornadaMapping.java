package com.proyecto_grupal;

public class jornadaMapping {

    public jornada_laboral mapjornada( String diaLaboraBD, int horario_entradaBD, int horario_salidaBD, int id_empleadoBD){
        jornada_laboral jornada = new jornada_laboral(diaLaboraBD, horario_entradaBD, horario_salidaBD,id_empleadoBD);
        return jornada;
    }

    public HorasTrabajadas maphorastrabajadas(  int horasTrabajadasBD, String nombreBD,String apellidoBD){
        if(horasTrabajadasBD > 18){
            horasTrabajadasBD = ((horasTrabajadasBD - 18) * 5000) + (18 * 3000);
            
        }else if(horasTrabajadasBD <= 18){
            horasTrabajadasBD = (horasTrabajadasBD * 3000);    
        }
        HorasTrabajadas Horas = new HorasTrabajadas(horasTrabajadasBD,nombreBD,apellidoBD);
        return Horas;
    }
    
}
