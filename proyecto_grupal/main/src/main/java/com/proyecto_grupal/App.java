package com.proyecto_grupal;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){

        jornadaController JornadaController = new jornadaController();
        EmpleadoController EmpleadoController = new EmpleadoController();
        EmpleadoController.postEmpleado();
        // EmpleadoController.postEmpleado();
        //JornadaController.getjornada();
        JornadaController.postJornada();
        // JornadaController.getSueldo();

    }    
}
