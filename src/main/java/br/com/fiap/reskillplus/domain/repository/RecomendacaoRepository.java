package br.com.fiap.reskillplus.domain.repository;

import br.com.fiap.reskillplus.domain.model.Recomendacao;
import java.util.List;

public interface RecomendacaoRepository {

    void salvar(Recomendacao recomendacao);
    void deletar(int id);
    List<Recomendacao> listarPorUsuario(int usuarioId);
    List<Recomendacao> listarTodas();
}
