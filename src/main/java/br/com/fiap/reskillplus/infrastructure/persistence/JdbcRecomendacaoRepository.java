package br.com.fiap.reskillplus.infrastructure.persistence;

import br.com.fiap.reskillplus.domain.model.Recomendacao;
import br.com.fiap.reskillplus.domain.repository.RecomendacaoRepository;
import br.com.fiap.reskillplus.infrastructure.exceptions.RecomendacaoException;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcRecomendacaoRepository implements RecomendacaoRepository {

    private final DatabaseConnection databaseConnection;

    public JdbcRecomendacaoRepository(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    @Override
    public void salvar(Recomendacao recomendacao) {
        String sql = "INSERT INTO recomendacoes (usuario_id, curso_id, relevancia, data_geracao) VALUES (?, ?, ?, ?)";
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, recomendacao.getUsuarioId());
            stmt.setInt(2, recomendacao.getCursoId());
            stmt.setDouble(3, recomendacao.getRelevancia());
            stmt.setDate(4, new java.sql.Date(recomendacao.getDataGeracao().getTime()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RecomendacaoException("Erro ao salvar recomendação", e);
        }
    }

    @Override
    public void deletar(int id) {
        String sql = "DELETE FROM recomendacoes WHERE id=?";
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RecomendacaoException("Erro ao deletar recomendação", e);
        }
    }

    @Override
    public List<Recomendacao> listarPorUsuario(int usuarioId) {
        return List.of();
    }

    @Override
    public List<Recomendacao> listarTodas() {
        List<Recomendacao> recomendacoes = new ArrayList<>();
        String sql = "SELECT * FROM recomendacoes";

        try (Connection conn = databaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                recomendacoes.add(new Recomendacao(
                        rs.getInt("id"),
                        rs.getInt("usuario_id"),
                        rs.getInt("curso_id"),
                        rs.getDouble("relevancia"),
                        rs.getDate("data_geracao")
                ));
            }

        } catch (SQLException e) {
            throw new RecomendacaoException("Erro ao listar recomendações", e);
        }

        return recomendacoes;
    }

}
