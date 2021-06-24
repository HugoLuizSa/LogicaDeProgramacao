package lista;

import javax.swing.JOptionPane;

public class Caso3 {

	public static void main(String[] args) {

		// lista de vogais
		char[] arrayVogais = { 'a', 'e', 'i', 'o', 'u' };

		// Criando array com 5 posições
		String[] nomeCidades = new String[5];

		// pedir o nome das cidades
		for (int i = 0; i < nomeCidades.length; i++) {
			nomeCidades[i] = JOptionPane.showInputDialog("Informe o nome da Cidade :");
		}

		// imprimir o nome das cidades e mostrar quantida de consoantes e de vogais
		listarCidadesVogais(nomeCidades,arrayVogais);
	}

	private static void listarCidadesVogais(String[] cidades,char[] vogais) {
		for (int i = 0; i < cidades.length; i++) {
			System.out.println("Nome da cidade : "+cidades[i]+" quantidade de vogais : "+quantidadeVogais(cidades[i],vogais));
		}
	}

	private static int quantidadeVogais(String nomeCidade,char[] vogais) {
		int qtdVogais = 0;
		for (int i = 0; i < nomeCidade.length(); i++) {
			// para cada cidade verificar se as letras são vogais
			for (int j = 0; j < vogais.length; j++) {
				if (nomeCidade.toLowerCase().charAt(i)==vogais[j]) {
					qtdVogais++;
				}
			}
		}
		return qtdVogais;
	}

}
