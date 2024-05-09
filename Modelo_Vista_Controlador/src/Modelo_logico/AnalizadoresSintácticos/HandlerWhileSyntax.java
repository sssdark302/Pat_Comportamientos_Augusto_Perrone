package Modelo_Vista_Controlador.src.Modelo_logico.AnalizadoresSintácticos;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class HandlerWhileSyntax extends Handler_Abstracto {
    private static final Pattern patron = Pattern.compile("while\\s*\\(([^)]+)\\)\\s*\\{([\\s\\S]*?)\\}");

    @Override
    public void proceso(String codigo, List<String> resultados) throws ExcepcionSintáctica {
        Matcher matcher = patron.matcher(codigo);
        if (matcher.find()){

        }
    }
}
