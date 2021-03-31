package If;

import javax.swing.JOptionPane;

public class Caso4 {

	static double valorHoraNormal = 10;
	static double valorHoraExtra = 15;
	static boolean gerente = false;
	static double horasTrabalhadasNormais;
	static double horasTrabalhadasExtras;
	static double salarioBruto, salarioLiquido;

	public static void main(String[] args) {

		/*
		 * ENUNCIADO ) A empresa Konoha paga R$10,00 por hora normal trabalhada, e
		 * R$15,00 por hora extra. Caso a fun��o do trabalhador seja de gerente, ele
		 * recebe 25% sobre o sal�rio bruto. Fa�a um algoritmo para calcular e imprimir
		 * o sal�rio bruto e o sal�rio l�quido de um determinado funcion�rio. Considere
		 * que o sal�rio l�quido � igual ao sal�rio bruto descontando-se 10% de
		 * impostos.
		 */

		// **Expediente deve ter 8horas , calculo feito por dia ;

		horasTrabalhadasNormais = Double
				.parseDouble(JOptionPane.showInputDialog("informe a quantidade de Horas trabalhada : "));
		gerente = Boolean.parseBoolean(JOptionPane.showInputDialog("Caso gerente Digite(True) caso contr�rio digite (False) : "));

		if (horasTrabalhadasNormais > 8) {
			horasTrabalhadasExtras = horasTrabalhadasNormais - 8;
			horasTrabalhadasNormais -= horasTrabalhadasExtras;
		} else {
			horasTrabalhadasExtras = 0;
		}

		if (gerente) {
			salarioBruto = ((horasTrabalhadasNormais * valorHoraNormal) + (horasTrabalhadasExtras * valorHoraExtra));
			salarioBruto *=1.25;
			salarioLiquido = salarioBruto - (salarioBruto * 0.15);
		} else {
			salarioBruto = ((horasTrabalhadasNormais * valorHoraNormal) + (horasTrabalhadasExtras * valorHoraExtra));
			salarioLiquido = salarioBruto-(salarioBruto * 0.15);
		}

		JOptionPane.showMessageDialog(null, "O funcionario trabalhou : \n"
		+"Horas normais :"+horasTrabalhadasNormais+"\n"
		+"Horas Extras :"+horasTrabalhadasExtras+"\n"
		+"Sal�rio Bruto R$:"+salarioBruto+"\n"
		+"Sal�rio L�quido R$:"+salarioLiquido+"\n");
		
	}
}
