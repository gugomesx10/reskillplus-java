package br.com.fiap.reskillplus.domain.service;

import br.com.fiap.reskillplus.domain.model.Habilidade;
import java.util.List;

public interface HabilidadeService {
    void cadastrar(Habilidade habilidade);
    List<Habilidade> listarPorUsuario(Long usuarioId);
    void atualizar(Habilidade habilidade);
    void remover(Long id);
}
