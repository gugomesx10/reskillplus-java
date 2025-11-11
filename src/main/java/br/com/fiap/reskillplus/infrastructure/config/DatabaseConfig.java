package br.com.fiap.reskillplus.infrastructure.config;

import br.com.fiap.reskillplus.domain.repository.*;
import br.com.fiap.reskillplus.infrastructure.persistence.*;
import io.agroal.api.AgroalDataSource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class DatabaseConfig {

    @Produces
    public DatabaseConnection databaseConnection(AgroalDataSource dataSource) {
        return new DatabaseConnectionImpl(dataSource);
    }

    @Produces
    public UsuarioRepository usuarioRepository(DatabaseConnection databaseConnection) {
        return new JdbcUsuarioRepository(databaseConnection);
    }

    @Produces
    public CursoRepository cursoRepository(DatabaseConnection databaseConnection) {
        return new JdbcCursoRepository(databaseConnection);
    }

    @Produces
    public MatriculaRepository matriculaRepository(DatabaseConnection databaseConnection) {
        return new JdbcMatriculaRepository(databaseConnection);
    }

    @Produces
    public HabilidadeRepository habilidadeRepository(DatabaseConnection databaseConnection) {
        return new JdbcHabilidadeRepository(databaseConnection);
    }

    @Produces
    public RecomendacaoRepository recomendacaoRepository(DatabaseConnection databaseConnection) {
        return new JdbcRecomendacaoRepository(databaseConnection);
    }
}
