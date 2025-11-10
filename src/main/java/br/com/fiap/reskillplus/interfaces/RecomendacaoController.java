package br.com.fiap.reskillplus.interfaces;

import br.com.fiap.reskillplus.domain.model.Recomendacao;
import java.util.List;

public interface RecomendacaoController {
    void gerar(Recomendacao recomendacao);
    List<Recomendacao> listarPorUsuario(Long usuarioId);
}
