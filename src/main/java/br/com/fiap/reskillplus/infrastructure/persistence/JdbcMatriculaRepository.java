package br.com.fiap.reskillplus.infrastructure.persistence;

import br.com.fiap.reskillplus.domain.model.Matricula;
import br.com.fiap.reskillplus.domain.repository.MatriculaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class JdbcMatriculaRepository implements MatriculaRepository {

    @Inject
    DatabaseConnection databaseConnection;

    @Override
    public void salvar(Matricula matricula) {
        String sql = "INSERT INTO MATRICULA (USUARIOID, CURSOID, DATAMATRICULA, STATUS, PROGRESSO) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, matricula.getUsuarioId());
            ps.setLong(2, matricula.getCursoId());
            ps.setTimestamp(3, Timestamp.valueOf(matricula.getDataMatricula()));
            ps.setString(4, matricula.getStatus());
            ps.setInt(5, matricula.getProgresso());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar matrícula: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Matricula> listarPorUsuario(Long usuarioId) {
        List<Matricula> lista = new ArrayList<>();
        String sql = "SELECT * FROM MATRICULA WHERE USUARIOID = ?";
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, usuarioId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(new Matricula(
                            rs.getLong("ID"),
                            rs.getLong("USUARIOID"),
                            rs.getLong("CURSOID"),
                            rs.getTimestamp("DATAMATRICULA").toLocalDateTime(),
                            rs.getString("STATUS"),
                            rs.getInt("PROGRESSO")
                    ));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar matrículas: " + e.getMessage(), e);
        }
        return lista;
    }

    @Override
    public void atualizarProgresso(Long id, Integer progresso) {
        String sql = "UPDATE MATRICULA SET PROGRESSO=? WHERE ID=?";
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, progresso);
            ps.setLong(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar progresso: " + e.getMessage(), e);
        }
    }
}
