package stdiagnosticos.exame;


import stdiagnosticos.modelo.*;


public interface CriadorExame {
    ExameClinico criar(Paciente paciente, Medico solicitante);
}