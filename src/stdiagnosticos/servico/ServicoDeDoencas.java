package stdiagnosticos.servico;

/**
 * Interface que define o contrato para um serviço de consulta de informações sobre doenças.
 * Padrão Proxy: Esta é a interface (Subject) que tanto o objeto Real quanto o Proxy irão implementar.
 */
public interface ServicoDeDoencas {
    /**
     * Busca e retorna os detalhes de uma doença específica.
     *
     * @param nomeDoenca O nome da doença a ser consultada.
     * @return Uma String com os detalhes da doença.
     */
    String getDetalhes(String nomeDoenca);
}
