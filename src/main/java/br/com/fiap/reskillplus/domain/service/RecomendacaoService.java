package br.com.fiap.reskillplus.domain.service;

import br.com.fiap.reskillplus.domain.model.Recomendacao;
import br.com.fiap.reskillplus.domain.exception.EntidadeNaoLocalizada;

public interface RecomendacaoService {
    Recomendacao criarRecomendacao(Recomendacao recomendacao);
    void editarRecomendacao(Recomendacao recomendacao);
    Recomendacao buscarRecomendacao(String cpf_usuario, String nome_curso) throws EntidadeNaoLocalizada;
    void excluirRecomendacao(String cpf_usuario, String nome_curso);
}
