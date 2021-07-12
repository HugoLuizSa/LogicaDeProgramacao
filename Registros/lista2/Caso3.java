package registros;

import javax.swing.JOptionPane;

public class Caso3 {

	static class Chamado {
		int cod;
		String titulo;
		Funcionario funcionario;
		char status;
	}

	static class Funcionario {
		int matricula;
		String nome, cargo;
	}

	public static void main(String[] args) {

		// criado funcionarios
		Funcionario f1 = cadastrarFuncionario(2, "Rafael", "Suporte");
		Funcionario f2 = cadastrarFuncionario(4, "Cris", "Comercial");
		Funcionario f3 = cadastrarFuncionario(99, "Carlos", "Comercial");

		// criado chamados
		Chamado c1 = cadastrarChamado(6, "dúvida pagamento", f1, 'A');
		Chamado c2 = cadastrarChamado(9, "Relatório", f1, 'F');
		Chamado c3 = cadastrarChamado(11, "Instalacao", f3, 'F');

		// lista de chamados
		Chamado[] chamados = { c1, c2, c3 };

		int menu = 0;
		int cod = 0;

		do {
			menu = renderizarMenu();
			OperarMenu(menu, chamados);
		} while (validarMenu(menu));

	}

	public static boolean validarMenu(int cod) {
		if (cod > 0 && cod < 9) {
			return true;
		}
		return false;
	}

	public static int renderizarMenu() {
		String menu = "1-Listar todos os chamados" + "\n 2- Pesquisar pelo código do chamado"
				+ "\n 3- Alterar o status de um chamado" + "\n 4- Pesquisar chamados vinculados ao funcionário"
				+ "\n 5- listar somente chamados abertos" + "\n 6- listar somente chamados fechados"
				+ "\n 7- Listar qtd chamados abertos" + "\n 8- Listar qtd chamados fechados";

		int op = Integer.parseInt(JOptionPane.showInputDialog(menu));
		return op;
	}

	public static void OperarMenu(int op, Chamado[] chamados) {

		int cod = 0;
		Chamado chamado;

		switch (op) {
		case 1:// listar chamados
			listarChamados(chamados);
			break;
		case 2:// pesquisar chamados
			cod = Integer.parseInt(JOptionPane.showInputDialog("Informe o código do chamado que deseja  : "));
			chamado = filtrarChamado(chamados, cod);
			mostrarChamado(chamado);
			break;
		case 3:// Alterar status chamado
			cod = Integer.parseInt(
					JOptionPane.showInputDialog("Informe o código do chamado que deseja alterar o status  : "));
			alterarStatus(chamados, cod);
			break;
		case 4:// Listar os chamados referente a um usuario
			cod = Integer
					.parseInt(JOptionPane.showInputDialog("Informe a matricula do funcionario que deseja filtrar : "));
			filtrarChamadosFuncionario(chamados, cod);
			break;
		case 5:// Listar somente chamados abertos
			filtrarChamadosStatus(chamados, 'A');
			break;
		case 6:// Listar somente chamados abertos
			filtrarChamadosStatus(chamados, 'F');
			break;
		case 7:// QTD chamados abertos
			System.out.println(qtdChamaos(chamados, 'A'));
			break;
		case 8:// QTD chamados fechados
			System.out.println(qtdChamaos(chamados, 'F'));
			break;
		default:
			JOptionPane.showMessageDialog(null, "Programa finalizado !");
			break;
		}
	}

	public static Chamado cadastrarChamado(int cod, String titulo, Funcionario funcionario, char status) {
		Chamado chamado = new Chamado();
		chamado.cod = cod;
		chamado.titulo = titulo;
		chamado.funcionario = funcionario;
		chamado.status = status;
		return chamado;
	}

	public static Funcionario cadastrarFuncionario(int matricula, String nome, String cargo) {
		Funcionario funcionario = new Funcionario();
		funcionario.matricula = matricula;
		funcionario.nome = nome;
		funcionario.cargo = cargo;
		return funcionario;
	}

	// mostrar informações do chamado
	public static void mostrarChamado(Chamado chamado) {
		System.out.println("Cod : " + chamado.cod + "\n Titulo: " + chamado.titulo + "\n Funcionario: "
				+ chamado.funcionario.nome + "\n Status: " + chamado.status);
	}

	// mostrar informações do funcionario
	public static void mostrarFuncionario(Funcionario funcionario) {
		System.out.println("Matricula : " + funcionario.matricula + "\n Nome : " + funcionario.nome + "\\n Cargo : "
				+ funcionario.cargo);
	}

	// 1-Listar todos os chamados
	static void listarChamados(Chamado[] chamados) {
		System.out.println("1-Listar todos os chamados !");
		for (int i = 0; i < chamados.length; i++) {
			Chamado chamado = chamados[i];
			mostrarChamado(chamado);
			System.out.println();
		}
	}

	// 2-Pesquisar pelo código do chamado
	static Chamado filtrarChamado(Chamado[] chamados, int codChamado) {
		System.out.println("2-Chamado Filtrado !");
		for (int i = 0; i < chamados.length; i++) {
			Chamado chamado = chamados[i];
			if (chamado.cod == codChamado) {
				return chamado;
			}
		}
		return null;
	}

	// 3-alterar Status
	public static void alterarStatus(Chamado[] chamados, int codChamado) {
		for (int i = 0; i < chamados.length; i++) {
			Chamado chamado = chamados[i];
			if (chamado.cod == codChamado) {
				chamado.status = JOptionPane
						.showInputDialog(
								"O status atual do chamado é " + chamado.status + " você deseja Fechar(F) ou Abrir(A)")
						.toUpperCase().charAt(0);
				System.out.println("--Alterado com suscesso!--");
			}
		}
	}

	// 4- filtrar chamados de um determinado funcionario
	public static void filtrarChamadosFuncionario(Chamado[] chamados, int matricula) {
		int acc = 0;
		for (int i = 0; i < chamados.length; i++) {
			Chamado chamado = chamados[i];
			if (chamado.funcionario.matricula == matricula) {
				acc++;
				mostrarChamado(chamado);
			}
		}

		if (acc == 0) {
			System.out.println("Nenhum Chamado para este funcionário !");
		}

	}

	// 5-FiltrarChamados Abertos
	// 6-FiltrarChamados Abertos
	public static void filtrarChamadosStatus(Chamado[] chamados, char status) {
		if (status == 'A') {
			System.out.println("Lista de chamados Abertos !");
		} else {
			System.out.println("Lista de chamados Fechados !");
		}
		for (int i = 0; i < chamados.length; i++) {
			Chamado chamado = chamados[i];
			if (chamado.status == status) {
				mostrarChamado(chamado);
			}
		}
	}

	// 7-QTD chamaos  abertos
	// 8-QTD chamaos fechados
	public static int qtdChamaos(Chamado[] chamados, char status) {
		int acc=0;
		
		if (status == 'A') {
			System.out.println("Qtd chamados Abertos !");
		} else {
			System.out.println("Qtd chamados Fechados !");
		}
		
		for (int i = 0; i < chamados.length; i++) {
			Chamado chamado = chamados[i];
			if (chamado.status == status) {
				acc++;
			}
		}
		return acc;
	}

}
