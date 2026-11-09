package br.edu.hospitalar.model;

import br.edu.hospitalar.model.Enums.*;

public class Quarto {
  public Long id;
  public String numero;
  public int andar;
  public int capacidadeMaxima;
  public int ocupacaoAtual;
  public SituacaoQuarto situacao = SituacaoQuarto.DISPONIVEL;
  public TipoQuarto tipo = TipoQuarto.ENFERMARIA;
  public Quarto() {}

  public boolean possuiVaga() { return ocupacaoAtual < capacidadeMaxima; }
  public void ocupar() {
    if (!possuiVaga()) throw new IllegalArgumentException("Quarto não possui capacidade disponível");
    ocupacaoAtual++;
    situacao = ocupacaoAtual >= capacidadeMaxima ? SituacaoQuarto.OCUPADO : SituacaoQuarto.DISPONIVEL;
  }
}
