import javax.swing.JOptionPane;

public class SituacaoDeAprendizado {

	static int codProduto=1;
	
	public static class Produto{
		int cod;
		String desc;
		double preco;
	}
	
	//Array de produtos
	static Produto[] produtos=new Produto[100];
	
	public static void main(String[] args) {

		String listaProdutos= "Teclado pc - 89,90; Monitor 22 - 899,90";
		importarProdutos(listaProdutos);
		
		produtoValido(1);

		editarProduto();
	}

	//metodo para importar os produtos
	public static void importarProdutos(String produtos) {
		
		//recebe o array de produtos e primeiro divide por ponto e virgular
		String [] produtosArray = realizarSplitDivisor(produtos,"; ");
		
		//agora que temos um array vamos iterar sobre ele , este array tem as informações de cada produtos dividida por ponto e virgula
		for(int i =0;i<produtosArray.length;i++) {
			
			Produto prod = new Produto();
			
			//linha com produto
			String produto = produtosArray[i];
			String informacoesProduto[]=realizarSplitDivisor(produto, " - ");
			
			String desc=informacoesProduto[0];
			double preco = formatarMoeda(informacoesProduto[1],',','.');
			
			prod=criarProduto(desc, preco);
			addProduto(prod);
			
		}
		JOptionPane.showMessageDialog(null, "Importado com sucesso !");
		listarProdutos();
	}
	
	//metodo para realizar o split do produto 
	public static String[] realizarSplitDivisor(String conteudo,String delimitador) {
		return conteudo.split(delimitador);
	}

	//formata o preco que deve estar informado como double e com ponto no lugar da virgula
	public static Double formatarMoeda(String valor,char original,char substituir) {
		return Double.parseDouble(valor.replace(original, substituir));
	}
	
	//metodo que cria um produto
	public static Produto criarProduto(String descProduto,Double precoProd) {
		Produto produto = new Produto(); 
		
		produto.cod=codProduto;
		produto.desc=descProduto;
		produto.preco=precoProd;
		
		codProduto++;
		
		return produto;
	}
	
	//adiciona o produto ao array de produtos
	public static void addProduto(Produto prod) {
		//percorre o array de produtos e o primeiro vazio que encontrar vai adicionar o produto
		for (int i = 0; i < produtos.length; i++) {
			Produto produto = produtos[i];
			if(produto==null) {
				produtos[i]=prod;
				break;
			}
		}
	}
	
	//lista todos os produtos
	public static void listarProdutos() {
		for (int i = 0; i < produtos.length; i++) {
			Produto produto = produtos[i];
			
			if(produto==null) {
				return;
			}
			
			mostrarInfoProdutos(produto);
		}
	}
	
	public static void mostrarInfoProdutos(Produto produto) {
		System.out.println();
		System.out.println("Produto");
		System.out.println("Código : "+produto.cod);
		System.out.println("Descrição: "+produto.desc);
		System.out.println("Preço : R$"+produto.preco);
	}
	
	//verifica se um produto é válido atravès do seu código
	public static Produto produtoValido(int codProduto) {
		
		Produto prod = new Produto();
		
		boolean valido =false;
		for (int i = 0; i < produtos.length; i++) {
			Produto produto = produtos[i];
			
			if(produto==null) {
				prod = null;
				return prod;
			}
			
			if(produto.cod==codProduto) {
				prod = produto;
				return prod;
			}
		}
		
		//caso código não seja válido !
		if(!valido) {
			JOptionPane.showMessageDialog(null, "Código não encontrado no sistema");
		}
		
		return prod;
	}
	
	public static void editarProduto() {
		int codProduto =Integer.parseInt(JOptionPane.showInputDialog("Informe o código do produto procurado : "));
		
		Produto prod = produtoValido(codProduto);
		
		//caso código não seja válido !
		if(prod==null) {
			return ;
		}

		String descricao=JOptionPane.showInputDialog("Informe o novo nome do produto " + prod.desc);
		double preco=Double.parseDouble(JOptionPane.showInputDialog("Informe o novo preco de R$ " + prod.preco+" para => " ));

		prod.desc=descricao;
		prod.preco=preco;
	
		JOptionPane.showMessageDialog(null, "Alterado com sucesso !");
		
		listarProdutos();
	}
}
