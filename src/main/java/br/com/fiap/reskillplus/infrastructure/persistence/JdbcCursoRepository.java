package br.com.fiap.reskillplus.infrastructure.persistence;

import br.com.fiap.reskillplus.domain.exception.EntidadeNaoLocalizada;
import br.com.fiap.reskillplus.domain.model.Curso;
import br.com.fiap.reskillplus.domain.repository.CursoRepository;
import br.com.fiap.reskillplus.infrastructure.exceptions.InfraestruturaException;

import java.sql.*;

public class JdbcCursoRepository implements CursoRepository {

    private final DatabaseConnection databaseConnection;

    public JdbcCursoRepository(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    @Override
    public Curso criarCurso(Curso curso) {
        String sql = """
            INSERT INTO T_RESKILL_CURSO
            (nome_curso, descricao_curso, carga_horaria, categoria)
            VALUES (?, ?, ?, ?)
        """;

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, curso.getNome_curso());
            stmt.setString(2, curso.getDescricao_curso());
            stmt.setString(3, curso.getCarga_horaria());
            stmt.setString(4, curso.getCategoria());

            stmt.executeUpdate();
            return curso;

        } catch (SQLException e) {
            throw new InfraestruturaException("Erro ao criar curso: " + e.getMessage(), e);
        }
    }

    @Override
    public void editarCurso(Curso curso) {
        String sql = """
            UPDATE T_RESKILL_CURSO
            SET descricao_curso = ?, carga_horaria = ?, categoria = ?
            WHERE nome_curso = ?
        """;

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, curso.getDescricao_curso());
            stmt.setString(2, curso.getCarga_horaria());
            stmt.setString(3, curso.getCategoria());
            stmt.setString(4, curso.getNome_curso());

            int updated = stmt.executeUpdate();
            if (updated == 0) {
                throw new EntidadeNaoLocalizada("Curso não encontrado: " + curso.getNome_curso());
            }

        } catch (SQLException | EntidadeNaoLocalizada e) {
            throw new InfraestruturaException("Erro ao editar curso: " + e.getMessage(), e);
        }
    }

    @Override
    public Curso buscarCurso(String nome) throws EntidadeNaoLocalizada {
        String sql = """
            SELECT nome_curso, descricao_curso, carga_horaria, categoria
            FROM T_RESKILL_CURSO
            WHERE nome_curso = ?
        """;

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Curso(
                        rs.getString("nome_curso"),
                        rs.getString("descricao_curso"),
                        rs.getString("carga_horaria"),
                        rs.getString("categoria")
                );
            }

            throw new EntidadeNaoLocalizada("Curso não encontrado: " + nome);

        } catch (SQLException e) {
            throw new InfraestruturaException("Erro ao buscar curso: " + e.getMessage(), e);
        }
    }

    @Override
    public Curso buscarCurso(int id) throws EntidadeNaoLocalizada {
        String sql = """
            SELECT nome_curso, descricao_curso, carga_horaria, categoria
            FROM T_RESKILL_CURSO
            WHERE id_curso = ?
        """;

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Não existe campo id no model → ignorado
                return new Curso(
                        rs.getString("nome_curso"),
                        rs.getString("descricao_curso"),
                        rs.getString("carga_horaria"),
                        rs.getString("categoria")
                );
            }

            throw new EntidadeNaoLocalizada("Curso não encontrado com ID: " + id);

        } catch (SQLException e) {
            throw new InfraestruturaException("Erro ao buscar curso por id: " + e.getMessage(), e);
        }
    }

    @Override
    public void excluirCurso(String nome) {
        String sql = "DELETE FROM T_RESKILL_CURSO WHERE nome_curso = ?";

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);

            int deleted = stmt.executeUpdate();
            if (deleted == 0) {
                throw new EntidadeNaoLocalizada("Curso não encontrado para exclusão: " + nome);
            }

        } catch (SQLException | EntidadeNaoLocalizada e) {
            throw new InfraestruturaException("Erro ao excluir curso: " + e.getMessage(), e);
        }
    }
}
