package Program;

import java.util.Random;
import java.util.Scanner;

public class Principal {

	private static int ganhador = 0;
	private static String[][] jogo = { { "   ", "   ", "   " }, { "   ", "   ", "   " }, { "   ", "   ", "   " } };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("===========================================");
		System.out.println("               Jogo da velha               ");
		System.out.println("===========================================");
		System.out.println();
		System.out.println("1 - 1 jogador;");
		System.out.println("2 - 2 jogadores.");
		System.out.print("Você escolhe qual modo? ");
		byte modo = sc.nextByte();
		while (modo != 1 && modo != 2) {
			System.out.printf("Erro de parâmetro! %nDigite o modo de jogo novamente: ");
			modo = sc.nextByte();
		}
		switch (modo) {
		case 1:

			break;
		case 2:
			System.out.print("O primeiro jogador escolhe X ou O? ");
			String j1 = sc.next().toUpperCase().trim();
			while (!j1.equals("X") && !j1.equals("O")) {
				System.out.printf("Erro de parâmetro! %nDigite sua escolha novamente: ");
				j1 = sc.next().toUpperCase().trim();
			}
			String j2;
			if (j1.equals("X")) {
				System.out.println();
				System.out.printf("Primeiro Jogador fica com \"X\"; %nSegundo jogador fica com \"O\".");
				j2 = "O";
				System.out.println();
			} else {
				System.out.println();
				System.out.printf("Primeiro Jogador fica com \"O\"; %nSegundo jogador fica com \"X\".");
				j2 = "O";
				System.out.println();
			}
			jogoBase();
			Random aleatorio = new Random();
			boolean ordem = aleatorio.nextBoolean();
			while (ganhador == 0) {
				System.out.println();
				if (ordem) {
					System.out.print("Jogador \"X\" faça sua jogada: ");
				} else {
					System.out.print("Jogador \"O\" faça sua jogada: ");
				}
				int jogada = sc.nextInt();
				while (jogada < 1 || jogada > 9 || testeCompatibilidade(jogada)) {
					System.out.printf("%nJogada inválida!%nPor favor digite novamente: ");
					jogada = sc.nextInt();
					System.out.println();
				}
				jogada(jogada, ordem);
				quemGanhou();
				imprimirJogo();
				ordem = !ordem;
			}
			System.out.println();
			System.out.println("===========================================");
			System.out.println("                 Resultado                 ");
			System.out.println("===========================================");
			System.out.println();
			resultado(j1, j2);
			sc.close();
			break;
		default:
			break;
		}
	}

	public static void jogada(int jogada, boolean peca) {
		int i, j;
		if (jogada == 1) {
			i = 0;
			j = 0;
		} else if (jogada == 2) {
			i = 0;
			j = 1;
		} else if (jogada == 3) {
			i = 0;
			j = 2;
		} else if (jogada == 4) {
			i = 1;
			j = 0;
		} else if (jogada == 5) {
			i = 1;
			j = 1;
		} else if (jogada == 6) {
			i = 1;
			j = 2;
		} else if (jogada == 7) {
			i = 2;
			j = 0;
		} else if (jogada == 8) {
			i = 2;
			j = 1;
		} else {
			i = 2;
			j = 2;
		}
		if (peca == true) {
			jogo[i][j] = " X ";
		} else {
			jogo[i][j] = " O ";
		}
	}

	public static void quemGanhou() {
		String[][] teste = jogo;
		int cont = 0;
		for (int j = 0; j < teste.length; j++) {
			if (teste[0][j].equals(" X ")) {
				cont++;
			}
		}
		if (cont == 3) {
			ganhador = 1;
		}
		cont = 0;
		for (int j = 0; j < teste.length; j++) {
			if (teste[1][j].equals(" X ")) {
				cont++;
			}
		}
		if (cont == 3) {
			ganhador = 1;
		}
		cont = 0;
		for (int j = 0; j < teste.length; j++) {
			if (teste[2][j].equals(" X ")) {
				cont++;
			}
		}
		if (cont == 3) {
			ganhador = 1;
		}
		cont = 0;
		for (int j = 0; j < teste.length; j++) {
			if (teste[j][0].equals(" X ")) {
				cont++;
			}
		}
		if (cont == 3) {
			ganhador = 1;
		}
		cont = 0;
		for (int j = 0; j < teste.length; j++) {
			if (teste[j][1].equals(" X ")) {
				cont++;
			}
		}
		if (cont == 3) {
			ganhador = 1;
		}
		cont = 0;
		for (int j = 0; j < teste.length; j++) {
			if (teste[j][2].equals(" X ")) {
				cont++;
			}
		}
		if (cont == 3) {
			ganhador = 1;
		}
		cont = 0;
		for (int i = 0; i < teste.length; i++) {
			for (int j = 0; j < teste[0].length; j++) {
				if (i == j) {
					if (teste[i][j].equals(" X ")) {
						cont++;
					}
				}
			}
		}
		if (cont == 3) {
			ganhador = 1;
		}
		cont = 0;
		for (int i = 0; i < teste.length; i++) {
			for (int j = 0; j < teste[0].length; j++) {
				if ((i + 1) + (j + 1) == 4) {
					if (teste[i][j].equals(" X ")) {
						cont++;
					}
				}
			}
		}
		if (cont == 3) {
			ganhador = 1;
		}
		cont = 0;
		for (int j = 0; j < teste.length; j++) {
			if (teste[0][j].equals(" O ")) {
				cont++;
			}
		}
		if (cont == 3) {
			ganhador = 2;
		}
		cont = 0;
		for (int j = 0; j < teste.length; j++) {
			if (teste[1][j].equals(" O ")) {
				cont++;
			}
		}
		if (cont == 3) {
			ganhador = 2;
		}
		cont = 0;
		for (int j = 0; j < teste.length; j++) {
			if (teste[2][j].equals(" O ")) {
				cont++;
			}
		}
		if (cont == 3) {
			ganhador = 2;
		}
		cont = 0;
		for (int j = 0; j < teste.length; j++) {
			if (teste[j][0].equals(" O ")) {
				cont++;
			}
		}
		if (cont == 3) {
			ganhador = 2;
		}
		cont = 0;
		for (int j = 0; j < teste.length; j++) {
			if (teste[j][1].equals(" O ")) {
				cont++;
			}
		}
		if (cont == 3) {
			ganhador = 2;
		}
		cont = 0;
		for (int j = 0; j < teste.length; j++) {
			if (teste[j][2].equals(" O ")) {
				cont++;
			}
		}
		if (cont == 3) {
			ganhador = 2;
		}
		cont = 0;

		for (int i = 0; i < teste.length; i++) {
			for (int j = 0; j < teste[0].length; j++) {
				if (i == j) {
					if (teste[i][j].equals(" O ")) {
						cont++;
					}
				}
			}
		}
		if (cont == 3) {
			ganhador = 2;
		}
		cont = 0;
		for (int i = 0; i < teste.length; i++) {
			for (int j = 0; j < teste[0].length; j++) {
				if ((i + 1) + (j + 1) == 4) {
					if (teste[i][j].equals(" O ")) {
						cont++;
					}
				}
			}
		}
		if (cont == 3) {
			ganhador = 2;
		}
		cont = 0;
		if (ganhador == 0) {
			for (int i = 0; i < teste.length; i++) {
				for (int j = 0; j < teste[0].length; j++) {
					if (jogo[i][j].equals(" X ") || jogo[i][j].equals(" O ")) {
						cont++;
					}
				}
			}
			if (cont == 9) {
				ganhador = 3;
			}
			cont = 0;
		}

	}

	public static boolean testeCompatibilidade(int jogada) {
		String[][] teste = jogo;
		int i, j;
		if (jogada == 1) {
			i = 0;
			j = 0;
		} else if (jogada == 2) {
			i = 0;
			j = 1;
		} else if (jogada == 3) {
			i = 0;
			j = 2;
		} else if (jogada == 4) {
			i = 1;
			j = 0;
		} else if (jogada == 5) {
			i = 1;
			j = 1;
		} else if (jogada == 6) {
			i = 1;
			j = 2;
		} else if (jogada == 7) {
			i = 2;
			j = 0;
		} else if (jogada == 8) {
			i = 2;
			j = 1;
		} else {
			i = 2;
			j = 2;
		}
		if (teste[i][j].equals(" X ") || teste[i][j].equals(" O ")) {
			return true;
		} else {
			return false;
		}
	}

	public static void jogoBase() {
		System.out.println();
		System.out.println(" Tabuleiro ");
		System.out.println();
		System.out.println(" 1 | 2 | 3 \t\t ");
		System.out.println("-----------\t\t Para selecionar a posição no");
		System.out.println(" 4 | 5 | 6 \t\t qual será a sua jogada, apenas");
		System.out.println("-----------\t\t digite o número representado. ");
		System.out.println(" 7 | 8 | 9 \t\t ");
	}

	public static void resultado(String j1, String j2) {
		if (ganhador == 1) {
			if (j1.equals("X")) {
				System.out.println("Jogador 1 \"X\" ganhou!");
			} else {
				System.out.println("Jogador 2 \"X\" ganhou!");
			}
		} else if (ganhador == 2) {
			if (j1.equals("O")) {
				System.out.println("Jogador 1 \"O\" ganhou!");
			} else {
				System.out.println("Jogador 2 \"O\" ganhou!");
			}
		} else {
			System.out.println("Deu velha... Empate!");
		}
	}

	public static void imprimirJogo() {
		System.out.println();
		System.out.println("            Tabuleiro            ");
		System.out.println();
		System.out.println(jogo[0][0] + "|" + jogo[0][1] + "|" + jogo[0][2] + "\t\t 1 | 2 | 3 ");
		System.out.println("-----------" + "\t\t-----------");
		System.out.println(jogo[1][0] + "|" + jogo[1][1] + "|" + jogo[1][2] + "\t\t 4 | 5 | 6 ");
		System.out.println("-----------" + "\t\t-----------");
		System.out.println(jogo[2][0] + "|" + jogo[2][1] + "|" + jogo[2][2] + "\t\t 7 | 8 | 9 ");
		System.out.println();
	}
}
