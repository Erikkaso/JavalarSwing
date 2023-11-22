package negocio;

import java.awt.Color;
import java.util.Random;

public class Bug {

	public int posicaox;
	public int posicaoy;
	public Plano plano;
	public String imagem;

	Random gerador = new Random();

	public Bug(Plano plano) {
		this.posicaox = gerador.nextInt(15) + 1;

		this.posicaoy = gerador.nextInt(15) + 1;

		this.plano = plano;
		this.imagem = "B";

		Celula aux = null;
		for (int i = 0; i < plano.listaCelulas.size(); i++) {
			aux = plano.listaCelulas.get(i);
			if (aux.posicaoX == this.posicaox && aux.posicaoY == this.posicaoy && aux.planeta == null) {
				while (aux.bug != null && aux.desenvolvedor != null && aux.planeta != null) {
					this.posicaox = gerador.nextInt(15) + 1;
					this.posicaoy = gerador.nextInt(15) + 1;
				}
				plano.listaCelulas.get(i).bug = this;
				plano.listaCelulas.get(i).imagem = this.imagem;
				plano.listaCelulas.get(i).label.setText(plano.listaCelulas.get(i).imagem);
				plano.listaCelulas.get(i).label.setForeground(Color.red);
			}
		}
	}
}
