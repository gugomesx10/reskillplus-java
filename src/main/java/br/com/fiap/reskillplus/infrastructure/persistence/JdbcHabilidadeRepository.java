package br.com.fiap.reskillplus.infrastructure.persistence;

import br.com.fiap.reskillplus.domain.model.Habilidade;
import br.com.fiap.reskillplus.domain.repository.HabilidadeRepository;
import br.com.fiap.reskillplus.infrastructure.exceptions.HabilidadeException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcHabilidadeRepository implements HabilidadeRepository {

    private final DatabaseConnection databaseConnection;

    public JdbcHabilidadeRepository(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    @Override
    public void salvar(Habilidade habilidade) {
        String sql = "INSERT INTO habilidades (nome, descricao, nivel) VALUES (?, ?, ?)";
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, habilidade.getNome());
            stmt.setString(2, habilidade.getDescricao());
            stmt.setString(3, habilidade.getNivel());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new HabilidadeException("Erro ao salvar habilidade", e);
        }
    }

    @Override
    public void atualizar(Habilidade habilidade) {
        String sql = "UPDATE habilidades SET nome=?, descricao=?, nivel=? WHERE id=?";
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, habilidade.getNome());
            stmt.setString(2, habilidade.getDescricao());
            stmt.setString(3, habilidade.getNivel());
            stmt.setInt(4, habilidade.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new HabilidadeException("Erro ao atualizar habilidade", e);
        }
    }

    @Override
    public void deletar(int id) {
        String sql = "DELETE FROM habilidades WHERE id=?";
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new HabilidadeException("Erro ao deletar habilidade", e);
        }
    }

    @Override
    public Habilidade buscarPorId(int id) {
        String sql = "SELECT * FROM habilidades WHERE id=?";
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Habilidade(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("descricao"),
                        rs.getString("nivel")
                );
            }
            return null;
        } catch (SQLException e) {
            throw new HabilidadeException("Erro ao buscar habilidade", e);
        }
    }

    @Override
    public List<Habilidade> listarTodas() {
        List<Habilidade> habilidades = new ArrayList<>();
        String sql = "SELECT * FROM habilidades";
        try (Connection conn = databaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                habilidades.add(new Habilidade(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("descricao"),
                        rs.getString("nivel")
                ));
            }
        } catch (SQLException e) {
            throw new HabilidadeException("Erro ao listar habilidades", e);
        }
        return habilidades;
    }
}
