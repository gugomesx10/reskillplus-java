package br.com.fiap.reskillplus.infrastructure.persistence;

import br.com.fiap.reskillplus.domain.model.Pagamento;
import br.com.fiap.reskillplus.domain.repository.PagamentoRepository;
import br.com.fiap.reskillplus.infrastructure.exceptions.InfraestruturaException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcPagamentoRepository implements PagamentoRepository {

    private final DatabaseConnection database;

    public JdbcPagamentoRepository(DatabaseConnection database) {
        this.database = database;
    }

    @Override
    public Pagamento salvar(Pagamento pagamento) {
        String sql = """
            DECLARE
                v_id NUMBER;
            BEGIN
                INSERT INTO T_RESKILL_PAGAMENTO
                (corporacao_id, user_id, quantia, status, dt_criacao)
                VALUES (?, ?, ?, ?, ?)
                RETURNING id INTO v_id;

                ? := v_id;
            END;
        """;

        try (Connection conn = database.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setLong(1, pagamento.getCorporacaoId());
            stmt.setLong(2, pagamento.getUserId());
            stmt.setBigDecimal(3, pagamento.getQuantia());
            stmt.setString(4, pagamento.getStatus());
            stmt.setTimestamp(5, Timestamp.valueOf(pagamento.getDataCriacao()));

            stmt.registerOutParameter(6, Types.NUMERIC);

            stmt.execute();

            pagamento.setId(stmt.getLong(6));

            return pagamento;

        } catch (Exception e) {
            throw new InfraestruturaException("Erro ao salvar pagamento: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Pagamento> listarTodos() {
        String sql = "SELECT * FROM T_RESKILL_PAGAMENTO ORDER BY id DESC";
        List<Pagamento> lista = new ArrayList<>();

        try (Connection conn = database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                lista.add(mapRow(rs));
            }

            return lista;

        } catch (Exception e) {
            throw new InfraestruturaException("Erro ao listar pagamentos: " + e.getMessage(), e);
        }
    }

    @Override
    public Pagamento buscarPorId(Long id) {
        String sql = "SELECT * FROM T_RESKILL_PAGAMENTO WHERE id = ?";

        try (Connection conn = database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return mapRow(rs);
            }

            return null;

        } catch (Exception e) {
            throw new InfraestruturaException("Erro ao buscar pagamento: " + e.getMessage(), e);
        }
    }

    @Override
    public Pagamento atualizarStatus(Long id, String novoStatus) {
        String sql = "UPDATE T_RESKILL_PAGAMENTO SET status = ? WHERE id = ?";

        try (Connection conn = database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, novoStatus);
            stmt.setLong(2, id);
            stmt.executeUpdate();

            return buscarPorId(id);

        } catch (Exception e) {
            throw new InfraestruturaException("Erro ao atualizar status do pagamento: " + e.getMessage(), e);
        }
    }

    @Override
    public void remover(Long id) {
        String sql = "DELETE FROM T_RESKILL_PAGAMENTO WHERE id = ?";

        try (Connection conn = database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            stmt.executeUpdate();

        } catch (Exception e) {
            throw new InfraestruturaException("Erro ao remover pagamento: " + e.getMessage(), e);
        }
    }

    private Pagamento mapRow(ResultSet rs) throws Exception {
        return new Pagamento(
                rs.getLong("id"),
                rs.getLong("corporacao_id"),
                rs.getLong("user_id"),
                rs.getBigDecimal("quantia"),
                rs.getString("status"),
                rs.getTimestamp("dt_criacao").toLocalDateTime()
        );
    }
}
