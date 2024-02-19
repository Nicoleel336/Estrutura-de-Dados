package nicoleellen;
import java.util.*;

public class CalculaModa {

	public static void main(String[] args) {
		Scanner scanf = new Scanner(System.in);
		int numeros[]; //armazena os números inseridos pelo o usuário
		int frequencia[]; //armazena a frenquencia de cada número
		int n, i,j;
		int maiorfrequencia = 1;
		int somaFrequencia = 0;
		int moda[];
		
		System.out.println("Gostaria de adicionar quantos numeros?: ");
		n = scanf.nextInt();
		numeros = new int[n]; //reserva espaço para n inteiros
		frequencia = new int[n];
		int cont = 0; //vai contar quantos numeros de moda
		
		//pegar os numeros
		for(i = 0; i < n; i++) {
			System.out.printf("Digite o %d numero: ",i+1);
			numeros[i] = scanf.nextInt();
		}
		 
		//organizar os numeros
		Funcoes.BubbleSort(numeros);
		
		//verificar os numeros
		System.out.println("Sua sequencia numerica e: ");
		Funcoes.MostraSequencia(numeros);
		
		//achar a frequencia dos numeros
		for(i = 0; i < n; i++) {
			for(j = 0; j < n; j++) {
				if(numeros[j] == numeros[i]) frequencia[i]++;
			}
		}
		
		//verificar o tipo de moda ou a maior frequencia
		for(i = 0; i< frequencia.length; i++) {
			if(frequencia[i] > maiorfrequencia) {
				maiorfrequencia = frequencia[i];
			}
			somaFrequencia += frequencia[i];
		}
		
		if(maiorfrequencia*frequencia.length == somaFrequencia) {
			System.out.println("Sua sequencia e AMODAL"); 
		}
		else {
			System.out.println("TIPO DE MODA: ");
			for(i = 0; i < frequencia.length; i++) {
				if(frequencia[i] == maiorfrequencia && Funcoes.Repetido(numeros[i],numeros,i) == false) {
					cont++; //conta quantas modas tem
				}
			}
			/*
			System.out.println("Maior frequencia: " + maiorfrequencia);
			System.out.println("Frequencia: ");
			Funcoes.MostraSequencia(frequencia);
			System.out.println("Contador: "+ cont);*/
			moda = new int[cont];
			
			if(cont == 1) {
				System.out.println("UNIMODAL");
			}
			else if(cont == 2) {
				System.out.println("BIMODAL");
			}
			else {System.out.println("MULTIMODAL");}
			j = 0;
			int temp = 0;
			for(i = 0; i < numeros.length; i++) {
				if(frequencia[i] == maiorfrequencia && numeros[i] != temp) {
					moda[j] = numeros[i];
					j++;
					temp = numeros[i];
				}
			}
			Funcoes.MostraSequencia(moda);
		}
			scanf.close();
	}
}
