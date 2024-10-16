package urna;

import java.util.Scanner;

public class EleicaoMain {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		
		EleicaoController eleicaoController = new EleicaoController();
		Votacao votacao = new Votacao(eleicaoController);
		int opcao = 0,numeroNovo;
		String nome, numeroVotado,numero;

		// Criação automatica para testes
		eleicaoController.cadastrarCandidato(1, "Candidato A");
		eleicaoController.cadastrarCandidato(2, "Candidato B");
		eleicaoController.cadastrarCandidato(3, "Candidato C");

		do {
			menu();
			opcao = scanner.nextInt();

			switch (opcao) {
			case 1:
				// Cadastrar
				System.out.print("Digite o número do candidato: ");
				numero = scanner.nextLine();
				
				numeroNovo=validaNumero(numero);
				
				while(eleicaoController.buscarCandidatoPorNumero(numeroNovo) != null) {
					System.out.println("Número do candidato ja cadastrado, escolha outro numero: ");
					numeroNovo = scanner.nextInt();
				}
				scanner.nextLine();

				System.out.print("Digite o nome do candidato: ");
				nome = scanner.nextLine();

				eleicaoController.cadastrarCandidato(numeroNovo, nome);

				break;

			case 2:
				// Votar
				eleicaoController.exibirCandidatos();
				System.out.print("\nDigite o número do candidato para votar: ");
				numeroVotado = scanner.nextLine();
				
				numeroNovo=validaNumero(numeroVotado);
				votacao.iniciarVotacao(numeroNovo);
				break;

			case 3:
				// Exibir o resultado
				eleicaoController.exibirResultado();
				break;

			case 0:
				// Sair
				System.out.println("Encerrando o sistema...");
				break;

			default:
				System.out.println("Opção inválida. Tente novamente.");
				break;
			}
		} while (opcao != 0);

	}

	private static void menu() {
		System.out.println("\n----- Menu de Eleição -----");
		System.out.println("1. Cadastrar Candidatos");
		System.out.println("2. Votar");
		System.out.println("3. Exibir Resultado");
		System.out.println("0. Sair");
		System.out.print("Escolha uma opção: ");
	}
	
	private static int validaNumero(String numero) {
		while (!numero.matches("[0-9]+")) {
			System.out.print("\nEntrada inválida. Digite um número válido: ");
			numero = scanner.nextLine();
		}
		Integer numeroNovo = Integer.parseInt(numero);
		return numeroNovo;
	}
}
