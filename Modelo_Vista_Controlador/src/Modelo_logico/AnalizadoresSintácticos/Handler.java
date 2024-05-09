package Modelo_Vista_Controlador.src.Modelo_logico.AnalizadoresSintácticos;

import java.util.List;

public interface Handler {

    //crear una lista para ver los errores
    void setSiguiente(Handler next);
    void proceso(String codigo, List<String> resultados) throws ExcepcionSintáctica;
}
