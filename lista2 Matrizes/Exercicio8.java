package lista2;

import javax.swing.JOptionPane;

public class Exercicio8 {

	static String[][] carrinho = new String[10][5];

	public static void main(String[] args) {

		boolean op = true;

		Extern: while (op) {

			int menu = Integer.parseInt(
					JOptionPane.showInputDialog("Informe uma opção : \n" + "1 - Adicionar produto ao carrinho \n"
							+ "2 - Remover produto por código \n" + "3 - Ver carrinho \n" + "4 - Ir para checkout \n"));

			if (menu <= 4 && menu > 0) {

				// 1 - Adicionar produto ao carrinho
				if (menu == 1) {
					Outer: for (String[] produto : carrinho) {

						if (produto[0] == null) {
							JOptionPane.showMessageDialog(null, "Informe os dados do produto");
							String cod = JOptionPane.showInputDialog("informe o codigo do produto : ");
							String descricao = JOptionPane.showInputDialog("informe a descricao do produto : ");
							String quantidade = JOptionPane.showInputDialog("informe a quantidade do produto : ");
							String valorUnitario = JOptionPane
									.showInputDialog("informe o valor Unitario do produto : ");

							produto[0] = cod;
							produto[1] = descricao;
							produto[2] = quantidade;
							produto[3] = valorUnitario;
							produto[4] = (Integer.parseInt(quantidade) * Double.parseDouble(valorUnitario)) + "";

							break Outer;
						} else if (!(carrinho[(carrinho.length - 1)][0] == null)) {
							JOptionPane.showMessageDialog(null, "Carrinho Cheio");
						}
					}
					JOptionPane.showMessageDialog(null, "finalizado o cadastro do produto");
					op = true;

				}

				// 2 - Remover produto carrinho
				if (menu == 2) {
					System.out.println("======remover produto Carrinho======");
					JOptionPane.showMessageDialog(null, "remover item do carrinho ");

					int codProduto = Integer.parseInt(JOptionPane.showInputDialog("informe o código do produto"));

					Outer: for (String[] produto : carrinho) {
						if (Integer.parseInt(produto[0]) == codProduto) {
							produto[0] = null;
							produto[1] = null;
							produto[2] = null;
							produto[3] = null;
							JOptionPane.showMessageDialog(null, "item removido");
							break Outer;
						}
					}
					System.out.println("==============");
					op = true;
				}

				// 3 - Ver carrinho
				if (menu == 3) {
					System.out.println("======Ver Carrinho======");
					JOptionPane.showMessageDialog(null, "Ver Carrinho ");
					for (String[] produto : carrinho) {

						if (produto[0] != null) {
							System.out.println("Cod : " + produto[0]);
							System.out.println("Descrição : " + produto[1]);
							System.out.println("Quantidade : " + produto[2]);
							System.out.println("Valor unitário: " + produto[3]);
							System.out.println(
									"Subtotal : R$" + (Integer.parseInt(produto[2]) * Double.parseDouble(produto[3])));
							System.out.println();
						}

					}
					JOptionPane.showMessageDialog(null, "finalizado Listagem");
					System.out.println("==============");
					op = true;
				}

				// 4- Checkout
				if (menu == 4) {
					double tt = 0;
					System.out.println("======Ver CheckOut======");
					JOptionPane.showMessageDialog(null, "Ver CheckOut ");
					for (String[] produto : carrinho) {
						if (produto[0] != null) {
							tt += Integer.parseInt(produto[2]) * Double.parseDouble(produto[3]);

							System.out.println("Cod : " + produto[0]);
							System.out.println("Descrição : " + produto[1]);
							System.out.println("Quantidade : " + produto[2]);
							System.out.println("Valor unitário: " + produto[3]);
							System.out.println(
									"Subtotal : R$" + (Integer.parseInt(produto[2]) * Double.parseDouble(produto[3])));
							System.out.println();
						}
					}
					JOptionPane.showMessageDialog(null, "valor total para ser pago R$:" + tt);
					System.out.println("valor total para ser pago R$:" + tt);
					JOptionPane.showMessageDialog(null, "finalizado Checkout");
					System.out.println("==============");
					JOptionPane.showMessageDialog(null, "Programa finalizado");
					op = false;
				}

			}
		}

	}
}
