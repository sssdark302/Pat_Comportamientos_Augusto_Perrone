package Modelo_Vista_Controlador.src.Modelo_logico.DesmenuzadorDeTexto;

import java.util.List;

public interface Handler {
    void setSiguiente(Modelo_Vista_Controlador.src.Modelo_logico.AnalizadoresSintácticos.Handler next);
    void proceso(String codigo, List<String> resultados) throws ExcepcionDesmenuzador;
}
