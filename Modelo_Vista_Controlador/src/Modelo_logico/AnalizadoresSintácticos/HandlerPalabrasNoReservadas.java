package Modelo_Vista_Controlador.src.Modelo_logico.AnalizadoresSintácticos;

import Modelo_Vista_Controlador.src.Modelo_logico.Handler_Abstracto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HandlerPalabrasNoReservadas
        extends Handler_Abstracto {

    private final static Pattern patron = Pattern.compile("\\b(?!(public|void|int|while|for)\\b)\\w+\\b\n"); //para cualquier palabra que no sea las reservadas en los bucles


    @Override
    public void proceso(String codigo) {

        try {
            Matcher matcher = patron.matcher(codigo);

            if (matcher.find()){
                System.out.println("Aqui hay palabras reservadas...");
            }
        }
    }
}
