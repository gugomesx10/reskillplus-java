package br.com.fiap.reskillplus.infrastructure.persistence;

import br.com.fiap.reskillplus.domain.model.Feedback;
import br.com.fiap.reskillplus.domain.repository.FeedbackRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class JdbcFeedbackRepository implements FeedbackRepository {

    @Inject
    DatabaseConnection databaseConnection;

    @Override
    public void salvar(Feedback feedback) {
        String sql = "INSERT INTO FEEDBACK (USUARIOID, CURSOID, AVALIACAO, COMENTARIO, DATAFEEDBACK) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, feedback.getUsuarioId());
            ps.setLong(2, feedback.getCursoId());
            ps.setInt(3, feedback.getAvaliacao());
            ps.setString(4, feedback.getComentario());
            ps.setTimestamp(5, Timestamp.valueOf(feedback.getDataFeedback()));
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar feedback: " + e.getMessage(), e);
        }
    }

    @Override
    public Feedback buscarPorId(Long id) {
        String sql = "SELECT * FROM FEEDBACK WHERE ID = ?";
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Feedback(
                            rs.getLong("ID"),
                            rs.getLong("USUARIOID"),
                            rs.getLong("CURSOID"),
                            rs.getInt("AVALIACAO"),
                            rs.getString("COMENTARIO"),
                            rs.getTimestamp("DATAFEEDBACK").toLocalDateTime()
                    );
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar feedback: " + e.getMessage(), e);
        }
        return null;
    }

    @Override
    public List<Feedback> listarPorCurso(Long cursoId) {
        List<Feedback> lista = new ArrayList<>();
        String sql = "SELECT * FROM FEEDBACK WHERE CURSOID = ?";
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, cursoId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(new Feedback(
                            rs.getLong("ID"),
                            rs.getLong("USUARIOID"),
                            rs.getLong("CURSOID"),
                            rs.getInt("AVALIACAO"),
                            rs.getString("COMENTARIO"),
                            rs.getTimestamp("DATAFEEDBACK").toLocalDateTime()
                    ));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar feedbacks: " + e.getMessage(), e);
        }
        return lista;
    }

    @Override
    public void deletar(Long id) {
        String sql = "DELETE FROM FEEDBACK WHERE ID = ?";
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar feedback: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Feedback> listarTodos() {
        List<Feedback> lista = new ArrayList<>();
        String sql = "SELECT * FROM FEEDBACK";
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new Feedback(
                        rs.getLong("ID"),
                        rs.getLong("USUARIOID"),
                        rs.getLong("CURSOID"),
                        rs.getInt("AVALIACAO"),
                        rs.getString("COMENTARIO"),
                        rs.getTimestamp("DATAFEEDBACK").toLocalDateTime()
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar feedbacks: " + e.getMessage(), e);
        }
        return lista;
    }
}
