package br.com.fiap.reskillplus.domain.service;

import br.com.fiap.reskillplus.domain.model.Habilidade;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HabilidadeDomainService {

    public boolean validarHabilidade(Habilidade habilidade) {
        return habilidade.getNome() != null && !habilidade.getNome().isBlank();
    }

    public void promoverNivel(Habilidade habilidade) {
        switch (habilidade.getNivel().toLowerCase()) {
            case "básico" -> habilidade.setNivel("intermediário");
            case "intermediário" -> habilidade.setNivel("avançado");
        }
    }
}
