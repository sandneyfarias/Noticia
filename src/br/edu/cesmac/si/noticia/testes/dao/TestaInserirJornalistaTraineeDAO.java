package br.edu.cesmac.si.noticia.testes.dao;

import java.sql.SQLException;

import br.edu.cesmac.si.noticia.dao.JornalistaTraineeDAO;
import br.edu.cesmac.si.noticia.model.JornalistaTrainee;

public class TestaInserirJornalistaTraineeDAO {

	public static void main(String[] args) {
		JornalistaTraineeDAO jornalistaTraineeDAO = new JornalistaTraineeDAO();

		JornalistaTrainee j1 = new JornalistaTrainee();
		j1.setNome("Dona Fifi");
		j1.setEmail("fifi@nol.com.br");
		j1.setSalario(1050.00);
		j1.setValeAlimentacao(150.00);

		try {
			jornalistaTraineeDAO.inserir(j1);
			System.out.println("Deu tudo certo");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
