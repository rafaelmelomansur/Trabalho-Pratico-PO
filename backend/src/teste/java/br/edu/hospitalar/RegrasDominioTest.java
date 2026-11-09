package br.edu.hospitalar;

import br.edu.hospitalar.model.*;
import br.edu.hospitalar.model.Enums.*;
import org.junit.jupiter.api.Test;
import java.time.*;
import static org.junit.jupiter.api.Assertions.*;

class RegrasDominioTest {
  @Test void emergenciaExigePrioridade() {
    Consulta c = new Consulta(); c.modalidade = ModalidadeConsulta.EMERGENCIA;
    assertThrows(IllegalArgumentException.class, c::validarModalidade);
  }
  @Test void consultaConcluidaNaoVoltaParaAgendada() {
    Consulta c = new Consulta(); c.situacao = SituacaoConsulta.CONCLUIDA;
    assertThrows(IllegalArgumentException.class, () -> c.alterarSituacao(SituacaoConsulta.AGENDADA));
  }
  @Test void quartoNaoUltrapassaCapacidade() {
    Quarto q = new Quarto(); q.capacidadeMaxima = 1; q.ocupar();
    assertFalse(q.possuiVaga()); assertThrows(IllegalArgumentException.class, q::ocupar);
  }
  @Test void procedimentoNaoConcluiSemInicio() {
    ProcedimentoCirurgico p = new ProcedimentoCirurgico();
    assertThrows(IllegalArgumentException.class, () -> p.alterarStatus(StatusProcedimento.CONCLUIDO));
    p.alterarStatus(StatusProcedimento.EM_ANDAMENTO);
    p.alterarStatus(StatusProcedimento.CONCLUIDO);
    assertEquals(StatusProcedimento.CONCLUIDO, p.status);
  }
  @Test void consultaEspecializadaExigeEspecialidade() {
    Consulta c = new Consulta(); c.modalidade = ModalidadeConsulta.ESPECIALIZADA;
    assertThrows(IllegalArgumentException.class, c::validarModalidade);
  }
}
