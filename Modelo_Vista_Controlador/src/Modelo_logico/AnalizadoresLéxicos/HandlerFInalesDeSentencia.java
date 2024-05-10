package Modelo_Vista_Controlador.src.Modelo_logico.AnalizadoresLéxicos;

import Modelo_Vista_Controlador.src.Modelo_logico.Handler_Abstracto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HandlerFInalesDeSentencia
        extends Handler_Abstracto {

        /*
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


         */
    private static final Pattern pattern = Pattern.compile("[;{}]");

    @Override
    public void proceso(String codigo) {
       try{
        Matcher matcher = pattern.matcher(codigo);

        while (matcher.find()) {

            switch (matcher.group()) {

                case ";":
                    System.out.println("Fin de sentencia detectado: ';'");
                    break;

                case "{":
                    System.out.println("Inicio de bloque detectado: '{'");
                    break;

                case "}":
                    System.out.println("Fin de bloque detectado: '}'");
                    break;
            }
        }if (!matcher.find()){
            throw new PatronExcepcionLexica("No se encuentran tokens válidos");
           }
        // Pasa el código al siguiente handler en la cadena de responsabilidad.
        pasarAlSiguiente(codigo);
    } catch (PatronExcepcionLexica patronExcepcionLexica){
        System.err.println("Error: " + patronExcepcionLexica.getMessage());
    }
    }
}
