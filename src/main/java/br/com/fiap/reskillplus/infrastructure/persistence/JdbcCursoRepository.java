package br.com.fiap.reskillplus.infrastructure.persistence;

import br.com.fiap.reskillplus.domain.model.Curso;
import br.com.fiap.reskillplus.domain.repository.CursoRepository;
import br.com.fiap.reskillplus.infrastructure.exceptions.CursoException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcCursoRepository implements CursoRepository {

    private final DatabaseConnection databaseConnection;

    public JdbcCursoRepository(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    @Override
    public void salvar(Curso curso) {
        String sql = "INSERT INTO cursos (titulo, descricao, categoria, carga_horaria) VALUES (?, ?, ?, ?)";
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, curso.getTitulo());
            stmt.setString(2, curso.getDescricao());
            stmt.setString(3, curso.getCategoria());
            stmt.setInt(4, curso.getCargaHoraria());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new CursoException("Erro ao salvar curso", e);
        }
    }

    @Override
    public void atualizar(Curso curso) {
        String sql = "UPDATE cursos SET titulo=?, descricao=?, categoria=?, carga_horaria=? WHERE id=?";
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, curso.getTitulo());
            stmt.setString(2, curso.getDescricao());
            stmt.setString(3, curso.getCategoria());
            stmt.setInt(4, curso.getCargaHoraria());
            stmt.setInt(5, curso.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new CursoException("Erro ao atualizar curso", e);
        }
    }

    @Override
    public void deletar(int id) {
        String sql = "DELETE FROM cursos WHERE id=?";
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new CursoException("Erro ao deletar curso", e);
        }
    }

    @Override
    public Curso buscarPorId(int id) {
        String sql = "SELECT * FROM cursos WHERE id=?";
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Curso(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("descricao"),
                        rs.getString("categoria"),
                        rs.getInt("carga_horaria")
                );
            }
            return null;
        } catch (SQLException e) {
            throw new CursoException("Erro ao buscar curso", e);
        }
    }

    @Override
    public List<Curso> listarTodos() {
        List<Curso> cursos = new ArrayList<>();
        String sql = "SELECT * FROM cursos";
        try (Connection conn = databaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                cursos.add(new Curso(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("descricao"),
                        rs.getString("categoria"),
                        rs.getInt("carga_horaria")
                ));
            }
        } catch (SQLException e) {
            throw new CursoException("Erro ao listar cursos", e);
        }
        return cursos;
    }
}
