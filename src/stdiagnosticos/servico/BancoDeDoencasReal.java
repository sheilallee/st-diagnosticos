package stdiagnosticos.servico;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementação do serviço real que acessa um "banco de dados" de doenças.
 * Padrão Proxy: Este é o objeto Real (RealSubject).
 * Ele simula um acesso lento para demonstrar a utilidade de um proxy com cache.
 */
public class BancoDeDoencasReal implements ServicoDeDoencas {

    private final Map<String, String> bancoDeDados = new HashMap<>();

    public BancoDeDoencasReal() {
        bancoDeDados.put(
                "Infecção Bacteriana",
                "Descrição: Doença causada por bactérias." +
                "Tratamento: Antibióticos.");

        bancoDeDados.put(
                "Anemia",
                "Descrição: Baixa contagem de hemoglobina no sangue. " +
                "Tratamento: Suplementação de ferro.");

        bancoDeDados.put(
                "Lesão Tecidual",
                "Descrição: Dano a tecidos moles do corpo. " +
                "Tratamento: Fisioterapia e repouso.");

        bancoDeDados.put(
                "Fratura Óssea",
                "Descrição: Quebra de um osso. " +
                "Tratamento: Imobilização e, em casos graves, cirurgia.");
    }

    public Map<String, String> getBanco() {
        return bancoDeDados;
    }

    @Override
    public String getDetalhes(String nomeDoenca) {
        System.out.println("\n>>> ACESSANDO BANCO DE DADOS REAL (LENTO)... <<<");
        try {
            // Simula a latência de uma chamada de rede ou acesso a banco de dados
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return bancoDeDados.getOrDefault(nomeDoenca, "Doença não encontrada no banco de dados.");
    }
}
