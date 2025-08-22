package stdiagnosticos.notificacao;


import stdiagnosticos.modelo.Paciente;


public interface Observador {
    void notificar(String mensagem, Paciente destinatario);
}