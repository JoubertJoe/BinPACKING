package main;

import java.util.Arrays;
import java.util.List;

import binpacking.BestFit;
import binpacking.BruteForce;
import binpacking.FirstFit;
import binpacking.NextFIt;
import util.AbstractBinPacking;

public class Principal {

	private static void teste(AbstractBinPacking algo, String algoName, int c) {
		long tempInicial;
		long tempoTotal;
		int qtdPacotesUsados;

		tempInicial = System.currentTimeMillis();
		qtdPacotesUsados = algo.getResult();
		algo.printBestBins();
		tempoTotal = System.currentTimeMillis() - tempInicial;
		System.out.println("\nNúmero de pacotes necessarios em " + algoName + ": " + qtdPacotesUsados
				+ " | Tamanho do Pacote = " + c);
		// ver tempo.
		// System.out.println("demorou " + tempoTotal + " ms");

		System.out.println("\n\n");
	}

	public static void main(String[] args) {

		List<Integer> entradaBrute = Arrays.asList(2, 5, 4, 7, 1, 3, 8);
		int peso[] = { 2, 5, 4, 7, 1, 3, 8 };
		int c = 10;
		long T1 = System.currentTimeMillis();
		BruteForce bf = new BruteForce(entradaBrute, c);
		FirstFit ff = new FirstFit();
		NextFIt nf = new NextFIt();
		BestFit bestf = new BestFit();

		System.out.println("\n-----------\nBrute Force");
		T1 = System.nanoTime();
		teste(bf, "força bruta", c);
		System.out.println("Tempo : " + (System.nanoTime() - T1) + " nanosegundos");

		System.out.println("\n-----------\nFirstFit");
		T1 = System.nanoTime();
		System.out.println("Numero de pacotes em FirstFit : " + ff.firstFit(peso, peso.length, c) + "\nTempo : "
				+ (System.nanoTime() - T1) + " nanosegundos");

		System.out.println("\n-----------\nBestFit");
		T1 = System.nanoTime();
		System.out.println("Numero de pacotes em BestFit : " + bestf.bestFit(peso, peso.length, c) + "\nTempo : "
				+ (System.nanoTime() - T1) + " nanosegundos");

		System.out.println("\n-----------\nNextFit");
		T1 = System.nanoTime();
		System.out.println("Numero de pacotes em NextFit : " + nf.nextFit(peso, peso.length, c) + "\nTempo : "
				+ (System.nanoTime() - T1) + " nanosegundos");

	}

}