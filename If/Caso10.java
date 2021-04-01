package LogicaDeProgramacao.If;

import javax.swing.JOptionPane;

public class Caso10 {

	static double numero1,numero2,numero3;

	public static void main(String[] args) {

		numero1 = Double.parseDouble(JOptionPane.showInputDialog("Informe o primeiro número : "));
		numero2 = Double.parseDouble(JOptionPane.showInputDialog("Informe o primeiro número : "));
		numero3 = Double.parseDouble(JOptionPane.showInputDialog("Informe o primeiro número : "));

		if ((numero1 > numero2) && (numero1 > numero3) ) {
			JOptionPane.showMessageDialog(null, "Primeiro Número é o maior!");
		} else if ((numero2 > numero3)) {
			JOptionPane.showMessageDialog(null, "Segundo Número é o maior!");
		} else  {
			JOptionPane.showMessageDialog(null, "Terceiro Número é o maior!");
		} 
	}
}
