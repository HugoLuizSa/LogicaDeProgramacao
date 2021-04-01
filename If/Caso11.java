package LogicaDeProgramacao.If;

import javax.swing.JOptionPane;

public class Caso11 {

	static double valorDeVenda, precoProduto;

	// até<=30-20%
	// até<=40-15%
	// >40-10%
	
	public static void main(String[] args) {

		precoProduto = Double.parseDouble(JOptionPane.showInputDialog("Informe o preco do produto : "));

		if (precoProduto <= 30) {
			valorDeVenda = precoProduto * 1.30;
		} else if (precoProduto <= 40) {
			valorDeVenda = precoProduto * 1.15;
		} else if (precoProduto > 40) {
			valorDeVenda = precoProduto * 1.10;
		}
		
		JOptionPane.showMessageDialog(null,"O produto com o preco R$"+precoProduto
				+"\n deve ser vendido por R$"+valorDeVenda);
	}
}
