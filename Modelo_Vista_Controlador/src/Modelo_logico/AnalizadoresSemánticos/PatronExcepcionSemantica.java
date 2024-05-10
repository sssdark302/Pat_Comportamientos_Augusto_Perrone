package Modelo_Vista_Controlador.src.Modelo_logico.AnalizadoresSemánticos;

public class PatronExcepcionSemantica
        extends RuntimeException{

    public PatronExcepcionSemantica(String mensaje){
        super(mensaje);
    }
}
