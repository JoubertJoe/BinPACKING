package binpacking;

import java.util.ArrayList;
import java.util.List;

import util.AbstractBinPacking;
import util.Bin;

public class BruteForce extends AbstractBinPacking {

    private List<Bin> bins = new ArrayList<Bin>();
    private int melhorSolucaoAtual;
    private List<Bin> melhorPacoteAtual;
    private int pacoteAtual = 1;

    /**
     * Solução em força bruta para o problema. O problema de Bin Packing
     * é N fatorial complexo, então o algoritmo levará um longo tempo para comletar
     *
     * @param in
     * @param tamanhoPacote
     */
    public BruteForce(List<Integer> in, int tamanhoPacote) {
        super(in, tamanhoPacote);
        this.melhorPacoteAtual = new ArrayList<Bin>();
        // Cria o máximo de pacotes neessários
        for (Integer in1 : in) {
            bins.add(new Bin(tamanhoPacote));
        }
        // Solução do pior caso: Cada item, um pacote.
        melhorSolucaoAtual = in.size();
    }

    @Override
    public int getResult() {
        // Chama bruteforce, com o input, começando na posição 0
        bruteforce(in, 0);

        return melhorSolucaoAtual;
    }

    /**
     * Solução em força burta para o problema
     *
     * @param in Lista de itens a ser empacotados
     * @param currentPosition Posição atual na lista
     */
    private void bruteforce(List<Integer> in, int currentPosition) {
        if (currentPosition >= in.size()) { // alcançou o ultimo item, iteração encerrada.
            int pacotesPreenchidos = getpacotesPreenchidosCount();
            if (pacotesPreenchidos < melhorSolucaoAtual) { // A solução é melhor do que a "melhor já encontrada"?
                melhorSolucaoAtual = pacotesPreenchidos; // Se sim, a salva.
                melhorPacoteAtual = deepCopy(bins);
            }
            return;
        }
        // Itera sobre os pacotes
        Integer currentItem = in.get(currentPosition);
        for (Bin bin : bins) {
            if (bin.put(currentItem)) {
                bruteforce(in, currentPosition + 1);
                bin.remove(currentItem);
            } // else: item não cabe no pacote, ignora.
        }
    }

    /**
     * Retorna quantos pacotes tem pelo menos um item dentro.
     *
     * @return
     */
    private int getpacotesPreenchidosCount() {
        int pacotesPreenchidos = 0;
        for (Bin bin : bins) {
            if (bin.numberOfItems() != 0) {
                pacotesPreenchidos++;
            }
        }
        return pacotesPreenchidos;
    }

    @Override
    public void printBestBins() {
        //System.out.println("\n");
        if (melhorSolucaoAtual == in.size()) {
            System.out.println("Cada item no seu próprio pacote");
        } else {
            for (Bin currentBin : melhorPacoteAtual) {
                if (currentBin.numberOfItems() != 0) { // Não imprime pacotes vazios
                	System.out.print("\nPacote: " + pacoteAtual + " Items: ");
                    System.out.println(currentBin.toString());
                    pacoteAtual++;
                }
            }
        }
    }
}