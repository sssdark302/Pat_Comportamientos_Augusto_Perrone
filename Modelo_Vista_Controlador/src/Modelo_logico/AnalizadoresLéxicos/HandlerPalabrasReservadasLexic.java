package Modelo_Vista_Controlador.src.Modelo_logico.AnalizadoresLéxicos;

import Modelo_Vista_Controlador.src.Modelo_logico.Handler_Abstracto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HandlerPalabrasReservadasLexic
        extends Handler_Abstracto {
    private static final Pattern patron = Pattern.compile("\\b(?:if|else|while|for|return|System\\.out\\.(println|print))\\b");

    @Override
    public void proceso(String codigo) {
        try{
            Matcher matcher = patron.matcher(codigo);
            boolean encontrado = false; //para incorporar el while siguiente:

            while(matcher.find()){
                encontrado = true;
                System.out.println("Token válido "+ matcher.group());
            }
            if (encontrado){
                throw new PatronExcepcionLexica("No hay tokens válidos");
            }
            pasarAlSiguiente(codigo);
        }catch (PatronExcepcionLexica patronExcepcionLexica){
            System.err.println("Error: " + patronExcepcionLexica.getMessage());
        }
    }
}
