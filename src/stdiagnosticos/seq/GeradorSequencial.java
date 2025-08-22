package stdiagnosticos.seq;


public class GeradorSequencial {
    private static GeradorSequencial instancia;
    private long atual = 1L;
    private GeradorSequencial() {}
    public static synchronized GeradorSequencial getInstancia() {
        if (instancia == null) instancia = new GeradorSequencial();
            return instancia;
    }
    public synchronized long proximoNumero() { return atual++; }
    public synchronized void reiniciar(long inicio) { this.atual = inicio; }
}