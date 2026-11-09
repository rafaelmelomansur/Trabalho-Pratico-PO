package br.edu.hospitalar.model;

public final class Enums {
  private Enums() {}

  public enum CategoriaProfissional { CLINICO_GERAL, ESPECIALISTA, CIRURGIAO }
  public enum ModalidadeConsulta { ROTINA, ESPECIALIZADA, EMERGENCIA }
  public enum SituacaoConsulta { AGENDADA, CONFIRMADA, EM_ATENDIMENTO, CONCLUIDA, CANCELADA, NAO_COMPARECEU }
  public enum PrioridadeEmergencia { BAIXA, MODERADA, ALTA, CRITICA }
  public enum StatusProcedimento { AGENDADO, EM_ANDAMENTO, CONCLUIDO, CANCELADO }
  public enum SituacaoQuarto { DISPONIVEL, OCUPADO }
  public enum TipoQuarto { ENFERMARIA, SEMI_INTENSIVO, UTI }
}
