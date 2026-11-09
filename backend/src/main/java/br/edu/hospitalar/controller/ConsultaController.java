package br.edu.hospitalar.controller;

import br.edu.hospitalar.model.Consulta;
import br.edu.hospitalar.model.Enums.SituacaoConsulta;
import br.edu.hospitalar.service.HospitalarService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {
  private final HospitalarService service;
  public ConsultaController(HospitalarService service) { this.service = service; }
  @GetMapping public List<Consulta> listar() { return service.consultas(); }
  @GetMapping("/{id}") public Consulta buscar(@PathVariable Long id) { return service.consulta(id); }
  @PostMapping public Consulta criar(@RequestBody Consulta consulta) { return service.criarConsulta(consulta); }
  @PatchMapping("/{id}/situacao") public Consulta alterarSituacao(@PathVariable Long id, @RequestParam SituacaoConsulta valor) { return service.alterarSituacao(id, valor); }
}
