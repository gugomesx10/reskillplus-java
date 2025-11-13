package br.com.fiap.reskillplus.infrastructure.persistence;

import br.com.fiap.reskillplus.domain.exception.EntidadeNaoLocalizada;
import br.com.fiap.reskillplus.domain.model.Usuario;
import br.com.fiap.reskillplus.domain.repository.UsuarioRepository;
import br.com.fiap.reskillplus.infrastructure.exceptions.InfraestruturaException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUsuarioRepository implements UsuarioRepository {

    private final DatabaseConnection databaseConnection;

    public JdbcUsuarioRepository(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    @Override
    public Usuario criarUsuario(Usuario usuario) {
        String sql = """
        INSERT INTO T_RESKILL_USUARIO
        (cpf_usuario, nome_usuario, senha, dt_nasc, end_usuario, mail_usuario)
        VALUES (?, ?, ?, ?, ?, ?)
        """;

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getCpf_usuario());
            stmt.setString(2, usuario.getNome_usuario());
            stmt.setString(3, usuario.getSenha());
            stmt.setString(4, usuario.getDt_nasc());
            stmt.setString(5, usuario.getEnd_usuario());
            stmt.setString(6, usuario.getMail_usuario());

            stmt.executeUpdate();
            return usuario;

        } catch (SQLException e) {
            throw new InfraestruturaException("Erro ao criar usuário: " + e.getMessage(), e);
        }
    }

    @Override
    public void editarUsuario(Usuario usuario) {
        String sql = """
        UPDATE T_RESKILL_USUARIO
        SET nome_usuario = ?, senha = ?, dt_nasc = ?, end_usuario = ?, mail_usuario = ?
        WHERE cpf_usuario = ?
        """;

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNome_usuario());
            stmt.setString(2, usuario.getSenha());
            stmt.setString(3, usuario.getDt_nasc());
            stmt.setString(4, usuario.getEnd_usuario());
            stmt.setString(5, usuario.getMail_usuario());
            stmt.setString(6, usuario.getCpf_usuario());

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new EntidadeNaoLocalizada("Usuário não encontrado para atualização: " + usuario.getCpf_usuario());
            }

        } catch (SQLException | EntidadeNaoLocalizada e) {
            throw new InfraestruturaException("Erro ao atualizar usuário: " + e.getMessage(), e);
        }
    }

    @Override
    public Usuario buscarUsuario(String cpf) throws EntidadeNaoLocalizada {
        String sql = """
        SELECT cpf_usuario, nome_usuario, senha, dt_nasc, end_usuario, mail_usuario
        FROM T_RESKILL_USUARIO
        WHERE cpf_usuario = ?
        """;

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Usuario(
                        rs.getString("nome_usuario"),
                        rs.getString("cpf_usuario"),
                        rs.getString("senha"),
                        rs.getString("dt_nasc"),
                        rs.getString("end_usuario"),
                        rs.getString("mail_usuario")
                );
            } else {
                throw new EntidadeNaoLocalizada("Usuário com CPF " + cpf + " não encontrado.");
            }

        } catch (SQLException e) {
            throw new InfraestruturaException("Erro ao buscar usuário: " + e.getMessage(), e);
        }
    }

    @Override
    public Usuario validarUsuario(String cpf, String senha) {
        String sql = """
        SELECT cpf_usuario, nome_usuario, senha, dt_nasc, end_usuario, mail_usuario
        FROM T_RESKILL_USUARIO
        WHERE cpf_usuario = ? AND senha = ?
        """;

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cpf);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Usuario(
                        rs.getString("nome_usuario"),
                        rs.getString("cpf_usuario"),
                        rs.getString("senha"),
                        rs.getString("dt_nasc"),
                        rs.getString("end_usuario"),
                        rs.getString("mail_usuario")
                );
            } else {
                throw new EntidadeNaoLocalizada("CPF ou senha inválidos.");
            }

        } catch (SQLException | EntidadeNaoLocalizada e) {
            throw new InfraestruturaException("Erro ao validar usuário: " + e.getMessage(), e);
        }
    }

    @Override
    public void excluirUsuario(String cpf) {
        String sql = "DELETE FROM T_RESKILL_USUARIO WHERE cpf_usuario = ?";

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cpf);

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new EntidadeNaoLocalizada("Usuário não encontrado para exclusão: " + cpf);
            }

        } catch (SQLException | EntidadeNaoLocalizada e) {
            throw new InfraestruturaException("Erro ao excluir usuário: " + e.getMessage(), e);
        }
    }
}
