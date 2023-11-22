package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import negocio.Bug;
import negocio.Desenvolvedor;
import negocio.Plano;
import negocio.FuncaoBotoes;
import persistencia.LerDados;

public class PainelBotoes extends JPanel {

	
	public Botao proxInstante;
	public Botao lerArquivoDeEntrada;
	public Botao gravarRelatorio;
	public Botao lerDadosParticipantes;
	public Botao gravarArquivo;
	public PainelPlano painelPlano;
	public LerDados dados;
	FuncaoBotoes fb = new FuncaoBotoes(this);
	
	public PainelBotoes(PainelPlano p) {
		this.painelPlano = p;
		criarBotoes();
		this.setBackground(Color.ORANGE);
		
	}

	private void criarBotoes() {
		proxInstante = new Botao("Processar Proximo Instante", Color.gray);
		//proxInstante.addActionListener(this);
		proxInstante.addActionListener(fb);

		lerArquivoDeEntrada = new Botao("Ler Novo Arquivo de Entrada", Color.gray);
		lerArquivoDeEntrada.addActionListener(fb);
		
		gravarRelatorio = new Botao("Gravar Relatorio", Color.gray);
		gravarRelatorio.addActionListener(fb);
		
		lerDadosParticipantes = new Botao("Ler Dados de Outros Participantes", Color.gray);
		lerDadosParticipantes.addActionListener(fb);

		gravarArquivo = new Botao("Gravar Arquivo de Saida", Color.gray);
		gravarArquivo.addActionListener(fb);

		this.setLayout(new GridLayout(5, 1));
		this.add(proxInstante);
		this.add(lerArquivoDeEntrada);
		this.add(gravarRelatorio);
		this.add(lerDadosParticipantes);
		this.add(gravarArquivo);

	}

//	@Override
//	public void actionPerformed(ActionEvent e) {
//
//		if (e.getSource() == proxInstante) {
//
//			try {
//				for (int i = 0; i < dados.lista.get(aux).valores[7]; i++) {
//					painelPlano.p.listaBug.add(new Bug(painelPlano.p));
//				}
//				for (int i = 0; i < dados.lista.get(aux).valores[8]; i++) {
//					painelPlano.p.listaDesenvolvedor.add(new Desenvolvedor(painelPlano.p));
//				}
//				// if (aux < dados.lista.size()) {
//				for (int i = 0; i < 7; i++) {
//					painelPlano.p.listaPlanetas.get(i + 1).valor += dados.lista.get(aux).valores[i];
//					painelPlano.p.listaPlanetas.get(i + 1).avancar();
//				}
//
//				// }
//				aux++;
//			//	painelPlano.criarPlano();
//			} catch (Exception e2) {
//				JOptionPane.showMessageDialog(null, "Nao ha arquivos para ser lidos.", "Aviso",
//						JOptionPane.WARNING_MESSAGE);
//			}
//
//		}
//
//		if (e.getSource() == lerArquivoDeEntrada) {
//			Object[] opcoes = { "10", "50", "100", "500", "1000", "1500", "2000" };
//			int opcaoSelecionada = JOptionPane.showOptionDialog(null, "Escolha qual arquivo deseja ler:", null,
//					JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
//			dados = new LerDados(opcaoSelecionada);
//			aux = 0;
//		}
//
//		else if (e.getSource() == gravarRelatorio) {
//			
//
//		} 
//		else if (e.getSource() == lerDadosParticipantes) {
//
//		} else if (e.getSource() == gravarArquivo) {
//
//		}
//
//	}
}
