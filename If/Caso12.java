package LogicaDeProgramacao.If;

import javax.swing.JOptionPane;

public class Caso12 {

	static double l1, l2, l3;
	static String tipoTriangulo;

	// 3 iguais equilatero
	// 2 iguais isóceles
	// todo diferente escaleno

	public static void main(String[] args) {

		l1 = Double.parseDouble(JOptionPane.showInputDialog("Informe o l1 do triangulo : "));
		l2 = Double.parseDouble(JOptionPane.showInputDialog("Informe o l1 do triangulo : "));
		l3 = Double.parseDouble(JOptionPane.showInputDialog("Informe o l1 do triangulo : "));

		if ((l1 == l2) && (l2 == l3)) {
			tipoTriangulo = "Equilatero";
		} else if ((l1 != l2) && (l1 != l3)) {
			tipoTriangulo = "Escaleno";
		} else {
			tipoTriangulo = "Isóceles";
		}

		JOptionPane.showMessageDialog(null,
				"l1 : " + l1 + "\n l2 : " + l2 + "\n l2 : " + l3 + "\n Tipo Triangulo : " + tipoTriangulo);
	}

}
