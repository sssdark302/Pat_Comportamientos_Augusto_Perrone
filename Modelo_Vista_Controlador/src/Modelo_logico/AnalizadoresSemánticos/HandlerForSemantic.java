package Modelo_Vista_Controlador.src.Modelo_logico.AnalizadoresSemánticos;

import Modelo_Vista_Controlador.src.Modelo_logico.Handler_Abstracto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HandlerForSemantic
        extends Handler_Abstracto {
    @Override
    public void proceso(String codigo) {
        try {
            Pattern pattern = Pattern.compile("for\\s*\\(([^;]+);\\s*([^;]+);\\s*([^)]+)\\)");
            Matcher matcher = pattern.matcher(codigo);
            if (matcher.find()) {
                String inicializacion = matcher.group(1);
                String condicion = matcher.group(2);
                String incremento = matcher.group(3);

                if (!verificarCondicionFor(condicion, incremento)) {
                    throw new PatronExcepcionSemantica("La condición del bucle For podría hacer que no sea infinito.");
                } else {
                    System.out.println("La condición del bucle For es semánticamente correcta para un bucle infinito.");
                }
            } else {
                throw new PatronExcepcionSemantica("No se encuentra una declaración de un bucle for.");
            }
            pasarAlSiguiente(codigo);
        } catch (PatronExcepcionSemantica patronExcepcionSemantica) {
            System.err.println("Error: " + patronExcepcionSemantica.getMessage());
        }
    }

    private boolean verificarCondicionFor(String condicion, String incremento) {
        //para que mantengan el bucle infinito
        Pattern patternCondicion = Pattern.compile("(\\w+)\\s*([<>!=]+)\\s*(\\w+)");
        Matcher matcherCondicion = patternCondicion.matcher(condicion);
        if (matcherCondicion.find()) {
            String variable = matcherCondicion.group(1);
            String operador = matcherCondicion.group(2);
            String valor = matcherCondicion.group(3);
            if (operador.equals("!=")) {
                //para que la variable no se modifique en el incremento
                if (incremento.contains(variable)) {
                    return false;
                }
                return true;
            }
        }
        return condicion.equals("true") && incrementoCorrecto(incremento);
    }

    private boolean incrementoCorrecto(String incremento) {
        //las operaciones en la variable de incremento no interfieran con la continuidad del bucle
        Pattern modifPatron = Pattern.compile("\\w+\\s*=\\s*\\w+\\s*[+-]\\s*\\d+");
        Matcher modifMatcher = modifPatron.matcher(incremento);
        return modifMatcher.find();
    }
}
