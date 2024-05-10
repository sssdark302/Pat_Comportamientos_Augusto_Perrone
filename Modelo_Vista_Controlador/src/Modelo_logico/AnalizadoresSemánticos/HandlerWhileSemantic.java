package Modelo_Vista_Controlador.src.Modelo_logico.AnalizadoresSemánticos;

import Modelo_Vista_Controlador.src.Modelo_logico.Handler_Abstracto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HandlerWhileSemantic
        extends Handler_Abstracto {

    @Override
    public void proceso(String codigo) {
        try {
            Pattern pattern = Pattern.compile("while\\(([^)]+)\\)"); //busca la regex para los while
            Matcher matcher = pattern.matcher(codigo); //compara
            if (matcher.find()) {
                String condicionalWhile = matcher.group(1); // extrae la condición del bucle while
                boolean condicionValida = verificarCondicionWhile(condicionalWhile); //llamada al metodo

                if (condicionValida) {
                    System.out.println("La condicion del bucle While es semanticamente correcta.");
                } else {
                    throw new PatronExcepcionSemantica("La condicion del bucle While no es semanticamente correcta.");
                }
            } else {
                throw new PatronExcepcionSemantica("No se encuentra una declaración de un bucle while.");
            }
        } catch (PatronExcepcionSemantica ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }

    private boolean verificarCondicionWhile(String condicion) {
        try{
            //ver si hay caracteres no permitidos
            if (!condicion.matches("[\\w\\s\\d()!<>=&|+\\-*/]+")) {
                throw new PatronExcepcionSemantica("No es posible continuar verificando el bucle while ya que tiene caracteres no permitidos")
            }

            Pattern patron = Pattern.compile("(\\w+)\\s*([<>=!]+)\\s*(\\w+)");
            Matcher matcher = patron.matcher(condicion);
            while (matcher.find()) {
                String primero = matcher.group(1); //(\\w+)
                String operandos = matcher.group(2); // ([<>=!]+)
                String tercero = matcher.group(3); //(\\w+)

                // Aquí implementarías la lógica para verificar los operandos y el operador
                // Por ejemplo, verificar que no se compare un String con un int directamente sin conversión

                // Ejemplo simplificado: verificar que no se use '=' en lugar de '=='
                if ("=".equals(operandos)) {
                    return false;
                }
            }

            // 3. Lógica de evaluación adicional si es necesario

            return true; // Si pasa todas las comprobaciones, la condición es válida
        }catch ()
    }

}
