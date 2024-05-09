package Modelo_Vista_Controlador.src.Modelo_logico.DesmenuzadorDeTexto;
import Modelo_Vista_Controlador.src.Modelo_logico.AnalizadoresSintácticos.ExcepcionSintáctica;
import Modelo_Vista_Controlador.src.Modelo_logico.AnalizadoresSintácticos.Handler;

import java.util.ArrayList;
import java.util.List;

public class DesmenuzadorDeTextoHandler
            implements Handler {

    //Entra un bloque de codigo, se debe separar cuando encuentre un ; o un { o etc,
    //cuando lo encuentra, cada linea se añade a un array
    //el array se debe recorrer y posteriormente analizar sintácticamente
    ArrayList<String> LineasCodigo = new ArrayList<>();
    List<String> ErroresCriticos = new ArrayList<>();


    public void desmenuzadorTexto(String bloqueTexto){

    }

    @Override
    public void setSiguiente(Handler next) {

    }

    @Override
    public void proceso(String codigo, List<String> resultados) throws ExcepcionSintáctica {

    }
}
