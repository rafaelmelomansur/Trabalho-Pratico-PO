package br.edu.hospitalar.model;

import br.edu.hospitalar.model.Enums.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class Consulta {
  public Long id;
  public Long pacienteId;
  public Long profissionalId;
  public LocalDate data;
  public LocalTime horario;
  public ModalidadeConsulta modalidade;
  public String motivo;
  public String especialidade;
  public PrioridadeEmergencia prioridade;
  public String observacoes;
  public SituacaoConsulta situacao = SituacaoConsulta.AGENDADA;

  public Consulta() {}

  public void validarModalidade() {
    if (modalidade == null) throw new IllegalArgumentException("A modalidade da consulta é obrigatória");
    if (modalidade == ModalidadeConsulta.EMERGENCIA && prioridade == null) {
      throw new IllegalArgumentException("Atendimento de emergência exige prioridade");
    }
    if (modalidade == ModalidadeConsulta.ESPECIALIZADA && (especialidade == null || especialidade.isBlank())) {
      throw new IllegalArgumentException("Consulta especializada exige especialidade");
    }
  }

  public void alterarSituacao(SituacaoConsulta nova) {
    if (nova == null) throw new IllegalArgumentException("A situação é obrigatória");
    if (situacao == SituacaoConsulta.CONCLUIDA && nova != SituacaoConsulta.CONCLUIDA) {
      throw new IllegalArgumentException("Consulta concluída não pode voltar para uma situação anterior");
    }
    if (situacao == SituacaoConsulta.CANCELADA && nova == SituacaoConsulta.CONCLUIDA) {
      throw new IllegalArgumentException("Consulta cancelada não pode ser concluída sem novo agendamento");
    }
    situacao = nova;
  }
}
