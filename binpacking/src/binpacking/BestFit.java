package binpacking;

public class BestFit {

	// Retorna o numero de pacotes necessario pelo método bestfit
	// online algorithm
	static int bestFit(int peso[], int n, int c) {
		// Inicializa o resultado (Contagem de pacotes)
		int resultado = 0;

		// Cria um vetor para guardar o espaço restante nos pacotes
		// Pode haver no máximo N pacotes.
		int pacotesRestante[] = new int[n];

		// Empacota 1 a 1
		for (int i = 0; i < n; i++) {
			// Acha o melhor pacote a ser empacotado
			// peso[i]
			int j;

			// Inicializa o espaço minimo a esquerda e o index
			// do melhor pacote
			int min = c + 1, bi = 0;

			for (j = 0; j < resultado; j++) {
				if (pacotesRestante[j] >= peso[i] && pacotesRestante[j] - peso[i] < min) {
					bi = j;
					min = pacotesRestante[j] - peso[i];
				}
			}

			// Se nenhum pacote acomoda peso[i],
			// então cria-se um novo pacote.
			if (min == c + 1) {
				pacotesRestante[resultado] = c - peso[i];
				resultado++;
			} else // escolhe o melhor pacote para um item.
				pacotesRestante[bi] -= peso[i];
		}
		return resultado;
	}
	public static void main(String[] args) {

		int peso[] = { 2, 5, 4, 7, 1, 3, 8 };
		int c = 10;
		int n = peso.length;
		System.out.println("Numero de pacotes necessários em Best Fit : " + bestFit(peso, n, c));
	}
}