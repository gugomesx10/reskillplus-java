package br.com.fiap.reskillplus.infrastructure.config;

import br.com.fiap.reskillplus.application.*;
import br.com.fiap.reskillplus.domain.repository.*;
import br.com.fiap.reskillplus.domain.service.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class ServiceConfig {

    @Produces
    @ApplicationScoped
    public CursoService cursoService(CursoRepository cursoRepository) {
        return new CursoServiceImpl(cursoRepository);
    }

    @Produces
    @ApplicationScoped
    public FeedbackService feedbackService(FeedbackRepository feedbackRepository) {
        return new FeedbackServiceImpl(feedbackRepository);
    }

    @Produces
    @ApplicationScoped
    public HabilidadeService habilidadeService(HabilidadeRepository habilidadeRepository) {
        return new HabilidadeServiceImpl(habilidadeRepository);
    }

    @Produces
    @ApplicationScoped
    public MatriculaService matriculaService(MatriculaRepository matriculaRepository) {
        return new MatriculaServiceImpl(matriculaRepository);
    }

    @Produces
    @ApplicationScoped
    public RecomendacaoService recomendacaoService(RecomendacaoRepository recomendacaoRepository) {
        return new RecomendacaoServiceImpl(recomendacaoRepository);
    }

    @Produces
    @ApplicationScoped
    public UsuarioService usuarioService(UsuarioRepository usuarioRepository) {
        return new UsuarioServiceImpl(usuarioRepository);
    }
}
