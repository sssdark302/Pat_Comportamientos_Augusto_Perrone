package Modelo_Vista_Controlador.src.Modelo_logico.DesmenuzadorDeTexto;
import Modelo_Vista_Controlador.src.Modelo_logico.AnalizadoresSintácticos.ExcepcionSintáctica;
import Modelo_Vista_Controlador.src.Modelo_logico.AnalizadoresSintácticos.Handler;
import Modelo_Vista_Controlador.src.Modelo_logico.AnalizadoresSintácticos.Handler_Abstracto;

import java.util.ArrayList;
import java.util.List;

public class DesmenuzadorDeTextoHandler {

    //Entra un bloque de codigo, se debe separar cuando encuentre un ; o un { o etc,
    //cuando lo encuentra, cada linea se añade a un array
    //el array se debe recorrer y posteriormente analizar sintácticamente
    ArrayList<String> LineasCodigo = new ArrayList<>();
    List<String> ErroresCriticos = new ArrayList<>();


    public List<String> desmenuzadorTexto(String codigo){

    String[] lineas = codigo.split("(?<=;)(?![{\\s])|(?<=})"); //separa el texto

        List<String> bloques = new ArrayList<>(); // se crea el arraylist para guardar los bloques que se separan

        for (String linea : lineas){ //por cada linea (bloque) en lineas
            bloques.add(codigo); //se añade al arraylist
        }

        return bloques;
    }

}
