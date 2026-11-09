package br.edu.hospitalar.service;

import br.edu.hospitalar.model.*;
import br.edu.hospitalar.model.Enums.*;
import br.edu.hospitalar.repository.Repositories;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class HospitalarService {
  public HospitalarService() {
    if (Repositories.pacientes.all().isEmpty()) {
      Paciente p = new Paciente(Repositories.pacientes.nextId(), "Marina Alves", "000.000.000-01", "1990-04-12", "(11) 98842-0192", "Rua A, 10", "marina@email.com");
      Repositories.pacientes.put(p.id, p);
      ProfissionalSaude prof = new ProfissionalSaude();
      prof.id = Repositories.profissionais.nextId(); prof.nome = "Dra. Helena Martins"; prof.registroProfissional = "CRM 10234"; prof.categoria = CategoriaProfissional.ESPECIALISTA; prof.especialidade = "Cardiologia";
      Repositories.profissionais.put(prof.id, prof);
      Quarto quarto = new Quarto(); quarto.id = Repositories.quartos.nextId(); quarto.numero = "201"; quarto.andar = 2; quarto.capacidadeMaxima = 4; quarto.tipo = TipoQuarto.ENFERMARIA;
      Repositories.quartos.put(quarto.id, quarto);
    }
  }

  public List<Paciente> pacientes() { return Repositories.pacientes.all(); }
  public Paciente paciente(Long id) { return Repositories.pacientes.find(id).orElseThrow(() -> notFound("Paciente não encontrado")); }
  public Paciente criarPaciente(Paciente p) { p.id = Repositories.pacientes.nextId(); Repositories.pacientes.put(p.id, p); return p; }

  public List<ProfissionalSaude> profissionais() { return Repositories.profissionais.all(); }
  public ProfissionalSaude profissional(Long id) { return Repositories.profissionais.find(id).orElseThrow(() -> notFound("Profissional não encontrado")); }
  public ProfissionalSaude criarProfissional(ProfissionalSaude p) {
    if (p.categoria == null) throw new IllegalArgumentException("Categoria profissional é obrigatória");
    if (p.categoria == CategoriaProfissional.ESPECIALISTA && (p.especialidade == null || p.especialidade.isBlank())) throw new IllegalArgumentException("Especialista deve informar especialidade");
    p.id = Repositories.profissionais.nextId(); Repositories.profissionais.put(p.id, p); return p;
  }

  public List<Consulta> consultas() { return Repositories.consultas.all(); }
  public Consulta consulta(Long id) { return Repositories.consultas.find(id).orElseThrow(() -> notFound("Consulta não encontrada")); }
  public Consulta criarConsulta(Consulta c) {
    paciente(c.pacienteId); ProfissionalSaude prof = profissional(c.profissionalId); c.validarModalidade();
    if (c.data == null || c.horario == null) throw new IllegalArgumentException("Data e horário são obrigatórios");
    if (c.modalidade == ModalidadeConsulta.ESPECIALIZADA && !prof.podeAtenderEspecialidade(c.especialidade)) throw new IllegalArgumentException("Profissional não possui especialidade compatível");
    boolean conflito = consultas().stream().anyMatch(x -> x.profissionalId.equals(c.profissionalId) && x.data.equals(c.data) && x.horario.equals(c.horario) && x.situacao != SituacaoConsulta.CANCELADA);
    if (conflito) throw new IllegalArgumentException("Profissional já possui atendimento nesse horário");
    c.id = Repositories.consultas.nextId(); Repositories.consultas.put(c.id, c); return c;
  }
  public Consulta alterarSituacao(Long id, SituacaoConsulta nova) { Consulta c = consulta(id); c.alterarSituacao(nova); return c; }

  public List<Internacao> internacoes() { return Repositories.internacoes.all(); }
  public Internacao criarInternacao(Internacao i) {
    paciente(i.pacienteId); profissional(i.profissionalId); Quarto q = quarto(i.quartoId);
    if (!q.possuiVaga()) throw new IllegalArgumentException("Quarto não possui capacidade disponível");
    q.ocupar(); i.id = Repositories.internacoes.nextId(); Repositories.internacoes.put(i.id, i); return i;
  }

  public List<Quarto> quartos() { return Repositories.quartos.all(); }
  public Quarto quarto(Long id) { return Repositories.quartos.find(id).orElseThrow(() -> notFound("Quarto não encontrado")); }
  public Quarto criarQuarto(Quarto q) { if (q.capacidadeMaxima <= 0) throw new IllegalArgumentException("Capacidade máxima deve ser maior que zero"); q.id = Repositories.quartos.nextId(); Repositories.quartos.put(q.id, q); return q; }

  public List<ProcedimentoCirurgico> procedimentos() { return Repositories.procedimentos.all(); }
  public ProcedimentoCirurgico criarProcedimento(ProcedimentoCirurgico p) {
    paciente(p.pacienteId); profissional(p.cirurgiaoId); if (p.descricao == null || p.descricao.isBlank()) throw new IllegalArgumentException("Descrição do procedimento é obrigatória");
    p.id = Repositories.procedimentos.nextId(); Repositories.procedimentos.put(p.id, p); return p;
  }
  public ProcedimentoCirurgico alterarProcedimento(Long id, StatusProcedimento status) { ProcedimentoCirurgico p = procedimentos().stream().filter(x -> x.id.equals(id)).findFirst().orElseThrow(() -> notFound("Procedimento não encontrado")); p.alterarStatus(status); return p; }

  private RuntimeException notFound(String message) { return new IllegalArgumentException(message); }
}
