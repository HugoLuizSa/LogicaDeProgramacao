import javax.swing.JOptionPane;

public class Vetores10 {

	static int[] numeros;
	static int[] resultados;

	public static void main(String[] args) {

		numeros = new int[5];
		resultados= new int[5];

		// popular array
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = Integer.parseInt(JOptionPane.showInputDialog("n #" + i + " de " + numeros.length));
			resultados[i]=numeros[i]*i;
		}

		for (int i = 0; i < numeros.length; i++) {
			JOptionPane.showMessageDialog(null, numeros[i] + "x"+i+ " = "+resultados[i]);
		}
	}
}
