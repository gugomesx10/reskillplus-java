package br.com.fiap.reskillplus.domain.repository;

import br.com.fiap.reskillplus.domain.model.Recomendacao;
import br.com.fiap.reskillplus.domain.exception.EntidadeNaoLocalizada;

import java.util.List;

public interface RecomendacaoRepository {

    Recomendacao criarRecomendacao(Recomendacao recomendacao);
    void editarRecomendacao(Recomendacao recomendacao);
    Recomendacao buscarRecomendacao(String cpf, String nomeCurso) throws EntidadeNaoLocalizada;
    void excluirRecomendacao(String cpf, String nomeCurso);
    List<Recomendacao> listarRecomendacoesPorUsuario(String cpf);
}
