package lista;

import javax.swing.JOptionPane;

public class Caso1 {

	public static void main(String[] args) {

		String[] nomes = new String [5];
		
		for (int i = 0; i < nomes.length; i++) {
			nomes[i]=JOptionPane.showInputDialog("Informe um nome ");
		}
		
		nomesTranformados(nomes);
		
	}

	private static void nomesTranformados(String[] nomesCaixaAlta) {
		String nomes="";
		for (int i = 0; i < nomesCaixaAlta.length; i++) {
			nomes+=nomesCaixaAlta[i].toUpperCase()+" \n";
		}
		JOptionPane.showMessageDialog(null,nomes);
	}
}
