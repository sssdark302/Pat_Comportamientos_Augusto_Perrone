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
        return "CountDown{num=0}";
    }

}
