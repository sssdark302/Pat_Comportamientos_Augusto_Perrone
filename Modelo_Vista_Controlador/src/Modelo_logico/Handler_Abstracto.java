package Modelo_Vista_Controlador.src.Modelo_logico;

public abstract class Handler_Abstracto
            implements Handler {
    protected Handler siguienteHandler;

    protected void pasarAlSiguiente(String codigo){
        if (siguienteHandler != null){
            siguienteHandler.proceso(codigo);
        }
    }

    @Override
    public void setSiguiente(Handler next) {
        this.siguienteHandler = next;
    }
    @Override
    public abstract void proceso(String codigo);
}
