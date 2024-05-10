package Modelo_Vista_Controlador.src.Modelo_logico;

public class CountDown {

    public void cuentaParaAtras() {
        int num = 10;
        while (num != 0) {
            System.out.println(num);
            num = num - 1;
        }
    }

    @Override
    public String toString() {
        return " public void cuentaParaAtras() {\n" +
                "        int num = 10;\n" +
                "        while (num != 0) {\n" +
                "            System.out.println(num);\n" +
                "            num = num - 1;\n" +
                "        }\n" +
                "    }";
    }

}
