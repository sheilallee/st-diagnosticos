package stdiagnosticos.validacao;

import stdiagnosticos.exame.*;

public class ValidaGlicoseHemograma extends ValidadorEncadeado {
    @Override
    protected ResultadoChecagem checar(ExameClinico exame) {
        if (!(exame instanceof HemogramaEx h)) return ResultadoChecagem.ok();
        double refMin = 70, refMax = 110; // mg/dL
        if (h.getGlicose() < refMin || h.getGlicose() > refMax)
            return ResultadoChecagem.erro("Glicose fora da faixa de referência (70-110 mg/dL)");
        return ResultadoChecagem.ok();
    }
}