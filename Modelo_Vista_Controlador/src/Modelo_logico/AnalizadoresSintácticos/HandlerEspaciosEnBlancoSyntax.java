package Modelo_Vista_Controlador.src.Modelo_logico.AnalizadoresSintácticos;

import java.util.List;

public class HandlerEspaciosEnBlancoSyntax
                extends Handler_Abstracto {

    @Override
    public void proceso(String codigo, List<String> resultados) throws ExcepcionSintáctica{
       try {
           if (codigo.contains(" ")){

           }
       } catch () {
           throw new ExcepcionSintáctica();
       }
    }
}
