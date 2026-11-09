package br.edu.hospitalar.model;

import br.edu.hospitalar.model.Enums.CategoriaProfissional;

public class MedicoEspecialista extends ProfissionalSaude {
  public MedicoEspecialista() { categoria = CategoriaProfissional.ESPECIALISTA; }
  public boolean atendeSuaEspecialidade(String solicitada) { return podeAtenderEspecialidade(solicitada); }
}
