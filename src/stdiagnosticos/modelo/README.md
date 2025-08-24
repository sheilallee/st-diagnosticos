# Pacote Modelo

Este pacote contém as classes de domínio principais do sistema, também conhecidas como entidades ou "modelos". Elas representam os objetos de negócio fundamentais sobre os quais o sistema opera.

## Classes Principais

- **`Paciente`:** Representa um paciente, com atributos como ID, nome e data de nascimento.
- **`Medico`:** Representa um médico, com ID, nome e especialidade.

Essas classes são usadas em todo o sistema para associar exames, laudos e diagnósticos às pessoas envolvidas.

Elas não implementam padrões de projeto complexos, pois seu objetivo principal é reter dados e fornecer uma representação orientada a objetos das entidades do mundo real.
