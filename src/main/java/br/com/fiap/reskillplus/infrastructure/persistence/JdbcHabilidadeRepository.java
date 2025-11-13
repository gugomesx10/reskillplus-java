package br.com.fiap.reskillplus.infrastructure.persistence;

import br.com.fiap.reskillplus.domain.exception.EntidadeNaoLocalizada;
import br.com.fiap.reskillplus.domain.model.Habilidade;
import br.com.fiap.reskillplus.domain.repository.HabilidadeRepository;
import br.com.fiap.reskillplus.infrastructure.exceptions.InfraestruturaException;

import java.sql.*;

public class JdbcHabilidadeRepository implements HabilidadeRepository {

    private final DatabaseConnection databaseConnection;

    public JdbcHabilidadeRepository(DatabaseConnection connection) {
        this.databaseConnection = connection;
    }

    @Override
    public Habilidade criarHabilidade(Habilidade habilidade) {
        String sql = """
            INSERT INTO T_RESKILL_HABILIDADE
            (nome_habilidade, descricao_habilidade, nivel, area)
            VALUES (?, ?, ?, ?)
        """;

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, habilidade.getNome_habilidade());
            stmt.setString(2, habilidade.getDescricao_habilidade());
            stmt.setString(3, habilidade.getNivel());
            stmt.setString(4, habilidade.getArea());

            stmt.executeUpdate();
            return habilidade;

        } catch (SQLException e) {
            throw new InfraestruturaException("Erro ao criar habilidade: " + e.getMessage(), e);
        }
    }

    @Override
    public void editarHabilidade(Habilidade habilidade) {
        String sql = """
            UPDATE T_RESKILL_HABILIDADE
            SET descricao_habilidade = ?, nivel = ?, area = ?
            WHERE nome_habilidade = ?
        """;

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, habilidade.getDescricao_habilidade());
            stmt.setString(2, habilidade.getNivel());
            stmt.setString(3, habilidade.getArea());
            stmt.setString(4, habilidade.getNome_habilidade());

            int updated = stmt.executeUpdate();
            if (updated == 0)
                throw new EntidadeNaoLocalizada("Habilidade não encontrada: " + habilidade.getNome_habilidade());

        } catch (SQLException | EntidadeNaoLocalizada e) {
            throw new InfraestruturaException("Erro ao editar habilidade: " + e.getMessage(), e);
        }
    }

    @Override
    public Habilidade buscarHabilidade(String nome) throws EntidadeNaoLocalizada {
        String sql = """
            SELECT nome_habilidade, descricao_habilidade, nivel, area
            FROM T_RESKILL_HABILIDADE
            WHERE nome_habilidade = ?
        """;

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Habilidade(
                        rs.getString("nome_habilidade"),
                        rs.getString("descricao_habilidade"),
                        rs.getString("nivel"),
                        rs.getString("area")
                );
            }

            throw new EntidadeNaoLocalizada("Habilidade não encontrada: " + nome);

        } catch (SQLException e) {
            throw new InfraestruturaException("Erro ao buscar habilidade: " + e.getMessage(), e);
        }
    }

    @Override
    public void excluirHabilidade(String nome) {
        String sql = "DELETE FROM T_RESKILL_HABILIDADE WHERE nome_habilidade = ?";

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);

            int deleted = stmt.executeUpdate();
            if (deleted == 0)
                throw new EntidadeNaoLocalizada("Habilidade não encontrada para exclusão: " + nome);

        } catch (SQLException | EntidadeNaoLocalizada e) {
            throw new InfraestruturaException("Erro ao excluir habilidade: " + e.getMessage(), e);
        }
    }
}
