package br.com.fiap.reskillplus.domain.repository;

import br.com.fiap.reskillplus.domain.model.Habilidade;
import java.util.List;

public interface HabilidadeRepository {

    void salvar(Habilidade habilidade);
    void atualizar(Habilidade habilidade);
    void deletar(int id);
    Habilidade buscarPorId(int id);
    List<Habilidade> listarTodas();
}
