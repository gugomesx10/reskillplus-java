package br.com.fiap.reskillplus.application;

import br.com.fiap.reskillplus.application.exceptions.RecomendacaoJaExisteException;
import br.com.fiap.reskillplus.domain.exception.EntidadeNaoLocalizada;
import br.com.fiap.reskillplus.domain.model.Recomendacao;
import br.com.fiap.reskillplus.domain.repository.RecomendacaoRepository;
import br.com.fiap.reskillplus.domain.service.RecomendacaoService;

public class RecomendacaoServiceImpl implements RecomendacaoService {

    private final RecomendacaoRepository recomendacaoRepository;

    public RecomendacaoServiceImpl(RecomendacaoRepository recomendacaoRepository) {
        this.recomendacaoRepository = recomendacaoRepository;
    }

    @Override
    public Recomendacao criarRecomendacao(Recomendacao recomendacao) {
        try {
            buscarRecomendacao(recomendacao.getCpf_usuario(), recomendacao.getNome_curso());
            throw new RecomendacaoJaExisteException("Recomendação já existe");
        } catch (EntidadeNaoLocalizada e) {
            return recomendacaoRepository.criarRecomendacao(recomendacao);
        }
    }

    @Override
    public void editarRecomendacao(Recomendacao recomendacao) {
        try {
            buscarRecomendacao(recomendacao.getCpf_usuario(), recomendacao.getNome_curso());
            recomendacaoRepository.editarRecomendacao(recomendacao);
        } catch (EntidadeNaoLocalizada e) {
            throw new RuntimeException("Recomendação não encontrada");
        }
    }

    @Override
    public Recomendacao buscarRecomendacao(String cpf, String curso) throws EntidadeNaoLocalizada {
        return recomendacaoRepository.buscarRecomendacao(cpf, curso);
    }

    @Override
    public void excluirRecomendacao(String cpf, String curso) {
        try {
            buscarRecomendacao(cpf, curso);
            recomendacaoRepository.excluirRecomendacao(cpf, curso);
        } catch (EntidadeNaoLocalizada e) {
            throw new RuntimeException("Recomendação não encontrada");
        }
    }
}
