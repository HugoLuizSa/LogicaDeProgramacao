package If;

import javax.swing.JOptionPane;

public class Caso8 {

	static int anoCarro;
	static double taxaVelho = 0.01;
	static double taxaNovo = 0.015;
	static double valorCarro, taxaPagar;

	public static void main(String[] args) {

		valorCarro = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor do veículo : "));
		anoCarro = Integer.parseInt(JOptionPane.showInputDialog("Informe o ano do carro : "));

		if (anoCarro < 1990) {
			taxaPagar = valorCarro * taxaVelho;
		} else {
			taxaPagar = valorCarro * taxaNovo;
		}

		JOptionPane.showMessageDialog(null, "O carro com ano de fabricacao " + anoCarro + "\n Com valor de R$"
				+ valorCarro + "\n deve pagar de documento R$" + taxaPagar);

	}
}
