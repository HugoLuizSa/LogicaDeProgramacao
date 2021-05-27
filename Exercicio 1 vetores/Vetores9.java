import javax.swing.JOptionPane;

public class Vetores9 {

	static int[] numeros;

	public static void main(String[] args) {

		numeros = new int[10];

		// popular array
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = Integer.parseInt(JOptionPane.showInputDialog("n #" + i + " de " + numeros.length));
		}

		for (int i = 0; i < numeros.length; i++) {
			if(numeros[i]<0) {
				JOptionPane.showMessageDialog(null, numeros[i]+" é negativo ");
			}else {
				JOptionPane.showMessageDialog(null, numeros[i]+" é positivo");				
			}
		}

	}
}
