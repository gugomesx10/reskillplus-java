package br.com.fiap.reskillplus.infrastructure.persistence;

import br.com.fiap.reskillplus.domain.model.Usuario;
import br.com.fiap.reskillplus.domain.repository.UsuarioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class JdbcUsuarioRepository implements UsuarioRepository {

    @Inject
    DatabaseConnection databaseConnection;

    public JdbcUsuarioRepository(DatabaseConnection databaseConnection) {
    }

    @Override
    public void salvar(Usuario usuario) {
        String sql = "INSERT INTO USUARIO (NOME, EMAIL, SENHA, NIVELEDUCACAO, AREASINTERESSE, DATACRIACAO) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getSenha());
            ps.setString(4, usuario.getNivelEducacao());
            ps.setString(5, usuario.getAreasInteresse());
            ps.setTimestamp(6, Timestamp.valueOf(usuario.getDataCriacao()));
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar usuário: " + e.getMessage(), e);
        }
    }

    @Override
    public Usuario buscarPorId(Long id) {
        String sql = "SELECT * FROM USUARIO WHERE ID = ?";
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Usuario(
                            rs.getLong("ID"),
                            rs.getString("NOME"),
                            rs.getString("EMAIL"),
                            rs.getString("SENHA"),
                            rs.getString("NIVELEDUCACAO"),
                            rs.getString("AREASINTERESSE"),
                            rs.getTimestamp("DATACRIACAO").toLocalDateTime()
                    );
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar usuário por ID: " + e.getMessage(), e);
        }
        return null;
    }

    @Override
    public Usuario buscarPorEmail(String email) {
        String sql = "SELECT * FROM USUARIO WHERE EMAIL = ?";
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Usuario(
                            rs.getLong("ID"),
                            rs.getString("NOME"),
                            rs.getString("EMAIL"),
                            rs.getString("SENHA"),
                            rs.getString("NIVELEDUCACAO"),
                            rs.getString("AREASINTERESSE"),
                            rs.getTimestamp("DATACRIACAO").toLocalDateTime()
                    );
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar usuário por e-mail: " + e.getMessage(), e);
        }
        return null;
    }

    @Override
    public List<Usuario> listarTodos() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM USUARIO";
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                usuarios.add(new Usuario(
                        rs.getLong("ID"),
                        rs.getString("NOME"),
                        rs.getString("EMAIL"),
                        rs.getString("SENHA"),
                        rs.getString("NIVELEDUCACAO"),
                        rs.getString("AREASINTERESSE"),
                        rs.getTimestamp("DATACRIACAO").toLocalDateTime()
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar usuários: " + e.getMessage(), e);
        }
        return usuarios;
    }

    @Override
    public void atualizar(Usuario usuario) {
        String sql = "UPDATE USUARIO SET NOME=?, EMAIL=?, SENHA=?, NIVELEDUCACAO=?, AREASINTERESSE=? WHERE ID=?";
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getSenha());
            ps.setString(4, usuario.getNivelEducacao());
            ps.setString(5, usuario.getAreasInteresse());
            ps.setLong(6, usuario.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar usuário: " + e.getMessage(), e);
        }
    }

    @Override
    public void deletar(Long id) {
        String sql = "DELETE FROM USUARIO WHERE ID = ?";
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar usuário: " + e.getMessage(), e);
        }
    }
}
