package br.com.fiap.reskillplus.infrastructure.config;

import br.com.fiap.reskillplus.application.*;
import br.com.fiap.reskillplus.domain.repository.*;
import br.com.fiap.reskillplus.domain.service.*;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ServiceConfig {

    @ApplicationScoped
    public CursoService cursoService(CursoRepository cursoRepository) {
        return new CursoServiceImpl(cursoRepository);
    }

    @ApplicationScoped
    public FeedbackService feedbackService(FeedbackRepository feedbackRepository) {
        return new FeedbackServiceImpl(feedbackRepository);
    }

    @ApplicationScoped
    public HabilidadeService habilidadeService(HabilidadeRepository habilidadeRepository) {
        return new HabilidadeServiceImpl(habilidadeRepository);
    }

    @ApplicationScoped
    public MatriculaService matriculaService(MatriculaRepository matriculaRepository) {
        return new MatriculaServiceImpl(matriculaRepository);
    }

    @ApplicationScoped
    public RecomendacaoService recomendacaoService(RecomendacaoRepository recomendacaoRepository) {
        return new RecomendacaoServiceImpl(recomendacaoRepository);
    }

    @ApplicationScoped
    public UsuarioService usuarioService(UsuarioRepository usuarioRepository) {
        return new UsuarioServiceImpl(usuarioRepository);
    }
}
