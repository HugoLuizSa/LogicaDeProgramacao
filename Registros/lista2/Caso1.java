package lista2;

public class Caso1 {

	static class Funcionario {
		int matricula;
		String nome, turno;
	}

	public static void main(String[] args) {

		Funcionario f1 = cadastrarFuncionario(14, "Alex", "Norturno");
		Funcionario f2 = cadastrarFuncionario(14, "Alexandre", "Matutino");
		Funcionario f3 = cadastrarFuncionario(14, "Rodrigo", "Vespertino");
		Funcionario f4 = cadastrarFuncionario(14, "Rogério", "Vespertino");

		Funcionario [] funcionarios = {f1,f2,f3,f4};
		
		String pesquisa = "Ro";
	
		filtrarPeloNome(funcionarios, pesquisa);
	}

	static Funcionario cadastrarFuncionario(int matricula, String nome, String turno) {
		Funcionario funcionario = new Funcionario();
		funcionario.matricula = matricula;
		funcionario.nome = nome;
		funcionario.turno = turno;
		return funcionario;
	}

	static void filtrarPeloNome(Funcionario[] funcionarios,String procurarPor) {
		for (int i = 0; i < funcionarios.length; i++) {
			if (funcionarios[i].nome.startsWith(procurarPor)) {
				mostrarInformacoes(funcionarios[i]);
				System.out.println();
			}
		}
	}

	static void mostrarInformacoes(Funcionario funcionario) {
		System.out.println("Matrícula: " + funcionario.matricula + "\n Nome: " + funcionario.nome + "\n Turno :"
				+ funcionario.turno);
	}
}
