# Diagrama de Classes — Sprint 2

O modelo da Sprint 2 mantém as seis classes principais da Sprint 1 e adiciona a especialização dos profissionais, as modalidades de atendimento, as situações controladas por enum e os procedimentos cirúrgicos.

```mermaid
classDiagram
  class Paciente {
    +Long id
    +String nome
    +String cpf
    +String dataNascimento
    +String telefone
    +String endereco
    +String email
  }
  class ProfissionalSaude {
    <<abstract>>
    +Long id
    +String nome
    +String registroProfissional
    +String telefone
    +String email
    +CategoriaProfissional categoria
    +String especialidade
    +podeAtenderEspecialidade()
  }
  class MedicoClinicoGeral
  class MedicoEspecialista
  class Cirurgiao
  class Consulta {
    +Long id
    +LocalDate data
    +LocalTime horario
    +ModalidadeConsulta modalidade
    +SituacaoConsulta situacao
    +PrioridadeEmergencia prioridade
    +validarModalidade()
    +alterarSituacao()
  }
  class ProcedimentoCirurgico {
    +String descricao
    +String tipoCirurgia
    +StatusProcedimento status
    +alterarStatus()
  }
  class Internacao {
    +LocalDate dataEntrada
    +LocalDate dataPrevistaAlta
    +LocalDate dataEfetivaAlta
    +boolean ativa
  }
  class Quarto {
    +String numero
    +int andar
    +int capacidadeMaxima
    +int ocupacaoAtual
    +TipoQuarto tipo
    +possuiVaga()
    +ocupar()
  }
  class CategoriaProfissional {
    <<enumeration>>
    CLINICO_GERAL
    ESPECIALISTA
    CIRURGIAO
  }
  class ModalidadeConsulta {
    <<enumeration>>
    ROTINA
    ESPECIALIZADA
    EMERGENCIA
  }
  class SituacaoConsulta {
    <<enumeration>>
    AGENDADA
    CONFIRMADA
    EM_ATENDIMENTO
    CONCLUIDA
    CANCELADA
    NAO_COMPARECEU
  }
  class PrioridadeEmergencia {
    <<enumeration>>
    BAIXA
    MODERADA
    ALTA
    CRITICA
  }
  class StatusProcedimento {
    <<enumeration>>
    AGENDADO
    EM_ANDAMENTO
    CONCLUIDO
    CANCELADO
  }
  class TipoQuarto {
    <<enumeration>>
    ENFERMARIA
    SEMI_INTENSIVO
    UTI
  }
  ProfissionalSaude <|-- MedicoClinicoGeral
  ProfissionalSaude <|-- MedicoEspecialista
  ProfissionalSaude <|-- Cirurgiao
  Paciente "1" --> "0..*" Consulta : possui
  ProfissionalSaude "1" --> "0..*" Consulta : atende
  Paciente "1" --> "0..*" Internacao : possui
  Quarto "1" --> "0..*" Internacao : recebe
  Paciente "1" --> "0..*" ProcedimentoCirurgico : realiza
  Cirurgiao "1" --> "0..*" ProcedimentoCirurgico : executa
  Consulta --> ModalidadeConsulta
  Consulta --> SituacaoConsulta
  Consulta --> PrioridadeEmergencia
  Quarto --> TipoQuarto
  ProcedimentoCirurgico --> StatusProcedimento
```

## Regras representadas

- Consultas especializadas exigem profissional com especialidade compatível.
- Emergências exigem prioridade `BAIXA`, `MODERADA`, `ALTA` ou `CRITICA`.
- O mesmo profissional não pode ter dois atendimentos no mesmo horário.
- Uma consulta concluída não retorna para agendada e uma cancelada não é concluída.
- Internações somente ocupam quartos com vaga.
- Procedimentos cirúrgicos só podem ser concluídos depois de entrarem em andamento.
