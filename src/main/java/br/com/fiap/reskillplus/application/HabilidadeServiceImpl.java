package br.com.fiap.reskillplus.application;

import br.com.fiap.reskillplus.application.exceptions.HabilidadeJaExisteException;
import br.com.fiap.reskillplus.domain.exception.EntidadeNaoLocalizada;
import br.com.fiap.reskillplus.domain.model.Habilidade;
import br.com.fiap.reskillplus.domain.repository.HabilidadeRepository;
import br.com.fiap.reskillplus.domain.service.HabilidadeService;

public class HabilidadeServiceImpl implements HabilidadeService {

    private final HabilidadeRepository habilidadeRepository;

    public HabilidadeServiceImpl(HabilidadeRepository habilidadeRepository) {
        this.habilidadeRepository = habilidadeRepository;
    }

    @Override
    public Habilidade criarHabilidade(Habilidade habilidade) {
        try {
            buscarHabilidade(habilidade.getNome_habilidade());
            throw new HabilidadeJaExisteException("Habilidade já cadastrada");
        } catch (EntidadeNaoLocalizada e) {
            return habilidadeRepository.criarHabilidade(habilidade);
        }
    }

    @Override
    public void editarHabilidade(Habilidade habilidade) {
        try {
            buscarHabilidade(habilidade.getNome_habilidade());
            habilidadeRepository.editarHabilidade(habilidade);
        } catch (EntidadeNaoLocalizada e) {
            throw new RuntimeException("Habilidade não encontrada");
        }
    }

    @Override
    public Habilidade buscarHabilidade(String nome) throws EntidadeNaoLocalizada {
        return habilidadeRepository.buscarHabilidade(nome);
    }

    @Override
    public void excluirHabilidade(String nome) {
        try {
            buscarHabilidade(nome);
            habilidadeRepository.excluirHabilidade(nome);
        } catch (EntidadeNaoLocalizada e) {
            throw new RuntimeException("Habilidade não encontrada");
        }
    }
}
