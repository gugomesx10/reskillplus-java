package br.com.fiap.reskillplus.domain.service;

import br.com.fiap.reskillplus.domain.model.Recomendacao;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.Date;

@ApplicationScoped
public class RecomendacaoDomainService {

    public void calcularRelevancia(Recomendacao recomendacao, double baseScore) {
        double bonusTempo = (System.currentTimeMillis() - recomendacao.getDataGeracao().getTime()) < 86400000 ? 1.1 : 1.0;
        recomendacao.setRelevancia(baseScore * bonusTempo);
    }

    public boolean validarRecomendacao(Recomendacao recomendacao) {
        return recomendacao.getUsuarioId() > 0 && recomendacao.getCursoId() > 0;
    }

    public void atualizarDataGeracao(Recomendacao recomendacao) {
        recomendacao.setDataGeracao(new Date());
    }
}
