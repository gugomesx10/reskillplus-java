package br.com.fiap.reskillplus.domain.repository;

import br.com.fiap.reskillplus.domain.model.Matricula;
import java.util.List;

public interface MatriculaRepository {

    void salvar(Matricula matricula);
    void atualizarProgresso(int id, boolean concluido);
    void deletar(int id);
    Matricula buscarPorId(int id);
    List<Matricula> listarPorUsuario(int usuarioId);
    List<Matricula> listarTodas();
}
