package registros.lista3;

import javax.swing.JOptionPane;

public class Caso3 {

	static class Venda {
		int codVenda;
		Produto[] produtos = new Produto[5];
		String formaPagamento;
	}

	static class Produto {
		String nome;
		int qtd;
		double valorUnitario;
	}

	public static void main(String[] args) {
		

		//cadastrando produtos
		Produto p1 =cadastrarProduto("Garrafa térmica", 2, 155.99);
		Produto p2 =cadastrarProduto("Caneca térmica", 2, 35.99);
		Produto p3 =cadastrarProduto("Caneta", 3, 5.99);
		Produto p4 =cadastrarProduto("Caderno", 1, 15.99);
		
		Produto p5 =cadastrarProduto("Garrafa térmica", 1, 155.99);
		Produto p6 =cadastrarProduto("Caneca térmica", 1, 35.99);
		Produto p7 =cadastrarProduto("Caneta", 2, 5.99);
		Produto p8 =cadastrarProduto("Caderno", 1, 15.99);
		
		Venda v1 = cadastrarVenda(1, addProdutosVenda(p1,p2,p3,p4), "débito");
		Venda v2 = cadastrarVenda(5, addProdutosVenda(p5,p6,p7,p8), "débito");
		Venda v3 = cadastrarVenda(5, addProdutosVenda(p5,p6,p7,p8), "crédito");
		
		Venda [] vendas = {v1,v2,v3};

		//mostrarVenda(v1);
		
		int op=0;
		do {
			op=menu();
			switch (op) {
			case 1:
				mostrarVendas(vendas);
				break;
			case 2:
				vendaMaiorValor(vendas);
				break;
			case 3:
				totalPorFormaDePagamento(vendas,"débito");
				break;
			case 4:
				totalPorFormaDePagamento(vendas,"débito");
				break;
			case 5:
				totalPorFormaDePagamento(vendas,"débito");
				break;

			default:
				break;
			}
			
		} while (opValida(op));
	}
	
	public static boolean opValida(int op) {
		if(op>0 && op<5) {
			return true;
		}
		return false;
	}
	
	public static int menu() {
		int op =Integer.parseInt(JOptionPane.showInputDialog("1 - Listar todos as vendas realizadas com suas respectivas informações;\r\n"
				+ "2 - Mostrar a venda de maior valor com suas respectivas informações;\r\n"
				+ "3 - Mostrar as vendas realizadas com a forma de pagamento: dinheiro;\r\n"
				+ "4 - Mostrar as vendas realizadas com a forma de pagamento: cartão de\r\n"
				+ "débito;\r\n"
				+ "5 - Mostrar às vendas realizadas com a forma de pagamento: cartão de\r\n"
				+ "crédito;\r\n"
				+ "6 - Fechar programa"));
		return op;
	}

	public static Produto[] addProdutosVenda(Produto... produtos) {
		Produto produtoArray[]=new Produto[5];
		
		for (int i = 0; i < produtos.length; i++) {
			produtoArray[i]=produtos[i];
		}
		return produtoArray;
	}
	
	public static Produto cadastrarProduto(String nome,int qtd,double valorUnitario) {
		Produto produto = new Produto();
		
		produto.nome=nome;
		produto.qtd=qtd;
		produto.valorUnitario=valorUnitario;
		
		return produto;
	}
	
	public static Venda cadastrarVenda(int codVenda,Produto[] produtos ,String formaPagamento) {
		Venda venda = new Venda();
		venda.codVenda=codVenda;
		venda.formaPagamento=formaPagamento;
		venda.produtos=produtos;
		return venda;
	}
	
	public static void mostrarProdutos(Produto[] produtos) {
		for (int i = 0; i < produtos.length; i++) {
			Produto produto = produtos[i];
			
			if(produto!=null) {
				System.out.println("=Informações do produto=");
				System.out.println(
						"Nome : "+produto.nome
						+"\n Quantidade : "+produto.qtd
						+"\n Valor Unitário : R$"+produto.valorUnitario
						);
				System.out.println("======================");
			}
			continue;
		}
	}
	
	//1
	public static void mostrarVenda(Venda venda) {
		
		System.out.println("=Informações da venda=");
		
		System.out.println("Cod : "+venda.codVenda);
		mostrarProdutos(venda.produtos);
		System.out.println("Pagamento : "+venda.formaPagamento);
		
		System.out.println("======================");
		
	}

	public static void mostrarVendas(Venda [] vendas) {
		for (int i = 0; i < vendas.length; i++) {
			Venda venda = vendas[i];
			if(venda!=null) {
				mostrarVenda(venda);
			}
		}
	}
	//2
	public static double calcularValorTotalProdutos(Venda v) {
		Produto [] produdos = v.produtos;
		
		double valorTotal=0;
		for (int i = 0; i < produdos.length; i++) {
			Produto produto = produdos[i];
			if(produto!=null) {
				valorTotal+=produto.valorUnitario*produto.qtd;
			}
		}
		
		return valorTotal;
	}
	
	public static void vendaMaiorValor(Venda[] venda) {
		double valor=0;
		Venda maiorVenda =new Venda();
		
		for (int i = 0; i < venda.length; i++) {
			Venda v = venda[i];
			if(v!=null) {
				if(calcularValorTotalProdutos(v)>calcularValorTotalProdutos(maiorVenda)) {
					maiorVenda=v;
					valor=calcularValorTotalProdutos(maiorVenda);
				}
			}
			continue;
		}
		
		System.out.println("==Maior Venda==");
		System.out.println("Valor maior Venda: R$"+valor);
		mostrarVenda(maiorVenda);
	}
	
	//3 - 4 - 5
	
	public static void totalPorFormaDePagamento(Venda[] vendas,String formaPagamento) {
		double tt = 0;
		for (int i = 0; i < vendas.length; i++) {
			Venda venda = vendas[i];
			
			if(venda.formaPagamento.equals(formaPagamento)) {
				tt+=calcularValorTotalProdutos(venda);
			}
			
		}
		System.out.println("Total de vendas em "+formaPagamento +" : R$"+tt);
	}
	
}
