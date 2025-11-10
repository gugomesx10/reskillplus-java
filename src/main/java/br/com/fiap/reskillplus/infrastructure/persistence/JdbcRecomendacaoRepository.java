package br.com.fiap.reskillplus.infrastructure.persistence;

import br.com.fiap.reskillplus.domain.model.Recomendacao;
import br.com.fiap.reskillplus.domain.repository.RecomendacaoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class JdbcRecomendacaoRepository implements RecomendacaoRepository {

    @Inject
    DatabaseConnection databaseConnection;

    public JdbcRecomendacaoRepository(DatabaseConnection databaseConnection) {
    }

    @Override
    public void salvar(Recomendacao recomendacao) {
        String sql = "INSERT INTO RECOMENDACAO (USUARIOID, CURSOID, PONTUACAO, DATARECOMENDACAO) VALUES (?, ?, ?, ?)";
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, recomendacao.getUsuarioId());
            ps.setLong(2, recomendacao.getCursoId());
            ps.setDouble(3, recomendacao.getPontuacao());
            ps.setTimestamp(4, Timestamp.valueOf(recomendacao.getDataRecomendacao()));
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar recomendação: " + e.getMessage(), e);
        }
    }

    @Override
    public Recomendacao buscarPorId(Long id) {
        return null;
    }

    @Override
    public List<Recomendacao> listarPorUsuario(Long usuarioId) {
        List<Recomendacao> lista = new ArrayList<>();
        String sql = "SELECT * FROM RECOMENDACAO WHERE USUARIOID = ?";
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, usuarioId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(new Recomendacao(
                            rs.getLong("ID"),
                            rs.getLong("USUARIOID"),
                            rs.getLong("CURSOID"),
                            rs.getDouble("PONTUACAO"),
                            rs.getTimestamp("DATARECOMENDACAO").toLocalDateTime()
                    ));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar recomendações: " + e.getMessage(), e);
        }
        return lista;
    }

    @Override
    public void deletar(Long id) {

    }
}
