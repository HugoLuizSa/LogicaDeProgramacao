import javax.swing.JOptionPane;

public class Vetores5 {

	static double[] notas;

	public static void main(String[] args) {

		int qtdNotas = Integer.parseInt(JOptionPane.showInputDialog("Quantas notas deseja informar ?"));

		notas = new double[qtdNotas];

		double media = 0;
		for (int i = 0; i < notas.length; i++) {
			notas[i] = Double.parseDouble(JOptionPane.showInputDialog("Informe um numero :  " + i));
			media += notas[i];
		}

		System.out.println(media/notas.length);
	}

}
