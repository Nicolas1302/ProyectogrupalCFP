package com.proyecto_grupal;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ){

        jornadaController JornadaController = new jornadaController();
        EmpleadoController EmpleadoController = new EmpleadoController();

        EmpleadoController.getEmpleado();//trae los Empleados de la Base de Datos en JSON empleadosBase.json
        EmpleadoController.postEmpleado();//toma los Datos de Empleado.json y lo carga a la Base de Datos
        JornadaController.getjornada();//Trae los datos de Jornada laboral de la Base De Datos en JSON jornadaBase.json
        JornadaController.postJornada();//toma los Datos de jornada.json y lo carga a la Base de Datos en la tabla JornadaLaboral
        JornadaController.getSueldos();//Trae los Calculos de los SueldosBruto y Neto dependiendo de los Horarios de Entrada y Salida en JSON SueldoBase.json
    }
}
