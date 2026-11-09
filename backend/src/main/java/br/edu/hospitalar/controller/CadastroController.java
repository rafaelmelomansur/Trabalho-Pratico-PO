package br.edu.hospitalar.controller;

import br.edu.hospitalar.model.*;
import br.edu.hospitalar.service.HospitalarService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CadastroController {
  private final HospitalarService service;
  public CadastroController(HospitalarService service) { this.service = service; }
  @GetMapping("/pacientes") public List<Paciente> pacientes() { return service.pacientes(); }
  @GetMapping("/pacientes/{id}") public Paciente paciente(@PathVariable Long id) { return service.paciente(id); }
  @PostMapping("/pacientes") public Paciente criarPaciente(@RequestBody Paciente p) { return service.criarPaciente(p); }
  @GetMapping("/profissionais") public List<ProfissionalSaude> profissionais() { return service.profissionais(); }
  @GetMapping("/profissionais/{id}") public ProfissionalSaude profissional(@PathVariable Long id) { return service.profissional(id); }
  @PostMapping("/profissionais") public ProfissionalSaude criarProfissional(@RequestBody ProfissionalSaude p) { return service.criarProfissional(p); }
}
