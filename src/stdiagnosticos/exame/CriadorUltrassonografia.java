package stdiagnosticos.exame;


import stdiagnosticos.modelo.*;


public class CriadorUltrassonografia implements CriadorExame {
    private final double precoBase;
    public CriadorUltrassonografia(double precoBase) { this.precoBase = precoBase; }
    @Override public ExameClinico criar(Paciente paciente, Medico solicitante) {
        return new UltrassonografiaEx(paciente, solicitante, precoBase);
    }
}