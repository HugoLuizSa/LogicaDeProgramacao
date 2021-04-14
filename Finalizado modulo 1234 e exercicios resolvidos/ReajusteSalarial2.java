import javax.swing.JOptionPane;

public class ReajusteSalarial2 {
	
	static char genero;
	static String nome;
	static double salario;

	public static void main(String[] args) {

		nome = JOptionPane.showInputDialog("Informe seu nome : "); 
		genero = JOptionPane.showInputDialog("Informe seu gênero : (M masculino|F feminino)").charAt(0); 
		salario=Double.parseDouble(JOptionPane.showInputDialog("Informe seu salário em R$ : ")); 
	
		//reajuste 28%
		salario*=1.28;
		
		JOptionPane.showMessageDialog(null, "Nome : "+nome+" Gênero: "+genero+" Salário : R$"+salario);
	}
}
