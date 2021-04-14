import javax.swing.JOptionPane;

public class Poupanca1 {
	
	//var
	static double valorEmDepositado;
	public static void main(String[] args) {

		double valorEmDepositado = Integer.parseInt(JOptionPane.showInputDialog("Informe o valor que você tem depositado na poupança em Reais: "));
		
		valorEmDepositado*=1.01;
		
		JOptionPane.showMessageDialog(null, "Seu novo saldo com reajuste de 1% deve ficar"
		+"\n R$ : "+valorEmDepositado);
	}
}
