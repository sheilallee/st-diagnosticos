# Pacote Fila

Este pacote gerencia a ordem em que os exames clínicos são processados, utilizando uma fila de prioridade.

## Estrutura e Padrões

### Priority Queue

- **`FilaExames`:** Esta classe encapsula uma `PriorityBlockingQueue` do Java. Ela não é um padrão de projeto GoF clássico, mas uma estrutura de dados fundamental usada para gerenciar a ordem dos exames.
- **`ComparadorExames`:** Implementa a interface `Comparator` para definir a lógica de priorização. No caso, exames de Raio-X têm prioridade sobre os demais.

O uso dessa estrutura garante que os exames mais urgentes (conforme definido pelo comparador) sejam processados primeiro.

## Funcionamento

1.  A `FilaExames` é instanciada com o `ComparadorExames`.
2.  Exames são adicionados à fila usando o método `adicionar()`.
3.  A fila interna automaticamente organiza os exames com base na lógica do comparador.
4.  O método `processarProximo()` retira e retorna o exame de maior prioridade da fila.
