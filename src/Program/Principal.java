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
		System.out.print("O primeiro jogador escolhe X ou O? ");
		String j1 = sc.next().toUpperCase().trim();
		System.out.print("O segundo jogador escolhe X ou O? ");
		String j2 = sc.next().toUpperCase().trim();
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
			while (jogada<1 || jogada >9 || jogo.testeCompatibilidade(jogada)) {
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
		if (jogo.getGanhador() == 1) {
			if (j1.equals("X")) {
				System.out.println("Jogador 1 \"X\" ganhou!");
			} else {
				System.out.println("Jogador 2 \"X\" ganhou!");
			}
		} else if (jogo.getGanhador() == 2) {
			if (j1.equals("O")) {
				System.out.println("Jogador 1 \"O\" ganhou!");
			} else {
				System.out.println("Jogador 2 \"O\" ganhou!");
			}
		} else {
			System.out.println("Deu velha... Empate!");
		}
		sc.close();
	}
}
