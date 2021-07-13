package lista3;

import javax.swing.JOptionPane;

public class Caso2 {

	public static class Aluno {
		String nome;
		int freq;
		double media;
	}

	public static void main(String[] args) {

		Aluno a1 = cadastrarAluno("Hugo", 80, 85.5);
		Aluno a2 = cadastrarAluno("Ciro", 70, 75.5);
		Aluno a3 = cadastrarAluno("Amoedo", 90, 95.5);

		Aluno[] alunos = { a1, a2, a3 };

		int op = 0;

		do {

			op = Integer.parseInt(JOptionPane.showInputDialog(menu()));

			switch (op) {
			case 1:
				listarAlunos(alunos);
				break;
			case 2:
				aprovados(alunos);
				break;
			case 3:
				reprovaPorNota(alunos);
				break;
			case 4:
				reprovaPorFrequencia(alunos);
				break;
			case 5:
				qtdAprovadosReprovados(alunos);
				break;
			default:
				break;
			}

		} while (opValida(op));

	}

	private static Aluno cadastrarAluno(String nome, int freq, double media) {
		Aluno aluno = new Aluno();

		aluno.nome = nome;
		aluno.freq = freq;
		aluno.media = media;

		return aluno;
	}

	// menu
	public static String menu() {
		return "1- Relatório de todos os alunos com seus respectivos dados;\r\n"
				+ "2- Relatório de alunos aprovados; Regra: média da nota maior ou igual 7 e\r\n"
				+ "frequência maior ou igual a 70%;\r\n"
				+ "3- Relatório de alunos reprovados por nota; Regra: média da nota menor\r\n"
				+ "que 7 e frequência maior ou igual a 70%;\r\n"
				+ "4- Relatório de alunos reprovados por frequência; Regra: média da nota\r\n"
				+ "maior ou igual 7 e frequência menor que 70%;\r\n"
				+ "5- Relatório com a quantidade de alunos aprovados e reprovados;\r\n"
				+ "Mostrar o total arrecadado com o valor das entregas\r\n" + "6- Fechar programa";
	}

	// opcao válida
	public static boolean opValida(int op) {
		if (op > 0 && op < 6) {
			return true;
		}
		return false;
	}

	// mostrar informacoes aluno
	public static String mostrarAluno(Aluno aluno) {
		return "Nome:" + aluno.nome + "\n Media:" + aluno.freq + "\n Media:" + aluno.media;
	}

	// 1-listar alunos
	public static void listarAlunos(Aluno[] alunos) {
		for (int i = 0; i < alunos.length; i++) {
			Aluno aluno = alunos[i];
			System.out.println(mostrarAluno(aluno));
			System.out.println();
		}
	}

	// 2- Alunos aprovados
	public static void aprovados(Aluno[] alunos) {
		System.out.println("==Alunos aprovados==");

		for (int i = 0; i < alunos.length; i++) {
			Aluno aluno = alunos[i];
			if (aluno.freq >= 70 && aluno.media >= 7) {
				System.out.println(mostrarAluno(aluno));
				System.out.println();
			}
		}
		System.out.println("==Alunos aprovados==");
	}

	// 3- Alunos aprovados
	public static void reprovaPorNota(Aluno[] alunos) {
		System.out.println("==Alunos aprovados==");

		for (int i = 0; i < alunos.length; i++) {
			Aluno aluno = alunos[i];
			if (aluno.freq > 70 && aluno.media < 7) {
				System.out.println(mostrarAluno(aluno));
				System.out.println();
			}
		}
		System.out.println("==Alunos aprovados==");
	}

	// 4- Alunos aprovados
	public static void reprovaPorFrequencia(Aluno[] alunos) {
		System.out.println("==Alunos aprovados==");

		for (int i = 0; i < alunos.length; i++) {
			Aluno aluno = alunos[i];
			if (aluno.freq < 70 && aluno.media >= 7) {
				System.out.println(mostrarAluno(aluno));
				System.out.println();
			}
		}
		System.out.println("==Alunos aprovados==");
	}
	
	// 5- Alunos qtd aprovados qtd reprovados
		public static void qtdAprovadosReprovados(Aluno[] alunos) {
			int aprovados=0;
			int reprovados=0;
			
			for (int i = 0; i < alunos.length; i++) {
				Aluno aluno = alunos[i];
				if (aluno.freq > 70 && aluno.media >= 7) {
					aprovados++;
				}else {
					reprovados++;
				}
			}
			
			System.out.println("== QTD Alunos aprovados== : "+aprovados);
			System.out.println("== QTD Alunos reprovados== : "+reprovados);
		}

}
