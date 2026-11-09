package br.edu.hospitalar.model;

import br.edu.hospitalar.model.Enums.*;

public class AtendimentoEmergencia extends Consulta {
  public AtendimentoEmergencia() { modalidade = ModalidadeConsulta.EMERGENCIA; }
  @Override public void validarModalidade() {
    if (prioridade == null) throw new IllegalArgumentException("Atendimento de emergência exige prioridade");
  }
}
