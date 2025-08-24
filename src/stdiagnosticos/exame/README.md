# Pacote Exame

Este pacote é central para a criação e manipulação dos diferentes tipos de exames clínicos no sistema.

## Padrões Implementados

### Factory Method

O padrão **Factory Method** é a base deste pacote.

- **`CriadorExame` (Interface):** Define o método `criar()` que as subclasses devem implementar para instanciar um tipo de exame específico.
- **`CriadorHemograma`, `CriadorRessonancia`, `CriadorRaioX` (Classes Concretas):** São as fábricas concretas. Cada uma é responsável por criar um objeto de exame correspondente (`HemogramaEx`, `RessonanciaEx`, `RaioXEx`).

Isso permite que o código cliente (como a `Main`) crie exames sem estar acoplado às classes concretas de cada um, facilitando a adição de novos tipos de exame no futuro.

## Classes Principais

- **`ExameClinico` (Interface):** Define o contrato comum para todos os tipos de exames, garantindo que todos tenham métodos essenciais como `getTipoExame()`, `getPaciente()`, etc.
- **`HemogramaEx`, `RessonanciaEx`, `RaioXEx` (Classes Concretas):** Representam os tipos de exames específicos, cada um com seus próprios atributos e dados.
