package binpacking;

public class FirstFit {

	static int firstFit(int peso[], int n, int c)
	{
	    //Inicializa resultado (contagem de pacotes)
	    int resultado = 0;

	    // Cria um vetor que guarda o espaço restante dos pacotes
	    int pacotesRestantes[] = new int[n];

	    // Empacota itens um a um
	    for (int i=0; i<n; i++)
	    {
	        // Acha o primeiro pacote a se encaixar em peso[i]
	        int j;
	        for (j=0; j<resultado; j++)
	        {
	            if (pacotesRestantes[j] >= peso[i])
	            {
	                pacotesRestantes[j] = pacotesRestantes[j] - peso[i];
	                break;
	            }
	        }

	        // Se nenhum pacote se encaixar em peso[i]
	        if (j==resultado)
	        {
	            pacotesRestantes[resultado] = c - peso[i];
	            resultado++;
	        }
	    }
	    return resultado;
	}

	public static void main(String[] args) {
		  int peso[] = {2, 5, 4, 7, 1, 3, 8};
		    int c = 10;
		    int n = peso.length;
		    System.out.println("Numero de pacotes necessários em First Fit : " + firstFit(peso, n, c)); 
		         
	}
	
	
}
