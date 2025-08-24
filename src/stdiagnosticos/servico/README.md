# Pacote Servico

Este pacote contém lógicas de negócio e serviços que orquestram funcionalidades mais complexas, combinando diferentes partes do sistema.

## Funcionalidades e Padrões

### 1. Análise de Resultados

- **`AnalisadorDeResultados`:** Esta classe funciona como um "motor de regras" simples. Ela recebe um objeto de exame, analisa seus dados (`instanceof`) e retorna uma `String` representando um possível diagnóstico. Ela centraliza a lógica de interpretação dos resultados dos exames.

### 2. Consulta a Banco de Dados de Doenças (Padrão Proxy)

Esta funcionalidade simula a consulta a uma base de dados externa e dispendiosa (em tempo ou custo) para obter informações detalhadas sobre doenças.

- **`ServicoDeDoencas` (Interface):** Define o contrato para o serviço de consulta (`getDetalhes`).
- **`BancoDeDoencasReal` (Real Subject):** A implementação real do serviço. Ela contém um mapa `hard-coded` de doenças e simula lentidão (`Thread.sleep()`) para representar um acesso custoso a um banco de dados.
- **`ProxyBancoDeDoencas` (Proxy):** A classe que o cliente utiliza. Ela atua como um intermediário para o `BancoDeDoencasReal`. A primeira vez que uma doença é solicitada, o Proxy chama o objeto real e armazena o resultado em um cache interno (um `Map`). Em chamadas subsequentes para a mesma doença, o Proxy retorna o resultado diretamente do cache, evitando a chamada lenta ao objeto real.

O padrão **Proxy (Virtual Proxy)** é usado aqui para otimizar o desempenho e controlar o acesso a um recurso caro.
