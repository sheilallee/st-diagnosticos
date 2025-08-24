# Pacote Notificacao

Este pacote implementa um sistema de notificações para informar as partes interessadas sobre eventos importantes, como a emissão de um laudo.

## Padrões Implementados

### Observer

O padrão **Observer** é o coração deste pacote.

- **`GerenciadorNotificacao` (Subject/Observable):** É a classe central que mantém uma lista de observadores (`Listener`). Ela fornece métodos para `inscrever()` e `desinscrever()` ouvintes. O método `notificar()` é chamado quando um evento ocorre (neste caso, a emissão de um laudo), e ele itera sobre todos os ouvintes inscritos, chamando seu método `update()`.
- **`Listener` (Observer):** A interface que define o método `update()`, que será implementado por todas as classes que desejam ser notificadas.
- **`Medico`, `Paciente` (Concrete Observers):** Embora localizadas no pacote `modelo`, essas classes implementam a interface `Listener`. Isso permite que instâncias de `Medico` e `Paciente` se inscrevam diretamente no `GerenciadorNotificacao` para serem notificadas quando um laudo que lhes diz respeito for emitido.

Este padrão desacopla o emissor do evento (o código que gera o laudo) dos receptores da notificação (médicos, pacientes, etc.), permitindo adicionar novos tipos de notificadores sem alterar o código do gerenciador.
