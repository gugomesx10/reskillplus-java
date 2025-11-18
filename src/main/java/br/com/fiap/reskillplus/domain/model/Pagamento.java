package br.com.fiap.reskillplus.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Pagamento {

    private Long id;
    private Long corporacaoId;
    private Long userId;
    private BigDecimal quantia;
    private String status; // PENDING, COMPLETED, FAILED
    private LocalDateTime dataCriacao = LocalDateTime.now();

    public Pagamento() {}

    public Pagamento(Long id, Long corporacaoId, Long userId,
                     BigDecimal quantia, String status, LocalDateTime dataCriacao) {
        this.id = id;
        this.corporacaoId = corporacaoId;
        this.userId = userId;
        this.quantia = quantia;
        this.status = status;
        this.dataCriacao = dataCriacao;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getCorporacaoId() { return corporacaoId; }
    public void setCorporacaoId(Long corporacaoId) { this.corporacaoId = corporacaoId; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public BigDecimal getQuantia() { return quantia; }
    public void setQuantia(BigDecimal quantia) { this.quantia = quantia; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getDataCriacao() { return dataCriacao; }
    public void setDataCriacao(LocalDateTime dataCriacao) { this.dataCriacao = dataCriacao; }
}
