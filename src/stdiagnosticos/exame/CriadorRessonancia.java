package stdiagnosticos.exame;


import stdiagnosticos.modelo.*;


public class CriadorRessonancia implements CriadorExame {
    private final double precoBase;
    public CriadorRessonancia(double precoBase) { this.precoBase = precoBase; }
    @Override public ExameClinico criar(Paciente paciente, Medico solicitante) {
        return new RessonanciaEx(paciente, solicitante, precoBase);
    }
}