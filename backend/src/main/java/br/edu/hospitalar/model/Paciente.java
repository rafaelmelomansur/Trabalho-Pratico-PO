package br.edu.hospitalar.model;

public class Paciente {
  public Long id;
  public String nome;
  public String cpf;
  public String dataNascimento;
  public String telefone;
  public String endereco;
  public String email;

  public Paciente() {}
  public Paciente(Long id, String nome, String cpf, String dataNascimento, String telefone, String endereco, String email) {
    this.id = id; this.nome = nome; this.cpf = cpf; this.dataNascimento = dataNascimento;
    this.telefone = telefone; this.endereco = endereco; this.email = email;
  }
}
