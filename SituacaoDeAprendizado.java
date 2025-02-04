import javax.swing.JOptionPane;

public class SituacaoDeAprendizado {

	static int codProduto = 1;
	static int codCliente = 1;
	static int codVenda = 1;

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
		Produto[] produtos = new Produto[5];
		Cliente cliente;
		double total;
	}

	// Array de produtos
	static Produto[] produtos = new Produto[100];
	// Array de Clientes
	static Cliente[] clientes = new Cliente[100];
	// Array de Vendas
	static Venda[] vendas = new Venda[30];

	public static void main(String[] args) {

		int menuPrincipal = 0;
		int menuVenda;
		int menuProduto;
		int menuCliente;
		int menuRelatorios;

		// menu princial
		do {
			// o try serve para caso o usuario tente colocar alguma letra no lugar de numero
			// ou vice versa
			try {

				menuPrincipal = Integer.parseInt(JOptionPane.showInputDialog(menuPrincial()));
				// vendas
				if (menuPrincipal == 1) {
					do {
						menuVenda = Integer.parseInt(JOptionPane.showInputDialog(menuVendas()));
						// criar venda
						if (menuVenda == 1) {
							CriarEditarVenda(0);
						}
						// editar venda
						if (menuVenda == 2) {
							int codVendaSeraEditata = Integer.parseInt(
									JOptionPane.showInputDialog("Informe o c�digo da venda que ser� editada : "));
							CriarEditarVenda(codVendaSeraEditata);
						}
						// vizualizar venda
						if (menuVenda == 3) {
							int codVendaSeraVizualizada = Integer.parseInt(
									JOptionPane.showInputDialog("Informe o c�digo da venda que ser� vizualizada : "));
							JOptionPane.showMessageDialog(null, listarVenda(codVendaSeraVizualizada));
						}

					} while (menuVenda > 0 && menuVenda < 3);
				}

				// produtos
				if (menuPrincipal == 2) {
					do {
						menuProduto = Integer.parseInt(JOptionPane.showInputDialog(menuProdutos()));
						// importar produtos
						if (menuProduto == 1) {
							String produtosImportar = JOptionPane.showInputDialog(
									"Importe os produtos : \n Exemplo : Teclado pc - 89,90; Monitor 22 - 899,90 ");
							importarProdutos(produtosImportar);
						}

						// editar produtos
						if (menuProduto == 2) {
							editarProduto();
						}
						// vizualizar produtos
						if (menuProduto == 3) {
							int codProdutoPesquisado = Integer.parseInt(
									JOptionPane.showInputDialog("Digite o c�digo do produto que deseja verificar : "));
							mostrarProduto(codProdutoPesquisado);
						}

					} while (menuProduto > 0 && menuProduto < 3);
				}

				// clientes
				if (menuPrincipal == 3) {
					do {
						menuCliente = Integer.parseInt(JOptionPane.showInputDialog(menuClientes()));
						// cadastrar cliente
						if (menuCliente == 1) {
							cadastrarCliente(0);
						}
						// editar cliente
						if (menuCliente == 2) {
							int codClienteEditadar = Integer.parseInt(
									JOptionPane.showInputDialog("Informe o c�digo do cliente que deseja editar"));
							cadastrarCliente(codClienteEditadar);
						}
						// vizualizar cliente
						if (menuCliente == 3) {
							int codClientePesquisado = Integer.parseInt(
									JOptionPane.showInputDialog("Digite o c�digo do cliente que deseja verificar : "));
							vizualizarCliente(codClientePesquisado);
						}

					} while (menuCliente > 0 && menuCliente < 3);
				}

				// relatorios
				if (menuPrincipal == 4) {
					do {
						menuRelatorios = Integer.parseInt(JOptionPane.showInputDialog(
								"Informe o numero do relat�rio que voc� deseja tirar :\n" + menuRelatorios()));

						// listar vendas
						if (menuRelatorios == 1) {
							String listaDeVendas = listarVendas();
							// caso a lista n�o esteja vazia
							if (listaDeVendas.length() > 2) {
								JOptionPane.showMessageDialog(null, listaDeVendas);
							}
						}
						// relatorio de vendas ordenadas pelo preco em ordem decrescente
						if (menuRelatorios == 2) {
							// System.out.print("relatorio de precos ordenados");
							listarVendasOrdermMenorVenda();
						}

						// listar todos os produtos
						if (menuRelatorios == 3) {
							String listaProdutos = listarProdutos();

							// verificar se a lista de produtos est� setada
							if (listaProdutos.length() > 2) {
								JOptionPane.showMessageDialog(null, listaProdutos);
							}
						}

						// listar os produtos por ordem de pre�o
						if (menuRelatorios == 4) {
							listarProdutosOrdemPreco();
						}
						// exibir a lista de clientes
						if (menuRelatorios == 5) {
							JOptionPane.showMessageDialog(null, mostrarTodosClientes());
						}

					} while (menuRelatorios > 0 && menuRelatorios < 6);
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "informar somente numeros no menu");
			}
		} while (menuPrincipal > 0 && menuPrincipal < 5);
	}

	// -------------------PRODUTO-------------------
	// 1 IMPORTAR PRODUTO
	// metodo para importar os produtos
	public static void importarProdutos(String produtos) {

		// recebe o array de produtos e primeiro divide por ponto e virgular
		String[] produtosArray = realizarSplitDivisor(produtos, "; ");

		// agora que temos um array vamos iterar sobre ele , este array tem as
		// informa��es de cada produtos dividida por ponto e virgula
		for (int i = 0; i < produtosArray.length; i++) {

			try {
				Produto prod = new Produto();

				// linha com produto
				String produto = produtosArray[i];

				String informacoesProduto[] = realizarSplitDivisor(produto, " - ");

				String desc = informacoesProduto[0];
				double preco = formatarMoeda(informacoesProduto[1], ',', '.');

				if (!validarDescricaoProduto(desc)) {
					JOptionPane.showMessageDialog(null,
							"Descri��o inv�lida , verifique seu arquivo antes de importar !");
					JOptionPane.showMessageDialog(null, " ARQUIVO N�O IMPORTADO ");
					return;
				}
				try {
					if (preco <= 0) {
						return;
					}
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null,
							" Preco inv�lido , voc� somente pode informar precos e que sejam positivos ! ");
					JOptionPane.showMessageDialog(null, " ARQUIVO N�O IMPORTADO ");
					return;
				}

				prod = criarProduto(desc, preco);
				addProduto(prod);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Arquivo inv�lido");
				return;
			}
		}
		JOptionPane.showMessageDialog(null, "Importado com sucesso !");
		// JOptionPane.showMessageDialog(null, listarProdutos());
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

		if (produtos[99] != null) {
			JOptionPane.showMessageDialog(null, "Lista de produtos atingiu o tamanho m�ximo ! ");
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

	// pesquisar produto pelo c�digo
	// verifica se um produto � v�lido atrav�s do seu c�digo
	public static Produto produtoValido(int codProduto) {

		Produto prod = new Produto();

		for (int i = 0; i < produtos.length; i++) {
			Produto produto = produtos[i];

			if (produto == null) {
				JOptionPane.showMessageDialog(null, "Produto n�o encontrado no sistema !");
				return produto;
			}

			if (produto.cod == codProduto) {
				prod = produto;
				return prod;
			}
		}
		return prod;
	}

	// mostra as informacoes de um produto atraves do codigo infomado
	public static void mostrarProduto(int codProduto) {

		Produto produto = produtoValido(codProduto);

		if (produto == null) {
			return;
		}

		String infoProduto = "Cod : " + produto.cod + "| Desc : " + produto.desc + " | Preco " + produto.preco + " \n";

		JOptionPane.showMessageDialog(null, infoProduto);

	}

	// retorna a lista de produtos em uma String
	public static String listaProdutos() {
		String listaProdutos = "";

		for (int i = 0; i < produtos.length; i++) {
			Produto produto = produtos[i];
			if (produto == null) {
				return listaProdutos;
			}
			listaProdutos += "cod :" + produto.cod + " desc : " + produto.desc + " Pre�o R$ : " + produto.preco + "\n";
		}

		return listaProdutos;
	}

	// 2 EDITAR PRODUTO
	public static void editarProduto() {

		if (produtos[0] == null) {
			JOptionPane.showMessageDialog(null, "lista de Produtos se encontra vazia");
			return;
		}
		int codProduto;
		try {
			codProduto = Integer.parseInt(JOptionPane.showInputDialog(
					"Informe o c�digo do produto procurado : \n +Lista produtos : \n" + listaProdutos()));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Voc� somente pode informar numeros");
			return;
		}

		Produto prod = produtoValido(codProduto);

		// caso c�digo n�o seja v�lido !
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
						" Preco inv�lido , deve ser um precos positivos e maior que R$ 0,00 ");
				return;
			}
			// caso descricao nao seja valida
			if (!validarDescricaoProduto(descricao)) {
				JOptionPane.showMessageDialog(null, " descricao inv�lida  , deve conter letras tamb�m ! ");
				return;
			}

			prod.desc = descricao;
			prod.preco = preco;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,
					" Preco inv�lido , voc� somente pode informar numero e que sejam positivos ! ");
			return;
		}

		JOptionPane.showMessageDialog(null, "Alterado com sucesso !");

		listarProdutos();
	}

	// valida a descricao do produto e retonar verdadeiro ou falso
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
				// JOptionPane.showMessageDialog(null, "Descri��o v�lida !");
				valido = true;
				return valido;
			}
			// System.out.println(descricao.charAt(i));
		}

		return valido;
	}

	// -------------------CLIENTE-------------------
	// recebe um cliente como parametro adiciona no array de clientes
	public static void addClienteToCliente(Cliente clienteAdd) {
		for (int i = 0; i < clientes.length; i++) {
			Cliente cliente = clientes[i];
			if (cliente == null) {
				clientes[i] = clienteAdd;
				return;
			}
		}
		JOptionPane.showMessageDialog(null, "Array cheio , n�o � poss�vel adicionar mais clientes ! ");
	}

	// cadastrar ou editar | para cadastrar passar 0 e caso queira editar passar o
	// codigo do cliente
	public static Cliente cadastrarCliente(int cod) {

		Cliente cliente = new Cliente();
		int cpf = 0;
		String nomeCliente;
		int telefone = 0;

		// validar se o cliente que ser� editado � v�lido
		if (cod > 0 && clienteValido(cod) == null) {
			return cliente;
		}

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
			telefone = Integer.parseInt(
					JOptionPane.showInputDialog("Informe o telefone do cliente (9 numeros exemplo : 99996666) "));

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
			JOptionPane.showMessageDialog(null, "Cliente editado com sucesso");
			return c;
		}

		cliente.cod = codCliente;
		cliente.cpf = cpf;
		cliente.nome = nomeCliente;
		cliente.telefone = telefone;
		codCliente++;

		if (cliente != null && cod == 0) {
			JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso");
			addClienteToCliente(cliente);
		}

		return cliente;
	}

	// recebe o codigo de um cliente e mostra as informa��es do mesmo
	public static void vizualizarCliente(int codCliente) {

		for (int i = 0; i < clientes.length; i++) {
			Cliente cliente = clientes[i];

			if (cliente == null) {
				JOptionPane.showMessageDialog(null, "C�digo n�o encontrado no sistema");
				return;
			}

			if (cliente.cod == codCliente) {
				JOptionPane.showMessageDialog(null, "Cod : " + cliente.cod + "| CPF : " + cliente.cpf + " | Nome "
						+ cliente.nome + " | Telefone " + cliente.telefone + "\n");
				return;
			}

		}
		JOptionPane.showMessageDialog(null, "C�digo n�o encontrado no sistema");
	}

	// verifica se um cliente � v�lido atrav�s do c�digo , caso v�lido retorna o
	// cliente
	public static Cliente clienteValido(int codCliente) {
		Cliente c = new Cliente();

		boolean valido = false;
		for (int i = 0; i < clientes.length; i++) {
			Cliente cliente = clientes[i];
			if (cliente == null) {
				JOptionPane.showMessageDialog(null, "C�digo n�o encontrado no sistema");
				return null;
			}

			if (cliente.cod == codCliente) {
				c = cliente;
				return c;
			}
		}
		JOptionPane.showMessageDialog(null, "C�digo n�o encontrado no sistema");
		return c;
	}

	// -------------------VENDA-------------------
	// 1 Criar venda
	// metodo para importar os produtos
	// parametro cod : 0 nova venda , valores acima de zero � para editar a venda
	public static void CriarEditarVenda(int cod) {
		Venda venda = new Venda();

		// valida se h� produtos cadastrados para realizar a venda
		if (produtos[0] == null) {
			JOptionPane.showMessageDialog(null, "Voc� n�o pode realizar vendas sem produtos cadastrados");
			return;
		}
		// valida se h� clientes cadastrados para realizar a venda
		if (clientes[0] == null) {
			JOptionPane.showMessageDialog(null, "Voc� n�o pode realizar vendas sem clientes cadastrados");
			return;
		}

		// editar venda
		if (cod > 0) {
			// verificar se a venda � v�lida

			Venda vendaEditada = vendaValida(cod);

			if (vendaEditada == null) {
				JOptionPane.showMessageDialog(null, "C�digo n�o encontrado");
				return;
			}

			if (vendas[0] == null) {
				JOptionPane.showMessageDialog(null, "Lista de vendas vazia");
				return;
			}

			// caso v�lida copiar o c�digo da venda original e editar todo o resto;
			int codigoOriginal = vendaEditada.cod;
			venda = vendaEditada;
			venda.cod = codigoOriginal;
			venda.produtos = new Produto[5];
		}

		// Pedir a desc da venda
		String desc = JOptionPane.showInputDialog("Informe uma descri��o para sua venda no m�nimo 5 caracteres :");
		// validar desc da venda
		if (desc.length() < 5) {
			JOptionPane.showMessageDialog(null, "Descri��o deve conter no m�nimo 5 caracteres");
			return;
		}

		// venda � valida , setar a descricao
		venda.desc = desc;

		// produtos da venda que devem ser 5 no m�ximo
		int codProd = 1;
		int contProdutos = 1;
		String prodsAdicionados = "";
		while (codProd > 0 || codProd == 5) {
			try {

				codProd = Integer.parseInt(
						JOptionPane.showInputDialog("Informe o c�digo do produto que voc� deseja #" + contProdutos
								+ "\n" + listarProdutos() + "\n" + "\n -----Carrinho------" + "\n Items adicionados \n"
								+ prodsAdicionados + "\n Caso n�o queira inserir mais nenhum produto digite 0(zero) "));
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "C�digo do produto deve ser um n�mero !");
				continue;
			}
			if (codProd == 0) {
				JOptionPane.showMessageDialog(null, "Seus items s�o : \n" + prodsAdicionados);
				break;
			}

			Produto prod = produtoValido(codProd);

			if (prod == null) {
				// JOptionPane.showInputDialog("Produto inv�lido , tente novamente ");
				continue;
			}

			// caso produto seja v�lido ser� adicionado no array de produtos da venda
			if (prod != null) {
				prodsAdicionados += contProdutos + " : " + prod.desc + " \n ";
				addProdutoArrayProdutos(venda.produtos, prod);
				contProdutos++;
			}

			if (venda.produtos[0] == null) {
				JOptionPane.showMessageDialog(null, "Venda deve conter no m�nimo um produto !");
				continue;
			}
			// verificar se o limite de produtos foi atingido

			if (venda.produtos[4] != null) {
				JOptionPane.showMessageDialog(null,
						"Inserido a quantidade m�xima de produtos , finalizada a insers�o de produtos !");
				codProd = 0;
				JOptionPane.showMessageDialog(null, "Seus items s�o : \n" + prodsAdicionados);
			}
		}

		// Cliente dentro da venda
		Cliente cliente = new Cliente();
		do {
			// solicitando o c�digo do cliente
			int codCli = 0;
			try {
				codCli = Integer.parseInt(JOptionPane.showInputDialog(
						"Informe o c�digo do cliente \n Lista de cliente \n" + mostrarTodosClientes()));
			} catch (Exception e) {
				// JOptionPane.showMessageDialog(null, "O C�digo do cliente deve ser um n�mero
				// !");
				cliente = null;
			}

			// Pegando o cliente atrav�s do c�digo digitado;
			cliente = clienteValido(codCli);

			// validando se o cliente � v�lido
			if (cliente == null) {
				// JOptionPane.showInputDialog("Cliente inv�lido , tente novamente");
				continue;
			}
			// enquanto o cliente n�o for v�lido o sistema vai pedir novamente
		} while (cliente == null);

		venda.cliente = cliente;
		venda.total = calcularValorDaVenda(venda);

		if (cod == 0) {
			addVendaArrayVendas(vendas, venda);
			venda.cod = codVenda;
			codVenda++;
			JOptionPane.showMessageDialog(null, "Cadastro feito com sucesso!");
		} else {
			JOptionPane.showMessageDialog(null, "Editada com sucesso!");
		}
	}

	// adiciona um elemento uma a um array de vendas qq
	public static void addVendaArrayVendas(Venda[] vendaAdd, Venda v) {
		for (int i = 0; i < vendaAdd.length; i++) {
			Venda venda = vendaAdd[i];
			if (venda == null) {
				vendaAdd[i] = v;
				return;
			}
		}
		JOptionPane.showMessageDialog(null, "Vendas atigiu o limite;");
	}

	// calcular o total da venda apartir do pre�o dos produtos
	public static double calcularValorDaVenda(Venda venda) {
		double valor = 0;

		for (int i = 0; i < venda.produtos.length; i++) {
			Produto produto = venda.produtos[i];
			if (produto == null) {
				return valor;
			}
			valor += produto.preco;
		}
		return valor;
	}

	// verifica se uma venda � valida apartir do seu codigo e ent�o retorna a mesma
	public static Venda vendaValida(int codVenda) {
		Venda v = new Venda();

		for (int i = 0; i < vendas.length; i++) {
			Venda venda = vendas[i];

			if (venda == null) {
				break;
			}

			if (venda.cod == codVenda) {
				v = venda;
				return v;
			}
		}
		JOptionPane.showMessageDialog(null, "Venda n�o encontrada !");
		v = null;
		return v;
	}

	// retorna uma string com a lista de vendas
	public static String listarVendas() {
		String vendaConcat = "Listagem de vendas : \n";
		double totalFaturamento = 0;
		if (vendas[0] == null) {
			JOptionPane.showMessageDialog(null, "N�o h� vendas para serem listadas");
			return "";
		}

		for (int i = 0; i < vendas.length; i++) {
			Venda venda = vendas[i];

			if (venda == null) {
				break;
			}

			vendaConcat += "Cod : " + venda.cod + " descri��o : " + venda.desc + " Cliente " + venda.cliente.nome
					+ "\n Total : R$ " + venda.total + "\n";
			totalFaturamento += venda.total;
		}
		return vendaConcat + "\n" + "Total Faturado R$ : " + totalFaturamento;
	}

	// lista uma venda apartir do codigo
	public static String listarVenda(int cod) {
		String vendaConcat = "";

		if (vendas[0] == null) {
			JOptionPane.showMessageDialog(null, "N�o h� vendas cadastradas !");
			return vendaConcat;
		}

		for (int i = 0; i < vendas.length; i++) {
			Venda venda = vendas[i];
			if (venda == null) {
				break;
			}
			if (venda.cod == cod) {
				vendaConcat += "Cod : " + venda.cod + " descri��o : " + venda.desc + " Cliente " + venda.cliente.nome
						+ "\n Total : R$ " + venda.total + "\n";
				break;
			}
		}
		return vendaConcat;
	}

	// RELATORIOS
	// 4 RELATORIOS

	// mostrar venda
	/*
	 * public static String mostrarVenda(Venda venda) { String dadosVenda="";
	 * 
	 * if(venda==null) { return dadosVenda; }
	 * 
	 * dadosVenda+="Cod : "+venda.cod+"Desc : "+venda.desc+" | Cliente : "+venda.
	 * cliente.nome+" Total: R$ "+venda.total;
	 * 
	 * return dadosVenda; }
	 */

	// 2 ordenar pela menor venda
	public static boolean vendaValidaArrayVendas(Venda[] vendasArray, Venda venda) {
		boolean contido = false;

		for (int i = 0; i < vendasArray.length; i++) {
			Venda v = vendasArray[i];

			if (v == null) {
				break;
			}

			if (venda.cod == v.cod) {
				contido = true;
			}
		}

		return contido;
	}

	// retona a posicao de uma venda
	public static int posicaoVenda(Venda[] vendasArray, Venda venda) {
		int posicao = 0;

		for (int i = 0; i < vendasArray.length; i++) {
			Venda v = vendasArray[i];

			if (v == null) {
				return posicao;
			}

			if (v == venda) {
				posicao = i;
			}
		}
		return posicao;
	}

	// retorna a menor venda de um array
	public static Venda retornaMenorVenda(Venda[] vendas) {

		Venda menorVenda = new Venda();
		double valorMaximo = 9999999;
		menorVenda.total = valorMaximo;

		for (int i = 0; i < vendas.length; i++) {
			Venda venda = vendas[i];

			if (venda == null) {
				break;
			}

			if (menorVenda.total < valorMaximo) {
				menorVenda = venda;
			}
		}

		return menorVenda;
	}

	// clona o array original de vendas e retorna o array clonado
	public static Venda[] copiarArrayVendas() {
		Venda[] arrayCopiado = new Venda[30];

		for (int i = 0; i < vendas.length; i++) {
			Venda venda = vendas[i];

			if (venda == null) {
				break;
			}
			arrayCopiado[i] = new Venda();
			arrayCopiado[i].cliente = venda.cliente;
			arrayCopiado[i].cod = venda.cod;
			arrayCopiado[i].desc = venda.desc;
			arrayCopiado[i].produtos = venda.produtos;
			arrayCopiado[i].total = venda.total;
		}

		return arrayCopiado;
	}

	public static void listarVendasOrdermMenorVenda() {
		// array que servir� para adicionar as vendas em ordem de valor

		// testar o array copiado

		Venda[] copiaVendas = new Venda[30];

		// array de vendas copiado para um outro array
		copiaVendas = copiarArrayVendas();

		Venda vendaAtual = new Venda();
		Venda vendaProxima = new Venda();
		Venda aux = new Venda();

		// algoritmo de ordena��o booble shot
		for (int i = 0; i < copiaVendas.length; i++) {
			for (int j = 0; j < copiaVendas.length - 1; j++) {

				vendaAtual = copiaVendas[j];
				try {
					vendaProxima = copiaVendas[j + 1];
				} catch (Exception e) {
					break;
				}

				// verificar se a venda atual ou a proxima venda est� vazia
				if (vendaAtual == null || vendaProxima == null) {
					break;
				}

				if (vendaAtual.total > vendaProxima.total) {
					aux = copiaVendas[j];
					copiaVendas[j] = vendaProxima;
					copiaVendas[j + 1] = aux;
				}
			}

		}

		String listaProdutosOrdenada = "";

		for (int i = 0; i < copiaVendas.length; i++) {
			Venda venda = copiaVendas[i];
			if (venda == null) {
				break;
			}
			listaProdutosOrdenada += listarVenda(venda.cod);
		}

		JOptionPane.showMessageDialog(null, "Vendas ordenas pelo valor total \n " + listaProdutosOrdenada);
	}

	// 3 lista todos os	produtos , do menor c�digo para o maior c�digo
	public static String listarProdutos() {
		String listaProduto = "Lista de produtos : \n";

		if (produtos[0] == null) {
			JOptionPane.showMessageDialog(null, "Lista de Pre�os est� vazia :");
			return listaProduto;
		}

		for (int i = 0; i < produtos.length; i++) {
			Produto produto = produtos[i];

			if (produto == null) {
				break;
			}

			listaProduto += "Cod : " + produto.cod + "| Desc : " + produto.desc + " | Preco " + produto.preco + " \n";

		}
		return listaProduto;
	}

	// 4 Ordenado pelo pre�o do menor produto Mostrar todos os produtos com seus
	// respectivos dados
	public static void listarProdutosOrdemPreco() {

		if (produtos[0] == null) {
			JOptionPane.showMessageDialog(null, "Lista de Pre�os est� vazia :");
			return;
		}

		Produto[] newProdutos = new Produto[100];
		Produto[] produtosOrdenados = new Produto[100];
		double precoMaximo = 999999999;

		// copiar todos produtos para newProdutos
		for (int i = 0; i < produtos.length; i++) {

			if (produtos[i] == null) {
				break;
			}
			newProdutos[i] = new Produto();
			newProdutos[i].cod = produtos[i].cod;
			newProdutos[i].desc = produtos[i].desc;
			newProdutos[i].preco = produtos[i].preco;
		}

		for (int i = 0; i < newProdutos.length; i++) {
			Produto produto = newProdutos[i];

			if (produto == null) {
				continue;
			}

			Produto produtoMenorPreco = new Produto();
			produtoMenorPreco.preco = precoMaximo;

			// descobrir o menor preco
			for (int j = 0; j < newProdutos.length; j++) {
				Produto produto2 = newProdutos[j];

				if (produto2 == null) {
					continue;
				}

				if (produto2.preco < produtoMenorPreco.preco) {
					produtoMenorPreco = produto2;
				}
			}

			// finalizado o for interno , agora se sabe quem � o produto com meno preco no
			// array
			// System.out.println(produtoMenorPreco.desc);
			int posicaoProdutoComMenorValor = posicaoDoProduto(produtoMenorPreco);

			Produto addProdutoMenorValor = copiarValoresProduto(produtoMenorPreco);
			addProdutoArrayProdutos(produtosOrdenados, addProdutoMenorValor);

			newProdutos[posicaoProdutoComMenorValor].preco = precoMaximo;

			// System.out.println(posicaoDoProduto(produtoMenorPreco));
		}

		String listaProdutosOrdenados = "";
		for (int j = 0; j < produtosOrdenados.length; j++) {
			Produto produto2 = produtosOrdenados[j];

			if (produto2 == null) {
				continue;
			}
			listaProdutosOrdenados += "COD : " + produto2.cod + "| DESC : " + produto2.desc + " VALOR : R$ "
					+ produto2.preco + " \n";
		}
		JOptionPane.showMessageDialog(null, "Relat�rio de produtos em ordem de pre�o : \n" + listaProdutosOrdenados);
	}

	// retorna a posicao do produto no array de produtos
	public static int posicaoDoProduto(Produto produto) {
		int posicao = 0;
		for (int i = 0; i < produtos.length; i++) {
			Produto p = produtos[i];

			if (p == null) {
				return posicao;
			}

			if (p.cod == produto.cod) {
				posicao = i;
			}
		}
		return posicao;
	}

	// adiona um produto a um array de produtos
	public static void addProdutoArrayProdutos(Produto[] produtos, Produto p) {
		for (int i = 0; i < produtos.length; i++) {
			Produto produto = produtos[i];
			if (produto == null) {
				produtos[i] = p;
				return;
			}
		}
		JOptionPane.showInputDialog("Imposs�vel colocar mais produtos");
	}

	// copia os valores do produto e retorna o produto com os valores copiados
	public static Produto copiarValoresProduto(Produto produto) {
		Produto p = new Produto();

		p.cod = produto.cod;
		p.desc = produto.desc;
		p.preco = produto.preco;

		return p;
	}

	// mostrar todos os clientes
	// 5 mostrar todos os clientes pela ordem do codigo (menor para o maior)
	public static String mostrarTodosClientes() {
		String todosClientes = "";

		if (clientes[0] == null) {
			JOptionPane.showMessageDialog(null, "Lista de clientes vazia ");
			return todosClientes;
		}

		for (int i = 0; i < clientes.length; i++) {
			Cliente cliente = clientes[i];

			if (cliente == null) {
				break;
			}

			todosClientes += "Cod : " + cliente.cod + " Nome : " + cliente.nome + " CPF : " + cliente.cpf
					+ " Telefone : " + cliente.telefone + "\n";

		}

		// verifica se a lista de clientes est
		if (todosClientes.equals("")) {
			todosClientes = "Lista de clientes Vazia";
		}

		return todosClientes;
	}

	// MENUS
	// menu principal
	public static String menuPrincial() {
		return "1-Vendas \n" + "2-Produtos \n" + "3-Clientes \n" + "4-Relat�rios\n" + "5-Finalizar programa \n";
	}

	// menu vendas
	public static String menuVendas() {
		return "1-Criar venda \n" + "2-Editar Venda \n" + "3-Vizualizar venda \n" + "4-Voltar \n";
	}

	// menu produtos
	public static String menuProdutos() {
		return "1-Importar produto \n" + "2-Editar Produto \n" + "3-Vizualizar Produto \n" + "4-Voltar\n";
	}

	// menu produtos
	public static String menuClientes() {
		return "1-Cadastrar Cliente\n" + "2-Editar Cliente \n" + "3-Vizualizar Cliente \n" + "4-Voltar\n";
	}

	// menu relatorios
	public static String menuRelatorios() {
		return "1-Relatorio de vendas - ordenar vendas , pelo c�digo crescente \n"
				+ "2-Relatorio de vendas - ordenar vendas , pela menor venda \n"
				+ "3-Relatorio de produto - ordenar produtos , pelo c�digo crescente \n"
				+ "4-Relatorio de produto - ordenar produtos , pelo preco crescente \n"
				+ "5-Relatorio de cliente - ordenar clientes , pelo c�digo crescente \n" + "6-Voltar\n";
	}
}
