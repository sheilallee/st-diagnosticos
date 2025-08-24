# Pacote Preco

Este pacote é responsável por calcular o custo dos exames, aplicando diferentes estratégias de precificação com base em fatores como convênios ou promoções.

## Padrões Implementados

### Strategy

O padrão **Strategy** é utilizado aqui para encapsular diferentes algoritmos de cálculo de preço.

- **`EstrategiaDePreco` (Strategy):** A interface que define o contrato para todas as estratégias de preço, com um único método `calcular(double valorBase)`.
- **`PrecoConvenio`, `PrecoRegular`, `PrecoPromocional` (Concrete Strategies):** Cada uma dessas classes implementa a interface `EstrategiaDePreco` e contém a lógica específica para um tipo de cálculo. Por exemplo, `PrecoConvenio` aplica um desconto fixo, enquanto `PrecoRegular` retorna o valor base.
- **`GestorDePreco` (Context):** Esta classe mantém uma referência a um objeto `EstrategiaDePreco`. O código cliente configura o `GestorDePreco` com a estratégia desejada. Quando o método `calcularValorFinal()` é chamado, ele delega o cálculo para o objeto de estratégia que está ativo no momento.

Isso permite que o algoritmo de cálculo de preço seja alterado em tempo de execução, simplesmente trocando o objeto de estratégia no `GestorDePreco`.
