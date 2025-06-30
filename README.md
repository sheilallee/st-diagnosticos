# ST Diagnósticos – Sistema de Gerenciamento de Exames Médicos e Emissão de Laudos

## Visão Geral

Este projeto simula o sistema de gestão de exames da empresa fictícia ST Diagnósticos, utilizando padrões de projeto para garantir modularidade, extensibilidade e manutenibilidade. A aplicação realiza geração de laudos, validações por tipo de exame, notificações aos pacientes, aplicação de descontos, priorização e filtragem de exames.

---

## Requisitos do domínio com descrição dos padrões de projeto utilizados

- **R1 – Carregar dados de CSV**  
 *Descrição:* os dados de entidades como Paciente, Medico (solicitante e responsável pelo laudo) serão estruturados previamente em arquivos CSV. Durante a execução, serão lidos e instanciados por métodos auxiliares simulados em Java.

- **R2 – Gerar número sequencial de exames**  
  *Descrição:* uso de uma **variável estática** na classe `Exame`, que é incrementada automaticamente a cada nova instância. 

- **R3 – Emitir laudos para diferentes tipos de exames (Hemograma, Ressonância, etc.)**  
  *Padrão Aplicado:* **Template Method**  
  *Descrição:* a classe abstrata Exame define a estrutura geral de um exame (com atributos e método getTipo()), e as subclasses implementam o comportamento específico de cada tipo de exame. Esse padrão permite reutilizar a estrutura comum, mantendo flexibilidade para especializações.

- **R4 – Gerar laudos em diferentes formatos (Texto, HTML, PDF)**  
  *Padrão Aplicado:* **Factory Method**  
  *Descrição:* a interface GeradorLaudo define o método gerarLaudo(), e suas implementações (GeradorLaudoTexto, GeradorLaudoHTML, GeradorLaudoPDF) são instanciadas dinamicamente por uma fábrica, de acordo com o formato desejado. Isso garante baixo acoplamento e extensibilidade no sistema de exportação de laudos.

- **R5 – Aplicar regras específicas de validação por tipo de exame**  
  *Padrão Aplicado:* **Strategy**  
  *Descrição:* a classe Laudo utiliza uma instância de ValidadorExame (interface de estratégia), que pode ser ValidadorHemograma, ValidadorRessonancia etc., dependendo do tipo de exame. Isso permite aplicar lógicas diferentes de validação conforme o tipo, respeitando o princípio do Aberto/Fechado.

- **R6 – Notificar paciente quando o laudo estiver pronto (WhatsApp, Email, etc.)**  
  *Padrão Aplicado:* **Observer**  
  *Descrição:* o Laudo possui uma lista de Notificadors (interface Notificador), e ao ser finalizado, dispara a notificação para todos os inscritos (como NotificadorWhatsapp e NotificadorEmail). Assim, novos canais de aviso podem ser adicionados sem alterar a lógica principal.

- **R7 – Aplicar descontos com base em idade, convênio e campanhas**  
  *Padrão Aplicado:* **Decorator**  
  *Descrição:* composição de descontos de forma extensível e flexível. A interface Desconto define o método calcular(). Implementações como DescontoIdoso, DescontoConvenio e SemDesconto são encadeadas dinamicamente, permitindo composições flexíveis de múltiplos descontos em um mesmo exame, via objetos decoradores. 

- **R8 – Classificar exames por prioridade (Urgente, Pouco Urgente, Rotina)**  
  *Padrão Aplicado:* **Chain of Responsibility**  
  *Descrição:* a classe ManipuladorPrioridade é abstrata e define processar(), que é implementado por ManipuladorUrgente, ManipuladorPoucoUrgente e ManipuladorRotina. Cada um decide se trata o exame ou delega para o próximo da cadeia, conforme a urgência.

- **R9 – Simular execução do sistema com todos os recursos integrados**  
 *Descrição:* será desenvolvido um método `main()` responsável por orquestrar todo o fluxo: leitura dos arquivos CSV, criação dos exames via fábrica, validação por estratégia, geração de laudos, aplicação de descontos, definição de prioridades, envio de notificações e aplicação de filtros.

- **R10 – Filtrar exames por tipo ou por data de realização**  
  *Padrão Aplicado:* **Command**  
  *Descrição:* a interface FiltroCommand define o método executar(), e implementações como FiltroPorTipo e FiltroPorData encapsulam filtros reutilizáveis. O sistema pode aplicar diferentes filtros de forma modular, permitindo composições futuras com facilidade. Desta forma, encapsula filtros como comandos reutilizáveis e desacoplados, facilitando manutenção e extensões futuras.

---

## Padrões de Projeto 

1. Factory Method: 
Permite a criação flexível de exames e laudos. As novas classes de exames ou formatos podem ser adicionadas sem impactar o código cliente.

2. Strategy: 
Aplica diferentes estratégias de validação para cada tipo de exame. O laudo delega essa responsabilidade ao validador específico, promovendo o princípio Open/Closed.

3. Observer: 
Permite que múltiplos mecanismos de notificação (email, WhatsApp, etc.) sejam registrados dinamicamente. Quando o laudo é gerado, todos os notificadores são chamados automaticamente.

4. Decorator: 
Aplicado na composição de descontos. O sistema pode encadear múltiplos descontos (idoso, convênio, etc), somando ou compondo suas lógicas dinamicamente.

5. Chain of Responsibility: 
Utilizado na priorização dos exames. Cada manipulador decide se processa ou passa para o próximo. Permite adicionar novas prioridades facilmente.

6. Command (Requisito R10): 
Cada filtro (por tipo, por data) é encapsulado como um comando reutilizável e independente. Facilita extensões futuras e permite composição de filtros em lote.

7. Template Method:  
Define uma estrutura base comum para exames na superclasse Exame, permitindo que subclasses como Hemograma, Ressonância e Ultrassonografia especializem partes específicas do comportamento. Garante reutilização e padronização do fluxo dos exames, mantendo flexibilidade para variações.

---

## Equipe:
- Gabriel Manassés
- Geraldo Neto
- Flávio Henrique
- Sheila Lee

## Informações do Projeto:
- Curso: Sistemas para Internet – IFPB
- Disciplina: Padrões de Projeto de Software
- Professor: Alex Sandro da Cunha Rêgo



