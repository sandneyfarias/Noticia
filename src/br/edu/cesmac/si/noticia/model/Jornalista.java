package br.edu.cesmac.si.noticia.model;

public class Jornalista extends JornalistaAbstract {
	
	protected PlanoDeSaude planoDeSaude;

	public Jornalista() {
	}
	
	public Jornalista(String nome, String email, double salario, PlanoDeSaude planoDeSaude) {
		super(nome, email, salario);
		this.planoDeSaude = planoDeSaude;
	}

	public PlanoDeSaude getPlanoDeSaude() {
		return planoDeSaude;
	}

	public void setPlanoDeSaude(PlanoDeSaude planoDeSaude) {
		this.planoDeSaude = planoDeSaude;
	}
	
	public boolean aplicaBonificacaoDe(double bonificacao) {
		if (bonificacao > (this.salario * 0.25)) {
			return false;
		}
		this.salario += bonificacao;
		return true;
	}
	
	@Override
	public void mostrarDados() {
		super.mostrarDados();
		if (this.planoDeSaude != null) {
			System.out.println(this.planoDeSaude.getNome());
		}
	}	
	
	

}
