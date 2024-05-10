package Modelo_Vista_Controlador.src.Modelo_logico;

import Modelo_Vista_Controlador.src.Modelo_logico.AnalizadoresSemánticos.*;
import Modelo_Vista_Controlador.src.Modelo_logico.AnalizadoresSintácticos.*;
import Modelo_Vista_Controlador.src.Modelo_logico.AnalizadoresLéxicos.*;

public class Main {
    public static void main(String[] args) {

        CountDown cuentaAtras = new CountDown();
        cuentaAtras.cuentaParaAtras();


        HandlerEspaciosEnBlancoSyntax handlerEspaciosEnBlancoSyntax = new HandlerEspaciosEnBlancoSyntax();
        HandlerFinalDeSentenciasSyntax handlerFinalDeSentenciasSyntax = new HandlerFinalDeSentenciasSyntax();
        HandlerForSyntax handlerForSyntax = new HandlerForSyntax();
        HandlerPalabrasNoReservadasSyntax handlerPalabrasNoReservadasSyntax = new HandlerPalabrasNoReservadasSyntax();
        HandlerPalabrasReservadasSyntax handlerPalabrasReservadasSyntax = new HandlerPalabrasReservadasSyntax();
        HandlerWhileSyntax handlerWhileSyntax = new HandlerWhileSyntax();


        HandlerEspaciosEnBlancoLexic handlerEspaciosEnBlancoLexic = new HandlerEspaciosEnBlancoLexic();
        HandlerFinalesDeSentenciaLexic handlerFinalesDeSentenciaLexic = new HandlerFinalesDeSentenciaLexic();
        HandlerForLexic handlerForLexico = new HandlerForLexic();
        HandlerPalabrasNoReservadasLexic handlerPalabrasNoReservadasLexic = new HandlerPalabrasNoReservadasLexic();
        HandlerPalabrasReservadasLexic handlerPalabrasReservadasLexic = new HandlerPalabrasReservadasLexic();
        HandlerWhileLexic handlerWhileLexico = new HandlerWhileLexic();


        HandlerDeclaracionDeVariablesSemantica handlerDeclaracionDeVariablesSemantica = new HandlerDeclaracionDeVariablesSemantica();
        HandlerForSemantic handlerForSemantic = new HandlerForSemantic();
        HandlerWhileSemantic handlerWhileSemantic = new HandlerWhileSemantic();

        System.out.println("-------------------------------------------------");

        System.out.println("Creacion cadena de responsabilidad...");

        System.out.println("Analizando sintaxis...");

        handlerEspaciosEnBlancoSyntax.setSiguiente(handlerFinalDeSentenciasSyntax);
        handlerFinalDeSentenciasSyntax.setSiguiente(handlerForSyntax);
        handlerForSyntax.setSiguiente(handlerPalabrasNoReservadasSyntax);
        handlerPalabrasNoReservadasSyntax.setSiguiente(handlerPalabrasReservadasSyntax);
        handlerPalabrasReservadasSyntax.setSiguiente(handlerWhileSyntax);

        System.out.println("Analizando lexicos...");
        handlerEspaciosEnBlancoLexic.setSiguiente(handlerFinalesDeSentenciaLexic);
        handlerFinalesDeSentenciaLexic.setSiguiente(handlerForLexico);
        handlerForLexico.setSiguiente(handlerPalabrasNoReservadasLexic);
        handlerPalabrasNoReservadasLexic.setSiguiente(handlerPalabrasReservadasLexic);
        handlerPalabrasReservadasLexic.setSiguiente(handlerWhileLexico);

        System.out.println("Analizando semanticos...");
        handlerDeclaracionDeVariablesSemantica.setSiguiente(handlerForSemantic);
        handlerForSemantic.setSiguiente(handlerWhileSemantic);
        handlerWhileSemantic.setSiguiente(null);

        System.out.println("-------------------------------------------------");

        handlerEspaciosEnBlancoSyntax.proceso(cuentaAtras.toString());





    }
}
