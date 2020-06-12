package br.edu.cesmac.si.noticia.testes.dao;

import java.sql.SQLException;
import java.util.List;

import br.edu.cesmac.si.noticia.dao.JornalistaTraineeDAO;
import br.edu.cesmac.si.noticia.model.JornalistaTrainee;

public class TestaExcluirJornalistaTraineeDAO {

	public static void main(String[] args) {
		JornalistaTraineeDAO jornalistaTraineeDAO = new JornalistaTraineeDAO();

		List<JornalistaTrainee> jornalistas = jornalistaTraineeDAO.listar();

		for (JornalistaTrainee j : jornalistas) {
			j.mostrarDados('*');
		}

		JornalistaTrainee j1 = new JornalistaTrainee();
		
		jornalistaTraineeDAO.excluirPorId(2l);
		
		jornalistas = jornalistaTraineeDAO.listar();
		
		for (JornalistaTrainee j : jornalistas) {
			j.mostrarDados('*');
		}
	}

}
