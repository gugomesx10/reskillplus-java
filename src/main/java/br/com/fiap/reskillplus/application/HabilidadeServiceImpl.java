package br.com.fiap.reskillplus.application;

import br.com.fiap.reskillplus.domain.model.Habilidade;
import br.com.fiap.reskillplus.domain.repository.HabilidadeRepository;
import br.com.fiap.reskillplus.domain.service.HabilidadeDomainService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;

@ApplicationScoped
public class HabilidadeServiceImpl {

    @Inject
    HabilidadeRepository repository;

    @Inject
    HabilidadeDomainService domainService;

    public HabilidadeServiceImpl(HabilidadeRepository habilidadeRepository) {
    }

    public Habilidade cadastrar(Habilidade habilidade) {
        if (!domainService.validarHabilidade(habilidade))
            throw new IllegalArgumentException("Habilidade inválida.");
        repository.salvar(habilidade);
        return habilidade;
    }

    public List<Habilidade> listarTodas() {
        return repository.listarTodas();
    }

    public Habilidade buscarPorId(int id) {
        return repository.buscarPorId(id);
    }

    public void atualizar(Habilidade habilidade) {
        repository.atualizar(habilidade);
    }

    public void deletar(int id) {
        repository.deletar(id);
    }
}
