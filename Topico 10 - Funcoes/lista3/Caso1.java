package lista3;

import javax.swing.JOptionPane;

public class Caso1 {

	static double a,b,result;
	static String op;
	
	public static void main(String[] args) {
		
		a=Double.parseDouble(JOptionPane.showInputDialog("Informe o numero n1 : "));
		b=Double.parseDouble(JOptionPane.showInputDialog("Informe o numero n2 : "));
		
		op=JOptionPane.showInputDialog("Informe o operador que você deseja '+' | '-' | '*' | '/' ");
		
		calcular(op, a, b);
		
		JOptionPane.showMessageDialog(null, " Resultado : "+a+" "+op+" "+b+" = "+result);
	}
	
	private static void calcular(String op , double n1 , double n2) {
		switch (op) {
		case "+":
			result=n1+n2;
			break;
		case "-":
			result=n1-n2;
			break;
		case "*":
			result=n1*n2;
			break;
		case "/":
			result=n1/n2;
			break;
		default:
			result=0;
			break;
		}
	}
}
