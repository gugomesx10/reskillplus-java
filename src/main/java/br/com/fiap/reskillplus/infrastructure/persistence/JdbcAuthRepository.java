package br.com.fiap.reskillplus.infrastructure.persistence;

import br.com.fiap.reskillplus.domain.model.AuthUsuario;
import br.com.fiap.reskillplus.domain.repository.AuthRepository;
import br.com.fiap.reskillplus.infrastructure.exceptions.InfraestruturaException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcAuthRepository implements AuthRepository {

    private final DatabaseConnection databaseConnection;

    public JdbcAuthRepository(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    @Override
    public AuthUsuario salvar(AuthUsuario usuario) {
        String sql = """
                INSERT INTO T_RESKILL_OAUTH
                    (provider, provider_id, email, nome)
                VALUES (?, ?, ?, ?)
                """;

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getProvider());
            stmt.setString(2, usuario.getProviderId());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getNome());
            stmt.executeUpdate();

            return usuario;

        } catch (SQLException e) {
            throw new InfraestruturaException("Erro ao salvar usuário OAuth: " + e.getMessage(), e);
        }
    }

    @Override
    public AuthUsuario buscarPorProviderId(String provider, String providerId) {
        String sql = """
                SELECT provider, provider_id, email, nome
                FROM T_RESKILL_OAUTH
                WHERE provider = ? AND provider_id = ?
                """;

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, provider);
            stmt.setString(2, providerId);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new AuthUsuario(
                        rs.getString("provider"),
                        rs.getString("provider_id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        null,
                        null
                );
            }

            return null;

        } catch (SQLException e) {
            throw new InfraestruturaException("Erro ao buscar usuário OAuth: " + e.getMessage(), e);
        }
    }
}
