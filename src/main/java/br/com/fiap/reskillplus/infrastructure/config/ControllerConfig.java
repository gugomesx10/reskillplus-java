package br.com.fiap.reskillplus.infrastructure.config;

import br.com.fiap.reskillplus.application.*;
import br.com.fiap.reskillplus.interfaces.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class ControllerConfig {

    @Produces
    public UsuarioController usuarioController(UsuarioServiceImpl usuarioServiceImpl) {
        return new UsuarioControllerImpl(usuarioServiceImpl);
    }

    @Produces
    public CursoController cursoController(CursoServiceImpl cursoServiceImpl) {
        return new CursoControllerImpl(cursoServiceImpl);
    }

    @Produces
    public MatriculaController matriculaController(MatriculaServiceImpl matriculaServiceImpl) {
        return new MatriculaControllerImpl(matriculaServiceImpl);
    }

    @Produces
    public HabilidadeController habilidadeController(HabilidadeServiceImpl habilidadeServiceImpl) {
        return new HabilidadeControllerImpl(habilidadeServiceImpl);
    }

    @Produces
    public RecomendacaoController recomendacaoController(RecomendacaoServiceImpl recomendacaoServiceImpl) {
        return new RecomendacaoControllerImpl(recomendacaoServiceImpl);
    }
}
