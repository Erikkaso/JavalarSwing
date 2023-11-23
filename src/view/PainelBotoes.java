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
}
