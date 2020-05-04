public abstract class Jornalista {
	
	protected String nome;
	protected String email;
	protected double salario;

	public Jornalista() {
	}

	public Jornalista(String nome, String email, double salario) {
		this.nome = nome;
		this.email = email;
		this.salario = salario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public void mostrarDados() {
		System.out.println("------- Jornalista-------");
		System.out.println(nome);
		System.out.println(email);
		System.out.println(salario);
	}

}
