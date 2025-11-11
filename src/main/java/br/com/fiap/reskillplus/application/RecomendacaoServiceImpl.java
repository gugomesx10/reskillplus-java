package br.com.fiap.reskillplus.application;

import br.com.fiap.reskillplus.domain.model.Recomendacao;
import br.com.fiap.reskillplus.domain.repository.RecomendacaoRepository;
import br.com.fiap.reskillplus.domain.service.RecomendacaoDomainService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;

@ApplicationScoped
public class RecomendacaoServiceImpl {

    @Inject
    RecomendacaoRepository repository;

    @Inject
    RecomendacaoDomainService domainService;

    public RecomendacaoServiceImpl(RecomendacaoRepository recomendacaoRepository) {
    }

    public void gerar(Recomendacao recomendacao, double baseScore) {
        domainService.calcularRelevancia(recomendacao, baseScore);
        repository.salvar(recomendacao);
    }

    public List<Recomendacao> listarPorUsuario(int usuarioId) {
        return repository.listarPorUsuario(usuarioId);
    }

    public List<Recomendacao> listarTodas() {
        return repository.listarTodas();
    }

    public void deletar(int id) {
        repository.deletar(id);
    }

    public Recomendacao gerar(Recomendacao entity) {
        return null;
    }
}
