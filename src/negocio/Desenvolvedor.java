package negocio;

import java.awt.Color;
import java.util.Random;
import javax.swing.ImageIcon;

public class Desenvolvedor {

	public int posicaox;
	public int posicaoy;
	public Plano plano;
	public ImageIcon icone;

	Random gerador = new Random();

	public Desenvolvedor(Plano plano) {
		this.posicaox = gerador.nextInt(15) + 1;

		this.posicaoy = gerador.nextInt(15) + 1;

		this.plano = plano;
		this.icone = new ImageIcon("imagens/dev.png");

		Celula aux = null;
		for (int i = 0; i < plano.listaCelulas.size(); i++) {
			aux = plano.listaCelulas.get(i);
			if (aux.posicaoX == this.posicaox && aux.posicaoY == this.posicaoy && aux.planeta == null) {
				while (aux.bug != null && aux.desenvolvedor != null && aux.planeta != null) {
					this.posicaox = gerador.nextInt(15) + 1;
					this.posicaoy = gerador.nextInt(15) + 1;
				}
				plano.listaCelulas.get(i).desenvolvedor = this;
				plano.listaCelulas.get(i).icone = this.icone;
				plano.listaCelulas.get(i).label.setIcon(plano.listaCelulas.get(i).icone);
				plano.listaCelulas.get(i).label.setForeground(Color.green);
			}
		}
	}
}
