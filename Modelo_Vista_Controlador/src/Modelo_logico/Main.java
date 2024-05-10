package Modelo_Vista_Controlador.src.Modelo_logico;

import Modelo_Vista_Controlador.src.Modelo_logico.AnalizadoresLéxicos.HandlerPalabrasNoReservadas;
import Modelo_Vista_Controlador.src.Modelo_logico.AnalizadoresSintácticos.*;

public class Main {
    public static void main(String[] args) {

        CountDown cuentaAtras = new CountDown();
        cuentaAtras.cuentaParaAtras();

        CountUp cuentaArriba = new CountUp();
        cuentaArriba.contadorHaciaArriba();

        HandlerEspaciosEnBlancoSyntax handlerEspacios = new HandlerEspaciosEnBlancoSyntax();
        HandlerFinalDeSentenciasSyntax handlerFinal = new HandlerFinalDeSentenciasSyntax();
        HandlerForSyntax handlerFor = new HandlerForSyntax();
        HandlerPalabrasNoReservadas handlerPalabras = new HandlerPalabrasNoReservadas();
        HandlerPalabrasReservadasSyntax handlerPalabrasReservadas = new HandlerPalabrasReservadasSyntax();
        HandlerWhileSyntax handlerWhile = new HandlerWhileSyntax();
        System.out.println("-------------------------------------------------");

        handlerEspacios.setSiguiente(handlerFinal);
        handlerFinal.setSiguiente(handlerFor);
        handlerFor.setSiguiente(handlerPalabras);
        handlerPalabras.setSiguiente(handlerPalabrasReservadas);
        handlerPalabrasReservadas.setSiguiente(handlerWhile);

        System.out.println("-------------------------------------------------");

        handlerEspacios.proceso(cuentaAtras.toString());


    }
}
