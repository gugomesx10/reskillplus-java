package br.com.fiap.reskillplus.interfaces;

import br.com.fiap.reskillplus.domain.model.Recomendacao;
import br.com.fiap.reskillplus.domain.exception.EntidadeNaoLocalizada;

public interface RecomendacaoController {

    Recomendacao criarRecomendacao(Recomendacao recomendacao);
    void editarRecomendacao(Recomendacao recomendacao);
    Recomendacao buscarRecomendacao(String cpf, String curso) throws EntidadeNaoLocalizada;
    void excluirRecomendacao(String cpf, String curso);
}
