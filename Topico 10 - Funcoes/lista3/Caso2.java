package lista3;

public class Caso2 {

	//variaveis globais
	static String[] nomes = {"João","Maria","Eduardo","Emilio","Alba"};
	static String[] nomesMaisculo=new String[5];
	
	public static void main(String[] args) {
		
		System.out.println("*Antes de alterar");
		mostrarArrayAtualizado(nomes);
		System.out.println("*Despois de alterar");
		passarParaMaisculo();
		mostrarArrayAtualizado(nomesMaisculo);
	}
	
	private static void mostrarArrayAtualizado(String[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
	
	private static void passarParaMaisculo() {
		for (int i = 0; i < nomes.length; i++) {
			nomesMaisculo[i]=nomes[i].toUpperCase();
		}
	}

}
