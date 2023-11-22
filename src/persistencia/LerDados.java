package persistencia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import negocio.Dados;

public class LerDados {

	 public ArrayList<Dados> lista;
	 private ArrayList<String> diretorio;
	 private int opcao;

	public LerDados(int opcao) {
		this.opcao = opcao;
		 lista = new ArrayList<Dados>();
		 diretorio = new ArrayList<>();
		 diretorio.add("dados/AE_10.csv");
		 diretorio.add("dados/AE_50.csv");
		 diretorio.add("dados/AE_100.csv");
		 diretorio.add("dados/AE_500.csv");
		 diretorio.add("dados/AE_1000.csv");
		 diretorio.add("dados/AE_1500.csv");
		 diretorio.add("dados/AE_2000.csv");
		 
		lerOsDados();
	}

	public void lerOsDados() {
		try (BufferedReader leitura = new BufferedReader(new FileReader(diretorio.get(opcao)))) {
			String linha = leitura.readLine();
			while (linha!= null) {
				 lista.add(separarDados(leitura.readLine()));
			}

		} catch (Exception e) {
			//System.out.println(e.getMessage());
		}
	}

	private Dados separarDados(String linha) {
		
		String dados[] = linha.split(",");
		Dados d = new Dados();
		for(int i=0;i<9;i++) {
			d.valores[i] = Integer.parseInt(dados[i+1]); 
		}
		return d;
	}
	
	public String enviarDiretorio(int opcao) {
		return diretorio.get(opcao);
	}
}
