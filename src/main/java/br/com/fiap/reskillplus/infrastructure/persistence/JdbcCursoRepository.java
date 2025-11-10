package br.com.fiap.reskillplus.infrastructure.persistence;

import br.com.fiap.reskillplus.domain.model.Curso;
import br.com.fiap.reskillplus.domain.repository.CursoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class JdbcCursoRepository implements CursoRepository {

    @Inject
    DatabaseConnection databaseConnection;

    public JdbcCursoRepository(DatabaseConnection databaseConnection) {
    }

    @Override
    public void salvar(Curso curso) {
        String sql = "INSERT INTO CURSO (TITULO, DESCRICAO, CATEGORIA, DURACAOHORAS, NIVEL, DATACRIACAO) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, curso.getTitulo());
            ps.setString(2, curso.getDescricao());
            ps.setString(3, curso.getCategoria());
            ps.setInt(4, curso.getDuracaoHoras());
            ps.setString(5, curso.getNivel());
            ps.setTimestamp(6, Timestamp.valueOf(curso.getDataCriacao()));
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar curso: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Curso> listarTodos() {
        List<Curso> cursos = new ArrayList<>();
        String sql = "SELECT * FROM CURSO";
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Curso curso = new Curso(
                        rs.getLong("ID"),
                        rs.getString("TITULO"),
                        rs.getString("DESCRICAO"),
                        rs.getString("CATEGORIA"),
                        rs.getInt("DURACAOHORAS"),
                        rs.getString("NIVEL"),
                        rs.getTimestamp("DATACRIACAO").toLocalDateTime()
                );
                cursos.add(curso);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar cursos: " + e.getMessage(), e);
        }
        return cursos;
    }

    @Override
    public Curso buscarPorId(Long id) {
        String sql = "SELECT * FROM CURSO WHERE ID = ?";
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Curso(
                            rs.getLong("ID"),
                            rs.getString("TITULO"),
                            rs.getString("DESCRICAO"),
                            rs.getString("CATEGORIA"),
                            rs.getInt("DURACAOHORAS"),
                            rs.getString("NIVEL"),
                            rs.getTimestamp("DATACRIACAO").toLocalDateTime()
                    );
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar curso por ID: " + e.getMessage(), e);
        }
        return null;
    }

    @Override
    public void atualizar(Curso curso) {
        String sql = "UPDATE CURSO SET TITULO=?, DESCRICAO=?, CATEGORIA=?, DURACAOHORAS=?, NIVEL=? WHERE ID=?";
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, curso.getTitulo());
            ps.setString(2, curso.getDescricao());
            ps.setString(3, curso.getCategoria());
            ps.setInt(4, curso.getDuracaoHoras());
            ps.setString(5, curso.getNivel());
            ps.setLong(6, curso.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar curso: " + e.getMessage(), e);
        }
    }

    @Override
    public void deletar(Long id) {
        String sql = "DELETE FROM CURSO WHERE ID = ?";
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar curso: " + e.getMessage(), e);
        }
    }
}
