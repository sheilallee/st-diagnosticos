package stdiagnosticos.notificacao;


import stdiagnosticos.modelo.Paciente;


public class EmailNotificador implements Observador {
    @Override public void notificar(String mensagem, Paciente p) {
        System.out.printf("[EMAIL] Para %s <%s>: %s\n", p.getNomeCompleto(), p.getEmail(), mensagem);
    }
}