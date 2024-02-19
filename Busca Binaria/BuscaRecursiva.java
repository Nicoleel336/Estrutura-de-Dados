package TarefaExtra;

public class BuscaBinariaRecursiva {
	public static final int NOT_FOUND = -1; // caso não encontre o número

	/**
	 * recursão
	 */
	// recebe um array de int's, o início e o final dele, além do número a ser
	// procurado
	private static int binarySearch(int[] a, int x, int low, int high) {

		if (low > high) // se o início for maior que o final, não encontrou
			return NOT_FOUND;

		int mid = (low + high) / 2; // calcula o meio do array

		if (a[mid] < x) // se o númmero do meio for menor que o número procurado
			return binarySearch(a, x, mid + 1, high); // a função é chamada novamente com o início sendo o meio + 1
		else if (a[mid] > x) // se o número do meio for maior que o número procurado
			return binarySearch(a, x, low, mid - 1); // a função é chamada novamente, com o final sendo o meio - 1
		else
			return mid; // caso o procurado seja o próprio meio, retorna o meio
	}

	// Programa teste
	public static void main(String[] args) {
		int SIZE = 1000000;
		int a[] = new int[SIZE];
		for (int i = 0; i < SIZE; i++)
			a[i] = 2 * i; // preenche o array com números pares

		// o vetor tem 1000, mas os índices vão de 0 a 1999
		/*
		 * a mudança deve ser feita no parâmetro "high" da função, pois se o decremento
		 * ocorresse dentro da função, o valor do final sempre sofreria uma diminuição e
		 * a busca seria "cortada"
		 */
		System.out.println("Posicao: " + binarySearch(a, -2, 0, SIZE - 1)); // -1
		System.out.println("Posicao: " + binarySearch(a, 0, 0, SIZE - 1));
		System.out.println("Posicao: " + binarySearch(a, 2, 0, SIZE - 1));
		System.out.println("Posicao: " + binarySearch(a, 400, 0, SIZE - 1));
		System.out.println("Posicao: " + binarySearch(a, 1275, 0, SIZE - 1)); // -1
		System.out.println("Posicao: " + binarySearch(a, 1998, 0, SIZE - 1));
		System.out.println("Posicao: " + binarySearch(a, 2000, 0, SIZE - 1)); // -1
		System.out.println("Posicao: " + binarySearch(a, 2002, 0, SIZE - 1)); // -1
		System.out.println("Posicao: " + binarySearch(a, 2200, 0, SIZE - 1)); // -1
		
		for(int i = 0; i < 5; i++) {
			long tempoInicial = System.nanoTime();
			System.out.println(binarySearch(a, 999998, 0, SIZE - 1));
			long tempoFinal = System.nanoTime();
			System.out.printf("Tempo de execução na %dº rodada:", i+1);
			System.out.println(tempoFinal-tempoInicial);
		}
	}

}
