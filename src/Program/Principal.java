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
		System.out.print("Voc� escolhe qual modo? ");
		byte modo = sc.nextByte();
		while (modo != 1 && modo != 2) {
			System.out.printf("Erro de par�metro! %nDigite o modo de jogo novamente: ");
			modo = sc.nextByte();
		}
		if (modo == 1) {

			System.out.println();
			System.out.printf("N�veis: %n1- F�cil; %n2- M�dio; %n3- Dif�cil.%n%n");
			System.out.print("Fa�a sua escolha: ");
			int nivel = sc.nextInt();
			while (nivel < 1 || nivel > 3) {
				System.out.printf("Erro de par�metro! %nDigite sua escolha novamente: ");
				nivel = sc.nextInt();
			}
			System.out.printf("%nO jogador escolhe \"X\" ou \"O\"? ");
			String j2, j1 = sc.next().trim().toUpperCase();
			while (!j1.equals("X") && !j1.equals("O")) {
				System.out.printf("Erro de par�metro! %nDigite sua escolha novamente: ");
				j1 = sc.next().toUpperCase().trim();
			}
			if (j1.equals("X")) {
				System.out.printf("%nO jogador ficou com \"X\"; %nO computador ficou com \"O\". ");
				j2 = "O";
			} else {
				System.out.printf("%nO jogador ficou com \"O\"; %nO computador ficou com \"X\".%n");
				j2 = "X";
			}
			jogoBase();
			Random aleatorio = new Random();
			boolean ordem = aleatorio.nextBoolean();
			while (ganhador == 0) {
				System.out.println();
				int jogada;
				if (ordem) {
					if (j1.equals("X")) {
						System.out.print("Jogador \"X\" fa�a a sua jogada: ");
						jogada = sc.nextInt();
						while (jogada < 1 || jogada > 9 || testeCompatibilidade(jogada)) {
							System.out.printf("%nJogada inv�lida!%nPor favor digite novamente: ");
							jogada = sc.nextInt();
							System.out.println();
						}
					} else {
						System.out.println("Vez do computado: ");
						jogada = aleatorio.nextInt(9) + 1;
						while (testeCompatibilidade(jogada)) {
							jogada = aleatorio.nextInt(9) + 1;
						}
						System.out.println("O computador jogou na casa: " + jogada);
					}
				} else {
					if (j1.equals("O")) {
						System.out.print("Jogador \"O\" fa�a a sua jogada: ");
						jogada = sc.nextInt();
						while (jogada < 1 || jogada > 9 || testeCompatibilidade(jogada)) {
							System.out.printf("%nJogada inv�lida!%nPor favor digite novamente: ");
							jogada = sc.nextInt();
							System.out.println();
						}
					} else {
						System.out.println("Vez do computado: ");
						jogada = aleatorio.nextInt(9) + 1;
						while (testeCompatibilidade(jogada)) {
							jogada = aleatorio.nextInt(9) + 1;
						}
						System.out.println("O computador jogou na casa: " + jogada);
					}
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
		} else {
			System.out.print("O primeiro jogador escolhe X ou O? ");
			String j1 = sc.next().toUpperCase().trim();
			while (!j1.equals("X") && !j1.equals("O")) {
				System.out.printf("Erro de par�metro! %nDigite sua escolha novamente: ");
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
				j2 = "X";
				System.out.println();
			}
			jogoBase();
			Random aleatorio = new Random();
			boolean ordem = aleatorio.nextBoolean();
			while (ganhador == 0) {
				System.out.println();
				if (ordem) {
					System.out.print("Jogador \"X\" fa�a sua jogada: ");
				} else {
					System.out.print("Jogador \"O\" fa�a sua jogada: ");
				}
				int jogada = sc.nextInt();
				while (jogada < 1 || jogada > 9 || testeCompatibilidade(jogada)) {
					System.out.printf("%nJogada inv�lida!%nPor favor digite novamente: ");
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

	public static boolean testeCompatibilidade(int jogada) {
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
		if (!jogo[i][j].equals("   ")) {
			return true;
		} else {
			return false;
		}
	}

	public static void quemGanhou() {
		int cont = 0;
		for (int i = 0; i < jogo.length; i++) {
			for (int j = 0; j < jogo[0].length; j++) {
				if (jogo[i][j].equals(" X ")) {
					cont++;
				}
			}
			if (cont == 3) {
				ganhador = 1;
			}
			cont = 0;
		}
		for (int i = 0; i < jogo.length; i++) {
			for (int j = 0; j < jogo[0].length; j++) {
				if (jogo[j][i].equals(" X ")) {
					cont++;
				}
			}
			if (cont == 3) {
				ganhador = 1;
			}
			cont = 0;
		}
		for (int i = 0; i < jogo.length; i++) {
			for (int j = 0; j < jogo[0].length; j++) {
				if (i == j) {
					if (jogo[i][j].equals(" X ")) {
						cont++;
					}
				}
			}
		}
		if (cont == 3) {
			ganhador = 1;
		}
		cont = 0;
		for (int i = 0; i < jogo.length; i++) {
			for (int j = 0; j < jogo[0].length; j++) {
				if ((i + 1) + (j + 1) == 4) {
					if (jogo[i][j].equals(" X ")) {
						cont++;
					}
				}
			}
		}
		if (cont == 3) {
			ganhador = 1;
		}
		cont = 0;
		for (int i = 0; i < jogo.length; i++) {
			for (int j = 0; j < jogo[0].length; j++) {
				if (jogo[i][j].equals(" O ")) {
					cont++;
				}
			}
			if (cont == 3) {
				ganhador = 1;
			}
			cont = 0;
		}
		for (int i = 0; i < jogo.length; i++) {
			for (int j = 0; j < jogo[0].length; j++) {
				if (jogo[j][i].equals(" O ")) {
					cont++;
				}
			}
			if (cont == 3) {
				ganhador = 1;
			}
			cont = 0;
		}
		for (int i = 0; i < jogo.length; i++) {
			for (int j = 0; j < jogo[0].length; j++) {
				if (i == j) {
					if (jogo[i][j].equals(" O ")) {
						cont++;
					}
				}
			}
		}
		if (cont == 3) {
			ganhador = 2;
		}
		cont = 0;
		for (int i = 0; i < jogo.length; i++) {
			for (int j = 0; j < jogo[0].length; j++) {
				if ((i + 1) + (j + 1) == 4) {
					if (jogo[i][j].equals(" O ")) {
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
			for (int i = 0; i < jogo.length; i++) {
				for (int j = 0; j < jogo[0].length; j++) {
					if (!jogo[i][j].equals("   ")) {
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

	public static void jogoBase() {
		System.out.println();
		System.out.println(" Tabuleiro ");
		System.out.println();
		System.out.println(" 1 | 2 | 3 \t\t ");
		System.out.println("-----------\t\t Para selecionar a posi��o no");
		System.out.println(" 4 | 5 | 6 \t\t qual ser� a sua jogada, apenas");
		System.out.println("-----------\t\t digite o n�mero representado. ");
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
