package stdiagnosticos;

import java.nio.file.*;
import java.util.*;
import stdiagnosticos.exame.*;
import stdiagnosticos.fila.*;
import stdiagnosticos.io.*;
import stdiagnosticos.laudo.*;
import stdiagnosticos.modelo.*;
import stdiagnosticos.notificacao.*;
import stdiagnosticos.preco.*;
import stdiagnosticos.validacao.*;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== STDiagnosticos — Execução de Demonstração ===\n");

        // 0) Carregamento (R1)
        Path pastaDados = Paths.get("dados");
        Files.createDirectories(pastaDados);
        LoaderDados.criarArquivosExemploSeNecessario(pastaDados);
        List<Paciente> pacientes = LoaderDados.carregarPacientes(pastaDados.resolve("pacientes.csv"));
        List<Medico> medicos = LoaderDados.carregarMedicos(pastaDados.resolve("medicos.csv"));

        System.out.println("Pacientes carregados: " + pacientes.size());
        System.out.println("Médicos carregados : " + medicos.size());
        System.out.println();

        System.out.println("Médicos disponíveis:");
        for (Medico m : medicos) {
            System.out.printf("- %s (CRM %s) — %s%n", m.getNome(), m.getCrm(), m.getEspecialidade());
        }
        System.out.println();

        // Strategy
        GestorDePreco gestor = new GestorDePreco();

        // Factory Method
        CriadorExame fabHemograma = new CriadorHemograma(72.00);
        CriadorExame fabUltrassom  = new CriadorUltrassonografia(140.00);
        CriadorExame fabResson     = new CriadorRessonancia(780.00);

        // Priority Queue
        FilaExames fila = new FilaExames();

        Paciente p1 = pacientes.get(0);
        Paciente p2 = pacientes.get(1);
        Paciente p3 = pacientes.get(2);

        Medico mHemato = medicos.get(0);
        Medico mRadio  = medicos.get(1);
        Medico mUltra  = medicos.get(3);

        // Hemograma p1
        ExameClinico eh1 = fabHemograma.criar(p1, mHemato);
        if (eh1 instanceof HemogramaEx h) {
            h.setHemoglobina(13.9);
            h.setHematocrito(41.0);
            h.setLeucocitos(7200);
        }
        gestor.definirPolitica(selecionarPolitica(p1));
        double valorFinal1 = gestor.calcularPreco(eh1.getPrecoBase());
        eh1.setPrecoFinal(valorFinal1);
        fila.adicionar(eh1, Prioridade.ROTINA);
        System.out.printf("Exame %s solicitado para %s — Preço final R$ %.2f — Prioridade %s%n",
                eh1.getTipo(), p1.getNomeCompleto(), valorFinal1, Prioridade.ROTINA);

        // Ressonância p2
        ExameClinico er1 = fabResson.criar(p2, mRadio);
        if (er1 instanceof RessonanciaEx r) {
            r.setRegiao("Coluna lombar");
            r.setUsoContraste(false);
            r.setPossuiImplanteMetalico(false);
        }
        gestor.definirPolitica(selecionarPolitica(p2));
        double valorFinal2 = gestor.calcularPreco(er1.getPrecoBase());
        er1.setPrecoFinal(valorFinal2);
        fila.adicionar(er1, Prioridade.URGENTE);
        System.out.printf("Exame %s solicitado para %s — Preço final R$ %.2f — Prioridade %s%n",
                er1.getTipo(), p2.getNomeCompleto(), valorFinal2, Prioridade.URGENTE);

        // Ultrassom p3
        ExameClinico eu1 = fabUltrassom.criar(p3, mUltra);
        if (eu1 instanceof UltrassonografiaEx u) {
            u.setOrgao("Tireoide");
            u.setAchados("Nódulo hipoecoico < 1cm");
            u.setMedidas("0,8 × 0,7 × 0,6 cm");
        }
        gestor.definirPolitica(selecionarPolitica(p3));
        double valorFinal3 = gestor.calcularPreco(eu1.getPrecoBase());
        eu1.setPrecoFinal(valorFinal3);
        fila.adicionar(eu1, Prioridade.POUCO_URGENTE);
        System.out.printf("Exame %s solicitado para %s — Preço final R$ %.2f — Prioridade %s%n%n",
                eu1.getTipo(), p3.getNomeCompleto(), valorFinal3, Prioridade.POUCO_URGENTE);

        // Processamento
        GerenciadorNotificacao notif = new GerenciadorNotificacao();
        notif.adicionar(new EmailNotificador());
        notif.adicionar(new SmsNotificador());
        notif.adicionar(new WhatsAppNotificador());

        while (!fila.vazia()) {
            ExamePrioritario prox = fila.proximo();
            ExameClinico ex = prox.getExame();
            System.out.printf("Processando exame: %s — Paciente: %s — Prioridade: %s%n",
                    ex.getTipo(), ex.getPaciente().getNomeCompleto(), prox.getPrioridade());

            RegraValidadora cadeia = MontadorCadeiaValidacao.para(ex);
            ResultadoChecagem res = (cadeia != null) ? cadeia.validar(ex) : ResultadoChecagem.ok();
            if (!res.aprovado()) {
                System.out.println("× Validação falhou: " + res.mensagem());
                System.out.println();
                continue;
            }

            // Bridge
            FormatoLaudo formato = switch (ex.getTipo()) {
                case "HEMOGRAMA" -> new FormatoPDF();
                case "RESSONANCIA" -> new FormatoHTML();
                default -> new FormatoTexto();
            };
            String laudo = formato.gerar(ex);
            System.out.println(laudo);

            // Observer
            notif.notificarTodos("Laudo emitido para " + ex.getPaciente().getNomeCompleto(), ex.getPaciente());
            System.out.println();
        }

        // Demonstração falha validação
        Paciente pFalha = pacientes.get(4);
        ExameClinico hemFalha = fabHemograma.criar(pFalha, mHemato);
        if (hemFalha instanceof HemogramaEx h) {
            h.setHemoglobina(2.0);
            h.setHematocrito(90.0);
            h.setLeucocitos(30000);
        }
        RegraValidadora cadFalha = MontadorCadeiaValidacao.para(hemFalha);
        ResultadoChecagem rFalha = cadFalha.validar(hemFalha);
        System.out.println("Demonstração de validação (deve falhar): " + rFalha);

        System.out.println("\n=== Fim da execução de demonstração ===");
    }

    private static PoliticaDesconto selecionarPolitica(Paciente p) {
        if (p.isPossuiConvenio()) return new DescontoPorConvenio(0.15);
        if (p.getIdade() >= 60) return new DescontoParaIdoso(0.08);
        return valor -> valor; // nenhum desconto
    }
}
