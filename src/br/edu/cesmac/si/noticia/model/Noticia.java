package br.edu.cesmac.si.noticia.model;

public class Noticia {
	private String titulo;
	private String resumo;
	private String texto;
	private JornalistaAbstract jornalista;

	public Noticia() {
		System.out.println("A notícia foi criada");
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public JornalistaAbstract getJornalista() {
		return jornalista;
	}

	public void setJornalista(JornalistaAbstract jornalista) {
		this.jornalista = jornalista;
	}

	boolean temJornalista() {
		return jornalista != null;
	}

	void mostrarDados() {
		System.out.println("-------Notícia-------");
		System.out.println(titulo);
		System.out.println(resumo);
		System.out.println(texto);
		if (temJornalista()) {
			jornalista.mostrarDados();
		}
	}
}
