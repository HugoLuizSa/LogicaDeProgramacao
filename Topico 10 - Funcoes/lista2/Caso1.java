package lista2;

import javax.swing.JOptionPane;

public class Caso1 {

	public static void main(String[] args) {

		/**
		 * 1. Escreva um programa que leia as medidas dos lados de um triângulo e
		 * retorne se ele é: Equilátero, Isósceles ou Escaleno. Os tamanhos dos lados
		 * devem ser passados por parâmetro e a função deve retornar o tipo de
		 * triângulo. Regras: 
		 * ● Triângulo Equilátero: possui os 3 lados iguais. 
		 * ● Triângulo Isóscele: possui 2 lados iguais. 
		 * ● Triângulo Escaleno: possui 3
		 * lados diferentes.
		 */

		double ladoA = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor do lado A do triangulo :"));
		double ladoB = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor do lado B do triangulo :"));
		double ladoC = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor do lado C do triangulo :"));
	
		System.out.println("O seu triangulo é do tipo : "+tipoTriangulo(ladoA, ladoB, ladoC));
	
	}
	// funcoes

	private static String tipoTriangulo(double a, double b, double c) {
		if (a == b && c == b) {
			return "Equilátero";
		} else if (a == b || c == b) {
			return "Isóscele";
		} else {
			return "Escaleno";
		}
	}

}
