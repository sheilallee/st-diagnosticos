# Pacote Laudo

Este pacote é responsável por gerar os laudos dos exames em diferentes formatos, desacoplando a estrutura do laudo do seu formato de apresentação.

## Padrões Implementados

### Bridge

O padrão **Bridge** é o conceito central aqui.

- **`GeradorDeLaudo` (Abstração):** É uma classe abstrata que contém uma referência a um objeto `FormatoLaudo`. Ela define o método `gerar()` que as subclasses usarão, mas delega a formatação real para o objeto `FormatoLaudo`.
- **`GeradorLaudoSimples`, `GeradorLaudoDetalhado` (Abstrações Refinadas):** Subclasses que implementam diferentes maneiras de estruturar o conteúdo do laudo (por exemplo, um simples com poucas informações e um detalhado com todas).
- **`FormatoLaudo` (Implementador):** A interface que define o contrato para as diferentes formas de apresentação (ex: TXT, HTML).
- **`FormatoLaudoTXT`, `FormatoLaudoHTML` (Implementadores Concretos):** As classes que implementam a lógica específica para gerar o laudo em um formato de texto simples ou em HTML.

O Bridge permite que você combine qualquer tipo de estrutura de laudo (Simples, Detalhado) com qualquer formato de saída (TXT, HTML) de forma independente.
