package stdiagnosticos.notificacao;


import java.util.*;
import stdiagnosticos.modelo.Paciente;


public class GerenciadorNotificacao {
    private final List<Observador> canais = new ArrayList<>();
    public void adicionar(Observador obs) { canais.add(obs); }
    public void remover(Observador obs) { canais.remove(obs); }
    public void notificarTodos(String msg, Paciente p) {
        for (Observador o : canais) o.notificar(msg, p);
    }
}