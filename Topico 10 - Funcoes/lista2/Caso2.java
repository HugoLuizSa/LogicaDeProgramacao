package lista2;

import javax.swing.JOptionPane;

public class Caso2 {

	public static void main(String[] args) {
		
		
		/**
		 * 2. Desenvolva um programa que solicite ao funcion�rio seu nome, cargo(deve
			ser solicitado G para ger�ncia ou P produ��o) e seu sal�rio. Atrav�s de
			uma fun��o voc� deve calcular o reajuste do sal�rio. Para cargo de
			ger�ncia o reajuste vai ser de 8% e para o cargo de produ��o o reajuste vai
			ser de 5%. A fun��o deve receber o cargo e o sal�rio por par�metro e
			retornar o novo sal�rio. Depois mostre o nome da pessoa, seu cargo e o
			novo sal�rio.
		 * 
		 * */
	
		
		String nomeFuncionario = JOptionPane.showInputDialog("Informe seu nome :");
		char cargoFuncionario= JOptionPane.showInputDialog("Informe seu cargo G para ger�ncia ou P produ��o :").charAt(0);
		double salarioAtual= Double.parseDouble(JOptionPane.showInputDialog("Informe seu sal�rio Atual"));
		
		System.out.printf("O funcionario : %s ocupa o cargo de %c %n seu salario antes do "
				+ "ajuste era R$ %.2f ap�s o ajuste ser� de R$ %.2f" ,nomeFuncionario,cargoFuncionario,salarioAtual,reajusteSalarial(cargoFuncionario,salarioAtual));
	}
	
	//m�todos
	private static double reajusteSalarial(char cargo , double salario) {
		if(cargo=='p' || cargo=='P') return salario*1.05;
		if(cargo=='g' || cargo=='G') return salario*1.08;
		return 0;
	}
	
}
