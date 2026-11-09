package br.edu.hospitalar.model;

import br.edu.hospitalar.model.Enums.ModalidadeConsulta;

public class ConsultaRotina extends Consulta {
  public ConsultaRotina() { modalidade = ModalidadeConsulta.ROTINA; }
  @Override public void validarModalidade() {
    if (motivo == null || motivo.isBlank()) throw new IllegalArgumentException("Consulta de rotina exige motivo");
  }
}
