package br.com.fiap.reskillplus.domain.repository;

import br.com.fiap.reskillplus.domain.model.Habilidade;
import java.util.List;

public interface HabilidadeRepository {
    void salvar(Habilidade habilidade);
    Habilidade buscarPorId(Long id);
    List<Habilidade> listarPorUsuario(Long usuarioId);
    void atualizar(Habilidade habilidade);
    void deletar(Long id);
}
