package br.com.fiap.reskillplus.application;

import br.com.fiap.reskillplus.application.exceptions.PagamentoException;
import br.com.fiap.reskillplus.domain.model.Pagamento;
import br.com.fiap.reskillplus.domain.repository.PagamentoRepository;
import br.com.fiap.reskillplus.domain.service.PagamentoService;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class PagamentoServiceImpl implements PagamentoService {

    private final PagamentoRepository repository;

    public PagamentoServiceImpl(PagamentoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Pagamento pagar(Long corporacaoId, Long userId, BigDecimal quantia) {
        try {
            Pagamento pagamento = new Pagamento(
                    null,
                    corporacaoId,
                    userId,
                    quantia,
                    "PENDING",
                    LocalDateTime.now()
            );
            return repository.salvar(pagamento);

        } catch (Exception e) {
            e.printStackTrace();
            throw new PagamentoException("Erro ao processar pagamento.");
        }
    }

    @Override
    public List<Pagamento> listar() {
        return repository.listarTodos();
    }

    @Override
    public Pagamento buscar(Long id) {
        Pagamento pagamento = repository.buscarPorId(id);
        if (pagamento == null) {
            throw new PagamentoException("Pagamento não encontrado: " + id);
        }
        return pagamento;
    }

    @Override
    public Pagamento atualizarStatus(Long id, String status) {
        buscar(id);
        return repository.atualizarStatus(id, status);
    }

    @Override
    public void remover(Long id) {
        buscar(id);
        repository.remover(id);
    }
}
