package Modelo_Vista_Controlador.src.Modelo_logico.AnalizadoresSintácticos;

import Modelo_Vista_Controlador.src.Modelo_logico.Handler_Abstracto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class HandlerPalabrasReservadasSyntax
        extends Handler_Abstracto {

    private static final Pattern patron = Pattern.compile("\\b(?:if|else|while|for|return|System\\.out\\.(println|print))\\b"); //este codigo regex solo lee las palabras reservadas que se encuentran en los bucles que se nos dieron
    @Override
    public void proceso(String codigo) {

        try{
            Matcher matcher = patron.matcher(codigo);

            if (matcher.find()){
                System.out.println("Las palabras reservadas están bien escritas...");
            }

            else {
                System.out.println("Ups, yo no puedo resolver esto...");
                pasarAlSiguiente(codigo);
            }

        }catch (PatternSyntaxException e){
            System.err.println("Error en la sintaxis del patrón de expresión regular: " + e.getMessage());
        }

    }
}
