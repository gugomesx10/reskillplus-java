package br.com.fiap.reskillplus.domain.repository;

import br.com.fiap.reskillplus.domain.model.Recomendacao;
import java.util.List;

public interface RecomendacaoRepository {
    void salvar(Recomendacao recomendacao);
    Recomendacao buscarPorId(Long id);
    List<Recomendacao> listarPorUsuario(Long usuarioId);
    void deletar(Long id);
}
