package br.edu.hospitalar.controller;

import br.edu.hospitalar.model.*;
import br.edu.hospitalar.service.HospitalarService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class InternacaoQuartoController {
  private final HospitalarService service;
  public InternacaoQuartoController(HospitalarService service) { this.service = service; }
  @GetMapping("/internacoes") public List<Internacao> internacoes() { return service.internacoes(); }
  @PostMapping("/internacoes") public Internacao criarInternacao(@RequestBody Internacao i) { return service.criarInternacao(i); }
  @GetMapping("/quartos") public List<Quarto> quartos() { return service.quartos(); }
  @GetMapping("/quartos/{id}") public Quarto quarto(@PathVariable Long id) { return service.quarto(id); }
  @PostMapping("/quartos") public Quarto criarQuarto(@RequestBody Quarto q) { return service.criarQuarto(q); }
}
