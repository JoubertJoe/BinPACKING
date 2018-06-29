package binpacking;

public class BestFit {

	// Retorna o numero de pacotes necessario pelo método bestfit
	// online algorithm
	public static int bestFit(int peso[], int n, int c) {

		// Inicializa o resultado (Contagem de pacotes)
		int resultado = 0;

		// Cria um vetor para guardar o espaço restante nos pacotes
		// Pode haver no máximo N pacotes.
		int pacotesRestantes[] = new int[n];

		// Empacota 1 a 1
		for (int i = 0; i < n; i++) {

			// Acha o melhor pacote a ser empacotado
			// peso[i]
			int j;

			// Inicializa o espaço minimo a esquerda e o index
			// do melhor pacote
			int min = c + 1, bi = 0;

			for (j = 0; j < resultado; j++) {
				if (pacotesRestantes[j] >= peso[i] && pacotesRestantes[j] - peso[i] < min) {
					bi = j;
					min = pacotesRestantes[j] - peso[i];
					System.out.println("\nPacote: " + (resultado) + " Item : " + peso[i]);
				}
			}

			// Se nenhum pacote acomoda peso[i],
			// então cria-se um novo pacote.
			if (min == c + 1) {
				
				pacotesRestantes[resultado] = c - peso[i];
				resultado++;
				System.out.println("\nPacote: " + resultado + " Item: " + peso[i]);
			} else // escolhe o melhor pacote para um item.
				pacotesRestantes[bi] -= peso[i];
		}
		return resultado;
	}

}
