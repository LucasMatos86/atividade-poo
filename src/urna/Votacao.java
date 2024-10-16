package urna;

import java.util.Scanner;

public class Votacao {
	private EleicaoController eleicaoController;
	static Scanner scanner = new Scanner(System.in);

	public Votacao(EleicaoController eleicaoController) {
		this.eleicaoController = eleicaoController;
	}

	public void iniciarVotacao(int numero) {

		Candidato candidato = eleicaoController.buscarCandidatoPorNumero(numero);
		char confirmacao, confirmacaoNulo, verificacao;

		if (candidato != null) {
			System.out.println("Você está votando em: " + candidato.getNome());
			System.out.print("Confirma o voto? (S/N): ");
			confirmacao = scanner.next().toUpperCase().charAt(0);

			verificacao = validaCaractere(confirmacao);

			if (verificacao == 'S') {
				candidato.incrementarVotos();
				System.out.println("Voto confirmado!\n");
			} else {
				System.out.println("Voto não confirmado.\n");
			}
		} else {
			System.out.println("Número inválido. Deseja confirmar voto nulo? (S/N): ");
			confirmacaoNulo = scanner.next().toUpperCase().charAt(0);

			verificacao = validaCaractere(confirmacaoNulo);
			if (verificacao == 'S') {
				System.out.println("Voto nulo confirmado!\n");
			} else {
				System.out.println("Voto nulo não confirmado.\n");
			}
		}
	}

	private static char validaCaractere(char a) {
		while (a != 'S' && a != 'N') {
			System.out.println("Opção inválida! Por favor, digite 'S' para Sim ou 'N' para Não.");
			System.out.print("Deseja confirmar voto nulo? (S/N): ");
			a = scanner.next().toUpperCase().charAt(0);
		}
		char validado = a;

		return validado;
	}
}
