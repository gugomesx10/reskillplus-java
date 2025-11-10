package br.com.fiap.reskillplus.interfaces;

import br.com.fiap.reskillplus.domain.model.Habilidade;
import java.util.List;

public interface HabilidadeController {
    void adicionar(Habilidade habilidade);
    List<Habilidade> listarPorUsuario(Long usuarioId);
}
