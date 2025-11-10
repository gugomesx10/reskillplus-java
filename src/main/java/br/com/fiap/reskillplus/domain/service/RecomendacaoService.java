package br.com.fiap.reskillplus.domain.service;

import br.com.fiap.reskillplus.domain.model.Recomendacao;
import java.util.List;

public interface RecomendacaoService {
    void gerar(Recomendacao recomendacao);
    List<Recomendacao> listarPorUsuario(Long usuarioId);
    void deletar(Long id);
}
