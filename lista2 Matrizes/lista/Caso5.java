package lista;

import javax.swing.JOptionPane;

public class Caso5 {

	public static void main(String[] args) {

		double[] vendas = new double[5];

		/// entrada dos valores de venda
		for (int i = 0; i < vendas.length; i++) {
			vendas[i] = Double.parseDouble(JOptionPane.showInputDialog("Informe o preço da compra : " + (i + 1)));
		}

		double[] pagamento = new double[5];
		/// entrada dos valores pagos
		for (int i = 0; i < pagamento.length; i++) {
			pagamento[i] = Double.parseDouble(
					JOptionPane.showInputDialog("Informe o preço da pago pela compra de : R$" + vendas[i]));
		}

		calcularTroco(vendas, pagamento);
	}

	private static void calcularTroco(double[] vendas, double[] pagamento) {

		for (int i = 0; i < pagamento.length; i++) {
			if (vendas[i] < pagamento[i]) {
				double troco = pagamento[i] - vendas[i] ;
				System.out.println(
						"Venda: R$ " + vendas[i] + " e pagou " + pagamento[i] + " o troco deve ser de : R$ " + troco);
			} else {
				System.out
						.println("Venda: R$ " + vendas[i] + " e pagou " + pagamento[i] + " o troco deve ser de : R$ 0");
			}
		}
	}

}
