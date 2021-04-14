import javax.swing.JOptionPane;

public class AlunoAprovado9 {

	static double semestre1, semestre2, frequencia, media;
	static String resultado;

	public static void main(String[] args) {

		semestre1 = Double.parseDouble("Informe a nota do semestre 1 :");
		semestre2 = Double.parseDouble("Informe a nota do semestre 2 :");
		frequencia = Double.parseDouble("Informe a frequencia do semestre (0% a 100%) :");

		media = (semestre1 + semestre2) / 2;
		
		if((media>7) && (frequencia>=75)) {
			resultado="Aprovado";
		}else if((media>7) && (frequencia<75)) {
			resultado="Reprovado por frequencia";
		}else if((media<7) && (frequencia>=75)) {
			resultado="Reprovado por nota";
		}else if((media<7) && (frequencia<75)) {
			resultado="Reprovado por nota e frequencia";
		}
		JOptionPane.showMessageDialog(null, resultado);
	}
}
