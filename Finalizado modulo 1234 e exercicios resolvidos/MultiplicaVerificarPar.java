import javax.swing.JOptionPane;

public class MultiplicaVerificarPar {
	
	static double n1,n2,multiplicacao,resultado; 
	static String msg ;
	
	public static void main(String[] args) {
		
		n1 = Double.parseDouble(JOptionPane.showInputDialog("Informe o n1 : "));
		n2 = Double.parseDouble(JOptionPane.showInputDialog("Informe o n2 : "));
		
		multiplicacao=n1*n2;
		resultado=multiplicacao%2;
		
		if(multiplicacao==0) {
			msg = "N1 * N2 = "+multiplicacao
				+" que é par ";
		}else {
			msg = "N1 * N2 = "+multiplicacao
					+" que é impar ";
		}
		
		JOptionPane.showMessageDialog(null, msg);
		
	}
}
