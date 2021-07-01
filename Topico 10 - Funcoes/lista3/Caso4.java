package lista3;

import javax.swing.JOptionPane;

public class Caso4 {

	static String[][] funcionarios = { { "Romário", "1000" }, { "Romário", "2000" } };;

	public static void main(String[] args) {

		double percentualAjuste = Double.parseDouble(JOptionPane.showInputDialog("Informe o quanto deseja ajustar o salario dos funcionários "));

		reajustarSalarios(percentualAjuste);

	}

	private static void reajustarSalarios(double percentualAjuste) {

		for (int i = 0; i < funcionarios.length; i++) {
			double ajustado = Double.parseDouble(funcionarios[i][1]) * (1 + (percentualAjuste/100));
			funcionarios[i][1] = ajustado + "";
			System.out.println("Nome : " + funcionarios[i][0] + " salario ajustado : R$" + funcionarios[i][1]);
			continue;
		}

	}
}
