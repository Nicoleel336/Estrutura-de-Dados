package TarefaExtra;

/*
 * 2) Adaptar a solução iterativa para considerar valores inteiro (i. e., os mesmos valores da solução recursiva). 
 * Considerar o atributo SIZE igual a 1000000; 
 * calcular e analisar o tempo gasto na execução para procurar 
 * três valores, a saber: 120, 520757 e 999998.
 * 
*/

public class BuscaBinariaV2 {
	int size = 1000000;
	private int numeros[] = new int[size];

	public void Preenche(int numeros[]) {
		for (int i = 0; i < size; i++)
			numeros[i] = 2 * i;
	}

	private int BuscaBin(int num) {
		int inicio = 0;
		int fim = size - 1;

		while (fim >= inicio) {
			int meio = (inicio + fim) / 2;
			int aux = numeros[meio];
			if (aux > num)
				fim = meio - 1;
			else if (aux < num)
				inicio = meio + 1;
			else
				return (meio);
		}

		return -1;
	}

	public static void main(String[] args) {
		BuscaBinariaV2 Buscar = new BuscaBinariaV2();
		Buscar.Preenche(Buscar.numeros); // preenche o vetor
		// buscar 3 valores: 120, 520757, 999998
		
		for(int i = 0; i < 5; i++) {
			long tempInicial = System.nanoTime();
			Buscar.BuscaBin(999998);
			long tempFinal = System.nanoTime();
			System.out.printf("Tempo de execução na %dº rodada:",i+1);
			System.out.println(tempFinal-tempInicial);
		}
		
	}

}
