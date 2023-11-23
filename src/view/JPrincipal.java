package view;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import negocio.Plano;


public class JPrincipal extends JFrame {

	private PainelPlano painelPlano;
	private Plano plano;

	public JPrincipal() {
		Plano plano = new Plano();
		painelPlano = new PainelPlano(plano);

		PainelBotoes painelBotoes = new PainelBotoes(painelPlano);

		this.setTitle("Sistema Javalar");
		this.setSize(900, 800);
		this.setBackground(Color.LIGHT_GRAY);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		painelPlano.setVisible(true);

		JPanel painelGenerico = new JPanel();

		painelGenerico.add(painelPlano);
		painelGenerico.add(painelBotoes);

		this.add(painelGenerico, BorderLayout.CENTER);
		this.setVisible(true);
	}

}
