package br.com.fiap.reskillplus.infrastructure.persistence;

import br.com.fiap.reskillplus.domain.model.Usuario;
import br.com.fiap.reskillplus.domain.repository.UsuarioRepository;
import br.com.fiap.reskillplus.infrastructure.exceptions.UsuarioException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcUsuarioRepository implements UsuarioRepository {

    private final DatabaseConnection databaseConnection;

    public JdbcUsuarioRepository(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    @Override
    public void salvar(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nome, email, senha, papel) VALUES (?, ?, ?, ?)";
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            stmt.setString(4, usuario.getPapel());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new UsuarioException("Erro ao salvar usuário", e);
        }
    }

    @Override
    public void atualizar(Usuario usuario) {

    }

    @Override
    public void deletar(int id) {

    }

    @Override
    public Usuario buscarPorId(int id) {
        return null;
    }

    @Override
    public Usuario buscarPorEmail(String email) {
        String sql = "SELECT * FROM usuarios WHERE email = ?";
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Usuario(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha"),
                        rs.getString("papel")
                );
            }
        } catch (SQLException e) {
            throw new UsuarioException("Erro ao buscar usuário por e-mail", e);
        }
        return null;
    }

    @Override
    public List<Usuario> listarTodos() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        try (Connection conn = databaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                usuarios.add(new Usuario(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha"),
                        rs.getString("papel")
                ));
            }
        } catch (SQLException e) {
            throw new UsuarioException("Erro ao listar usuários", e);
        }
        return usuarios;
    }
}
