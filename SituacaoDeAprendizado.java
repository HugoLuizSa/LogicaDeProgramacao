import javax.swing.JOptionPane;

public class SituacaoDeAprendizado {

	static int codProduto = 1;
	static int codCliente = 1;
	static int codVenda=1;

	public static class Produto {
		int cod;
		String desc;
		double preco;
	}
	public static class Cliente {
		String nome;
		int cod, cpf, telefone;
	}
	
	public static class Venda {
		int cod;
		String desc;
		Produto [] produtos =new Produto[5];
		Cliente cliente;
		double total;
	}
	
	
	// Array de produtos
	static Produto[] produtos = new Produto[100];
	//Array de Clientes 
	static Cliente[] clientes = new Cliente[100];
	//Array de Vendas
	static Venda[] vendas = new Venda[30];
	
	public static void main(String[] args) {

		int menuPrincipal;
		int menuVenda;
		int menuProduto;
		int menuCliente;
		
		//menu princial
		do {
			menuPrincipal=Integer.parseInt(JOptionPane.showInputDialog(menuPrincial()));
			
			//vendas
			if(menuPrincipal==1) {
				do {
					menuVenda=Integer.parseInt(JOptionPane.showInputDialog(menuVendas()));
				} while (menuVenda>0&&menuVenda<3);
			}
			
			//produtos
			if(menuPrincipal==2) {
				do {
					menuProduto=Integer.parseInt(JOptionPane.showInputDialog(menuProdutos()));
				} while (menuProduto>0&&menuProduto<3);
			}
			
			//clientes
			if(menuPrincipal==3) {
				do {
					menuCliente=Integer.parseInt(JOptionPane.showInputDialog(menuClientes()));
				} while (menuCliente>0&&menuCliente<3);
			}
			
		} while (menuPrincipal>0&&menuPrincipal<5);
	}

	// -------------------PRODUTO-------------------
	// 1 IMPORTAR PRODUTO
	// metodo para importar os produtos
	public static void importarProdutos(String produtos) {

		// recebe o array de produtos e primeiro divide por ponto e virgular
		String[] produtosArray = realizarSplitDivisor(produtos, "; ");

		// agora que temos um array vamos iterar sobre ele , este array tem as
		// informações de cada produtos dividida por ponto e virgula
		for (int i = 0; i < produtosArray.length; i++) {
			
			try {
			Produto prod = new Produto();

			// linha com produto
			String produto = produtosArray[i];
			
			String informacoesProduto[] = realizarSplitDivisor(produto, " - ");

			String desc = informacoesProduto[0];
			double preco = formatarMoeda(informacoesProduto[1], ',', '.');

			if (!validarDescricaoProduto(desc)) {
				JOptionPane.showMessageDialog(null, "Descrição inválida , verifique seu arquivo antes de importar !");
				JOptionPane.showMessageDialog(null, " ARQUIVO NÃO IMPORTADO ");
				return;
			}
			try {
				if (preco <= 0) {
					return;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null,
						" Preco inválido , você somente pode informar precos e que sejam positivos ! ");
				JOptionPane.showMessageDialog(null, " ARQUIVO NÃO IMPORTADO ");
				return;
			}

			prod = criarProduto(desc, preco);
			addProduto(prod);
			}catch (Exception e) {
				JOptionPane.showMessageDialog(null,"Arquivo inválido");
				return;
			}
		}
		JOptionPane.showMessageDialog(null, "Importado com sucesso !");
		//JOptionPane.showMessageDialog(null, listarProdutos());
	}

	// metodo para realizar o split do produto
	public static String[] realizarSplitDivisor(String conteudo, String delimitador) {
		return conteudo.split(delimitador);
	}

	// formata o preco que deve estar informado como double e com ponto no lugar da
	// virgula
	public static Double formatarMoeda(String valor, char original, char substituir) {
		return Double.parseDouble(valor.replace(original, substituir));
	}

