package stdiagnosticos.notificacao;


import stdiagnosticos.modelo.Paciente;


public class SmsNotificador implements Observador {
    @Override public void notificar(String mensagem, Paciente p) {
        System.out.printf("[SMS] Para %s (%s): %s\n", p.getNomeCompleto(), p.getFone(), mensagem);
    }
}