package lista3;

import javax.swing.JOptionPane;

public class Caso1 {

	/*código da camiseta(número inteiro), modelo da camiseta, cor da camiseta,
	tamanho da camiseta (P, M, G, GG e Extra), quantidade disponível, valor
	unitário.*/

	static class Camiseta {
		 int cod;
		 String modelo,cor,tamanho;
		 int qtd;
		 double valor;
	}
	
	public static void main(String[] args) {

		Camiseta c1 = cadastrarCamiseta(1, "regata", "red", "M", 4, 200.75);
		Camiseta c2 = cadastrarCamiseta(2, "manga curta", "blue", "P", 65, 120);
		Camiseta c3 = cadastrarCamiseta(3, "camisa xadrez", "red", "G", 4, 20.99);
		Camiseta c4= cadastrarCamiseta(4, "camisa", "purple", "P", 4, 200.85);
		Camiseta c5 = cadastrarCamiseta(5, "manga cumprida", "blue", "Extra", 65, 20.33);
		
		Camiseta [] camisetas = {c1,c2,c3,c4,c5};
		
		int op=0;
		int cod =0;
		do {
			op=Integer.parseInt(JOptionPane.showInputDialog(menu()));
			switch (op) {
			case 1:
				cod=Integer.parseInt(JOptionPane.showInputDialog("Qual codigo está procurando : "));
				pesquisarCodigo(camisetas, cod);
				break;
			case 2:
				relatorio(camisetas);
				break;
			case 3:
				valorEstoque(camisetas);
				break;
			default:
				JOptionPane.showMessageDialog(null,"Programa finalizado!");
				break;
			}
		} while (opValida(op));
		
	}
	
	public static boolean opValida(int op) {
		if(op>0 && op<4) {
			return true;
		}
		return false;
	}
	
	public static String menu() {
		return "1- Pesquisar a camiseta pelo código\r\n"
				+ "2- Mostrar um relatório de camisetas pelo tamanho cadastrado\r\n"
				+ "3-Mostrar um relatório de camisetas pelo modelo cadastrado; Neste\r\n"
				+ "relatório é preciso mostrar o valor total em estoque(quantidade x preço\r\n"
				+ "unitário);\r\n"
				+ "4- Fechar programa\r\n"
				+ "Essas opções devem ser realizadas através de procedimentos.";
	}
	
	public static Camiseta cadastrarCamiseta(int cod,String modelo,String cor,String tamanho,int qtd,double valor) {
		Camiseta camiseta= new Camiseta();
		
		camiseta.cod=cod;
		camiseta.modelo=modelo;
		camiseta.cor=cor;
		camiseta.tamanho=tamanho;
		camiseta.qtd=qtd;
		camiseta.valor=valor;
		
		return camiseta;
	}

	public static void mostrarCamiseta(Camiseta c) {
		System.out.println(
				"\n  Cod :"+ c.cod
				+"\n Modelo  :"+ c.modelo
				+"\n Cor :"+ c.cor
				+"\n Tamanho :"+ c.tamanho
				+"\n Qtd :"+ c.qtd
				+"\n Valor R$ :"+ c.valor
				+"\n ");
	}
	
	//1
	public static void pesquisarCodigo(Camiseta[] c,int cod) {
		for (int i = 0; i < c.length; i++) {
			Camiseta camiseta = c[i];
			if(camiseta.cod==cod) {
				mostrarCamiseta(camiseta);
				System.out.println();
			}
			continue;
		}
	}
	//2
	public static void relatorio(Camiseta[] c) {
		String[] tamanhos= {"P","M","G","GG","Extra"};
		
		for (int i = 0; i < tamanhos.length; i++) {
			
			System.out.println("================");
			System.out.println("Camisetas do tamanho : "+tamanhos[i]);
			
			for (int j = 0; j < c.length; j++) {
				Camiseta camiseta = c[j];
				if(camiseta.tamanho.equals(tamanhos[i])) {
					mostrarCamiseta(camiseta);
				}
				continue;
			}
			System.out.println("================");
		}
	}
	
	//3
	public static void valorEstoque(Camiseta[] c) {
		for (int i = 0; i < c.length; i++) {
			Camiseta camiseta = c[i];
			
			System.out.println("======");
			System.out.println("Valor em estoque :"+camiseta.modelo);
			System.out.println("QTD :"+camiseta.qtd+" Preco : R$"+camiseta.valor+" -> Total : R$"+(camiseta.qtd*camiseta.valor));
			System.out.println("======");
		
		}
	}
	
}
