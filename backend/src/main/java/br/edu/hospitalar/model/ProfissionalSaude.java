package br.edu.hospitalar.model;

import br.edu.hospitalar.model.Enums.CategoriaProfissional;

public class ProfissionalSaude {
  public Long id;
  public String nome;
  public String registroProfissional;
  public String telefone;
  public String email;
  public CategoriaProfissional categoria;
  public String especialidade;

  public ProfissionalSaude() {}
  public boolean podeAtenderEspecialidade(String solicitada) {
    return categoria == CategoriaProfissional.CLINICO_GERAL ||
      (especialidade != null && solicitada != null && especialidade.equalsIgnoreCase(solicitada));
  }
}
