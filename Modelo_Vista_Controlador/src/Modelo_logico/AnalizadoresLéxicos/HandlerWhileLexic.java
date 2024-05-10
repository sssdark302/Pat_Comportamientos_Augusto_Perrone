package Modelo_Vista_Controlador.src.Modelo_logico.AnalizadoresLéxicos;

import Modelo_Vista_Controlador.src.Modelo_logico.Handler_Abstracto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HandlerWhileLexic
        extends Handler_Abstracto {

    private static final Pattern patron = Pattern.compile("\\b\\d+\\b|\\b[a-zA-Z_][a-zA-Z0-9_]*\\b|\\b[+\\-*/()]=?\\b");


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
                System.out.println("No hay tokens válidos");
            }
            pasarAlSiguiente(codigo);
        }catch ()
    }
}
