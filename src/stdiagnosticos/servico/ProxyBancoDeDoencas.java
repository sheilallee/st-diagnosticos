package stdiagnosticos.servico;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementação do Proxy para o serviço de banco de dados de doenças.
 * Padrão Proxy: Este é o objeto Proxy. Ele controla o acesso ao objeto Real (BancoDeDoencasReal)
 * e adiciona uma camada de cache para otimizar as consultas.
 */
public class ProxyBancoDeDoencas implements ServicoDeDoencas {

    private final BancoDeDoencasReal servicoReal;
    private final Map<String, String> cache = new HashMap<>();

    public ProxyBancoDeDoencas(BancoDeDoencasReal servicoReal) {
        this.servicoReal = servicoReal;
    }

    @Override
    public String getDetalhes(String nomeDoenca) {
        // Verifica se o resultado já está no cache
        if (cache.containsKey(nomeDoenca)) {
            System.out.println("\n>>> OBTENDO DADOS DO CACHE (RÁPIDO) <<<");
            return cache.get(nomeDoenca);
        }

        // Se não estiver no cache, chama o serviço real
        String detalhes = servicoReal.getDetalhes(nomeDoenca);

        // Armazena o novo resultado no cache antes de retorná-lo
        cache.put(nomeDoenca, detalhes);

        return "'"+nomeDoenca+"'" + ": " + detalhes;
    }
}
