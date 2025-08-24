# Pacote Seq

Este pacote contém uma classe utilitária para gerar números de sequência únicos.

## Funcionamento

- **`GeradorSequencia`:** Esta classe implementa o padrão **Singleton**.

O construtor é privado e a única maneira de obter uma instância da classe é através do método estático `getInstance()`. Isso garante que exista apenas uma instância do gerador em toda a aplicação.

A classe mantém um contador interno (`sequencia`) que é incrementado a cada chamada do método `getProximoNumero()`. Por ser um Singleton, o estado do contador é compartilhado globalmente, garantindo que cada chamada retorne um número único em toda a execução do programa.

É usado para gerar IDs únicos para pacientes e médicos na classe `LeitorPacientes`.
