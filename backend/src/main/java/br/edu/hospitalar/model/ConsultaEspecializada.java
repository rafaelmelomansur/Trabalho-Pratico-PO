package br.edu.hospitalar.model;

import br.edu.hospitalar.model.Enums.ModalidadeConsulta;

public class ConsultaEspecializada extends Consulta {
  public ConsultaEspecializada() { modalidade = ModalidadeConsulta.ESPECIALIZADA; }
  @Override public void validarModalidade() {
    if (especialidade == null || especialidade.isBlank()) throw new IllegalArgumentException("Consulta especializada exige especialidade");
  }
}
