package br.com.fiap.reskillplus.interfaces;

import br.com.fiap.reskillplus.domain.model.Habilidade;
import br.com.fiap.reskillplus.domain.service.HabilidadeService;
import br.com.fiap.reskillplus.domain.exception.EntidadeNaoLocalizada;

import jakarta.enterprise.inject.Vetoed;
import jakarta.inject.Inject;

@Vetoed
public class HabilidadeControllerImpl implements HabilidadeController {

    private final HabilidadeService habilidadeService;

    @Inject
    public HabilidadeControllerImpl(HabilidadeService habilidadeService) {
        this.habilidadeService = habilidadeService;
    }

    @Override
    public Habilidade criarHabilidade(Habilidade habilidade) {
        return habilidadeService.criarHabilidade(habilidade);
    }

    @Override
    public void editarHabilidade(Habilidade habilidade) {
        habilidadeService.editarHabilidade(habilidade);
    }

    @Override
    public Habilidade buscarHabilidade(String nome) throws EntidadeNaoLocalizada {
        return habilidadeService.buscarHabilidade(nome);
    }

    @Override
    public void excluirHabilidade(String nome) {
        habilidadeService.excluirHabilidade(nome);
    }
}
