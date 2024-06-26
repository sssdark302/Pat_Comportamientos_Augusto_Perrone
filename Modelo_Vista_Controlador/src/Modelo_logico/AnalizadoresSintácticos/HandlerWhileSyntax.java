package Modelo_Vista_Controlador.src.Modelo_logico.AnalizadoresSintácticos;

import Modelo_Vista_Controlador.src.Modelo_logico.Handler;
import Modelo_Vista_Controlador.src.Modelo_logico.Handler_Abstracto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class HandlerWhileSyntax
        extends Handler_Abstracto {
    private static final Pattern patron = Pattern.compile("while\\s*\\(([^)]+)\\)\\s*\\{([\\s\\S]*?)\\}");


    @Override
    public void proceso(String codigo) {
        try {
            Matcher matcher = patron.matcher(codigo);

            if (matcher.matches()) {
                String condition = matcher.group(1); //representa
                System.out.println("Bucle 'while' encontrado, pasando la condición al análisis léxico: " + condition);
                pasarAlSiguiente(condition); // Pasar la condición al handler léxico para su análisis detallado

            } else {
                System.out.println("Ups, yo no puedo resolver esto...");
            }
        }catch (PatternSyntaxException e) {
            System.err.println("Error en la sintaxis del patrón de expresión regular: " + e.getMessage());
        }
    }
/*
    @Override
    public void proceso(String codigo) {

        try {
            Matcher matcher = patron.matcher(codigo); // compara el patrón con el código

            if (matcher.find()) { // si encuentra el patrón
                System.out.println("Bucle While bien escrito...");
            }

            else {
                System.out.println("Ups, yo no puedo resolver esto...");
                pasarAlSiguiente(codigo);
            }

        }
    }

 */


    @Override
    public void setSiguiente(Handler next) {
        this.siguienteHandler = next;
    }
}
