package br.com.fiap.reskillplus.domain.service;

import br.com.fiap.reskillplus.domain.model.Habilidade;
import br.com.fiap.reskillplus.domain.exception.EntidadeNaoLocalizada;

public interface HabilidadeService {
    Habilidade criarHabilidade(Habilidade habilidade);
    void editarHabilidade(Habilidade habilidade);
    Habilidade buscarHabilidade(String nome_habilidade) throws EntidadeNaoLocalizada;
    void excluirHabilidade(String nome_habilidade);
}
