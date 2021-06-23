import javax.swing.JOptionPane;

public class Caso3 {

	public static void main(String[] args) {

		String nomes[] = new String[5];

		// obtendo os nomes
		for (int i = 0; i < nomes.length; i++) {
			String nome =JOptionPane.showInputDialog("informe o nome "+(i+1)); 
			nomes[i]=nome;
		}

		for (String nome : nomes) {
			if(iniciaComVogal(nome)) {
				System.out.println(nome);
			}
		}

	}

	// vogais A,E,I,O,U
	private static boolean iniciaComVogal(String letraString) {
		if (letraString.toLowerCase().startsWith("a") || letraString.toLowerCase().startsWith("e")
				|| letraString.toLowerCase().startsWith("i") || letraString.toLowerCase().startsWith("o")
				|| letraString.toLowerCase().startsWith("u")) {
			return true;
		}
		return false;
	}

}
