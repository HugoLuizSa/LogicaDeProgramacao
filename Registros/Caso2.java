package lista1;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Caso2 {

	// Prova
	static class Prova {
		String data;
		double nota;
	}

	static class Aluno {
		String nome;
		int idade;
		Prova[] provas = new Prova[3];
	}

	public static void main(String[] args) {

		Prova[] provas = new Prova[3];

		Aluno aluno = new Aluno();

		for (int i = 0; i < provas.length; i++) {
			Prova prova = new Prova();

			prova.nota = Double.parseDouble(JOptionPane.showInputDialog("informe a nota da prova :"));
			prova.data = JOptionPane.showInputDialog("Informe a data da prova:");

			provas[i] = prova;
		}

		// criar aluno
		aluno = CriarAluno("Hugo", provas);
		// usar o aluno para calcular a média
		System.out.println(mediaSimples(aluno));
	}

	// pega a lista de dentro do aluno para calcular a média
	public static double mediaSimples(Aluno a) {
		double somaNotas = 0;
		for (int i = 0; i < a.provas.length; i++) {
			somaNotas += a.provas[i].nota;
		}
		return somaNotas / a.provas.length;
	}

	public static Aluno CriarAluno(String nome, Prova[] provas) {
		Aluno aluno = new Aluno();
		aluno.nome = nome;
		aluno.provas = provas;
		return aluno;
	}

	public static Prova CriarProva(double nota, String dtRealizacao) {
		Prova prova = new Prova();

		prova.nota = nota;
		prova.data = dtRealizacao;

		return prova;
	}
}
