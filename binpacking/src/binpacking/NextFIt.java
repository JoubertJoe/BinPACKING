package binpacking;

public class NextFIt {

	// Algoritmo NEXT FIT que retorna o número de pacotes necessários.
	public static int nextFit(int peso[], int n, int c) {
		// Iniciliza o resultado (contagem de pacotes) e a capacidade restante de
		// pacotes.
		int resultado = 1, pacotesRestantes = c;

		// Empacota itens um a um.
		for (int i = 0; i < n; i++) {
			// Caso o item não caiba neste pacote.
			if (peso[i] > pacotesRestantes) {
				resultado++; // Usa o próximo pacote
				pacotesRestantes = c - peso[i];
			} else
				pacotesRestantes -= peso[i];
			System.out.println("\nPacote: "+resultado+" Item: "+peso[i]);
		}
		
		return resultado;
	}

	

}
