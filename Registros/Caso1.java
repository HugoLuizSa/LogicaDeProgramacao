package lista1;

public class Caso1 {

	//criando registro da classe Diario de classe
	static class Diario{
		String disciplina,dtInicio,dtTermino;
		int qtdAlunos;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//criar um novo diario de classe
		
		Diario diario= new Diario ();
		
		diario = criarDiario("Matemática","01/01/2021","20/11/2021",20);
		
		mostrarDiario(diario);
	}

	static Diario criarDiario(String disciplina,String dtInicio,String dtTermino,int qtdAluno) {
		Diario diario = new Diario();
		
		diario.disciplina=disciplina;
		diario.dtInicio=dtInicio;
		diario.dtTermino=dtTermino;
		diario.qtdAlunos=qtdAluno;
		
		return diario;
	}
	
	static void mostrarDiario(Diario diario) {
		
		System.out.println("Nome disciplina: "+diario.disciplina);
		System.out.println("dt inicio : "+diario.dtInicio);
		System.out.println("dt termino :  "+diario.dtTermino);
		System.out.println("qtd alunos : "+diario.qtdAlunos);
	}
}
