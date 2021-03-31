package If;

import javax.swing.JOptionPane;

public class Caso7 {

	static double altura, pesoIdeal;
	static String genero;

	public static void main(String[] args) {
		
		/*
		 * Construa um algoritmo que calcule o peso ideal de uma pessoa.
		   Dados de entrada: altura e sexo.
		      ⦿ Fórmulas para cálculo do peso:
		     ⌾ Peso ideal de homem = (72,7 x altura) - 58
		    ⌾ Peso ideal da mulher = (62,1 x altura) - 44,7
		 * 
		 * */
		

		genero = JOptionPane.showInputDialog("Informe o seu genero (masculino M | feminino F ) : ");
		altura = Double.parseDouble(JOptionPane.showInputDialog("Informe a sua altura em cm :"));
		 
		if (genero.equalsIgnoreCase("M")) {
			pesoIdeal = (72.7 * altura / 100) - 58;
		} else if (genero.equalsIgnoreCase("F")) {
			pesoIdeal = (62.1 * altura / 100) - 44.7;
		} else {
			JOptionPane.showMessageDialog(null, "Dados de entrada inválidos ");
		}
		JOptionPane.showMessageDialog(null, "A pessoa do gênero do " + genero + "\n Com altura " + altura/100+"m"+
				"\n seu peso ideal seria de : " + pesoIdeal+"kg");
	}
}
