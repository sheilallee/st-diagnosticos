package stdiagnosticos.validacao;

import stdiagnosticos.exame.*;

public class ValidaCreatininaHemograma extends ValidadorEncadeado {
    @Override
    protected ResultadoChecagem checar(ExameClinico exame) {
        if (!(exame instanceof HemogramaEx c)) return ResultadoChecagem.ok();

        double valor = c.getCreatinina();
        int idade = c.getPaciente().getIdade();
        if (idade < 12) {
            if (valor < 0.20 || valor > 0.50)
                return ResultadoChecagem.erro("Creatinina fora do esperado para crianças (0,20–0,50 mg/dL)");
        } else if (idade >= 60) {
            if (valor < 0.30 || valor > 1.20)
                return ResultadoChecagem.erro("Creatinina fora do esperado para idosos (0,30–1,20 mg/dL)");
        } else {
            if (valor < 0.40 || valor > 1.20)
                return ResultadoChecagem.erro("Creatinina fora do esperado para adultos (0,40–1,20 mg/dL)");
        }

        return ResultadoChecagem.ok("Creatinina dentro da faixa esperada");
    }
}