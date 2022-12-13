package com.proyecto_grupal;

import java.util.ArrayList;

import javax.security.auth.x500.X500Principal;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Result;

public class jornadaService {

    jornadaDTO JornadaDTO = new jornadaDTO();
    jornadaMapping Sueldo = new jornadaMapping();
    
    public ArrayList<jornada_laboral> getJornada(){
        ArrayList<jornada_laboral> Jornadas = JornadaDTO.getJornada();
        return Jornadas;
    }


    public void validateAndSaveJornada(jornada_laboral jornada){
        if(jornada.getHorario_entrada() < 1669280400 ){  //fecha en Segundos tomada del Dia 2022-11-24
            System.out.println("ERROR: A partir de las 09:00 puede darse Entrada");
            System.out.println("Hora actual:  " + (jornada.getHorario_entrada() - 1669248000)/3600 +" HS");
        }if(jornada.getHorario_salida() > 1669323600){
            System.out.println("ERROR: Excede el horario extra permitido.");
        }else {
            JornadaDTO.savejornada_laboral(jornada.getDiaLaboral(), jornada.getHorario_entrada() , jornada.getHorario_salida(), jornada.getid_empleado()); 
            System.out.println("OK");
        }
    }

    

    public ArrayList<horasTrabajada> gethoras(){
        ArrayList<jornada_laboral> jornadas = JornadaDTO.getJornada();
        ArrayList<horasTrabajada> horasTrabajadas = new ArrayList<horasTrabajada>();
        int horatotal1 = 0;
        int horatotal2 = 0;
        int horatotal3 = 0;
        int horatotal4 = 0;
        int horatotal5 = 0;
        int horatotal6 = 0;
        for(int x = 0 ;x < jornadas.size();x++){
            if(jornadas.get(x).getid_empleado() == 1){
                horatotal1 = horatotal1 + (jornadas.get(x).getHorario_salida() - jornadas.get(x).getHorario_entrada())/3600 ;  
            }
            if(jornadas.get(x).getid_empleado() == 2){
                horatotal2 = horatotal2 + (jornadas.get(x).getHorario_salida() - jornadas.get(x).getHorario_entrada())/3600 ;  
            }
            if(jornadas.get(x).getid_empleado() == 3){
                horatotal3 = horatotal3 + (jornadas.get(x).getHorario_salida() - jornadas.get(x).getHorario_entrada())/3600 ;   
            }
            if(jornadas.get(x).getid_empleado() == 4){
                horatotal4 = horatotal4 + (jornadas.get(x).getHorario_salida() - jornadas.get(x).getHorario_entrada())/3600 ;  
            }
            if(jornadas.get(x).getid_empleado() == 5){
                horatotal5 = horatotal5 + (jornadas.get(x).getHorario_salida() - jornadas.get(x).getHorario_entrada())/3600 ;  
            }
            if(jornadas.get(x).getid_empleado() == 6){
                horatotal6 = horatotal6 + (jornadas.get(x).getHorario_salida() - jornadas.get(x).getHorario_entrada())/3600 ;  
            }
        }
        horasTrabajadas.add(new horasTrabajada(horatotal1,1));
        horasTrabajadas.add(new horasTrabajada(horatotal2,2));
        horasTrabajadas.add(new horasTrabajada(horatotal3,3));
        horasTrabajadas.add(new horasTrabajada(horatotal4,4));
        horasTrabajadas.add(new horasTrabajada(horatotal5,5));
        horasTrabajadas.add(new horasTrabajada(horatotal6,6));
        System.out.println(horasTrabajadas);
        return horasTrabajadas;
    }


    public ArrayList<Sueldos> getSueldo(){

        ArrayList<horasTrabajada> horasTrabajadas = gethoras();
        ArrayList<Sueldos> sueldos = new ArrayList<Sueldos>();
        int sueldoBruto = 0;
        int sueldoNeto = 0;

        for(int x = 0; x < horasTrabajadas.size();x++){
            if(horasTrabajadas.get(x).gethorasTrabajadas() > 160){
                sueldoBruto = ((horasTrabajadas.get(x).gethorasTrabajadas() - 160) * 5000) + (160 * 3000);
                sueldoNeto = sueldoBruto/100*80;
                 
            }else{
                sueldoBruto = horasTrabajadas.get(x).gethorasTrabajadas() * 3000;
                sueldoNeto = sueldoBruto/100*80;
                 
            }
            sueldos.add(new Sueldos(sueldoBruto, sueldoNeto, x+1));
            
        }
        System.out.println(sueldos);
        return sueldos;
    }
        //Hacer array de  las horas y hacer el sueldo
    

    
        
    
}
        
        
        
        


    
    

