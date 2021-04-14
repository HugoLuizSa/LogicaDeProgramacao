import javax.swing.JOptionPane;

public class VerificaRaiz {

	static double numero, resultado;

	public static void main(String[] args) {

		numero = Double.parseDouble(JOptionPane.showInputDialog("Informe um número : "));

		if (numero % 9 == 0) {
			resultado = 9;
		} else if (numero % 8 == 0) {
			resultado = 8;
		} else if (numero % 7 == 0) {
			resultado = 7;
		} else if (numero % 6 == 0) {
			resultado = 6;
		} else if (numero % 5 == 0) {
			resultado = 5;
		} else if (numero % 4 == 0) {
			resultado = 4;
		} else if (numero % 3 == 0) {
			resultado = 3;
		} else if (numero % 2 == 0) {
			resultado = 2;
		}

		JOptionPane.showMessageDialog(null, "Numero : "+numero +" é raiz de "+resultado);
	}
}
