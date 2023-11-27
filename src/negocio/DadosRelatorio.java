package negocio;

import java.util.ArrayList;
import java.util.Arrays;

import persistencia.Escrever;
import persistencia.RelatorioDAO;

public class DadosRelatorio {
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getNome_arquivo() {
		return nome_arquivo;
	}

	public void setNome_arquivo(String nome_arquivo) {
		this.nome_arquivo = nome_arquivo;
	}

	private String nome;
	private int matricula;
	private String nome_arquivo;
	public ArrayList<Planetas> planets;
	private RelatorioDAO relatorioDAO;
	public Plano plano;
	public String[] infos;

	public DadosRelatorio(String nome, int matricula, String nome_arquivo, Plano p) {
		relatorioDAO = new RelatorioDAO();
		this.nome = nome;
		this.matricula = matricula;
		this.nome_arquivo = nome_arquivo;
		this.plano = p;
		this.planets = p.listaPlanetas;
	}

	public DadosRelatorio(String nome, int matricula, String nome_arquivo, String infos[]) {
		relatorioDAO = new RelatorioDAO();
		this.nome = nome;
		this.matricula = matricula;
		this.nome_arquivo = nome_arquivo;
		this.infos = infos;

	}

	public DadosRelatorio() {
		relatorioDAO = new RelatorioDAO();
	}

	public ArrayList<DadosRelatorio> buscarTodosDados() {
		ArrayList<DadosRelatorio> listaDados = relatorioDAO.selecionarTodosDadosRelatorios();
		return listaDados;
	}

	public void inserir(DadosRelatorio a) {
		relatorioDAO.inserir(a);
	}

	public void enviarDados(ArrayList<DadosRelatorio> listaDados) {
		Escrever e = new Escrever();
		ArrayList<String> nomes = new ArrayList<>();
		nomes.add(listaDados.get(0).getNome());
		String[] planetas = { "Python", "Javascript", "Ruby", "Php", "C#", "C++", "C" };
		String planetaMaisViveu = "";
		String nomeMaisRepetido = "";
		int matriculaRelacionada = 0;
		int horastotais = 0;
		int anostotais = 0;
		int indiceMaiorValor = 0;
		int[] bugSom = new int[4];
		int[] devSom = new int[4];
		int[] velocidadeMediaPlanetas = new int[7];
		int[] contExplosao = new int[7];// explosoes que ocorreram em cada planeta

		////////// ********* 1 ********//////////////////
		for (DadosRelatorio dadosRelatorio : listaDados) {// recebendo os nomes
			if (nomes.contains(dadosRelatorio.getNome()) == false) {
				nomes.add(dadosRelatorio.getNome());
			}

			for (int i = 0; i < 7; i++) {// 14 21 -> indice da velocidade dos planetas
				if (Integer.parseInt(dadosRelatorio.infos[i + 14]) == 0) {
					contExplosao[i]++;
				}

				velocidadeMediaPlanetas[i] += Integer.parseInt(dadosRelatorio.infos[i + 14]); // obter velocidade media
																								// de cada planeta

				horastotais += Integer.parseInt(dadosRelatorio.infos[i + 21]);// 10 - horas totais dos planetas
				anostotais += Integer.parseInt(dadosRelatorio.infos[i + 28]);// 11 - anos totais dos planetas
			}

			int maiorValor = Integer.parseInt(dadosRelatorio.infos[14]);// valor inicial de vida

			for (int i = 14; i < 21; i++) {
				if (Integer.parseInt(dadosRelatorio.infos[i]) > maiorValor) {// olhando qual planeta tem mais vida
					maiorValor = Integer.parseInt(dadosRelatorio.infos[i]);
					indiceMaiorValor = i;
				}
			}
			planetaMaisViveu = planetas[encontrarIndiceMaiorValor(contExplosao)];
//////////////////////////////////////////////////////////////////////////////4;5///////////////////////////

			for (int i = 35; i < 43; i++) {
				if (i < 39)
					bugSom[i - 35] += Integer.parseInt(dadosRelatorio.infos[i]);

				else
					devSom[i - 39] += Integer.parseInt(dadosRelatorio.infos[i]);
			}

		}
		int maxContagem = 0;

		for (String nomeUnico : nomes) {/// olhar nome mais frequente
			int contagem = contarOcorrencias(nomeUnico, listaDados);

			if (contagem > maxContagem) {
				maxContagem = contagem;
				nomeMaisRepetido = nomeUnico;
			}
		}

		for (DadosRelatorio dadosRelatorio : listaDados) {// procurando a matricula
			if (nomeMaisRepetido.equals(dadosRelatorio.getNome()) == true)
				matriculaRelacionada = dadosRelatorio.getMatricula();
		}

		String vel = "";
		for (int i = 0; i < 7; i++) {
			if (i < 6)
				vel += planetas[i] + ": " + (velocidadeMediaPlanetas[i] / listaDados.size()) + " - ";
			else
				vel += planetas[i] + ": " + (velocidadeMediaPlanetas[i] / listaDados.size());
		}

		e.escreverDados("dados/RelatorioFinal.txt",
				matriculaRelacionada + " - " + nomeMaisRepetido + ", " + planetas[indiceMaiorValor - 14] + ", "
						+ planetaMaisViveu + ", " + (encontrarIndiceMaiorValor(bugSom) + 1) + ", "
						+ (encontrarIndiceMaiorValor(devSom) + 1) + ", " + listaDados.size() + ", " + vel + ", "
						+ Arrays.stream(bugSom).sum() + ", " + Arrays.stream(devSom).sum() + ", " + horastotais + ", "
						+ anostotais + "\n\n");
	}

	private static int contarOcorrencias(String nome, ArrayList<DadosRelatorio> listaDados) {
		int contagem = 0;
		for (DadosRelatorio elemento : listaDados) {
			if (nome.equals(elemento.getNome())) {
				contagem++;
			}
		}
		return contagem;
	}

	private static int encontrarIndiceMaiorValor(int[] x) {
		int indiceMaiorValor = 0;
		int maiorValor = x[0];

		for (int i = 1; i < x.length; i++) {
			if (x[i] > maiorValor) {
				maiorValor = x[i];
				indiceMaiorValor = i;
			}
		}

		return indiceMaiorValor;
	}
}
