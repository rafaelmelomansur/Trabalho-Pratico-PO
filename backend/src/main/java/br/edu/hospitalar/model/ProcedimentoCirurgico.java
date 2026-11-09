package br.edu.hospitalar.model;

import br.edu.hospitalar.model.Enums.StatusProcedimento;
import java.time.LocalDateTime;

public class ProcedimentoCirurgico {
  public Long id;
  public Long pacienteId;
  public Long cirurgiaoId;
  public String descricao;
  public String tipoCirurgia;
  public String observacoesPreOperatorias;
  public String observacoesPosOperatorias;
  public LocalDateTime dataHoraPrevista;
  public LocalDateTime dataHoraEfetiva;
  public StatusProcedimento status = StatusProcedimento.AGENDADO;
  public ProcedimentoCirurgico() {}

  public void alterarStatus(StatusProcedimento novoStatus) {
    if (novoStatus == StatusProcedimento.CONCLUIDO && dataHoraEfetiva == null) {
      throw new IllegalArgumentException("Procedimento só pode ser concluído depois de iniciado");
    }
    if (status == StatusProcedimento.CANCELADO && novoStatus == StatusProcedimento.CONCLUIDO) {
      throw new IllegalArgumentException("Procedimento cancelado não pode ser concluído");
    }
    if (novoStatus == StatusProcedimento.EM_ANDAMENTO && dataHoraEfetiva == null) dataHoraEfetiva = LocalDateTime.now();
    status = novoStatus;
  }
}
