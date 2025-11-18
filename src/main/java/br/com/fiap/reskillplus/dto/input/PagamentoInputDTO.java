package br.com.fiap.reskillplus.dto.input;

import java.math.BigDecimal;

public class PagamentoInputDTO {

    private Long corporacaoId;
    private Long userId;
    private BigDecimal quantia;

    public Long getCorporacaoId() { return corporacaoId; }
    public void setCorporacaoId(Long corporacaoId) { this.corporacaoId = corporacaoId; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public BigDecimal getQuantia() { return quantia; }
    public void setQuantia(BigDecimal quantia) { this.quantia = quantia; }
}
