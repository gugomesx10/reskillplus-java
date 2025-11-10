package br.com.fiap.reskillplus.infrastructure.persistence;

import br.com.fiap.reskillplus.domain.model.Habilidade;
import br.com.fiap.reskillplus.domain.repository.HabilidadeRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class JdbcHabilidadeRepository implements HabilidadeRepository {

    @Inject
    DatabaseConnection databaseConnection;

    public JdbcHabilidadeRepository(DatabaseConnection databaseConnection) {
    }

    @Override
    public void salvar(Habilidade habilidade) {
        String sql = "INSERT INTO HABILIDADE (USUARIOID, NOMEHABILIDADE, NIVELPROFICIENCIA) VALUES (?, ?, ?)";
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, habilidade.getUsuarioId());
            ps.setString(2, habilidade.getNomeHabilidade());
            ps.setInt(3, habilidade.getNivelProficiencia());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar habilidade: " + e.getMessage(), e);
        }
    }

    @Override
    public Habilidade buscarPorId(Long id) {
        return null;
    }

    @Override
    public List<Habilidade> listarPorUsuario(Long usuarioId) {
        List<Habilidade> lista = new ArrayList<>();
        String sql = "SELECT * FROM HABILIDADE WHERE USUARIOID = ?";
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, usuarioId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(new Habilidade(
                            rs.getLong("ID"),
                            rs.getLong("USUARIOID"),
                            rs.getString("NOMEHABILIDADE"),
                            rs.getInt("NIVELPROFICIENCIA")
                    ));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar habilidades: " + e.getMessage(), e);
        }
        return lista;
    }

    @Override
    public void atualizar(Habilidade habilidade) {

    }

    @Override
    public void deletar(Long id) {
        String sql = "DELETE FROM HABILIDADE WHERE ID = ?";
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar habilidade: " + e.getMessage(), e);
        }
    }
}
