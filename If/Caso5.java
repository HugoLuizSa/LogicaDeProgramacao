package If;

import javax.swing.JOptionPane;

public class Caso5 {

	static int idade;
	static String categoria;
	
	public static void main(String[] args) {

		/*
		 * Um determinado clube de futebol pretende classificar seus atletas em
		 * categorias e para isto ele contratou um programador para criar um programa
		 * que executasse esta tarefa. Para isso o clube criou uma tabela que continha a
		 * faixa etária do atleta e sua categoria. A tabela está demonstrada ao lado:
		 */

		/*
		 * Construa um programa que solicite o nome e a idade de um atleta e imprima a
		 * sua categoria
		 */
		
		/*
		 * De 05 a 10 anos Infantil
		De 11 a 15 anos Juvenil
		De 16 a 20 anos Júnior
		De 21 a 25 anos Profissional
		*/
		
		idade=Integer.parseInt(JOptionPane.showInputDialog("Informe a idade do atleta : "));
		
		if(idade >=5 && idade <=10 ) {
			categoria="Infantil";
		}else if(idade >=11 && idade <=15 ) {
			categoria="Juvenil";
		}else if(idade >=16 && idade <=20 ) {
			categoria="Júnior";
		}else if(idade >=21 && idade <=25 ) {
			categoria="Profissional";
		}
		
		JOptionPane.showMessageDialog(null, "O atleta com idade de "+idade+"\n CATEGORIA : " +categoria);
		
	}
}
