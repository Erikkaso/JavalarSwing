package negocio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import persistencia.LerDados;
import view.PainelBotoes;

public class FuncaoBotoes implements ActionListener {
	private PainelBotoes central;
	private int aux = 0;
	private String diretorio;
	private ArrayList<DadosRelatorio> dadosObtidos;

	public FuncaoBotoes(PainelBotoes painel) {
		this.central = painel;
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == central.proxInstante) {

			try {
				for (int i = 0; i < central.dados.lista.get(aux).valores[7]; i++) {
					central.painelPlano.p.listaBug.add(new Bug(central.painelPlano.p));
				}
				for (int i = 0; i < central.dados.lista.get(aux).valores[8]; i++) {
					central.painelPlano.p.listaDesenvolvedor.add(new Desenvolvedor(central.painelPlano.p));
				}
				// if (aux < dados.lista.size()) {
				for (int i = 0; i < 7; i++) {
					central.painelPlano.p.listaPlanetas.get(i + 1).valor += central.dados.lista.get(aux).valores[i];
					central.painelPlano.p.listaPlanetas.get(i + 1).avancar();
				}

				// }
				aux++;
				// painelPlano.criarPlano();
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Nao ha arquivos para ser lidos.", "Aviso",
						JOptionPane.WARNING_MESSAGE);
			}

		}

		if (e.getSource() == central.lerArquivoDeEntrada) {
			try {
				Object[] opcoes = { "10", "50", "100", "500", "1000", "1500", "2000" };
				int opcaoSelecionada = JOptionPane.showOptionDialog(null, "Escolha qual arquivo deseja ler:", null,
						JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
				central.dados = new LerDados(opcaoSelecionada);
				diretorio = "" + central.dados.enviarDiretorio(opcaoSelecionada);
				aux = 0;
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

		else if (e.getSource() == central.gravarRelatorio) {
			DadosRelatorio dr = new DadosRelatorio("Pedro Eric Carneiro", 538121, diretorio, central.painelPlano.p);
	//		System.out.println(diretorio);
			dr.inserir(dr);
		}

		else if (e.getSource() == central.lerDadosParticipantes) {
			DadosRelatorio dr = new DadosRelatorio();
			dadosObtidos = dr.buscarTodosDados();
		} else if (e.getSource() == central.gravarArquivo) {
			DadosRelatorio dr = new DadosRelatorio();
			try {
				dr.enviarDados(dadosObtidos);
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Nao ha arquivos para ser salvo.", "Aviso",
						JOptionPane.WARNING_MESSAGE);
			}

		}

	}

}
