import javax.swing.JOptionPane;

public class Vetores11 {

	static int[] numeros;

	public static void main(String[] args) {

		numeros = new int[5];
		int soma = 0;
		// popular array
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = Integer.parseInt(JOptionPane.showInputDialog("n #" + i + " de " + numeros.length));
			
			if(numeros[i]<0 || numeros[i]>50) {
				JOptionPane.showMessageDialog(null, "Você informou um valor abaixo de 0 ou acima de 50 !");
			}else {
				soma+=numeros[i];
			}
		}
		
		JOptionPane.showMessageDialog(null,"Soma dos numeros entre 0 e 50 deu igual : "+soma);
		
		JOptionPane.showMessageDialog(null,"Numeros fora do intervalo !");
		for (int i = 0; i < numeros.length; i++) {
			if(numeros[i]<0 || numeros[i]>50){
				JOptionPane.showMessageDialog(null,"numero fora do intervalo : "+numeros[i]);				
			}
		}
	}
}