	// metodo que cria um produto
	public static Produto criarProduto(String descProduto, Double precoProd) {
		Produto produto = new Produto();

		produto.cod = codProduto;
		produto.desc = descProduto;
		produto.preco = precoProd;

		codProduto++;

		return produto;
	}

	// adiciona o produto ao array de produtos
	public static void addProduto(Produto prod) {
		// percorre o array de produtos e o primeiro vazio que encontrar vai adicionar o
		// produto
		
			if(produtos[99]!=null) {
				JOptionPane.showMessageDialog(null, "Lista de produtos atingiu o tamanho máximo ! ");
				return;
			}
		
			for (int i = 0; i < produtos.length; i++) {
				Produto produto = produtos[i];
				if (produto == null) {
					produtos[i] = prod;
					break;
				}
			}
			return;
	}

	//pesquisar produto pelo código
	// verifica se um produto é válido atravès do seu código
	public static Produto produtoValido(int codProduto) {

		Produto prod = new Produto();

		for (int i = 0; i < produtos.length; i++) {
			Produto produto = produtos[i];

			if (produto == null) {
				prod = null;
				JOptionPane.showMessageDialog(null, "Código não encontrado no sistema");
				return prod;
			}

			if (produto.cod == codProduto) {
				prod = produto;
				return prod;
			}
		}

		return prod;
	}

	//mostra as informacoes de um produto atraves do codigo infomado
	public static void mostrarProduto(int codProduto) {
		
		Produto produto = produtoValido(codProduto);
		
		if(produto==null) {
			return ;
		}
		
		String infoProduto = "Cod : " + produto.cod + "| Desc : " + produto.desc + " | Preco " + produto.preco + " \n";
	
		JOptionPane.showMessageDialog(null, infoProduto);
		
	}
	
	// 2 EDITAR PRODUTO
	public static void editarProduto() {
		int codProduto = Integer.parseInt(JOptionPane.showInputDialog("Informe o código do produto procurado : "));

		Produto prod = produtoValido(codProduto);

		// caso código não seja válido !
		if (prod == null) {
			return;
		}

		String descricao = JOptionPane.showInputDialog("Informe o novo nome do produto " + prod.desc);

		try {
			double preco = Double
					.parseDouble(JOptionPane.showInputDialog("Informe o novo preco de R$ " + prod.preco + " para => "));

			// caso preco seja negativo
			if (preco < 0) {
				JOptionPane.showMessageDialog(null,
						" Preco inválido , deve ser um precos positivos e maior que R$ 0,00 ");
				return;
			}
			// caso descricao nao seja valida
			if (!validarDescricaoProduto(descricao)) {
				JOptionPane.showMessageDialog(null, " descricao inválida  , deve conter letras também ! ");
				return;
			}

			prod.desc = descricao;
			prod.preco = preco;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,
					" Preco inválido , você somente pode informar numero e que sejam positivos ! ");
			return;
		}

		JOptionPane.showMessageDialog(null, "Alterado com sucesso !");

