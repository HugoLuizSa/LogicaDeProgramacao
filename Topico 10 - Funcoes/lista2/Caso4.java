package lista2;

import javax.swing.JOptionPane;

public class Caso4 {

	public static void main(String[] args) {

		String [][] funcionarios=new String[2][3];
		
		for (int i = 0; i < funcionarios.length; i++) {
			funcionarios[i][0]=JOptionPane.showInputDialog("Informe o seu n�mero de matr�cula : ");
			funcionarios[i][1]=JOptionPane.showInputDialog("Informe o seu nome :  ");
			funcionarios[i][2]=JOptionPane.showInputDialog("matutino (M), vespertino (V) e noturno (N) , ! ");
		}
		
		int matriculaProcurada=Integer.parseInt(JOptionPane.showInputDialog("informe o c�digo da matricula procurada"));
		
		String funcionarioPesquisado=pesquisaMatricula(funcionarios,matriculaProcurada);			
		
		JOptionPane.showInputDialog("Funcionario pesquisado : \n"+funcionarioPesquisado);
		
	}
	//Funcoes

	private static String pesquisaMatricula(String[][] funcionarios,int matriculaProcurada) {
		for (int i = 0; i < funcionarios.length; i++) {
			if(Integer.parseInt(funcionarios[i][0])==matriculaProcurada) {
				return "Matricula : "+funcionarios[i][0]+"\n"+
						"Nome: "+funcionarios[i][1]+"\n"+
						"Turno : "+funcionarios[i][2]+"\n";
			}
		}
		return "Matr�cula n�o cadastrada";
	}
	
}
