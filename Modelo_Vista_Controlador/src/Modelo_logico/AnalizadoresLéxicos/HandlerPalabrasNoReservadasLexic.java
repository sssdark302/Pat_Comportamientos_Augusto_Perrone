package Modelo_Vista_Controlador.src.Modelo_logico.AnalizadoresLéxicos;

import Modelo_Vista_Controlador.src.Modelo_logico.Handler_Abstracto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HandlerPalabrasNoReservadasLexic
        extends Handler_Abstracto {
    private final static Pattern patron = Pattern.compile("\\b[a-zA-Z_][a-zA-Z0-9_]*\\b");
    @Override
    public void proceso(String codigo) {
        try{
            Matcher matcher = patron.matcher(codigo);
            boolean encontrado = false; //para incorporar el while siguiente:

            while(matcher.find()){
                encontrado = true;
                System.out.println("Token válido "+ matcher.group());
            }
            if (!encontrado){
                throw new PatronExcepcionLexica("No hay tokens válidos");
            }
            pasarAlSiguiente(codigo);
        }catch (PatronExcepcionLexica patronExcepcionLexica){
            System.err.println("Error: " + patronExcepcionLexica.getMessage());
        }
    }
}
