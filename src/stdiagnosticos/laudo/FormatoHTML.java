package stdiagnosticos.laudo;


import stdiagnosticos.exame.*;
import java.time.*;


public class FormatoHTML implements FormatoLaudo {
    @Override public String gerar(ExameClinico e) {
        StringBuilder body = new StringBuilder();
        body.append("<h2>STDiagnósticos</h2>");
        body.append("<p><b>Data:</b> ").append(LocalDate.now()).append("</p>");
        body.append("<p><b>Nº Exame:</b> ").append(e.getNumeroExame()).append("</p>");
        body.append("<p><b>Paciente:</b> ").append(e.getPaciente().getNomeCompleto())
        .append(" (Idade ").append(e.getPaciente().getIdade()).append(")</p>");
        body.append("<p><b>Solicitante:</b> ").append(e.getSolicitante().getNome()).append("</p>");
        body.append("<p><b>Tipo:</b> ").append(e.getTipo()).append("</p>");
        body.append("<p><b>Preço:</b> R$ ").append(String.format("%.2f", e.getPrecoFinal())).append("</p>");


        if (e instanceof HemogramaEx h) {
            body.append("<ul>")
            .append("<li>Hemoglobina: ").append(h.getHemoglobina()).append(" g/dL</li>")
            .append("<li>Hematócrito: ").append(h.getHematocrito()).append(" %</li>")
            .append("<li>Leucócitos: ").append(h.getLeucocitos()).append(" /mm³</li>")
            .append("</ul>");
        } else if (e instanceof RessonanciaEx r) {
            body.append("<ul>")
            .append("<li>Região: ").append(r.getRegiao()).append("</li>")
            .append("<li>Contraste: ").append(r.isUsoContraste()?"Sim":"Não").append("</li>")
            .append("</ul>");
        } else if (e instanceof UltrassonografiaEx u) {
            body.append("<ul>")
            .append("<li>Órgão: ").append(u.getOrgao()).append("</li>")
            .append("<li>Achados: ").append(u.getAchados()).append("</li>")
            .append("<li>Medidas: ").append(u.getMedidas()).append("</li>")
            .append("</ul>");
        }


        return "<html><head><meta charset=\"utf-8\"><title>Laudo</title></head><body>" + body + "</body></html>";
    }
}