import javax.swing.JOptionPane;

public class Vetores8 {

	static int[] numeros;

	public static void main(String[] args) {

		numeros = new int[10];

		// popular array
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = Integer.parseInt(JOptionPane.showInputDialog("n #" + i + " de " + numeros.length));
		}

		for (int i = 0; i < numeros.length; i++) {
			int qtd=0;
			for (int j = 0; j < numeros.length; j++) {
				if(numeros[i]==numeros[j]) {
					qtd++;
				}
			}
			if(qtd>=2) {
				JOptionPane.showMessageDialog(null, "O numero "+numeros[i]+" já apareceu "+qtd+" vezes !");	
				break;
			}
		}

	}
}
