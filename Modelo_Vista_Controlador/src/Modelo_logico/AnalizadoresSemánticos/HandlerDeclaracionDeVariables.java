package Modelo_Vista_Controlador.src.Modelo_logico.AnalizadoresSemánticos;

import Modelo_Vista_Controlador.src.Modelo_logico.Handler_Abstracto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HandlerDeclaracionDeVariables
        extends Handler_Abstracto {
    @Override
    public void proceso(String codigo) {
        try {
            Pattern pattern = Pattern.compile("\\b(int|String)\\s+([a-zA-Z_][a-zA-Z0-9_]*)\\s*(=\\s*[^;]+)?;"); //regex para la declaracion
            Matcher matcher = pattern.matcher(codigo); //comapara
            boolean encontrado = false;

            while (matcher.find()) {
                encontrado = true;
                String tipo = matcher.group(1); //en la regex, es el tipo de variable que se puede elegir (int o string)
                String asignacion = matcher.group(3); //este es el grupo que va entre el "=" y el ";"

                if (asignacion != null && !esAsignacionValida(tipo, asignacion.trim().substring(1).trim())) { //solo trimea los espacios en blancos
                    throw new PatronExcepcionSemantica("La declaracion de la variable '" + matcher.group(2) + "' no es semanticamente correcta.");
                }

                System.out.println("Declaracion de variable '" + matcher.group(2) + "' detectada y es semanticamente correcta.");
            }
            
            if (!encontrado) {
                throw new PatronExcepcionSemantica("No se encuentra una declaracion de variable.");
            }
        } catch (PatronExcepcionSemantica ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }
    private boolean esAsignacionValida(String tipo, String valor) {
        switch (tipo) {
            case "int":
                return valor.matches("-?\\d+");
            case "String": //para el bucle for (a menos q sea foreach) y while String no hace falta
                return valor.startsWith("\"") && valor.endsWith("\"");
            default:
                return false;
        }
    }
}
