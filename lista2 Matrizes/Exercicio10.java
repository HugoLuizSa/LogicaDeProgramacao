package lista2;

import java.awt.JobAttributes;

import javax.swing.JOptionPane;

public class Exercicio10 {

	public static void main(String[] args) {

		String[][] fornecedores = new String[5][3];
		String[][] notas = new String[100][88];

		// fornecedor
		// ● Razão social
		// ● Nome fantasia
		// ● CNPJ

		// Nota
		// ● Código
		// ● CNPJ do fornecedor
		// ● Dia
		// ● Mês
		// ● Ano
		// ● Valor da compra (R$)
		// ● Valor dos impostos (R$)
		// ● Valor total (R$)

		int menu;

		do {
			menu = Integer.parseInt(JOptionPane.showInputDialog("1 - Inserir fornecedor: \n"
					+ "2 - Listar fornecedores: \n" + "3 - Lançar nota: \n" + "4 - Remover nota por código: \n"
					+ "5 - listar notas: \n" + "6 - Buscar nota por código: \n" + "7 - Sair \n"));

			// 1- inserir fornecedor
			if (menu == 1) {
				Adicionar: for (String[] fornecedor : fornecedores) {
					if (fornecedor[0] == null) {
						fornecedor[0] = JOptionPane.showInputDialog("Informe a razão social");
						fornecedor[1] = JOptionPane.showInputDialog("Informe o Nome fantasia");
						fornecedor[2] = JOptionPane.showInputDialog("Informe o CNPJ");
						break Adicionar;
					}
				}
			} // fim 1- inserir fornecedor

			// 2- listar fornecedor
			if (menu == 2) {
				System.out.println("==Listagem de Fornecedores==");
				for (String[] fornecedor : fornecedores) {
					if (fornecedor[0] != null) {
						System.out.println("● Razão social " + fornecedor[0]);
						System.out.println("● Nome fantasia " + fornecedor[1]);
						System.out.println("● CNPJ " + fornecedor[2]);

						System.out.println();
						// fornecedor[0] = JOptionPane.showInputDialog("Informe a razão social");
						// fornecedor[1] = JOptionPane.showInputDialog("Informe o Nome fantasia");
						// fornecedor[2] = JOptionPane.showInputDialog("Informe o CNPJ");
					}
				}
				System.out.println("==*=*==");
			} // fim 2- listar fornecedor

			// 3 - lançar nota
			if (menu == 3) {
				Cadastrar: for (String[] nota : notas) {
					if (nota[0] == null) {
						nota[0] = JOptionPane.showInputDialog("● Código");
						nota[1] = JOptionPane.showInputDialog("● CNPJ do fornecedor");
						nota[2] = JOptionPane.showInputDialog("● Dia");
						nota[3] = JOptionPane.showInputDialog("● Mês");
						nota[4] = JOptionPane.showInputDialog("● Ano");
						nota[5] = JOptionPane.showInputDialog("● Valor da compra (R$)");
						nota[6] = JOptionPane.showInputDialog("● Valor dos impostos (R$)");

						double tt = Double.parseDouble(nota[5]) + Double.parseDouble(nota[6]);
						nota[7] = tt + "";
						break Cadastrar;
					}
				}
			} // fim 3 - lançar nota

			// 4 - Remover nota por código
			if (menu == 4) {
				int cod = Integer.parseInt(JOptionPane.showInputDialog("informe o codigo da nota que deseja excluir"));
				Remover :for (int i = 0; i < notas.length; i++) {
					if (Integer.parseInt(notas[i][0]) == cod) {
						JOptionPane.showMessageDialog(null, "entrou");
						for (int j = 0; j < notas[i].length; j++) {
							notas[i][j] = null;
							break Remover;
						}
					}
				}
			} // 4 - FIM Remover nota por código

			// 5 - Listar notas
			if (menu == 5) {
				System.out.println("==Listagem de Notas==");
				for (String[] nota : notas) {
					if (nota[0] != null) {
						System.out.println("● Código : " + nota[0]);
						System.out.println("● CNPJ do fornecedor : " + nota[1]);
						System.out.println("● Vencidmento: " + nota[2]+"/"+nota[3]+"/"+nota[4]);
						System.out.println("● Valor da compra (R$) : " + nota[5]);
						System.out.println("● Valor dos impostos (R$): " + nota[6]);
						System.out.println("● Valor total (R$) : " + nota[7]);
						System.out.println();
					}
				}
				System.out.println("== Fim ==");
				System.out.println();
			} // 5- Fim Listar notas

			// 6 - Listar notas
			if (menu == 6) {
				int cod = Integer.parseInt(JOptionPane.showInputDialog("Informe o código da nota procurada"));
				System.out.println("==Listagem de Notas procurada por codigo==");
				for (String[] nota : notas) {
					if (nota[0] != null) {
						if (Integer.parseInt(nota[0]) == cod) {
							System.out.println("● Código  : " + nota[0]);
							System.out.println("● CNPJ do fornecedor  : " + nota[1]);
							System.out.println("● Vencidmento: " + nota[2]+"/"+nota[3]+"/"+nota[4]);
							System.out.println("● Valor da compra (R$) : " + nota[5]);
							System.out.println("● Valor dos impostos (R$ : )" + nota[6]);
							System.out.println("● Valor total (R$)  : " + nota[7]);
							System.out.println();
						}
					}
				}
				System.out.println("== Fim ==");
				System.out.println();
			} // 6- Fim Listar notas

		} while (menu > 0 && menu < 7);
		JOptionPane.showMessageDialog(null, "Programa Finalizado");
	}
}
