package br.com.fiap.reskillplus.interfaces;

import br.com.fiap.reskillplus.domain.model.Habilidade;
import br.com.fiap.reskillplus.domain.exception.EntidadeNaoLocalizada;

public interface HabilidadeController {

    Habilidade criarHabilidade(Habilidade habilidade);
    void editarHabilidade(Habilidade habilidade);
    Habilidade buscarHabilidade(String nome) throws EntidadeNaoLocalizada;
    void excluirHabilidade(String nome);
}
