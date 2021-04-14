import javax.swing.JOptionPane;

public class MaiorNumero4 {

	static double a,b,sub;
	static String msg;	
	
	public static void main(String[] args) {

		a = Double.parseDouble(JOptionPane.showInputDialog("Informe o n1: "));
		b = Double.parseDouble(JOptionPane.showInputDialog("Informe o n2: "));
		
		sub=a-b;
		
		if(sub<0) {
			msg="B é maior";
		}else if(sub>0) {
			msg="A é maior";
		}else {
			msg="Os numeros são iguais";
		}
		
		JOptionPane.showMessageDialog(null,msg);
	}
}
