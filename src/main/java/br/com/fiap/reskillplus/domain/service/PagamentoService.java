package br.com.fiap.reskillplus.domain.service;

import br.com.fiap.reskillplus.domain.model.Pagamento;

import java.math.BigDecimal;
import java.util.List;

public interface PagamentoService {
    Pagamento pagar(Long corporacaoId, Long userId, BigDecimal quantia);
    List<Pagamento> listar();
    Pagamento buscar(Long id);
    Pagamento atualizarStatus(Long id, String status);
    void remover(Long id);
}
