package br.edu.hospitalar.model;

import br.edu.hospitalar.model.Enums.CategoriaProfissional;

public class Cirurgiao extends ProfissionalSaude {
  public Cirurgiao() { categoria = CategoriaProfissional.CIRURGIAO; }
  public String registroProcedimentos() { return "Procedimentos cirúrgicos registrados por " + nome; }
}
