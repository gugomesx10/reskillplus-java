package br.com.fiap.reskillplus.infrastructure.persistence;

import br.com.fiap.reskillplus.domain.model.Matricula;
import br.com.fiap.reskillplus.domain.repository.MatriculaRepository;
import br.com.fiap.reskillplus.infrastructure.exceptions.MatriculaException;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcMatriculaRepository implements MatriculaRepository {

    private final DatabaseConnection databaseConnection;

    public JdbcMatriculaRepository(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    @Override
    public void salvar(Matricula matricula) {
        String sql = "INSERT INTO matriculas (usuario_id, curso_id, data_matricula, concluido) VALUES (?, ?, ?, ?)";

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, matricula.getUsuarioId());
            stmt.setInt(2, matricula.getCursoId());
            stmt.setDate(3, new java.sql.Date(matricula.getDataMatricula().getTime())); // ← conversão correta
            stmt.setBoolean(4, matricula.isConcluido());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new MatriculaException("Erro ao salvar matrícula", e);
        }
    }


    @Override
    public void atualizarProgresso(int id, boolean concluido) {
        String sql = "UPDATE matriculas SET concluido=? WHERE id=?";
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setBoolean(1, concluido);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new MatriculaException("Erro ao atualizar progresso da matrícula", e);
        }
    }

    @Override
    public void deletar(int id) {

    }

    @Override
    public Matricula buscarPorId(int id) {
        return null;
    }

    @Override
    public List<Matricula> listarPorUsuario(int usuarioId) {
        return List.of();
    }

    @Override
    public List<Matricula> listarTodas() {
        List<Matricula> matriculas = new ArrayList<>();
        String sql = "SELECT * FROM matriculas";

        try (Connection conn = databaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                matriculas.add(new Matricula(
                        rs.getInt("id"),
                        rs.getInt("usuario_id"),
                        rs.getInt("curso_id"),
                        rs.getDate("data_matricula"),
                        rs.getBoolean("concluido")
                ));
            }

        } catch (SQLException e) {
            throw new MatriculaException("Erro ao listar matrículas", e);
        }

        return matriculas;
    }

}
