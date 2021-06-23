import javax.swing.JOptionPane;

public class Caso4 {

	public static void main(String[] args) {

		String[] nomes=new String[5];
		double[] salarios=new double[5];
	
		//popular vetor nomes
		nomes=getNomes(nomes);
		
		//popular vetor salarios
		salarios=getSalarios(salarios);
		
		System.out.println("Antes do ajuste");
		//mostrar nome e salário
		mostrarDadosFuncionario(nomes,salarios);
		System.out.println();
		
		double percentualAjuste = Double.parseDouble(JOptionPane.showInputDialog("Informe o percentual de ajuste formato (50 %) "));
		double [] salariosReajustados= reajustarSalarios(salarios,percentualAjuste);
		
		//mostrar nome e salário
		System.out.println("Depois do ajuste de "+percentualAjuste+"%");
		mostrarDadosFuncionario(nomes,salariosReajustados);
		System.out.println();
	}

	private static double[] reajustarSalarios(double[] salarios,double percentual) {
		for (int i = 0; i < salarios.length; i++) {
			salarios[i]=salarios[i]*(1+(percentual/100));
		}
		return salarios;
	}

	private static void mostrarDadosFuncionario(String[] nomes, double[] salarios) {
		for (int i = 0; i < nomes.length; i++) {
			System.out.println("-----------");
			System.out.println("Nome : "+nomes[i]);
			System.out.println("Salario : "+salarios[i]);
			System.out.println("-----------");
		}
		System.out.println();
	}

	private static double[] getSalarios(double[] salarios) {
		double [] novosSalarios = new double[salarios.length];
		for (int j = 0; j < novosSalarios.length; j++) {
			double salario = Double.parseDouble(JOptionPane.showInputDialog("Informe o salário do funcionário"+(j+1)));
			 novosSalarios[j] = salario;
		}
		return novosSalarios;
	}

	private static String[] getNomes(String[] nomes) {
		String [] nomesPrenchidos=new String[nomes.length];
		for (int i = 0; i < nomesPrenchidos.length; i++) {
			String nome = JOptionPane.showInputDialog("Digite um nome : "+(i+1));
			nomesPrenchidos[i]=nome;
		}
		return nomesPrenchidos;
	}
	
	
}
