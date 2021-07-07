package lista1;

public class Caso3 {

	
	static class Pessoa{
		String nome,telefone;
		int dia,mes;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Pessoa[] pessoas = new Pessoa[3];
		
		Pessoa p1= new Pessoa();
		Pessoa p2= new Pessoa();
		Pessoa p3= new Pessoa();

		p1 = criarPessoa("Hugo", "9999-9999", 23, 9);
		p2 = criarPessoa("Roberto", "9999-8888", 14, 7);
		p3 = criarPessoa("Ligia", "9999-7777", 27, 3);
				
		pessoas[0]=p1;
		pessoas[1]=p2;
		pessoas[2]=p3;
		
		verificarAniversariantes(pessoas, 3);
	}

	public static Pessoa criarPessoa(String nome,String telefone,int dia , int mes) {
		Pessoa pessoa = new Pessoa();
		pessoa.nome=nome;
		pessoa.telefone=telefone;
		pessoa.dia=dia;
		pessoa.mes=mes;
		return pessoa;
	}

	public static void aniversariante(Pessoa p , int mes) {
		if(p.mes==mes) {
			System.out.println("Nome: "+p.nome
					+"\n telefone: "+p.telefone
					+"\n dia: "+p.dia
					+"\n mes: "+p.mes);
		}
	}
	
	public static void verificarAniversariantes(Pessoa [] pessoas,int mesFiltrado) {
		for (int i = 0; i < pessoas.length; i++) {
			aniversariante(pessoas[i], mesFiltrado);
		}
	}
	
}
