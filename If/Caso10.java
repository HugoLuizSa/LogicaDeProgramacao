package LogicaDeProgramacao.If;

import javax.swing.JOptionPane;

public class Caso10 {

	static double numero1,numero2,numero3;

	public static void main(String[] args) {

		numero1 = Double.parseDouble(JOptionPane.showInputDialog("Informe o primeiro n�mero : "));
		numero2 = Double.parseDouble(JOptionPane.showInputDialog("Informe o primeiro n�mero : "));
		numero3 = Double.parseDouble(JOptionPane.showInputDialog("Informe o primeiro n�mero : "));

		if ((numero1 > numero2) && (numero1 > numero3) ) {
			JOptionPane.showMessageDialog(null, "Primeiro N�mero � o maior!");
		} else if ((numero2 > numero3)) {
			JOptionPane.showMessageDialog(null, "Segundo N�mero � o maior!");
		} else  {
			JOptionPane.showMessageDialog(null, "Terceiro N�mero � o maior!");
		} 
	}
}
