package lista;

public class Caso4 {

	public static void main(String[] args) {
		
		//simulacao do arquivo
		String cidades = "Pessoa 1-Tubar�o/SC;Pessoa 2-Florian�polis/SC;Pessoa 3-S�o Paulo/SP;Pessoa 4-Osasco/SP;Pessoa 5-Porto Alegre/RS;Pessoa 6- Rio de Janeiro/RJ;Pessoa 7-S�o Paulo/SPPessoa 8-Florian�polis/SC;Pessoa 9- Rio de Janeiro/RJ;Pessoa 10-Tubar�o/SC";
		
		
		//formato de sa�da
		//Nome: Pessoa 1. Mora em: Tubar�o/SC;
		String[] cidadesToArray = quebraPorCaractere(cidades,";");
		
		for (int i = 0; i < cidadesToArray.length; i++) {
			String [] informacoes= quebraPorCaractere(cidadesToArray[i],"-");
			System.out.println("Nome: "+informacoes[0]+". Mora em : "+informacoes[1]);
		}
	}
	
	public static String[] quebraPorCaractere(String cidades,String separador) {
		String [] cidadesToArray= cidades.split(separador);
		return cidadesToArray;
	}
	
}
