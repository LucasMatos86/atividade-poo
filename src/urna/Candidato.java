package urna;

public class Candidato {
	private int numero;
	private String nome;
	private int votos;

	public Candidato() {
	}

	public Candidato(int numero, String nome) {
		this.numero = numero;
		this.nome = nome;
		this.votos = 0;
	}

	public int getNumero() {
		return numero;
	}

	public String getNome() {
		return nome;
	}

	public int getVotos() {
		return votos;
	}

	public void incrementarVotos() {
		this.votos++;
	}
}
