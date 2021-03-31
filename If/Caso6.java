package If;

import javax.swing.JOptionPane;

public class Caso6 {
	
	static int nv;
	static double n1=12;
	static double n2=17;
	static double n3=25;
	static double horas,pagamento;
	
	public static void main(String[] args) {
		
		horas = Double.parseDouble(JOptionPane.showInputDialog("informe Quantas horas o prefessor tem na instituição : "));
		nv= Integer.parseInt(JOptionPane.showInputDialog("informe o nível do professor (1,2,3):"));
				
		if(nv==1) {
			pagamento=horas*n1;
		}else if(nv==2){
			pagamento=horas*n2;
		}else if(nv==3){
			pagamento=horas*n3;
		}else {
			JOptionPane.showMessageDialog(null, "Nível informado inválido ! ");
			pagamento=0;
		}
		
		JOptionPane.showMessageDialog(null, "O professor de nível N"+nv
				+"\n com "+horas+" hora(s) "
				+"\n Deve receber R$"+pagamento);
	}
}
