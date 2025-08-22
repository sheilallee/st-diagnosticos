package stdiagnosticos.laudo;


import java.time.*;
import stdiagnosticos.exame.*;


public class FormatoTexto implements FormatoLaudo {
    @Override public String gerar(ExameClinico e) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n-- LAUDO (TEXTO SIMPLES) --\n");
        sb.append("Laboratório STDiagnósticos\n");
        sb.append("Data: ").append(LocalDate.now()).append('\n');
        sb.append("Nº Exame: ").append(e.getNumeroExame()).append("\n\n");
        sb.append("PACIENTE: ").append(e.getPaciente().getNomeCompleto()).append(" (Idade ")
        .append(e.getPaciente().getIdade()).append(")\n");
        sb.append("Solicitante: ").append(e.getSolicitante().getNome()).append("\n");
        sb.append("Tipo: ").append(e.getTipo()).append("\n");
        sb.append("Preço: R$ ").append(String.format("%.2f", e.getPrecoFinal())).append("\n\n");


        if (e instanceof HemogramaEx h) {
            sb.append("Hemoglobina: ").append(h.getHemoglobina()).append(" g/dL\n");
            sb.append("Hematócrito: ").append(h.getHematocrito()).append(" %\n");
            sb.append("Leucócitos: ").append(h.getLeucocitos()).append(" /mm³\n");
        } else if (e instanceof RessonanciaEx r) {
            sb.append("Região: ").append(r.getRegiao()).append("\n");
            sb.append("Contraste: ").append(r.isUsoContraste() ? "Sim" : "Não").append("\n");
        } else if (e instanceof UltrassonografiaEx u) {
            sb.append("Órgão: ").append(u.getOrgao()).append("\n");
            sb.append("Achados: ").append(u.getAchados()).append("\n");
            sb.append("Medidas: ").append(u.getMedidas()).append("\n");
        }
        sb.append("\nAss.: ").append(e.getSolicitante().getNome()).append(" — CRM ")
        .append(e.getSolicitante().getCrm()).append("\n");
        sb.append("-- Fim --\n");
        return sb.toString();
    }
}