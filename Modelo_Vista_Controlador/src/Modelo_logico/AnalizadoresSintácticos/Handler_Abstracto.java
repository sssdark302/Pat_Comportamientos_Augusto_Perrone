package Modelo_Vista_Controlador.src.Modelo_logico.AnalizadoresSintácticos;

import java.util.ArrayList;
import java.util.List;

public abstract class Handler_Abstracto
            implements Handler {
    protected Handler next;

    List<String> ErroresCriticos = new ArrayList<>();
    protected void pasarAlSiguiente(String codigo, List<String> resultados) throws ExcepcionSintáctica {
        if (next != null){
            next.proceso(codigo, resultados);
        }
    }

    @Override
    public void setSiguiente(Handler next) {
        this.next = next;
    }
    @Override
    public abstract void proceso(String codigo, List<String> resultados) throws ExcepcionSintáctica;
}
