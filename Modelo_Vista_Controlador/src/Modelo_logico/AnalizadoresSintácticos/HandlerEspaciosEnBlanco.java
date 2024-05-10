package Modelo_Vista_Controlador.src.Modelo_logico.AnalizadoresSintácticos;

import Modelo_Vista_Controlador.src.Modelo_logico.Handler_Abstracto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class HandlerEspaciosEnBlanco
            extends Handler_Abstracto {
    private final static Pattern patron = Pattern.compile(" ");


    @Override
    public void proceso(String codigo) {

        try {
            Matcher matcher = patron.matcher(codigo);

            if (matcher.find()){
                System.out.println("Se han encontrado espacios...");
            }

            else {
                System.out.println("Ups, yo no puedo resolver esto...");
                pasarAlSiguiente(codigo);
            }

        }catch (PatternSyntaxException e){
            System.err.println("Error en la sintaxis del patrón de expresión regular:"  + e.getMessage());
        }

    }
}
