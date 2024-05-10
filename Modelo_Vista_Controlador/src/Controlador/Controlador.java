package Modelo_Vista_Controlador.src.Controlador;
import Modelo_Vista_Controlador.src.Modelo_logico.Main;
import Modelo_Vista_Controlador.src.Vista.Vista;

public class Controlador {
    private Main modelo;
    private Vista vista;

    public Controlador(Vista vista, Main modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.addAnalyzeListener(e -> analizarTexto());
        this.vista.addClearListener(e -> limpiarTexto());
    }

    private void analizarTexto() {
        String input = vista.getInputText();  // Obtener texto de entrada desde la vista
        String resultado = modelo.analizar(input);  // Llamar a la función de análisis del modelo
        vista.setOutputText(resultado);  // Mostrar el resultado en la vista
    }

    private void limpiarTexto() {
        vista.getInputText();
        vista.setOutputText("");
    }
}

