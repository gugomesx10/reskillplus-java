package br.com.fiap.reskillplus.domain.repository;

import br.com.fiap.reskillplus.domain.model.Matricula;
import java.util.List;

public interface MatriculaRepository {
    void salvar(Matricula matricula);
    Matricula buscarPorId(Long id);
    List<Matricula> listarPorUsuario(Long usuarioId);
    List<Matricula> listarPorCurso(Long cursoId);
    void atualizar(Matricula matricula);
    void deletar(Long id);
}
