package If;

import javax.swing.JOptionPane;

public class Caso6 {
	
	static int nv;
	static double n1=12;
	static double n2=17;
	static double n3=25;
	static double horas,pagamento;
	
	public static void main(String[] args) {
		
		horas = Double.parseDouble(JOptionPane.showInputDialog("informe Quantas horas o prefessor tem na institui��o : "));
		nv= Integer.parseInt(JOptionPane.showInputDialog("informe o n�vel do professor (1,2,3):"));
				
		if(nv==1) {
			pagamento=horas*n1;
		}else if(nv==2){
			pagamento=horas*n2;
		}else if(nv==3){
			pagamento=horas*n3;
		}else {
			JOptionPane.showMessageDialog(null, "N�vel informado inv�lido ! ");
			pagamento=0;
		}
		
		JOptionPane.showMessageDialog(null, "O professor de n�vel N"+nv
				+"\n com "+horas+" hora(s) "
				+"\n Deve receber R$"+pagamento);
	}
}
