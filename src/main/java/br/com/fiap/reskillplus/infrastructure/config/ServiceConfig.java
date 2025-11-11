package br.com.fiap.reskillplus.infrastructure.config;

import br.com.fiap.reskillplus.application.*;
import br.com.fiap.reskillplus.domain.repository.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class ServiceConfig {

    @Produces
    public UsuarioServiceImpl usuarioService(UsuarioRepository usuarioRepository) {
        return new UsuarioServiceImpl(usuarioRepository);
    }

    @Produces
    public CursoServiceImpl cursoService(CursoRepository cursoRepository) {
        return new CursoServiceImpl(cursoRepository);
    }

    @Produces
    public MatriculaServiceImpl matriculaService(MatriculaRepository matriculaRepository) {
        return new MatriculaServiceImpl(matriculaRepository);
    }

    @Produces
    public HabilidadeServiceImpl habilidadeService(HabilidadeRepository habilidadeRepository) {
        return new HabilidadeServiceImpl(habilidadeRepository);
    }

    @Produces
    public RecomendacaoServiceImpl recomendacaoService(RecomendacaoRepository recomendacaoRepository) {
        return new RecomendacaoServiceImpl(recomendacaoRepository);
    }
}