		listarProdutos();
	}

	//valida a descricao do produto e retonar verdadeiro ou falso
	public static boolean validarDescricaoProduto(String descricao) {
		boolean valido = false;

		descricao = descricao.toLowerCase().trim();

		for (int i = 0; i < descricao.length(); i++) {
			try {
				char caractere = descricao.charAt(i);

				String letra = Character.toString(caractere);

				if (Integer.parseInt(letra) >= 0 || Integer.parseInt(letra) <= 9) {
					System.out.println("numero!");
				}
			} catch (Exception e) {
				// JOptionPane.showMessageDialog(null, "Descrição válida !");
				valido = true;
				return valido;
			}
			// System.out.println(descricao.charAt(i));
		}

		return valido;
	}

	// -------------------CLIENTE-------------------
	//recebe um cliente como parametro adiciona no array de clientes
	public static void addClienteToCliente(Cliente clienteAdd) {
		for (int i = 0; i < clientes.length; i++) {
			Cliente cliente = clientes[i];
			if (cliente == null) {
				clientes[i] = clienteAdd;
				return;
			}
		}
		JOptionPane.showMessageDialog(null, "Array cheio , não é possível adicionar mais clientes ! ");
	}

	// cadastrar ou editar | para cadastrar passar 0 e caso queira editar passar o
	// codigo do cliente
	public static Cliente cadastrarCliente(int cod) {

		Cliente cliente = new Cliente();
		int cpf = 0;
		String nomeCliente;
		int telefone = 0;

		nomeCliente = JOptionPane.showInputDialog("Informe o nome do cliente ");
		if (!validarDescricaoProduto(nomeCliente)) {
			JOptionPane.showMessageDialog(null, "nome deve conter somente letras ");
			cliente = null;
			return cliente;
		}

		try {
			cpf = Integer.parseInt(JOptionPane.showInputDialog("Informe o cpf do cliente (8 numeros)"));

			if ((cpf + "").length() != 8) {
				// JOptionPane.showMessageDialog(null, (cpf+"").length());
				cliente = null;
				JOptionPane.showMessageDialog(null, "cpf deve conter 8 numeros ");
				return cliente;
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "cpf deve conter somente numeros ");
			cliente = null;
			return cliente;
		}

		try {
			telefone = Integer.parseInt(JOptionPane.showInputDialog("Informe o telefone do cliente (9 numeros exemplo : 99996666) "));
			
			if ((telefone + "").length() < 8 || (telefone + "").length() > 10) {
				JOptionPane.showMessageDialog(null, "telefone deve conter  9 ");
				cliente = null;
				return cliente;
			} 	

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "telefone deve conter somente numeros !");
			cliente = null;
			return cliente;
		}

		if (cod > 0 && clienteValido(cod) != null) {
			Cliente c = clienteValido(cod);
			c.cpf = cpf;
			c.nome = nomeCliente;
			c.telefone = telefone;
			return c;
		}

		cliente.cod = codCliente;
		cliente.cpf = cpf;
		cliente.nome = nomeCliente;
		cliente.telefone = telefone;
		codCliente++;

		if (cliente != null && cod == 0) {
			addClienteToCliente(cliente);
		}

		return cliente;
	}

	//recebe o codigo de um cliente e mostra as informações do mesmo
	public static void vizualizarCliente(int codCliente) {

		for (int i = 0; i < clientes.length; i++) {
			Cliente cliente = clientes[i];

			if (cliente == null) {
				return;
			}

			if (cliente.cod == codCliente) {
				JOptionPane.showMessageDialog(null, "Cod : " + cliente.cod + "| CPF : " + cliente.cpf + " | Nome "
						+ cliente.nome + " | Telefone " + cliente.telefone + "\n");
				return;
			}

		}
		JOptionPane.showMessageDialog(null, "Código não encontrado no sistema");
	}
	
	//verifica se um cliente é válido através do código , caso válido retorna o cliente
	public static Cliente clienteValido(int codCliente) {
		Cliente c = new Cliente();

		boolean valido = false;
		for (int i = 0; i < clientes.length; i++) {
			Cliente cliente = clientes[i];
			if(cliente==null) {
				JOptionPane.showMessageDialog(null, "Código não encontrado no sistema");
				return null;
			}
			
			if (cliente.cod == codCliente) {
				c = cliente;
				return c;
			}
		}
		JOptionPane.showMessageDialog(null, "Código não encontrado no sistema");
		return c;
	}

	// -------------------VENDA-------------------
	// 1 Criar venda
	// metodo para importar os produtos
	//0 nova venda , valores acima de zero é para editar a venda
	public static void CriarEditarVenda(int cod) {
		Venda venda = new Venda();
		
		//valida se há produtos cadastrados para realizar a venda
		if(produtos[0]==null) {
			JOptionPane.showMessageDialog(null,"Você não pode realizar vendas sem produtos cadastrados");
			return;
		}
		//valida se há clientes cadastrados para realizar a venda
		if(clientes[0]==null) {
			JOptionPane.showMessageDialog(null,"Você não pode realizar vendas sem clientes cadastrados");
			return;
		}
		
		//editar venda
		if(cod>0) {
			//verificar se a venda é válida
			
			Venda vendaEditada = vendaValida(cod);
			
			if(vendaEditada==null) {
				JOptionPane.showMessageDialog(null, "Código não encontrado");
				return;
			}
			
			//caso válida copiar o código da venda original e editar todo o resto;
			int codigoOriginal =vendaEditada.cod;
			venda=vendaEditada;
			venda.cod=codigoOriginal;
		}
		
		//Pedir a desc da venda
		String desc = JOptionPane.showInputDialog("Informe uma descrição para sua venda no mínimo 5 caracteres :");
		//validar desc da venda
		if(desc.length()<5) {
			JOptionPane.showMessageDialog(null,"Descrição deve conter no mínimo 5 caracteres");
			return;
		}
		
		//venda é valida , setar a descricao
		venda.desc=desc;
		
		// produtos da venda que devem ser 5 no máximo
		int codProd=1;
		int contProdutos=1;
		String prodsAdicionados="";
		while (codProd>0 || codProd==5) {
			try {
				
			
			codProd=Integer.parseInt(JOptionPane.showInputDialog("Informe o código do produto que você deseja #"+contProdutos
					+"\n"+listarProdutos()+"\n"
					+"\n -----Carrinho------"
					+"\n Items adicionados \n"+prodsAdicionados
					+"\n Caso não queira inserir mais nenhum produto digite 0(zero) "));
			}catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Código do produto deve ser um número !");
				continue;
			}
			if(codProd==0) {
				JOptionPane.showMessageDialog(null, "Seus items são : \n"+prodsAdicionados);
				break;
			}
			
			Produto prod = produtoValido(codProd);
			
			if(prod==null) {
				//JOptionPane.showInputDialog("Produto inválido , tente novamente ");
				continue;
			}
			
			
			
			//caso produto seja válido será adicionado no array de produtos da venda
			if(prod!=null) {
				prodsAdicionados+=contProdutos+" : "+prod.desc+" \n ";
				addProdutoArrayProdutos(venda.produtos,prod);
				contProdutos++;
			}
			
			if(venda.produtos[0]==null) {
				JOptionPane.showMessageDialog(null,"Venda deve conter no mínimo um produto !");
				continue;
			}
			//verificar se o limite de produtos foi atingido
			
			
			if(venda.produtos[4]!=null) {
				JOptionPane.showMessageDialog(null,"Inserido a quantidade máxima de produtos , finalizada a insersão de produtos !");
				codProd=0;
				JOptionPane.showMessageDialog(null, "Seus items são : \n"+prodsAdicionados);
			}
		}
		
		//Cliente dentro da venda
		Cliente cliente = new Cliente();
		do {
			//solicitando o código do cliente
			int codCli=0;
			try {
				codCli=Integer.parseInt(JOptionPane.showInputDialog("Informe o código do cliente \n Lista de cliente \n"+mostrarTodosClientes()));
			}catch (Exception e) {
				//JOptionPane.showMessageDialog(null, "O Código do cliente deve ser um número !");
				cliente=null;
			}
			
			//Pegando o cliente através do código digitado;
			cliente = clienteValido(codCli);
			
			//validando se o cliente é válido
			if(cliente==null) {
				//JOptionPane.showInputDialog("Cliente inválido , tente novamente");
				continue;
			}
			//enquanto o cliente não for válido o sistema vai pedir novamente
		} while (cliente==null);
		
		venda.cliente=cliente;
		venda.total=calcularValorDaVenda(venda);
		
		if(cod==0) {
			addVendaArrayVendas(vendas,venda);
			venda.cod=codVenda;
			codVenda++;
			JOptionPane.showMessageDialog(null, "Cadastro feito com sucesso!");
		}else {
			JOptionPane.showMessageDialog(null, "Editada com sucesso!");
		}
	}
	
	public static void addVendaArrayVendas(Venda[] vendaAdd,Venda v) {
		for (int i = 0; i < vendaAdd.length; i++) {
			Venda venda = vendaAdd[i];
			if(venda==null) {
				vendaAdd[i]=v;
				return;
			}
		}
		JOptionPane.showInputDialog("Vendas atigiu o limite;");
	}
	
	public static double calcularValorDaVenda(Venda venda) {
		double valor = 0;
		
		for (int i = 0; i < venda.produtos.length; i++) {
			Produto produto = venda.produtos[i];
			if(produto==null) {
				return valor;
			}
			valor+=produto.preco;
		}
		return valor;
	}
	
	public static Venda vendaValida(int codVenda) {
		Venda v = new Venda();
		
		for (int i = 0; i < vendas.length; i++) {
			Venda venda = vendas[i];
			
			if(venda==null) {
				break;
			}
			
			if(venda.cod==codVenda) {
				v=venda;
				return v;
			}
		}
		JOptionPane.showMessageDialog(null, "Venda não encontrada !");
		v=null;
		return v;
	}
	
	public static String listarVendas() {
		String vendaConcat="Listagem de vendas : \n";
		String produtos="";
		for (int i = 0; i < vendas.length; i++) {
			Venda venda= vendas[i];
			if(venda==null) {
				break;
			}
			vendaConcat+="Cod : "+venda.cod+" descrição : "+venda.desc+" Cliente "+venda.cliente.nome+"\n Total : R$ "+venda.total+"\n";
		}
		return vendaConcat;
	}
	
	public static String listarVenda(int cod) {
		String vendaConcat="";
		String produtos="";
		for (int i = 0; i < vendas.length; i++) {
			Venda venda= vendas[i];
			if(venda==null) {
				break;
			}
			if(venda.cod==cod) {
				vendaConcat+="Cod : "+venda.cod+" descrição : "+venda.desc+" Cliente "+venda.cliente.nome+"\n Total : R$ "+venda.total+"\n";
				break;
			}
		}
		return vendaConcat;
	}
	//RELATORIOS
	//4 RELATORIOS
	
	//3 lista todos os produtos , do menor código para o maior código
	public static String listarProdutos() {
			String listaProduto = "Lista de produtos : \n";

			for (int i = 0; i < produtos.length; i++) {
				Produto produto = produtos[i];

				if (produto == null) {
					break;
				}

				listaProduto += "Cod : " + produto.cod + "| Desc : " + produto.desc + " | Preco " + produto.preco + " \n";

			}
			return listaProduto;
		}
	
	//4 Ordenado pelo preço do menor produto Mostrar todos os produtos com seus respectivos dados
	public static void listarProdutosOrdemPreco() {
		
		Produto [] newProdutos= new Produto[100];
		Produto [] produtosOrdenados= new Produto[100];
		double precoMaximo=999999999;
		
		//copiar todos produtos para newProdutos
		for (int i = 0; i < produtos.length; i++) {
			
			if(produtos[i]==null) {
				break;
			}
			newProdutos[i]=new Produto();
			newProdutos[i].cod=produtos[i].cod;
			newProdutos[i].desc=produtos[i].desc;
			newProdutos[i].preco=produtos[i].preco;
		}
		
		for (int i = 0; i < newProdutos.length; i++) {
			Produto produto = newProdutos[i];
			
			if(produto==null) {
				continue;
			}
			
			Produto produtoMenorPreco=new Produto();
			produtoMenorPreco.preco=precoMaximo;
			
			//descobrir o menor preco
			for (int j = 0; j < newProdutos.length; j++) {
				Produto produto2 = newProdutos[j];
				
				if(produto2==null) {
					continue;
				}
				
				if(produto2.preco<produtoMenorPreco.preco) {
					produtoMenorPreco=produto2;
				}
			}
			
			//finalizado o for interno , agora se sabe quem é o produto com meno preco no array
			//System.out.println(produtoMenorPreco.desc);
			int posicaoProdutoComMenorValor=posicaoDoProduto(produtoMenorPreco);
			
			Produto addProdutoMenorValor = copiarValoresProduto(produtoMenorPreco);
			addProdutoArrayProdutos(produtosOrdenados, addProdutoMenorValor);
			
			newProdutos[posicaoProdutoComMenorValor].preco=precoMaximo;
			
			
			//System.out.println(posicaoDoProduto(produtoMenorPreco));
		}
		
		String listaProdutosOrdenados="";
		for (int j = 0; j < produtosOrdenados.length; j++) {
			Produto produto2 = produtosOrdenados[j];
			
			if(produto2==null) {
				continue;
			}
			listaProdutosOrdenados+="COD : "+produto2.cod+"| DESC : "+produto2.desc+" VALOR : R$ "+produto2.preco+" \n";
		}
		JOptionPane.showMessageDialog(null,"Relatório de produtos em ordem de preço : \n"+ listaProdutosOrdenados);
	}
	
	public static int posicaoDoProduto(Produto produto) {
		int posicao = 0;
		for (int i = 0; i < produtos.length; i++) {
			Produto p= produtos[i];
			
			if(p==null) {
				return posicao;
			}
			
			if(p.cod==produto.cod) {
				posicao=i;
			}
		}
		return posicao;
	}
	public static void addProdutoArrayProdutos(Produto[] produtos,Produto p) {
		for (int i = 0; i < produtos.length; i++) {
			Produto produto = produtos[i];
			if(produto==null) {
				produtos[i]=p;
				return;
			}
		}
		JOptionPane.showInputDialog("Impossível colocar mais produtos");
	}
	public static Produto copiarValoresProduto(Produto produto) {
		Produto p = new Produto();
		
		p.cod=produto.cod;
		p.desc=produto.desc;
		p.preco=produto.preco;
		
		return p;
	}
	
	//5 mostrar todos os clientes pela ordem do codigo (menor para o maior)
	public static String mostrarTodosClientes() {
			String todosClientes="";
			
			for (int i = 0; i < clientes.length; i++) {
				Cliente cliente = clientes[i];
				
				if(cliente==null) {
					break;
				}
				
				todosClientes+="Cod : "+cliente.cod+" Nome : "+cliente.nome+" CPF : "+cliente.cpf
						+" Telefone : "+cliente.telefone+"\n";
				
			}
			
			//verifica se a lista de clientes est
			if(todosClientes.equals("")) {
				todosClientes="Lista de clientes Vazia";
			}
			
			return todosClientes;
		}

	//MENUS
	//menu principal
	public static String menuPrincial() {
		return "1-Vendas \n"+
				"2-Produtos \n"+
				"3-Clientes \n"+
				"4-Relatórios\n"+
				"5-Finalizar programa \n";
	}
	//menu vendas
	public static String menuVendas() {
		return "1-Criar venda \n"+
				"2-Editar Venda \n"+
				"3-Vizualizar venda \n"+
				"4-Voltar \n";
	}
	//menu produtos
	public static String menuProdutos() {
			return "1-Importar produto \n"+
					"2-Editar Produto \n"+
					"3-Vizualizar Produto \n"+
					"4-Voltar\n";
	}
	//menu produtos
	public static String menuClientes() {
			return "1-Cadastrar Cliente\n"+
					"2-Editar Cliente \n"+
					"3-Vizualizar Cliente \n"+
					"4-Voltar\n";
	}
	//menu relatorios
		public static String menuRelatorios() {
				return "1-Relatorio de vendas - ordenar vendas pelo código crescente \n"+
						"2-Relatorio de vendas - ordenar vendas pela menor venda \n"+
						"3-Relatorio de produto - ordenar vendas pelo código crescente \n"+
						"3-Relatorio de produto - ordenar vendas pelo preco crescente \n"+
						"3-Relatorio de cliente - ordenar pelo código crescente \n"+
						"6-Voltar\n";
		}
}
