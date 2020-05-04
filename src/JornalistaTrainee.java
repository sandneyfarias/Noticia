public class JornalistaTrainee extends Jornalista {

	private double valeAlimentacao;

	public JornalistaTrainee() {
	}

	public JornalistaTrainee(String nome, String email, double salario, double valeAlimentacao) {
		super(nome, email, salario);
		this.valeAlimentacao = valeAlimentacao;
	}

	public double getValeAlimentacao() {
		return valeAlimentacao;
	}

	public void setValeAlimentacao(double valeAlimentacao) {
		this.valeAlimentacao = valeAlimentacao;
	}

	@Override
	public void mostrarDados() {
		super.mostrarDados();
		System.out.println(valeAlimentacao);
	}

	void mostrarDados(char ornamento) {
		System.out.println(String.valueOf(ornamento).repeat(50));
		super.mostrarDados();
		System.out.println(valeAlimentacao);
		System.out.println(String.valueOf(ornamento).repeat(50));
	}

}
