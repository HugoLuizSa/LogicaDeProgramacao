package LogicaDeProgramacao.If;

import javax.swing.JOptionPane;

public class Caso9 {

	static double numero;
	
	public static void main(String[] args) {
		
		numero=Double.parseDouble(JOptionPane.showInputDialog("Informe um n�mero : "));
		
		if(numero>0) {
			JOptionPane.showMessageDialog(null, "N�mero positivo !");
		}else if(numero<0) {
			JOptionPane.showMessageDialog(null, "N�mero negativo!");
		}else {
			JOptionPane.showMessageDialog(null, "N�mero neutro!");
		}
		
	}

}
