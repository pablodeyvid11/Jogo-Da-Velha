package Game;

public class velha {
	private int ganhador;
	private String[][] jogo = new String[3][3];

	public void setGanhador(int ganhador) {
		this.ganhador = ganhador;
	}
	public int getGanhador() {
		return ganhador;
	}
	public void organizacao() {
		String[][] organizado = new String[3][3];
		for (int i = 0; i < organizado.length; i++) {
			for (int j = 0; j < organizado[0].length; j++) {
				organizado[i][j] = "   ";
			}
		}
		this.jogo = organizado;
	}
	public void quemGanhou() {
		String[][] teste = this.jogo;
		int cont = 0;
		for (int j = 0; j < teste.length; j++) {
			if (teste[0][j].equals(" X ")) {
				cont++;
			}
		}
		if (cont == 3) {
			this.ganhador = 1;
		}
		cont = 0;
		for (int j = 0; j < teste.length; j++) {
			if (teste[1][j].equals(" X ")) {
				cont++;
			}
		}
		if (cont == 3) {
			this.ganhador = 1;
		}
		cont = 0;
		for (int j = 0; j < teste.length; j++) {
			if (teste[2][j].equals(" X ")) {
				cont++;
			}
		}
		if (cont == 3) {
			this.ganhador = 1;
		}
		cont = 0;
		for (int j = 0; j < teste.length; j++) {
			if (teste[j][0].equals(" X ")) {
				cont++;
			}
		}
		if (cont == 3) {
			this.ganhador = 1;
		}
		cont = 0;
		for (int j = 0; j < teste.length; j++) {
			if (teste[j][1].equals(" X ")) {
				cont++;
			}
		}
		if (cont == 3) {
			this.ganhador = 1;
		}
		cont = 0;
		for (int j = 0; j < teste.length; j++) {
			if (teste[j][2].equals(" X ")) {
				cont++;
			}
		}
		if (cont == 3) {
			this.ganhador = 1;
		}
		cont = 0;
		
		for (int i = 0; i < teste.length; i++) {
			for (int j = 0; j < teste[0].length; j++) {
				if (i==j) {
					if (teste[i][j].equals(" X ")) {
						cont++;
					}
				}
			}
		}
		if (cont == 3) {
			this.ganhador = 1;
		}
		cont = 0;
		for (int i = 0; i < teste.length; i++) {
			for (int j = 0; j < teste[0].length; j++) {
				if ((i+1)+(j+1) == 4) {
					if (teste[i][j].equals(" X ")) {
						cont++;
					}
				}
			}
		}
		if (cont == 3) {
			this.ganhador = 1;
		}
		for (int j = 0; j < teste.length; j++) {
			if (teste[0][j].equals(" O ")) {
				cont++;
			}
		}
		if (cont == 3) {
			this.ganhador = 2;
		}
		cont = 0;
		for (int j = 0; j < teste.length; j++) {
			if (teste[1][j].equals(" O ")) {
				cont++;
			}
		}
		if (cont == 3) {
			this.ganhador = 2;
		}
		cont = 0;
		for (int j = 0; j < teste.length; j++) {
			if (teste[2][j].equals(" O ")) {
				cont++;
			}
		}
		if (cont == 3) {
			this.ganhador = 2;
		}
		cont = 0;
		for (int j = 0; j < teste.length; j++) {
			if (teste[j][0].equals(" O ")) {
				cont++;
			}
		}
		if (cont == 3) {
			this.ganhador = 2;
		}
		cont = 0;
		for (int j = 0; j < teste.length; j++) {
			if (teste[j][1].equals(" O ")) {
				cont++;
			}
		}
		if (cont == 3) {
			this.ganhador = 2;
		}
		cont = 0;
		for (int j = 0; j < teste.length; j++) {
			if (teste[j][2].equals(" O ")) {
				cont++;
			}
		}
		if (cont == 3) {
			this.ganhador = 2;
		}
		cont = 0;
		
		for (int i = 0; i < teste.length; i++) {
			for (int j = 0; j < teste[0].length; j++) {
				if (i==j) {
					if (teste[i][j].equals(" O ")) {
						cont++;
					}
				}
			}
		}
		if (cont == 3) {
			this.ganhador = 2;
		}
		cont = 0;
		for (int i = 0; i < teste.length; i++) {
			for (int j = 0; j < teste[0].length; j++) {
				if ((i+1)+(j+1) == 4) {
					if (teste[i][j].equals(" O ")) {
						cont++;
					}
				}
			}
		}
		if (cont == 3) {
			this.ganhador = 2;
		}
		if (this.ganhador == 0) {
			for (int i = 0; i < teste.length; i++) {
				for (int j = 0; j < teste[0].length; j++) {
					if (!teste[i][j].equals("   ")) {
						cont++;
					}
				}
			}
			if (cont == 9) {
				this.ganhador = 3;
			}
			cont = 0;
		}
		
	}
	public void jogada(int jogada, boolean peca) {
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
		if (peca) {
			this.jogo[i][j] = " X ";
		} else {
			this.jogo[i][j] = " O ";
		}
	}
	public boolean testeCompatibilidade(int jogada) {
		String[][] teste = this.jogo;
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
	public void jogoBase() {
		System.out.println();
		System.out.println(" Tabuleiro ");
		System.out.println();
		System.out.println(" 1 | 2 | 3 \t\t ");
		System.out.println("-----------\t\t Para selecionar a posição no");
		System.out.println(" 4 | 5 | 6 \t\t qual será a sua jogada, apenas");
		System.out.println("-----------\t\t digite o número representado. ");
		System.out.println(" 7 | 8 | 9 \t\t ");
	}
	public void imprimirJogo() {
		System.out.println();
		System.out.println("            Tabuleiro            ");
		System.out.println();
		System.out.println(jogo[0][0] + "||" + jogo[0][1] + "||" + jogo[0][2]);
		System.out.println("=============");
		System.out.println(jogo[1][0] + "||" + jogo[1][1] + "||" + jogo[1][2]);
		System.out.println("=============");
		System.out.println(jogo[2][0] + "||" + jogo[2][1] + "||" + jogo[2][2]);
	}
}