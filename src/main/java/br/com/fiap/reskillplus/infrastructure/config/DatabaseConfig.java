package br.com.fiap.reskillplus.infrastructure.config;

import br.com.fiap.reskillplus.domain.repository.*;
import br.com.fiap.reskillplus.infrastructure.persistence.*;

import io.agroal.api.AgroalDataSource;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DatabaseConfig {

    @ApplicationScoped
    public DatabaseConnection databaseConnection(AgroalDataSource dataSource) {
        return new DatabaseConnectionImpl(dataSource);
    }

    @ApplicationScoped
    public UsuarioRepository usuarioRepository(DatabaseConnection databaseConnection) {
        return new JdbcUsuarioRepository(databaseConnection);
    }

    @ApplicationScoped
    public CursoRepository cursoRepository(DatabaseConnection databaseConnection) {
        return new JdbcCursoRepository(databaseConnection);
    }

    @ApplicationScoped
    public HabilidadeRepository habilidadeRepository(DatabaseConnection databaseConnection) {
        return new JdbcHabilidadeRepository(databaseConnection);
    }

    @ApplicationScoped
    public MatriculaRepository matriculaRepository(DatabaseConnection databaseConnection) {
        return new JdbcMatriculaRepository(databaseConnection);
    }

    @ApplicationScoped
    public RecomendacaoRepository recomendacaoRepository(DatabaseConnection databaseConnection) {
        return new JdbcRecomendacaoRepository(databaseConnection);
    }

    @ApplicationScoped
    public AuthRepository authRepository(DatabaseConnection databaseConnection) {
        return new JdbcAuthRepository(databaseConnection);
    }

    @ApplicationScoped
    public PagamentoRepository pagamentoRepository(DatabaseConnection databaseConnection) {
        return new JdbcPagamentoRepository(databaseConnection);
    }
}
