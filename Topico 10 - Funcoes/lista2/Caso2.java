package lista2;

import javax.swing.JOptionPane;

public class Caso2 {

	public static void main(String[] args) {
		
		
		/**
		 * 2. Desenvolva um programa que solicite ao funcionário seu nome, cargo(deve
			ser solicitado G para gerência ou P produção) e seu salário. Através de
			uma função você deve calcular o reajuste do salário. Para cargo de
			gerência o reajuste vai ser de 8% e para o cargo de produção o reajuste vai
			ser de 5%. A função deve receber o cargo e o salário por parâmetro e
			retornar o novo salário. Depois mostre o nome da pessoa, seu cargo e o
			novo salário.
		 * 
		 * */
	
		
		String nomeFuncionario = JOptionPane.showInputDialog("Informe seu nome :");
		char cargoFuncionario= JOptionPane.showInputDialog("Informe seu cargo G para gerência ou P produção :").charAt(0);
		double salarioAtual= Double.parseDouble(JOptionPane.showInputDialog("Informe seu salário Atual"));
		
		System.out.printf("O funcionario : %s ocupa o cargo de %c %n seu salario antes do "
				+ "ajuste era R$ %.2f após o ajuste será de R$ %.2f" ,nomeFuncionario,cargoFuncionario,salarioAtual,reajusteSalarial(cargoFuncionario,salarioAtual));
	}
	
	//métodos
	private static double reajusteSalarial(char cargo , double salario) {
		if(cargo=='p' || cargo=='P') return salario*1.05;
		if(cargo=='g' || cargo=='G') return salario*1.08;
		return 0;
	}
	
}
