# Pacote IO

Este pacote lida com a entrada e saída de dados, especificamente a leitura de informações de pacientes de um arquivo de texto.

## Funcionamento

- **`LeitorPacientes`:** Esta classe contém um método estático `lerPacientesDeArquivo()`.

O método recebe o caminho de um arquivo, lê cada linha e a utiliza para criar instâncias da classe `Paciente` (do pacote `modelo`). É uma classe utilitária, focada em uma única responsabilidade: carregar dados de uma fonte externa para o sistema.

Embora não implemente um padrão de projeto GoF específico, ela segue o **Princípio da Responsabilidade Única (SRP)**, isolando a lógica de leitura de arquivos do resto do sistema.
