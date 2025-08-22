package stdiagnosticos.exame;


import stdiagnosticos.modelo.*;


public class CriadorHemograma implements CriadorExame {
    private final double precoBase;
    public CriadorHemograma(double precoBase) { this.precoBase = precoBase; }
    @Override public ExameClinico criar(Paciente paciente, Medico solicitante) {
        return new HemogramaEx(paciente, solicitante, precoBase);
    }
}