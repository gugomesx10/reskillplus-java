package br.com.fiap.reskillplus.infrastructure.config;

import br.com.fiap.reskillplus.domain.service.*;
import br.com.fiap.reskillplus.interfaces.*;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ControllerConfig {

    @ApplicationScoped
    public CursoController cursoController(CursoService cursoService) {
        return new CursoControllerImpl(cursoService);
    }

    @ApplicationScoped
    public FeedbackController feedbackController(FeedbackService feedbackService) {
        return new FeedbackControllerImpl(feedbackService);
    }

    @ApplicationScoped
    public HabilidadeController habilidadeController(HabilidadeService habilidadeService) {
        return new HabilidadeControllerImpl(habilidadeService);
    }

    @ApplicationScoped
    public MatriculaController matriculaController(MatriculaService matriculaService) {
        return new MatriculaControllerImpl(matriculaService);
    }

    @ApplicationScoped
    public RecomendacaoController recomendacaoController(RecomendacaoService recomendacaoService) {
        return new RecomendacaoControllerImpl(recomendacaoService);
    }

    @ApplicationScoped
    public UsuarioController usuarioController(UsuarioService usuarioService) {
        return new UsuarioControllerImpl(usuarioService);
    }
}
