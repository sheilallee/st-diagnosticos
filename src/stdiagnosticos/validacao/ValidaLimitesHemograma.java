package stdiagnosticos.validacao;


import stdiagnosticos.exame.*;


public class ValidaLimitesHemograma extends ValidadorEncadeado {
    @Override protected ResultadoChecagem checar(ExameClinico exame) {
        if (!(exame instanceof HemogramaEx h)) return ResultadoChecagem.ok();
            // Faixas de referência simples (neutras quanto a sexo), e tolerância de 50% para extremos
            double refHbMin=13.0, refHbMax=17.0; // g/dL
            double refHtMin=38.0, refHtMax=50.0; // %
            double refLeuMin=4000, refLeuMax=11000; // /mm3


        if (h.getHemoglobina() < refHbMin*0.5 || h.getHemoglobina() > refHbMax*1.5)
            return ResultadoChecagem.erro("Hemoglobina fora do permitido (±50% extrap.)");
        if (h.getHematocrito() < refHtMin*0.5 || h.getHematocrito() > refHtMax*1.5)
            return ResultadoChecagem.erro("Hematócrito fora do permitido (±50% extrap.)");
        if (h.getLeucocitos() < refLeuMin*0.5 || h.getLeucocitos() > refLeuMax*1.5)
            return ResultadoChecagem.erro("Leucócitos fora do permitido (±50% extrap.)");
        return ResultadoChecagem.ok();
    }
}