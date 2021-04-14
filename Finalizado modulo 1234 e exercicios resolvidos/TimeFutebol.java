import javax.swing.JOptionPane;

public class TimeFutebol {
	
	static String nome,local;
	static int tipoSocio,time,idade;
	
	public static void main(String[] args) {

		nome=JOptionPane.showInputDialog("informe seu nome");
		tipoSocio=Integer.parseInt(JOptionPane.showInputDialog("1-VIP \n 2-Normal"));
		time=Integer.parseInt(JOptionPane.showInputDialog("1-casa \n 2-Visitante"));
		idade=Integer.parseInt(JOptionPane.showInputDialog("informe sua idade :"));
		
		if((tipoSocio == 1) && (time==1)) {
			local="vip casa todas deve sentar nas cadeiras azuis";
		}else if((tipoSocio == 1) && (time==2)) {
			local="vip visitante deve sentar nas cadeiras vermelhas";
		}else if((tipoSocio == 2) && (time==1) && (idade<31)) {
			local="normal casa 0 até 30 cadeiras amarelas";
		}else if((tipoSocio == 2) && (time==1) && (idade>30)) {
			local="normal casa 0 até 30 cadeiras verdes";
		}else {
			local="normal casa 0 até 30 cadeiras pretas";
		}
		
		System.out.println(local);
	}
}
