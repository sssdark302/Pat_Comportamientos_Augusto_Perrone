package Modelo_Vista_Controlador.src.Modelo_logico;

public class CountUp {
    public void contadorHaciaArriba(){
        for (int i = 0; true; i++){
            System.out.println(i);
        }
    }

    @Override
    public String toString() {
        return "public void contadorHaciaArriba(){\n" +
                "        for (int i = 0; true; i++){\n" +
                "            System.out.println(i);\n" +
                "        }\n" +
                "    }";
    }
}
