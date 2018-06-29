package binpacking;

public class FirstFit {

	public int firstFit(int peso[], int n, int c) {
		// Inicializa resultado (contagem de pacotes)
		int resultado = 0;

		// Cria um vetor que guarda o espaço restante dos pacotes
		int pacotesRestantes[] = new int[n];

		// Empacota itens um a um
		for (int i = 0; i < n; i++) {
			// Acha o primeiro pacote a se encaixar em peso[i]
			int j;
			for (j = 0; j < resultado; j++) {
				if (pacotesRestantes[j] >= peso[i]) {
					pacotesRestantes[j] = pacotesRestantes[j] - peso[i];
					System.out.println("\nPacote: " + (j+1) + " Item: " + peso[i]
							);
					break;
				}
			}

			// Se nenhum pacote se encaixar em peso[i]
			if (j == resultado) {
				pacotesRestantes[resultado] = c - peso[i];
				resultado++;
				System.out.println("\nPacote: " + (j+1) + " Item: " + peso[i]
						);
			}
		}
		return resultado;
	}

	

}
