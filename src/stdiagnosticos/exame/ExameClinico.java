package stdiagnosticos.exame;


import stdiagnosticos.modelo.*;
import stdiagnosticos.seq.GeradorSequencial;


public abstract class ExameClinico {
    private final long numeroExame; // R2 — gerado via Singleton
    private final Paciente paciente;
    private final Medico solicitante;
    private final double precoBase;
    private double precoFinal;


    protected ExameClinico(Paciente paciente, Medico solicitante, double precoBase) {
        this.numeroExame = GeradorSequencial.getInstancia().proximoNumero();
        this.paciente = paciente;
        this.solicitante = solicitante;
        this.precoBase = precoBase;
    }


    public long getNumeroExame() { return numeroExame; }
    public Paciente getPaciente() { return paciente; }
    public Medico getSolicitante() { return solicitante; }
    public double getPrecoBase() { return precoBase; }
    public double getPrecoFinal() { return precoFinal; }
    public void setPrecoFinal(double precoFinal) { this.precoFinal = precoFinal; }


    public abstract String getTipo();
}