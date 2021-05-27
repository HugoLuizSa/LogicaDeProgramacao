import javax.swing.JOptionPane;

public class Vetores4 {

	
	static double []vetorA;
	static double []vetorB;
	static double []vetorC;
	
	public static void main(String[] args) {
	
		vetorA = new double[5]; 
		vetorB = new double[5]; 
		vetorC = new double[5]; 
		
		for (int i = 0; i < vetorA.length; i++) {
			double n=Double.parseDouble(JOptionPane.showInputDialog("Informe um numero A :  "+i));
			vetorA[i]=n;
			n=Double.parseDouble(JOptionPane.showInputDialog("Informe um numero :  "+i));
			vetorB[i]=n;
			
			
			vetorC[i]=vetorA[i]*vetorB[i];
			System.out.println(vetorA[i]+"x"+vetorB[i]+" = "+vetorC[i]);
		}
	}

}
