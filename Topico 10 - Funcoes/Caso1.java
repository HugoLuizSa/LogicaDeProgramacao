import javax.swing.JOptionPane;

public class Caso1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double numero1 = Double.parseDouble(JOptionPane.showInputDialog("Informe o numero ! "));
		double numero2 = Double.parseDouble(JOptionPane.showInputDialog("Informe o numero ! "));

		int operador = Integer.parseInt(JOptionPane.showInputDialog(
				"Informe um operado" + "\n 1-somar" + "\n 2-subtrair" + "\n 3-multiplicar" + "\n 4-dividir"));

		double resultado;

		switch (operador) {
		case 1:
			resultado = somar(numero1, numero2);
			System.out.println("O resultado de "+numero1+"+"+numero2+"="+resultado);
			break;
		case 2:
			resultado = subtrair(numero1, numero2);
			break;
		case 3:
			resultado = multiplicar(numero1, numero2);
			System.out.println("O resultado de "+numero1+"*"+numero2+"="+resultado);
			break;
		case 4:
			resultado = dividir(numero1, numero2);
			System.out.println("O resultado de "+numero1+"/"+numero2+"="+resultado);
			break;

		default:
			JOptionPane.showMessageDialog(null, "Opção inválida");
			break;
		}
		
		
	}

	private static double dividir(double numero1, double numero2) {
		// TODO Auto-generated method stub
		return numero1 + numero2;
	}

	private static double multiplicar(double numero1, double numero2) {
		// TODO Auto-generated method stub
		return numero1 * numero2;
	}

	private static double subtrair(double numero1, double numero2) {
		// TODO Auto-generated method stub
		return numero1 - numero2;
	}

	private static double somar(double numero1, double numero2) {
		// TODO Auto-generated method stub
		return numero1 + numero2;
	}

}
