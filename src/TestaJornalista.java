
public class TestaJornalista {

	public static void main(String[] args) {
		PlanoDeSaude planoDeSaude = new PlanoDeSaude("SUSMED");
		JornalistaProfissional j1 = new JornalistaProfissional();
		j1.setNome("Cid Bobeira");
		j1.setEmail("cidbobeira@nol.com");
		j1.setSalario(450000.00);
		j1.setPlanoDeSaude(planoDeSaude);
		j1.mostrarDados();
		
		JornalistaProfissional j2 = new JornalistaProfissional("Tadeu Osmit", "tosmit@nol.com.br", 120000, planoDeSaude);
		j2.mostrarDados();		
		
		JornalistaTrainee jt1 = new JornalistaTrainee();
		jt1.setNome("Gloria Azia");
		jt1.setEmail("gloriaazai@nol.com");
		jt1.setSalario(450.00);
		jt1.setValeAlimentacao(150.00);
		jt1.mostrarDados('=');
		
		JornalistaTrainee jt2 = new JornalistaTrainee("Márcio Buchudo", "buchudo@nol.com", 550.00, 150.00);
		jt2.mostrarDados('=');		
	}
	
}
