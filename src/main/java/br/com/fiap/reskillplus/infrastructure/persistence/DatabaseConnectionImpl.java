package br.com.fiap.reskillplus.infrastructure.persistence;

import io.agroal.api.AgroalDataSource;
import jakarta.enterprise.context.ApplicationScoped;
import java.sql.Connection;
import java.sql.SQLException;

@ApplicationScoped
public class DatabaseConnectionImpl implements DatabaseConnection {

    private final AgroalDataSource dataSource;

    public DatabaseConnectionImpl(AgroalDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
