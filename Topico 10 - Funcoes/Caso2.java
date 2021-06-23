import javax.swing.JOptionPane;

public class Caso2 {

	public static void main(String[] args) {

		String nomeCompleto = JOptionPane.showInputDialog("Informe seu nome completo:");

		String primeiroNome = getPrimeiroNome(nomeCompleto);

		JOptionPane.showMessageDialog(null,
				"Seu nome Completo " + nomeCompleto + " seu primeiro nome : " + primeiroNome);

	}

	private static String getPrimeiroNome(String nome) {
		return nome.split(" ")[0];
	}

}
