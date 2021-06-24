package lista;

import javax.swing.JOptionPane;

public class Caso2 {

	public static void main(String[] args) {

		char[] arrayVogais = { 'a', 'e', 'i', 'o', 'u' };

		String[] nomes = new String[5];

		for (int i = 0; i < nomes.length; i++) {
			nomes[i] = JOptionPane.showInputDialog("Informe um nome : #" + (i + 1));
		}

		int[] qtdVogaisConsoantes = getVogaisConsoantes(nomes, arrayVogais);

		JOptionPane.showMessageDialog(null, "Quantidade de nome iniciados em vogais : " + qtdVogaisConsoantes[0]
				+ "\n Quantidade de nome iniciados em consoantes : " + qtdVogaisConsoantes[1]);

	}

	private static int[] getVogaisConsoantes(String[] nomes, char[] arrayVogais) {
		int vogais = 0;
		int consoantes = 0;

		// percorrendo os nomes
		for (int i = 0; i < nomes.length; i++) {
			char inicial = (nomes[i]).toLowerCase().charAt(0);
			// verificar se a inicial é uma vogal
			for (int j = 0; j < arrayVogais.length; j++) {
				if (inicial == arrayVogais[j]) {
					// System.out.println("Inicial : "+inicial);
					// System.out.println("Entrou");
					vogais++;
				}
			}
		}

		consoantes = nomes.length - vogais;

		int[] letras = { vogais, consoantes };

		return letras;
	}
}
