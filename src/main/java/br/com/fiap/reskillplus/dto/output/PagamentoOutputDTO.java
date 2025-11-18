package br.com.fiap.reskillplus.dto.output;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PagamentoOutputDTO {

    private Long id;
    private BigDecimal quantia;
    private String status;
    private LocalDateTime dataCriacao;

    public PagamentoOutputDTO(Long id, BigDecimal quantia,
                              String status, LocalDateTime dataCriacao) {
        this.id = id;
        this.quantia = quantia;
        this.status = status;
        this.dataCriacao = dataCriacao;
    }

    public Long getId() { return id; }
    public BigDecimal getQuantia() { return quantia; }
    public String getStatus() { return status; }
    public LocalDateTime getDataCriacao() { return dataCriacao; }
}
