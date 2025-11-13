package br.com.fiap.reskillplus.infrastructure.persistence;

import br.com.fiap.reskillplus.domain.exception.EntidadeNaoLocalizada;
import br.com.fiap.reskillplus.domain.model.Recomendacao;
import br.com.fiap.reskillplus.domain.repository.RecomendacaoRepository;
import br.com.fiap.reskillplus.infrastructure.exceptions.InfraestruturaException;

import java.sql.*;
import java.util.List;

public class JdbcRecomendacaoRepository implements RecomendacaoRepository {

    private final DatabaseConnection databaseConnection;

    public JdbcRecomendacaoRepository(DatabaseConnection connection) {
        this.databaseConnection = connection;
    }

    @Override
    public Recomendacao criarRecomendacao(Recomendacao rec) {
        String sql = """
            INSERT INTO T_RESKILL_RECOMENDACAO
            (cpf_usuario, nome_curso, motivo, data_recomendacao)
            VALUES (?, ?, ?, ?)
        """;

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, rec.getCpf_usuario());
            stmt.setString(2, rec.getNome_curso());
            stmt.setString(3, rec.getMotivo());
            stmt.setString(4, rec.getData_recomendacao());

            stmt.executeUpdate();
            return rec;

        } catch (SQLException e) {
            throw new InfraestruturaException("Erro ao criar recomendação: " + e.getMessage(), e);
        }
    }

    @Override
    public void editarRecomendacao(Recomendacao recomendacao) {
        String sql = """
        UPDATE T_RESKILL_RECOMENDACAO
        SET motivo = ?, data_recomendacao = ?
        WHERE cpf_usuario = ? AND nome_curso = ?
    """;

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, recomendacao.getMotivo());
            stmt.setString(2, recomendacao.getData_recomendacao());
            stmt.setString(3, recomendacao.getCpf_usuario());
            stmt.setString(4, recomendacao.getNome_curso());

            int updated = stmt.executeUpdate();
            if (updated == 0) {
                throw new EntidadeNaoLocalizada(
                        "Recomendação não encontrada para CPF=" + recomendacao.getCpf_usuario()
                                + " e curso=" + recomendacao.getNome_curso()
                );
            }

        } catch (SQLException | EntidadeNaoLocalizada e) {
            throw new InfraestruturaException("Erro ao editar recomendação: " + e.getMessage(), e);
        }
    }

    @Override
    public Recomendacao buscarRecomendacao(String cpf, String curso) throws EntidadeNaoLocalizada {
        String sql = """
            SELECT cpf_usuario, nome_curso, motivo, data_recomendacao
            FROM T_RESKILL_RECOMENDACAO
            WHERE cpf_usuario = ? AND nome_curso = ?
        """;

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cpf);
            stmt.setString(2, curso);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Recomendacao(
                        rs.getString("cpf_usuario"),
                        rs.getString("nome_curso"),
                        rs.getString("motivo"),
                        rs.getString("data_recomendacao")
                );
            }

            throw new EntidadeNaoLocalizada("Recomendação não encontrada.");

        } catch (SQLException e) {
            throw new InfraestruturaException("Erro ao buscar recomendação: " + e.getMessage(), e);
        }
    }

    @Override
    public void excluirRecomendacao(String cpf, String curso) {
        String sql = "DELETE FROM T_RESKILL_RECOMENDACAO WHERE cpf_usuario = ? AND nome_curso = ?";

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cpf);
            stmt.setString(2, curso);

            int deleted = stmt.executeUpdate();
            if (deleted == 0)
                throw new EntidadeNaoLocalizada("Recomendação não encontrada para exclusão.");

        } catch (SQLException | EntidadeNaoLocalizada e) {
            throw new InfraestruturaException("Erro ao excluir recomendação: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Recomendacao> listarRecomendacoesPorUsuario(String cpf) {
        return List.of();
    }
}
