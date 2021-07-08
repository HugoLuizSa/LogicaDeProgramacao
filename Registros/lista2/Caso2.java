package lista2;

import javax.swing.JOptionPane;

public class Caso2 {

	static class Delivery {
		int cod;
		String nomeDoCliente;
		double valor, taxaEntrega;
		String bairroDeEntrega;
	}

	public static void main(String[] args) {

		Delivery d1 = cadastrarDelivery(1, "Roberto", 50.99, 10, "Centro");
		Delivery d2 = cadastrarDelivery(2, "Francisco", 40.54, 30, "Area Rural");
		Delivery d3 = cadastrarDelivery(3, "Maria", 19.88, 20, "Zona franca");

		Delivery[] deliveries = { d1, d2, d3 };

		int menu;
		do {
			menu=Integer.parseInt(JOptionPane.showInputDialog(""
					+ "1- Pesquisar venda pelo código\r\n"
					+ "2- Mostrar total vendido\r\n"
					+ "3- Mostrar o total arrecadado com o valor das entregas\r\n"
					+ "4- Fechar programa "));
			
			switch (menu) {
			case 1:
				int cod = Integer.parseInt(JOptionPane.showInputDialog("Informe o código :"));
				pesquisaCod(cod, deliveries);
				break;
			case 2:
				JOptionPane.showMessageDialog(null, "Total Vendido : R$"+totalVendido(deliveries)); 
				break;
			case 3:
				JOptionPane.showMessageDialog(null, "Total de entrega : R$"+totalEntrega(deliveries)); 
				break;
			case 4:
				menu=-1;
				break;
			default:
				menu=-1;
			}
			
		} while (sair(menu));
	}

	//MÉTODOS 
	
	public static Delivery cadastrarDelivery(int cod, String nomeDoCliente, double valor, double taxaEntrega,
			String bairroDeEntrega) {
		Delivery delivery = new Delivery();

		delivery.cod = cod;
		delivery.nomeDoCliente = nomeDoCliente;
		delivery.valor = valor;
		delivery.taxaEntrega = taxaEntrega;
		delivery.bairroDeEntrega = bairroDeEntrega;

		return delivery;

	}

	public static void pesquisaCod(int cod, Delivery[] d) {
		for (int i = 0; i < d.length; i++) {
			if (d[i].cod == cod) {
				System.out.println("Cod : "+d[i].cod
						+ "\n nomeDoCliente : "+d[i].nomeDoCliente
						+ "\n taxaEntrega R$: "+d[i].valor
						+ "\n valor: R$"+d[i].taxaEntrega
						+ "\n bairroDeEntrega: "+d[i].bairroDeEntrega
				);
			}
		}
	}

	public static double totalVendido(Delivery[] d) {
		double total = 0;
		for (int i = 0; i < d.length; i++) {
			total += d[i].valor;
		}
		return total;
	}

	public static double totalEntrega(Delivery[] d) {
		double total = 0;
		for (int i = 0; i < d.length; i++) {
			total += d[i].taxaEntrega;
		}
		return total;
	}

	public static boolean sair(int cod) {
		if (cod <= 0 || cod > 3) {
			return false;
		}
		return true;
	}

}
