# Pacote Validacao

Este pacote é responsável por validar os dados dos exames antes que eles sejam processados, utilizando uma cadeia de regras de validação.

## Padrões Implementados

### Chain of Responsibility

O padrão **Chain of Responsibility** é a espinha dorsal deste pacote.

- **`RegraValidadora` (Handler):** É uma classe abstrata que define a estrutura de cada elo da cadeia. Ela contém uma referência para a `proxima` regra na cadeia e um método abstrato `validar()` que as subclasses devem implementar.
- **`ValidaDadosPaciente`, `ValidaDadosMedico`, `ValidaLaudo` (Concrete Handlers):** Cada uma dessas classes é uma regra de validação específica. Elas implementam o método `validar()` com sua própria lógica (ex: verificar se o paciente não é nulo). Se a validação passar, a classe chama o método `validar()` da próxima regra na cadeia (`proxima.validar()`), passando a responsabilidade adiante.

## Funcionamento

1.  Na `Main`, as regras são instanciadas e encadeadas umas às outras usando o método `setProxima()`.
2.  O método `validar()` da primeira regra na cadeia é chamado.
3.  O exame passa por cada regra em sequência. Se uma regra falhar, ela lança uma `RuntimeException`, interrompendo o fluxo. Se todas as regras passarem, o processo é concluído com sucesso.

Isso cria um pipeline de validação flexível, onde é fácil adicionar, remover ou reordenar as regras sem alterar o código que inicia o processo.
