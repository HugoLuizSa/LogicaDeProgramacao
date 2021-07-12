package registros;

import javax.swing.JOptionPane;

public class Caso4 {

	static class Nf {
		int cod;
		String dataEmissao;
		double valorCompra;
		double valorImposto;
		double valorTotal = valorCompra + valorImposto;
		Fornecedor fornecedor;
	}

	static class Fornecedor {
		String razaoSocial;
		String nomeFantasia;
		String cnpj;
	}

	public static void main(String[] args) {

		Nf[] nfs = new Nf[10];

		Fornecedor f1 = cadastrarFornecedor("Americanas LTDA", "Americanas", "9999-9999");
		Fornecedor f2 = cadastrarFornecedor("NetShoes LTDA", "NetShoes", "9999-8888");
		Fornecedor f3 = cadastrarFornecedor("Kabum S.A", "Kabum", "9999-7777");

		Fornecedor[] fornecedores = { f1, f2, f3 };

		Nf nf1 = new Nf();
		Nf nf2 = new Nf();

		nf1.cod=1;
		nf1.dataEmissao="1";
		nf1.fornecedor=f1;
		nf1.valorCompra=10;
		nf1.valorImposto=20;

		nf2.cod=3;
		nf2.dataEmissao="2";
		nf2.fornecedor=f2;
		nf2.valorCompra=20;
		nf2.valorImposto=30;
		
		addNota(nf1, nfs);
		addNota(nf2, nfs);
		
		//listarNotas(nfs);
		
		//listarFornecedor(fornecedores);
		
		//localizarNota(nfs, 3);
		
		//Fornecedor f =localizarFornecedor(fornecedores,"Kabum");
		//System.out.print(f.nomeFantasia);
		
		int op=0;
		do {
			op=rodarMenu();
			switch (op) {
			case 1:
				Nf nf = cadastrarNota(fornecedores);
				addNota(nf, nfs);
				break;
			case 2:
				listarNotas(nfs);
				break;
			case 3:
				listarFornecedor(fornecedores);
				break;
			case 4:
				localizarNota(nfs);
				break;
			default:
				break;
			}
		} while (menuValido(op));
	}
	
	//rendeziar menu
	
	public static String renderizarMenu() {
		return ""
				+ "\n 1-Cadastrar nota : "
				+ "\n 2-Listar notas : "
				+ "\n 3- Listar Fornecedores : "
				+ "\n 4- Buscar notas por código :"
				;
	}
	
	public static int rodarMenu() {
		int op = Integer.parseInt(JOptionPane.showInputDialog(renderizarMenu()));
		return op;
	}
	
	public static boolean menuValido(int op) {
		if(op>0 && op<5) {
			return true;
		}
		return false;
	}
	
	//mostrar informações
	private static String fornecedorInformacoes(Fornecedor f) {
		return "Razao social : "+f.razaoSocial
				+"\n nomeFantasia : "+f.nomeFantasia
				+"\n cnpj : "+f.cnpj;
	}

	private static String notaInformacoes(Nf n) {
		return "cod : "+n.cod
				+"\n valorCompra R$: "+n.valorCompra
				+"\n valorImposto R$: "+n.valorImposto
				+"\n valorTotal R$: "+(n.valorImposto+n.valorCompra)
				+"\n Fornecedor : "+(n.fornecedor.nomeFantasia);
	}
	
	// utilitarios
	private static Fornecedor cadastrarFornecedor(String razaoSocial, String nomeFantasia, String cnpj) {
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.razaoSocial = razaoSocial;
		fornecedor.nomeFantasia = nomeFantasia;
		fornecedor.cnpj = cnpj;
		return fornecedor;
	}

	private static Fornecedor localizarFornecedor(Fornecedor[] fornecedores, String nomeFantasia) {
		for (int i = 0; i < fornecedores.length; i++) {
			Fornecedor fornecedor = fornecedores[i];
			System.out.println(fornecedor.nomeFantasia);
			if (fornecedor.nomeFantasia.equals(nomeFantasia)) {
				System.out.println(fornecedor.nomeFantasia);
				return fornecedor;
			}
		}
		return null;
	}

	//3
	private static void listarFornecedor(Fornecedor[] fornecedores) {
		for(int i = 0;i<fornecedores.length;i++) {
			Fornecedor fornecedor=fornecedores[i];
			if(fornecedor!=null) {
				System.out.println(fornecedorInformacoes(fornecedor));
				System.out.println();
			}
			continue;
		}
	}
	
	//1
	private static Nf cadastrarNota(Fornecedor[] f) {
		Nf nf = new Nf();
		nf.cod=Integer.parseInt(JOptionPane.showInputDialog("Informe o código da nota :"));
		nf.dataEmissao=JOptionPane.showInputDialog("Informe a data de emissão da nota :");
		nf.valorCompra=Double.parseDouble(JOptionPane.showInputDialog("Informe o valor da compra :"));
		nf.valorImposto=Double.parseDouble(JOptionPane.showInputDialog("Informe valor dos impostos :"));
		String fornecedor=JOptionPane.showInputDialog("o nome fantasia do fornecedor :");
		
		nf.fornecedor=localizarFornecedor(f,fornecedor);
		
		return nf;
	}
	
	private static void addNota(Nf notaAdicionar,Nf[] nfs) {
		notas:for (int i = 0; i < nfs.length; i++) {
			if(nfs[i]==null) {
				System.out.println("Adicionado na posicao "+i);
				nfs[i]=notaAdicionar;
				break notas;
			}
			continue;
		}
	}

	//2
	public static void listarNotas(Nf notas[]) {
		for (int i = 0; i < notas.length; i++) {
			//verificar se o array está vazio
			Nf nf = notas[i];
			if(nf!=null) {
				System.out.println(notaInformacoes(nf));
				System.out.println();
			}
			continue;
		}
	}
	
	//4
	public static void localizarNota(Nf[] nfs) {
		int cod=Integer.parseInt(JOptionPane.showInputDialog("Informe o códido da nota que está procurando !"));
		for (int i = 0; i < nfs.length; i++) {
			Nf nf = nfs[i];
			if(nf!=null) {
				if(nf.cod==cod) {
					System.out.println("Nota pesquisada cod: "+cod);
				 System.out.println(notaInformacoes(nf));
				}				
			}
			continue;
		}
	}
	
}
