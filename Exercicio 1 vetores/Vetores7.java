import javax.swing.JOptionPane;

public class Vetores7 {

	static int[] idade;
	static String[] nome;

	public static void main(String[] args) {

		int qtdAluno=4;
		
		idade = new int[qtdAluno];
		nome= new String[qtdAluno];
		
		for (int i = 0; i < idade.length; i++) {
			nome[i]=JOptionPane.showInputDialog("Nome do aluno");
			idade[i]=Integer.parseInt(JOptionPane.showInputDialog("idade do aluno"));
		}
		
		
		JOptionPane.showMessageDialog(null, "Alunos maiores de idade !");
		for (int i = 0; i < idade.length; i++) {
			if(idade[i]>=18) {
				JOptionPane.showMessageDialog(null, "Nome: "+nome[i]+" idade: "+idade[i]);
			}
		}
		
		JOptionPane.showMessageDialog(null, "Alunos menores de idade !");
		for (int i = 0; i < idade.length; i++) {
			if(idade[i]<18) {
				JOptionPane.showMessageDialog(null, "Nome: "+nome[i]+" idade: "+idade[i]);
			}
		}
		
		
		/*
		 * for (int i = 0; i < c.length; i++) { if ((i % 2) == 0) { if (i == 0) { c[i] =
		 * a[i]; } else { c[i] = a[i / 2]; } } else {
		 * 
		 * if (i == 1) { c[i] = b[0]; } else { c[i] = b[i - 2];
		 * 
		 * } } }
		 */

		/*
		 * for (int j = 0; j < a.length; j++) { if(j==0) { c[j]=a[j]; }else {
		 * c[j+1]=a[j]; } }
		 * 
		 * for (int j = 0; j < a.length; j++) { if(j==0) { c[1]=b[0]; }else {
		 * c[j+2]=b[j]; } }
		 */

	}
}
