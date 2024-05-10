package Modelo_Vista_Controlador.src.Modelo_logico.AnalizadoresLéxicos;

import Modelo_Vista_Controlador.src.Modelo_logico.Handler_Abstracto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HandlerWhileLexic
        extends Handler_Abstracto {

    private static final Pattern patron = Pattern.compile("while\\s*\\(([^)]+)\\)\\s*\\{([\\s\\S]*?)\\}");


}
