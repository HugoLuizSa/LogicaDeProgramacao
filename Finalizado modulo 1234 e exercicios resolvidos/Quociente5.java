import javax.swing.JOptionPane;

public class Quociente5 {
	
	static double a,b,quociente,restoInteiro;
	static String msg;	
	
	public static void main(String[] args) {
		
		a = Double.parseDouble(JOptionPane.showInputDialog("Dividendo o n1: "));
		b = Double.parseDouble(JOptionPane.showInputDialog("Divisor o n2: "));

		restoInteiro=a%b;
		quociente=a/b;
		
		JOptionPane.showMessageDialog(null,"Quociente: "+Math.floor(quociente));
		JOptionPane.showMessageDialog(null,"Resto : "+restoInteiro);
	}
}
