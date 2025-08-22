package stdiagnosticos.notificacao;


import stdiagnosticos.modelo.Paciente;


public class WhatsAppNotificador implements Observador {
    @Override public void notificar(String mensagem, Paciente p) {
        System.out.printf("[WhatsApp] %s — %s\n", p.getNomeCompleto(), mensagem);
    }
}