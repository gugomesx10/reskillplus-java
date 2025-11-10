package br.com.fiap.reskillplus.domain.service;

import br.com.fiap.reskillplus.domain.model.Habilidade;
import java.util.List;

public interface HabilidadeService {

    void adicionar(Habilidade habilidade);

    List<Habilidade> listarPorUsuario(Long usuarioId);

    void remover(Long id);
}
