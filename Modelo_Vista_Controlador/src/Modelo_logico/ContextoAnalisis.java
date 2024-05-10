package Modelo_Vista_Controlador.src.Modelo_logico;

import java.util.ArrayList;
import java.util.List;

public class ContextoAnalisis {
    private List<String> resultados = new ArrayList<>();

    public void agregarResultado(String resultado) {
        resultados.add(resultado);
    }

    public String getResultados() {
        return String.join("\n", resultados);  // Devuelve todos los resultados como una sola cadena
    }
}