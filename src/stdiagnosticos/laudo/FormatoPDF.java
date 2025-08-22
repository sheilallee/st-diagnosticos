package stdiagnosticos.laudo;


import stdiagnosticos.exame.*;
import java.time.*;


/**
* Simulação de PDF (sem dependências). Em projeto real, integrar iText/OpenPDF.
*/
public class FormatoPDF implements FormatoLaudo {
    @Override public String gerar(ExameClinico e) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n================= [PDF SIMULADO] =================\n");
        sb.append("STDiagnósticos — Laudo\n");
        sb.append("Emitido em: ").append(LocalDate.now()).append("\n");
        sb.append("Número: ").append(e.getNumeroExame()).append("\n");
        sb.append("Paciente: ").append(e.getPaciente().getNomeCompleto()).append("\n");
        sb.append("Tipo: ").append(e.getTipo()).append("\n");
        sb.append("Valor cobrado: R$ ").append(String.format("%.2f", e.getPrecoFinal())).append("\n");


        if (e instanceof HemogramaEx h) {
            sb.append("[HEMOGRAMA]\n")
            .append("Hb: ").append(h.getHemoglobina()).append(" g/dL; Ht: ")
            .append(h.getHematocrito()).append(" %; Leuc: ")
            .append(h.getLeucocitos()).append(" /mm³\n");
        } else if (e instanceof RessonanciaEx r) {
            sb.append("[RESSONÂNCIA]\n")
            .append("Região: ").append(r.getRegiao())
            .append("; Contraste: ").append(r.isUsoContraste()?"Sim":"Não").append("\n");
        } else if (e instanceof UltrassonografiaEx u) {
            sb.append("[ULTRASSONOGRAFIA]\n")
            .append("Órgão: ").append(u.getOrgao()).append("; Achados: ")
            .append(u.getAchados()).append("; Medidas: ").append(u.getMedidas()).append("\n");
        }
        sb.append("Ass. Dr(a). ").append(e.getSolicitante().getNome())
        .append(" — CRM ").append(e.getSolicitante().getCrm()).append("\n");
        sb.append("==================================================\n");
        return sb.toString();
    }
}