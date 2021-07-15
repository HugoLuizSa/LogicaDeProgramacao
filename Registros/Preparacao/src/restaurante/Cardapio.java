package restaurante;

import javax.swing.JOptionPane;

public class Cardapio {

	static class itemCardapio {
		int cod;
		String descricao;
		double preco;
		int qtdPessoas;
		Categoria categoria;
	}

	static class Categoria {
		int cod;
		String descricao;
	}

	static Categoria[] categorias = new Categoria[10];
	static itemCardapio[] itemsCardapio = new itemCardapio[40];

	public static void main(String[] args) {

		Categoria c1 = cadastrarCategoria("Pães");
		Categoria c2 = cadastrarCategoria("Massas");
		// Categoria c3 = cadastrarCategoria("Pães");

		categorias[0] = c1;
		categorias[1] = c2;
	}

	// CADASTRAR CATEGORIA
	public static Categoria cadastrarCategoria(String descricao) {
		Categoria c = new Categoria();

		if (!arrayInicializado(categorias)) {
			c.descricao = descricao;
			c.cod = 1;
			return c;
		}
		
		//caso array iniciado startar o for , caso invalido vai mostrar o erro
		for (int i = 0; i < categorias.length; i++) {
			if(categorias[i]==null) {
			}
			if(stringsDiferentes(c.descricao, descricao)) {
				
			}else {
				c=null;
			}
		}
		
		return c;
		
	}


	// verificar descricao já informada
	public static boolean naoInformado(Categoria c) {
		boolean informada = true;
		for (int i = 0; i < categorias.length; i++) {
			Categoria categoria = categorias[i];
			if (!(stringsDiferentes(c.descricao, categoria.descricao))) {
				informada = false;
			}
		}
		return informada;
	}

	// tamanho descricao
	public static boolean tamanhoValido(String descricao, int tamanho) {
		boolean valido = true;

		if (descricao.length() < tamanho) {
			valido = false;
			JOptionPane.showMessageDialog(null, "Descrição com tamanho inválido");
		}

		return valido;
	}

	// comparar strings
	public static boolean stringsDiferentes(String a, String b) {
		boolean iguais = true;

		if ((a.toLowerCase().equals(b.toLowerCase()))) {
			iguais = false;
			JOptionPane.showMessageDialog(null, "Descrição já utilizada");
		}
		return iguais;
	}

	public static boolean arrayInicializado(Object[] array) {
		boolean inicializado = true;
		if (array[0] == null) {
			inicializado = false;
		}
		return inicializado;
	}

}
