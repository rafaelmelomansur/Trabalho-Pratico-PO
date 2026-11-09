package br.edu.hospitalar.model;

import br.edu.hospitalar.model.Enums.CategoriaProfissional;

public class MedicoClinicoGeral extends ProfissionalSaude {
  public MedicoClinicoGeral() { categoria = CategoriaProfissional.CLINICO_GERAL; }
  public boolean podeRealizarAvaliacaoInicial() { return true; }
}
