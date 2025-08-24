package stdiagnosticos.servico;

import stdiagnosticos.exame.ExameClinico;
import stdiagnosticos.exame.HemogramaEx;
import stdiagnosticos.exame.RessonanciaEx;
import stdiagnosticos.exame.UltrassonografiaEx;

public class AnalisadorDeResultados {

    private final ServicoDeDoencas servicoDeDoencas;

    public AnalisadorDeResultados(ServicoDeDoencas servico) {
        this.servicoDeDoencas = servico;
    }

    public String analisar(ExameClinico exame) {
        String nomeDoenca = null;

        if (exame instanceof HemogramaEx h) {
            if (h.getLeucocitos() > 11000) nomeDoenca = "Infecção Bacteriana";
            else if (h.getHemoglobina() < 12) nomeDoenca = "Anemia";

        } else if (exame instanceof RessonanciaEx r) {
            if (r.getLaudo() != null) nomeDoenca = "Fratura Óssea";

        } else if (exame instanceof UltrassonografiaEx rx) {
            if (rx.getLaudo() != null) nomeDoenca = "Lesão Tecidual";
        }

        if (nomeDoenca != null) {
            // Aqui passamos pelo Proxy
            String detalhes = servicoDeDoencas.getDetalhes(nomeDoenca);

            return "'" + detalhes + "'";
        }

        return "Nenhum diagnóstico encontrado";
    }
}