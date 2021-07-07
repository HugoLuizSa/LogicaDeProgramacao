package registros;

public class Caso4 {

	static class Loja {
		String nome, telefone;
	}

	static class Produto {
		double precoProduto;
		Loja loja;
	}

	public static void main(String[] args) {

		// criar loja
		Loja loja1 = new Loja();
		loja1 = criarLoja("Loja A", "9999-9999");
		Produto produto1 = new Produto();
		produto1 = criarProduto(99.8, loja1);

		Loja loja2 = new Loja();
		loja2 = criarLoja("Loja B", "9999-8888");
		Produto produto2 = new Produto();
		produto2 = criarProduto(89.8, loja2);

		Loja loja3 = new Loja();
		loja3 = criarLoja("Loja C", "9999-7777");
		Produto produto3 = new Produto();
		produto3 = criarProduto(2.99, loja3);

		Produto[] arrayProdutos = { produto1, produto2, produto3 };
		
		double precoMedio = calcularPrecoMedio(arrayProdutos);
	
		System.out.println("preco médio R$ :"+precoMedio);
		
		System.out.println();

		System.out.println("Lista de lojas que estão com o preço abaixo da média");
		
		System.out.println();
		
		Loja l1 = new Loja();
		
		l1=getLoja(produto3);
		
		//System.out.println(produto3.loja.nome);
		
		lojasPrecoAbaixo(arrayProdutos, precoMedio);
	}

	public static Loja criarLoja(String nome, String telefone) {
		Loja loja = new Loja();
		loja.nome = nome;
		loja.telefone = telefone;
		return loja;
	}

	public static Produto criarProduto(double precoProduto, Loja loja) {
		Produto produto = new Produto();
		produto.precoProduto = precoProduto;
		produto.loja = loja;
		return produto;
	}

	public static double calcularPrecoMedio(Produto[] produtos) {
		double media = 0;
		for (int i = 0; i < produtos.length; i++) {
			media += produtos[i].precoProduto;
		}
		return media / produtos.length;
	}

	public static void lojasPrecoAbaixo(Produto [] produtos,double precoMedio) {
		for (int i = 0; i < produtos.length; i++) {
			if(produtos[i].precoProduto<precoMedio) {
				Loja loja = new Loja();
				loja=produtos[i].loja;
				System.out.println("A loja : "+loja.nome+"\n com telefone "+loja.telefone+" está com os preços abaixo da média !");
			}
		}
	}
	
	public static Loja getLoja(Produto p) {
		Loja l = new Loja();
		l=p.loja;	
		return l;
	}
	
	
}
