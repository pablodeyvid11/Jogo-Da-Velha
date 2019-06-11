package Program;

import java.util.Random;
import java.util.Scanner;

import Game.velha;

public class Principal {

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
				System.out.print("Erro de parâmetro! %nDigite sua escolha novamente: ");
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
			velha jogo = new velha();
			jogo.organizacao();
			jogo.jogoBase();
			jogo.setGanhador(0);
			Random aleatorio = new Random();
			boolean ordem = aleatorio.nextBoolean();
			while (jogo.getGanhador() == 0) {
				System.out.println();
				if (ordem) {
					System.out.print("Jogador \"X\" faça sua jogada: ");
				} else {
					System.out.print("Jogador \"O\" faça sua jogada: ");
				}
				int jogada = sc.nextInt();
				while (jogada < 1 || jogada > 9 || jogo.testeCompatibilidade(jogada)) {
					System.out.printf("%nJogada inválida!%nPor favor digite novamente: ");
					jogada = sc.nextInt();
					System.out.println();
				}
				jogo.jogada(jogada, ordem);
				jogo.quemGanhou();
				jogo.imprimirJogo();
				ordem = !ordem;
			}
			System.out.println();
			System.out.println("===========================================");
			System.out.println("                 Resultado                 ");
			System.out.println("===========================================");
			System.out.println();
			jogo.resultado(j1, j2);
			sc.close();
			break;
		default:
			break;
		}
	}
}
