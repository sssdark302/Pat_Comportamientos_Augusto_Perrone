package Modelo_Vista_Controlador.src.Modelo_logico.AnalizadoresLéxicos;

public class PatronExcepcionLexica
        extends RuntimeException{
    public PatronExcepcionLexica(String mensaje){
        super(mensaje);
    }
}
