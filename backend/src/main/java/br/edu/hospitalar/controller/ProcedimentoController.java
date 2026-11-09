package br.edu.hospitalar.controller;

import br.edu.hospitalar.model.Enums.StatusProcedimento;
import br.edu.hospitalar.model.ProcedimentoCirurgico;
import br.edu.hospitalar.service.HospitalarService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/procedimentos-cirurgicos")
public class ProcedimentoController {
  private final HospitalarService service;
  public ProcedimentoController(HospitalarService service) { this.service = service; }
  @GetMapping public List<ProcedimentoCirurgico> listar() { return service.procedimentos(); }
  @PostMapping public ProcedimentoCirurgico criar(@RequestBody ProcedimentoCirurgico p) { return service.criarProcedimento(p); }
  @PatchMapping("/{id}/status") public ProcedimentoCirurgico status(@PathVariable Long id, @RequestParam StatusProcedimento valor) { return service.alterarProcedimento(id, valor); }
}
