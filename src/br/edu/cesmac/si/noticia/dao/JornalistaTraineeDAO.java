package br.edu.cesmac.si.noticia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.cesmac.si.noticia.jdbc.ConnectionFactory;
import br.edu.cesmac.si.noticia.model.JornalistaTrainee;

public class JornalistaTraineeDAO {

	public void inserir(JornalistaTrainee jornalista) throws SQLException {
		try (Connection connection = new ConnectionFactory().getConnection()) {
			connection.setAutoCommit(false);

			Long idJornalista = this.inserirJornalista(connection, jornalista);

			String sql = "INSERT INTO jornalistaTrainee" + " (idJornalista, valeAlimentacao)" + " values (?, ?)";
			PreparedStatement stmt = null;

			try {
				stmt = connection.prepareStatement(sql);
				stmt.setLong(1, idJornalista);
				stmt.setDouble(2, jornalista.getValeAlimentacao());
				stmt.executeUpdate();
				connection.commit();
			} catch (SQLException e) {
				connection.rollback();
				System.out.println(e);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	private Long inserirJornalista(Connection connection, JornalistaTrainee jornalista) {
		String sql = "INSERT INTO jornalista" + " (nome, email, salario)" + " values (?, ?, ?)";

		try {
			PreparedStatement stmt;

			stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, jornalista.getNome());
			stmt.setString(2, jornalista.getEmail());
			stmt.setDouble(3, jornalista.getSalario());
			stmt.executeUpdate();

			try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					return generatedKeys.getLong(1);
				}
			}

		} catch (SQLException e) {
			System.out.println(e);
		}

		return 0l;
	}

	public void alterar(JornalistaTrainee jornalista) {
		try (Connection connection = new ConnectionFactory().getConnection()) {
			connection.setAutoCommit(false);
			this.alterarJornalista(connection, jornalista);

			String sql = "UPDATE jornalistaTrainee " + "SET valeAlimentacao = ? " + "WHERE idJornalista = ?";
			try {
				PreparedStatement stmt;

				stmt = connection.prepareStatement(sql);
				stmt.setDouble(1, jornalista.getValeAlimentacao());
				stmt.setLong(2, jornalista.getIdJornalista());

				stmt.execute();
				stmt.close();
				connection.commit();
			} catch (SQLException e) {
				connection.rollback();				
				System.out.println(e);
			}

		} catch (SQLException e1) {
			System.out.println(e1);
		}
	}

	public void alterarJornalista(Connection connection, JornalistaTrainee jornalista) {
		String sql = "UPDATE jornalista " + "SET nome = ?, " + " email = ?, " + " salario = ? "
				+ "WHERE idJornalista = ?";

		try {
			PreparedStatement stmt;

			stmt = connection.prepareStatement(sql);
			stmt.setString(1, jornalista.getNome());
			stmt.setString(2, jornalista.getEmail());
			stmt.setDouble(3, jornalista.getSalario());
			stmt.setLong(4, jornalista.getIdJornalista());

			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public void excluirPorId(Long idJornalista) {
		try (Connection connection = new ConnectionFactory().getConnection()) {
			connection.setAutoCommit(false);
			this.excluirJornalistaTraineePorId(connection, idJornalista);
			this.excluirJornalistaPorId(connection, idJornalista);
			connection.commit();
		} catch (SQLException e1) {
			System.out.println(e1);
		}
	}

	private void excluirJornalistaTraineePorId(Connection connection, Long idJornalista) {
		String sql = "DELETE FROM jornalistaTrainee WHERE idJornalista = ?";

		try {
			PreparedStatement stmt;

			stmt = connection.prepareStatement(sql);
			stmt.setLong(1, idJornalista);

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	private void excluirJornalistaPorId(Connection connection, Long idJornalista) {
		String sql = "DELETE FROM jornalista WHERE idJornalista = ?";

		try {
			PreparedStatement stmt;

			stmt = connection.prepareStatement(sql);
			stmt.setLong(1, idJornalista);

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public List<JornalistaTrainee> listar() {
		List<JornalistaTrainee> jornalistas = new ArrayList<JornalistaTrainee>();

		try (Connection connection = new ConnectionFactory().getConnection()) {

			try {
				String sql = "SELECT j.idJornalista, nome, email, salario, valealimentacao " + " FROM jornalista j "
						+ " INNER JOIN jornalistaTrainee jt ON jt.idJornalista = j.idJornalista "
						+ " ORDER BY nome";

				PreparedStatement stmt = connection.prepareStatement(sql);
				ResultSet resultado = stmt.executeQuery();

				while (resultado.next()) {
					Long idJornalista = resultado.getLong("idJornalista");
					String nome = resultado.getString("nome");
					String email = resultado.getString("email");
					Double salario = resultado.getDouble("salario");
					Double valeAlimentacao = resultado.getDouble("valeAlimentacao");

					JornalistaTrainee jornalista = new JornalistaTrainee();
					jornalista.setIdJornalista(idJornalista);
					jornalista.setNome(nome);
					jornalista.setEmail(email);
					jornalista.setSalario(salario);
					jornalista.setValeAlimentacao(valeAlimentacao);

					jornalistas.add(jornalista);
				}

				resultado.close();
				stmt.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}

		return jornalistas;
	}

}
