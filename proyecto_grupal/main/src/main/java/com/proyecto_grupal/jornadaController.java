package com.proyecto_grupal;

public class jornadaController {
    public static void main( String[] args ){
        empladoService empleadoService = new empladoService();

        JSONParser jsonParser = new JSONParser();
        jornadaBuilder jornadaBuilder = new jornadaBuilder();

        try(FileReader reader = new FileReader("proyecto_grupal/jornada.json")){
            Object obj = jsonParser.parse(reader);
            JSONArray jsonEmpleados = (JSONArray) obj;
            jornada_laboral empleado = jornadaBuilder.builderjornada((JSONObject)jsonEmpleados.get(0));
            System.out.println(jornada_laboral);
            
            
            empleadoService.validateAndSaveEmpleado(jornada_laboral);

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
