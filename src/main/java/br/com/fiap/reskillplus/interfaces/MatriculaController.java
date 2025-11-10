package br.com.fiap.reskillplus.interfaces;

import br.com.fiap.reskillplus.domain.model.Matricula;
import java.util.List;

public interface MatriculaController {
    void matricular(Matricula matricula);
    List<Matricula> listarPorUsuario(Long usuarioId);
    void atualizarProgresso(Long id, Integer progresso);
}
