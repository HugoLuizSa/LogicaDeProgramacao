package lista;

public class Caso4 {

	public static void main(String[] args) {
		
		//simulacao do arquivo
		String cidades = "Pessoa 1-Tubarão/SC;Pessoa 2-Florianópolis/SC;Pessoa 3-São Paulo/SP;Pessoa 4-Osasco/SP;Pessoa 5-Porto Alegre/RS;Pessoa 6- Rio de Janeiro/RJ;Pessoa 7-São Paulo/SPPessoa 8-Florianópolis/SC;Pessoa 9- Rio de Janeiro/RJ;Pessoa 10-Tubarão/SC";
		
		
		//formato de saída
		//Nome: Pessoa 1. Mora em: Tubarão/SC;
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
