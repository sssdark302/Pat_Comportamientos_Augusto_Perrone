package Modelo_Vista_Controlador.src.Modelo_logico;

import Modelo_Vista_Controlador.src.Modelo_logico.AnalizadoresSintácticos.ExcepcionSintáctica;

public interface Handler {

    //crear una lista para ver los errores
    void setSiguiente(Handler next);
    void proceso(String codigo);
}
