package Modelo_Vista_Controlador.src.Modelo_logico.AnalizadoresSemánticos;

import Modelo_Vista_Controlador.src.Modelo_logico.Handler_Abstracto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HandlerWhileSemantic
        extends Handler_Abstracto {

    @Override
    public void proceso(String codigo) {
        try {
            Pattern pattern = Pattern.compile("while\\(([^)]+)\\)"); //busca la regex para los while
            Matcher matcher = pattern.matcher(codigo); //compara
            if (matcher.find()) {
                String condicionalWhile = matcher.group(1); // extrae la condición del bucle while
                boolean condicionValida = verificarCondicionWhile(condicionalWhile); //llamada al metodo

                if (condicionValida) {
                    System.out.println("La condicion del bucle While es semanticamente correcta.");
                } else {
                    throw new PatronExcepcionSemantica("La condicion del bucle While no es semanticamente correcta.");
                }
            } else {
                throw new PatronExcepcionSemantica("No se encuentra una declaración de un bucle while.");
            }
            pasarAlSiguiente(codigo);
        } catch (PatronExcepcionSemantica ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }

    private boolean verificarCondicionWhile(String condicion) {
        try{
            Pattern patternCondicion = Pattern.compile("(\\w+)\\s*([<>!=]+)\\s*0");
            Matcher matcherCondicion = patternCondicion.matcher(condicion);

            if (matcherCondicion.find()) {
                String variable = matcherCondicion.group(1);
                String operador = matcherCondicion.group(2);

                //como queremos saber que sea posible que el while llegue a 0, solo vamos a mirar ese caso.
                if (operador.equals("!=")) {
                    // que mire modificaciones en el cuerpo del bucle
                    Pattern modifPatron = Pattern.compile(variable + "\\s*=\\s*" + variable + "\\s*[-+]\\s*\\d+");
                    Matcher modifMatcher = modifPatron.matcher(condicion);
                    while (modifMatcher.find()) {
                        String modificacion = modifMatcher.group();
                        // verificar si incrementa o decrementa
                        if (modificacion.contains("-")) {
                            System.out.println("Condicion valida, puede llegar a 0 el bucle..."); // decrementa, puede llegar a cero
                            return true;
                        }else {
                            throw new PatronExcepcionSemantica("El bucle no va a llegar a 0 porque la condicion es inválida.");
                        }
                    }
                    throw new PatronExcepcionSemantica("No se ha encontrado una ");
                } else {
                    System.out.println("La operacion no es adecuada para garantizar llegar a 0");
                    return false;
                }
            }
        }catch (PatronExcepcionSemantica patronExcepcionSemantica){
            System.err.println("Error: " + patronExcepcionSemantica.getMessage());
        }
        return false;
    }

}
