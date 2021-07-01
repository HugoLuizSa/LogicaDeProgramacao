package lista2;

import javax.swing.JOptionPane;

public class Caso3 {

	public static void main(String[] args) {

		String tipoSocio=JOptionPane.showInputDialog("Informe o Tipo de sócio que você é : ");
		String time=JOptionPane.showInputDialog("Informe o seu time : "); 
		int idade=Integer.parseInt(JOptionPane.showInputDialog("Informe sua idade"));
		
		JOptionPane.showMessageDialog(null, "Seu local de assento é nas cadeiras : "+localAssento(tipoSocio, time, idade));
	}

	// funcao

	private static String localAssento(String tipoSocio, String time, int idade) {

		if (tipoSocio.toLowerCase().equals("vip")) {
			if (time.toLowerCase().equals("casa")) {
				return "cadeiras azuis";
			}
			if (time.toLowerCase().equals("visitante") || time.toLowerCase().equals("visitantes")) {
				return "cadeiras vermelhas";
			}
		} else {
			if (time.toLowerCase().equals("casa")) {
				if (idade < 31) {
					return "cadeiras amarelas";
				} else {
					return "cadeiras verdes";
				}
			} else {
				return "cadeiras pretas";
			}
		}
		return "";
	}
}
