package LogicaDeProgramacao.If;

import javax.swing.JOptionPane;

public class Caso9 {

	static double numero;
	
	public static void main(String[] args) {
		
		numero=Double.parseDouble(JOptionPane.showInputDialog("Informe um número : "));
		
		if(numero>0) {
			JOptionPane.showMessageDialog(null, "Número positivo !");
		}else if(numero<0) {
			JOptionPane.showMessageDialog(null, "Número negativo!");
		}else {
			JOptionPane.showMessageDialog(null, "Número neutro!");
		}
		
	}

}
