package br.com.fiap.reskillplus.infrastructure.config;

import br.com.fiap.reskillplus.domain.service.UsuarioService;
import br.com.fiap.reskillplus.domain.service.CursoService;
import br.com.fiap.reskillplus.domain.service.HabilidadeService;
import br.com.fiap.reskillplus.domain.service.MatriculaService;
import br.com.fiap.reskillplus.domain.service.RecomendacaoService;

import br.com.fiap.reskillplus.interfaces.UsuarioController;
import br.com.fiap.reskillplus.interfaces.UsuarioControllerImpl;

import br.com.fiap.reskillplus.interfaces.CursoController;
import br.com.fiap.reskillplus.interfaces.CursoControllerImpl;

import br.com.fiap.reskillplus.interfaces.HabilidadeController;
import br.com.fiap.reskillplus.interfaces.HabilidadeControllerImpl;

import br.com.fiap.reskillplus.interfaces.MatriculaController;
import br.com.fiap.reskillplus.interfaces.MatriculaControllerImpl;

import br.com.fiap.reskillplus.interfaces.RecomendacaoController;
import br.com.fiap.reskillplus.interfaces.RecomendacaoControllerImpl;

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
}
