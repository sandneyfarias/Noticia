package br.edu.cesmac.si.noticia.testes.dao;

import java.sql.SQLException;
import java.util.List;

import br.edu.cesmac.si.noticia.dao.JornalistaTraineeDAO;
import br.edu.cesmac.si.noticia.model.JornalistaTrainee;

public class TestaAlterarJornalistaTraineeDAO {

	public static void main(String[] args) {
		JornalistaTraineeDAO jornalistaTraineeDAO = new JornalistaTraineeDAO();

		List<JornalistaTrainee> jornalistas = jornalistaTraineeDAO.listar();

		for (JornalistaTrainee j : jornalistas) {
			j.mostrarDados('*');
		}

		JornalistaTrainee j1 = new JornalistaTrainee();
		j1.setIdJornalista(2l);
		j1.setNome("Dona Fifi Fofoca");
		j1.setEmail("fififofoca@nol.com.br");
		j1.setSalario(1150.00);
		j1.setValeAlimentacao(250.00);

		jornalistaTraineeDAO.alterar(j1);

		jornalistas = jornalistaTraineeDAO.listar();
		
		for (JornalistaTrainee j : jornalistas) {
			j.mostrarDados('*');
		}
	}

}
