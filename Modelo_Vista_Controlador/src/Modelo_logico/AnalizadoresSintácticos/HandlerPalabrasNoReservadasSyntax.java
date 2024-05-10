package Modelo_Vista_Controlador.src.Modelo_logico.AnalizadoresSintácticos;

import Modelo_Vista_Controlador.src.Modelo_logico.Handler_Abstracto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class HandlerPalabrasNoReservadasSyntax
        extends Handler_Abstracto {

    private final static Pattern patron = Pattern.compile("\\b(?!(public|void|int)\\b)\\w+\\b\n"); //para cualquier palabra que no sea las reservadas en los bucles menos el while y el for, que tienen sus propios handlers


    @Override
    public void proceso(String codigo) {

        try {
            Matcher matcher = patron.matcher(codigo);

            if (matcher.find()){
                System.out.println("Aqui hay palabras reservadas...");
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
