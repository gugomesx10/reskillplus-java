package br.com.fiap.reskillplus.infrastructure.config;

import br.com.fiap.reskillplus.application.AuthServiceImpl;
import br.com.fiap.reskillplus.domain.service.*;

import br.com.fiap.reskillplus.interfaces.*;

import br.com.fiap.reskillplus.mapper.AuthMapper;
import br.com.fiap.reskillplus.mapper.PagamentoMapper;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ControllerConfig {

    @ApplicationScoped
    public UsuarioController usuarioController(UsuarioService usuarioService) {
        return new UsuarioControllerImpl(usuarioService);
    }

    @ApplicationScoped
    public CursoController cursoController(CursoService cursoService) {
        return new CursoControllerImpl(cursoService);
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
    public AuthController authController(AuthServiceImpl authServiceImpl, AuthMapper authMapper) {
        return new AuthControllerImpl(authServiceImpl, authMapper);
    }

    @ApplicationScoped
    public PagamentoController pagamentoController(PagamentoService pagamentoService, PagamentoMapper mapper) {
        return new PagamentoControllerImpl(pagamentoService, mapper);
    }

}
