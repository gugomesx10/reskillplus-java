package br.com.fiap.reskillplus.infrastructure.persistence;

import br.com.fiap.reskillplus.domain.exception.EntidadeNaoLocalizada;
import br.com.fiap.reskillplus.domain.model.Matricula;
import br.com.fiap.reskillplus.domain.repository.MatriculaRepository;
import br.com.fiap.reskillplus.infrastructure.exceptions.InfraestruturaException;

import java.sql.*;
import java.util.List;

public class JdbcMatriculaRepository implements MatriculaRepository {

    private final DatabaseConnection databaseConnection;

    public JdbcMatriculaRepository(DatabaseConnection connection) {
        this.databaseConnection = connection;
    }

    @Override
    public Matricula criarMatricula(Matricula matricula) {
        String sql = """
            INSERT INTO T_RESKILL_MATRICULA
            (cpf_usuario, nome_curso, dt_matricula, status)
            VALUES (?, ?, ?, ?)
        """;

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, matricula.getCpf_usuario());
            stmt.setString(2, matricula.getNome_curso());
            stmt.setString(3, matricula.getDt_matricula());
            stmt.setString(4, matricula.getStatus());

            stmt.executeUpdate();
            return matricula;

        } catch (SQLException e) {
            throw new InfraestruturaException("Erro ao criar matrícula: " + e.getMessage(), e);
        }
    }

    @Override
    public void editarMatricula(Matricula matricula) {
        String sql = """
        UPDATE T_RESKILL_MATRICULA
        SET dt_matricula = ?, status = ?
        WHERE cpf_usuario = ? AND nome_curso = ?
    """;

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, matricula.getDt_matricula());
            stmt.setString(2, matricula.getStatus());
            stmt.setString(3, matricula.getCpf_usuario());
            stmt.setString(4, matricula.getNome_curso());

            int updated = stmt.executeUpdate();
            if (updated == 0) {
                throw new EntidadeNaoLocalizada(
                        "Matrícula não encontrada para CPF=" + matricula.getCpf_usuario()
                                + " e curso=" + matricula.getNome_curso()
                );
            }

        } catch (SQLException | EntidadeNaoLocalizada e) {
            throw new InfraestruturaException("Erro ao editar matrícula: " + e.getMessage(), e);
        }
    }

    @Override
    public Matricula buscarMatricula(String cpf, String curso) throws EntidadeNaoLocalizada {
        String sql = """
            SELECT cpf_usuario, nome_curso, dt_matricula, status
            FROM T_RESKILL_MATRICULA
            WHERE cpf_usuario = ? AND nome_curso = ?
        """;

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cpf);
            stmt.setString(2, curso);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Matricula(
                        rs.getString("cpf_usuario"),
                        rs.getString("nome_curso"),
                        rs.getString("dt_matricula"),
                        rs.getString("status")
                );
            }

            throw new EntidadeNaoLocalizada("Matrícula não encontrada para CPF=" + cpf + " curso=" + curso);

        } catch (SQLException e) {
            throw new InfraestruturaException("Erro ao buscar matrícula: " + e.getMessage(), e);
        }
    }

    @Override
    public void excluirMatricula(String cpf, String curso) {
        String sql = "DELETE FROM T_RESKILL_MATRICULA WHERE cpf_usuario = ? AND nome_curso = ?";

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cpf);
            stmt.setString(2, curso);

            int deleted = stmt.executeUpdate();
            if (deleted == 0)
                throw new EntidadeNaoLocalizada("Matrícula não encontrada para exclusão.");

        } catch (SQLException | EntidadeNaoLocalizada e) {
            throw new InfraestruturaException("Erro ao excluir matrícula: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Matricula> listarMatriculasPorUsuario(String cpf) {
        return List.of();
    }
}
