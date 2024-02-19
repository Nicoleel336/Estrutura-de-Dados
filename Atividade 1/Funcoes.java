package nicoleellen;

public class Funcoes {
	
	public static void BubbleSort(int v[]) {
		int i,j;
		int temp;
		
		for(i = 0; i < v.length - 1; i++) {
			for(j = 0; j < v.length - 1 - i; j++) {
				if(v[j] > v[j+1]) {
					temp = v[j];
					v[j] = v[j+1];
					v[j+1] = temp;
				}
			}
		}
		
	}
	
	public static void MostraSequencia(int v[]) {
		int i;
		for(i = 0; i < v.length; i++) {
			System.out.printf("%d ",v[i]);
		}
		System.out.println("\n");
	}
	
	public static boolean Repetido(int n,int v[], int fim) {
		int i;
		for(i = 0; i < fim; i++) {
			if(v[i] == n) {
				return true;
			}
		}
		return false;
	}
		
			
}
