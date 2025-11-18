package br.com.fiap.reskillplus.domain.repository;

import br.com.fiap.reskillplus.domain.model.Pagamento;

import java.util.List;

public interface PagamentoRepository {

    Pagamento salvar(Pagamento pagamento);

    List<Pagamento> listarTodos();

    Pagamento buscarPorId(Long id);

    Pagamento atualizarStatus(Long id, String novoStatus);

    void remover(Long id);
}
