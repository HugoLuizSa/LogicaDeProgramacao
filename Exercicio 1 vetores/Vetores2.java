import javax.swing.JOptionPane;

public class Vetores2 {

	
	static double []vetorA;
	static double []vetorB;
	
	public static void main(String[] args) {
	
		vetorA = new double[5]; 
		vetorB = new double[5]; 
		
		for (int i = 0; i < vetorA.length; i++) {
			double n=Double.parseDouble(JOptionPane.showInputDialog("Informe um numero :  "));
			vetorA[i]=n;
			vetorB[i]=vetorA[i]*vetorA[i];
			
			System.out.println(vetorA[i]+"x"+vetorA[i]+" = "+vetorB[i]);
		}
	}

}
