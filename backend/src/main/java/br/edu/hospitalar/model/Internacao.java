package br.edu.hospitalar.model;

import java.time.LocalDate;

public class Internacao {
  public Long id;
  public Long pacienteId;
  public Long profissionalId;
  public Long quartoId;
  public LocalDate dataEntrada;
  public LocalDate dataPrevistaAlta;
  public LocalDate dataEfetivaAlta;
  public String observacoes;
  public boolean ativa = true;
  public Internacao() {}
}
