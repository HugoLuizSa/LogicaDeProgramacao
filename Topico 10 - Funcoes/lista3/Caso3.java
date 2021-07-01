package lista3;

import javax.swing.JOptionPane;

public class Caso3 {

	static int[] tabuada= new int[10];
	
	public static void main(String[] args) {

		int tabuadaDesejada=Integer.parseInt(JOptionPane.showInputDialog("Informe a tabuada desejada"));
	
		tabuadaRealizada(tabuadaDesejada);
		
	}

	private static void tabuadaRealizada(int numeroTabuadaGerada) {
		//colocando os numero de 0 a 10 na tabuada
		for(int i = 0;i<tabuada.length;i++) {
			tabuada[i]=(i+1);
		}
		//realizando a tabuada
		for (int i = 0; i < tabuada.length; i++) {
			System.out.println(numeroTabuadaGerada+"x"+tabuada[i]+"="+(numeroTabuadaGerada*tabuada[i]));
		}
	}
}
