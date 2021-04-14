import javax.swing.JOptionPane;

public class CalculoSalario3 {
	
	//var
	static double salarioMinimo=1000;
	static double salarioUsuario;
	static double  qtdSalariosMinimos;
	
	public static void main(String[] args) {

		salarioUsuario=Double.parseDouble(JOptionPane.showInputDialog("Informe seu salario R$: "));
		salarioMinimo=Double.parseDouble(JOptionPane.showInputDialog("Informe o salario mínimo : "));
		
		qtdSalariosMinimos=(salarioUsuario/salarioMinimo);
		
		JOptionPane.showMessageDialog(null, "Salario do usuario R$ "+salarioUsuario
				+" que representa "+qtdSalariosMinimos+" salários mínimos ");
	}
}
