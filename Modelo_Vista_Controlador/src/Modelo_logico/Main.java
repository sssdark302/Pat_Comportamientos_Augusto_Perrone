package Modelo_Vista_Controlador.src.Modelo_logico;

import Modelo_Vista_Controlador.src.Modelo_logico.AnalizadoresSintácticos.HandlerFinalDeSentenciasSyntax;

public class Main {
    public static void main(String[] args) {

        CountDown cuentaAtras = new CountDown();
        cuentaAtras.cuentaParaAtras();

        CountUp cuentaArriba = new CountUp();
        cuentaArriba.contadorHaciaArriba();

        HandlerFinalDeSentenciasSyntax handlerFinalDeSentenciasSyntax = new HandlerFinalDeSentenciasSyntax();
        handlerFinalDeSentenciasSyntax.proceso(cuentaAtras.toString());




    }
}
