package br.com.fiap.reskillplus.interfaces;

import br.com.fiap.reskillplus.domain.model.Curso;
import java.util.List;

public interface CursoController {
    void criarCurso(Curso curso);
    List<Curso> listarCursos();
    Curso buscarPorId(Long id);
    void deletarCurso(Long id);
}
