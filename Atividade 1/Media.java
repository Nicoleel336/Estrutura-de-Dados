package nicoleellen;
import java.util.*;

public class Media {

	public static void main(String[] args) {
		Scanner scanf = new Scanner(System.in);
		Aluno alunos[];
		int tamanho; //tamanho da turma
		int idade_digitada; //idade digitada pelo usuário
		double media, soma = 0;
		
		System.out.println("Insira a quantidade de discentes na turma: ");
		tamanho = scanf.nextInt();
		alunos = new Aluno[tamanho];
		
		for (int i = 0; i < tamanho; i++) {
			
			alunos[i] = new Aluno(); //inicializando a posição, se não dá 'null'
			
			System.out.printf("Digite a idade do aluno %d: ",i+1);
			idade_digitada = scanf.nextInt();
			
			while (!(idade_digitada>0 && idade_digitada<=100)) { //validação da idade
				System.out.printf("Idade inválida! Digite a idade do aluno %d novamente: ",i+1);
				idade_digitada = scanf.nextInt();
			}
			
			alunos[i].idade = idade_digitada;
			soma += alunos[i].idade;
		}
		
		media = soma/tamanho;
		
		System.out.printf("A media da turma e: %.1f",media);
		
		scanf.close();
	}

}
