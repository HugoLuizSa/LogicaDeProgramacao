import javax.swing.JOptionPane;

public class AutoEscola10 {
	
	static char tipoCarteira;
	static String habilitadoPara;
	public static void main(String[] args) {

		tipoCarteira=JOptionPane.showInputDialog("Informe o tipo da sua CNH").charAt(0);
		
		switch (tipoCarteira) {
		case 'A':
			habilitadoPara="Moto";
			break;
		case 'a':
			habilitadoPara="Moto";
			break;
		case 'B':
			habilitadoPara="Carro";
			break;
		case 'b':
			habilitadoPara="Carro";
			break;
		default:
			habilitadoPara="Entrada inválida";
			break;
		}
		
		JOptionPane.showMessageDialog(null,habilitadoPara);
	}
}
