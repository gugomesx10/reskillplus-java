package br.com.fiap.reskillplus.application;

import br.com.fiap.reskillplus.domain.model.Habilidade;
import br.com.fiap.reskillplus.domain.repository.HabilidadeRepository;
import br.com.fiap.reskillplus.domain.service.HabilidadeService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;

@ApplicationScoped
public class HabilidadeServiceImpl implements HabilidadeService {

    @Inject
    HabilidadeRepository habilidadeRepository;

    public HabilidadeServiceImpl(HabilidadeRepository habilidadeRepository) {
    }

    @Override
    public void adicionar(Habilidade habilidade) {
        habilidadeRepository.salvar(habilidade);
    }

    @Override
    public List<Habilidade> listarPorUsuario(Long usuarioId) {
        return habilidadeRepository.listarPorUsuario(usuarioId);
    }

    @Override
    public void remover(Long id) {
        habilidadeRepository.deletar(id);
    }
}
