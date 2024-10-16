package urna;

import java.util.ArrayList;

public class EleicaoController {
	private ArrayList<Candidato> candidatos;

	public EleicaoController() {
		this.candidatos = new ArrayList<>();
	}

	public void cadastrarCandidato(int numero, String nome) {
		candidatos.add(new Candidato(numero, nome));
	}

	public Candidato buscarCandidatoPorNumero(int numero) {
		for (Candidato candidato : candidatos) {
			if (candidato.getNumero() == numero) {
				return candidato;
			}
		}
		return null;
	}

	public void exibirCandidatos() {
		System.out.println("\nCandidatos:");
		for (Candidato candidato : candidatos) {
			System.out.println("Número: " + candidato.getNumero() + " - Nome: " + candidato.getNome());
		}
	}

	public void exibirResultado() {
		System.out.println("\nResultado final:");
		for (Candidato candidato : candidatos) {
			System.out.println("Número: " + candidato.getNumero() + " - Nome: " + candidato.getNome() + " - Votos: "
					+ candidato.getVotos());
		}
	}
}
