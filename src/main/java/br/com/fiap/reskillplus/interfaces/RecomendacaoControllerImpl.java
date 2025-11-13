package br.com.fiap.reskillplus.interfaces;

import br.com.fiap.reskillplus.domain.model.Recomendacao;
import br.com.fiap.reskillplus.domain.service.RecomendacaoService;
import br.com.fiap.reskillplus.domain.exception.EntidadeNaoLocalizada;

import jakarta.enterprise.inject.Vetoed;
import jakarta.inject.Inject;

@Vetoed
public class RecomendacaoControllerImpl implements RecomendacaoController {

    private final RecomendacaoService recomendacaoService;

    @Inject
    public RecomendacaoControllerImpl(RecomendacaoService recomendacaoService) {
        this.recomendacaoService = recomendacaoService;
    }

    @Override
    public Recomendacao criarRecomendacao(Recomendacao recomendacao) {
        return recomendacaoService.criarRecomendacao(recomendacao);
    }

    @Override
    public void editarRecomendacao(Recomendacao recomendacao) {
        recomendacaoService.editarRecomendacao(recomendacao);
    }

    @Override
    public Recomendacao buscarRecomendacao(String cpf, String curso)
            throws EntidadeNaoLocalizada {
        return recomendacaoService.buscarRecomendacao(cpf, curso);
    }

    @Override
    public void excluirRecomendacao(String cpf, String curso) {
        recomendacaoService.excluirRecomendacao(cpf, curso);
    }
}
