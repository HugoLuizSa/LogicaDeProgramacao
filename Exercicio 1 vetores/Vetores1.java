import javax.swing.JOptionPane;

public class Vetores1 {

	static int[] numeros;
	static int[] pares;
	static int[] impares;

	public static void main(String[] args) {

		numeros = new int[5];

		int contPar = 0;
		int contImpar = 0;

		for (int i = 0; i < numeros.length; i++) {
			int numero = Integer.parseInt(JOptionPane.showInputDialog("Informe um número ! #" + i));
			numeros[i] = numero;

			if (numero % 2 == 0) {
				contPar++;
			} else {
				contImpar++;
			}
		}

		pares = new int[contPar];
		impares = new int[contImpar];

		// pares

		for (int i = 0; i < numeros.length; i++) {
			for (int j = 0; j <= i; j++) {
				if (numeros[i] % 2 == 0) {
					//System.out.println("I: " + i + " = " + numeros[i]);
					if (pares[j] == 0) {
						pares[j] = numeros[i];
						j = i;
					}
				}else {
					if(impares[j]==0) {
						impares[j]=numeros[i];	
						j = i;
					}
				}
			}
		}

		System.out.println("--Pares--");
		for (int j = 0; j < pares.length; j++) {			
			System.out.println(pares[j]);
		}

		System.out.println("--Impares--");
		
		for (int j = 0; j < impares.length; j++) {			
			System.out.println(impares[j]);
		}
	}
}
