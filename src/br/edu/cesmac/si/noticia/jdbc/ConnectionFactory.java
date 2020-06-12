package br.edu.cesmac.si.noticia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:postgresql://localhost:15432/noticiassi", "postgres",
					"Postgres2019!");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
