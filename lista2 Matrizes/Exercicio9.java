package lista2;

import javax.swing.JOptionPane;

public class Exercicio9 {

	static String[][] clientes = new String[2][7];

	public static void main(String[] args) {

		// Desenvolva um programa que permita a gestão de cadastro de 30 clientes,
		// coletando para cada um deles:

		/**
		 * ● Código alfanumérico ● Nome ● Sobrenome ● Logradouro ● Bairro ● Cidade ●
		 * Estado
		 */

		int menu;
		do {
			menu = Integer.parseInt(JOptionPane.showInputDialog("" + "1 - Adicionar Novo \n" + "2 - Alterar código \n"
					+ "3 - Busca código \n" + "4 - Listar Todos \n" + "5 - Remover código \n" + "6 - Sair \n"));

			// beggin 1 - Adicionar cliente
			if (menu == 1) {
				Cadastro: for (String[] cliente : clientes) {
					if (cliente[0] == null) {
						cliente[0] = JOptionPane.showInputDialog("Código alfanumérico");
						cliente[1] = JOptionPane.showInputDialog("Nome");
						cliente[2] = JOptionPane.showInputDialog("Sobrenome");
						cliente[3] = JOptionPane.showInputDialog("Logradouro");
						cliente[4] = JOptionPane.showInputDialog("Bairro");
						cliente[5] = JOptionPane.showInputDialog("Cidade");
						cliente[6] = JOptionPane.showInputDialog("Estado");
						break Cadastro;
					}
				}
			}
			// end 1

			// start 2 - alterar código
			if (menu == 2) {
				System.out.println("==Alterar Código==");
				String codigoProcurado = JOptionPane.showInputDialog("Informe o código que você está procurando");

				for (String[] cliente : clientes) {
					if (codigoProcurado.equals(cliente[0])) {
						System.out.println("Código Atual :" + cliente[0]);
						cliente[0] = JOptionPane.showInputDialog("Informe o novo código");
						System.out.println("Código atualizado :" + cliente[0]);
					}
				}
				System.out.println("==Finalizado Alterar Código==");
			} // end 2

			// start 3 - Buscar código
			if (menu == 3) {
				System.out.println("==Buscar por Código==");
				String codigoProcurado = JOptionPane.showInputDialog("Informe o código que você está procurando");

				for (String[] cliente : clientes) {
					if (codigoProcurado.equals(cliente[0])) {
						System.out.println("Código alfanumérico " + cliente[0]);
						System.out.println("Nome " + cliente[1]);
						System.out.println("Sobrenome " + cliente[2]);
						System.out.println("Logradouro" + cliente[3]);
						System.out.println("Bairro " + cliente[4]);
						System.out.println("Cidade " + cliente[5]);
						System.out.println("Estado" + cliente[6]);
					}
				}
				System.out.println("==Finalizado Buscar por Código==");
			} // end 3

			// start 4 - Listar todos
			if (menu == 4) {
				System.out.println("==Listar todos==");
				for (String[] cliente : clientes) {
					if (cliente[0] != null) {
						System.out.println("Nome " + cliente[1]);
						System.out.println("Sobrenome " + cliente[2]);
						System.out.println();
					}
				}
				System.out.println("==Listar todos==");
			} // end 4

			// start 5 - remover
			if (menu == 5) {
				System.out.println("==Remover por Código==");
				String codigoProcurado = JOptionPane.showInputDialog("Informe o código que você está procurando");

				for (String[] cliente : clientes) {
					if (codigoProcurado.equals(cliente[0])) {
						cliente[0] = null;
						cliente[1] = null;
						cliente[2] = null;
						cliente[3] = null;
						cliente[4] = null;
						cliente[5] = null;
						cliente[6] = null;
					}
				}
				System.out.println("==Finalizado Buscar por Código==");
			} // end 5

		} while (menu > 0 && menu < 6);

		JOptionPane.showMessageDialog(null, "Programa finalizado !");
	}
}
