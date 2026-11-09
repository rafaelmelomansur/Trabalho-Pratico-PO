package br.edu.hospitalar.repository;

import br.edu.hospitalar.model.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class Repositories {
  public static final Store<Paciente> pacientes = new Store<>();
  public static final Store<ProfissionalSaude> profissionais = new Store<>();
  public static final Store<Consulta> consultas = new Store<>();
  public static final Store<Internacao> internacoes = new Store<>();
  public static final Store<Quarto> quartos = new Store<>();
  public static final Store<ProcedimentoCirurgico> procedimentos = new Store<>();

  public static class Store<T> {
    private final Map<Long, T> values = new LinkedHashMap<>();
    private final AtomicLong sequence = new AtomicLong();
    public synchronized T save(Long id, T value) { values.put(id == null ? sequence.incrementAndGet() : id, value); return value; }
    public synchronized Optional<T> find(Long id) { return Optional.ofNullable(values.get(id)); }
    public synchronized List<T> all() { return new ArrayList<>(values.values()); }
    public synchronized long nextId() { return sequence.incrementAndGet(); }
    public synchronized void put(Long id, T value) { values.put(id, value); }
  }
}
