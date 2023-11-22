package negocio;
import java.awt.Color;
import java.util.ArrayList;


public abstract class Planetas implements Movimento {

	private int id;
	public String nome;
	public int posicaox;
	public int posicaoy;
	public Plano plano;
	private String imagem;
	public float rotacao;
	public int anos;
	public int velocidade;
	public String resumo;
	public Boolean explodiu;
	public int valor;
	public int colisaoBugs;
	public int colisaoDevs;

	public Planetas(int id, String nome, int posicaox, int posicaoy, Plano plano, String imagem, int velocidade) {
		this.id = id;
		this.nome = nome;
		this.posicaox = posicaox;
		this.posicaoy = posicaoy;
		this.plano = plano;
		this.imagem = imagem;
		this.velocidade = velocidade;
		this.valor=0;
		this.colisaoDevs = 0;
		this.colisaoBugs = 0;

		for (int i = 0; i < plano.listaCelulas.size(); i++) {
			Celula aux = plano.listaCelulas.get(i);
			if (aux.posicaoX == posicaox && aux.posicaoY == posicaoy) {
				plano.listaCelulas.get(i).planeta = this;
				plano.listaCelulas.get(i).imagem = this.imagem;
				plano.listaCelulas.get(i).label.setText(plano.listaCelulas.get(i).imagem);
				plano.listaCelulas.get(i).label.setForeground(Color.blue);
			}
		}
	}

	public void mapear(ArrayList<Orbita> posicoesOrbita, int x, int y, int tamY) {

		for (int i = 0; i < ((tamY - 1) / 2); i++) {
			int xx = 8;
			int yy = y;
			xx -= i;
			posicoesOrbita.add(new Orbita(xx, yy));
		}

		for (int i = 0; i < tamY; i++) {
			int xx = x;
			int yy = y;
			yy += i;
			posicoesOrbita.add(new Orbita(xx, yy));
		}

		for (int i = 0; i < tamY - 2; i++) {
			int xx = (x + 1);
			int yy = (y + tamY - 2 + 1);
			xx += i;
			posicoesOrbita.add(new Orbita(xx, yy));
		}

		for (int i = 0; i < tamY - 1; i++) {
			int xx = (x + tamY - 2 + 1);
			int yy = (y + tamY - 2 + 1);
			yy -= i;
			posicoesOrbita.add(new Orbita(xx, yy));
		}

		for (int i = 0; i < ((tamY - 1) / 2); i++) {
			int xx = 8 + ((tamY - 1) / 2);
			int yy = y;
			xx -= i;
			posicoesOrbita.add(new Orbita(xx, yy));
		}
	}

	public void contarGiro(ArrayList<Orbita> posicoesOrbita, int avanco, int unidade, int limite, String img, int id) {
		int movimento = 0;
//		if (avanco == 0)
//			avanco = 1;
		movimento += unidade * avanco;

		while (movimento >= limite) {
			movimento -= limite;
			this.anos++;
		}

		movimentar(id, img, posicoesOrbita.get(movimento).x, posicoesOrbita.get(movimento).y);

	}

	public void movimentar(int id, String imagem, int x, int y) {
		if (velocidade > 0) {
			for (int i = 0; i < plano.listaCelulas.size(); i++) {
				if (plano.listaCelulas.get(i).planeta != null && plano.listaCelulas.get(i).planeta.id == id) {
					plano.listaCelulas.get(i).planeta = null;
					plano.listaCelulas.get(i).imagem = "";
					plano.listaCelulas.get(i).label.setText(plano.listaCelulas.get(i).imagem);		
				}

				if (plano.listaCelulas.get(i).posicaoX == x && plano.listaCelulas.get(i).posicaoY == y) {
					posicaox = plano.listaCelulas.get(i).posicaoX;
					posicaoy = plano.listaCelulas.get(i).posicaoY;

					plano.listaCelulas.get(i).planeta = this;
					plano.listaCelulas.get(i).imagem = imagem;
					plano.listaCelulas.get(i).label.setText(plano.listaCelulas.get(i).imagem);
					plano.listaCelulas.get(i).label.setForeground(Color.blue);

					colisaoDesenvolvedorBug(plano.listaCelulas.get(i), posicaox, posicaoy);

//					System.out.println("a velocidade do planeta " + this.nome + " eh:" + this.velocidade
//							+ " se passaram " + this.rotacao + " horas e " + this.anos + " ano(s)");
				}
			}
		}
	}

	public void colisaoDesenvolvedorBug(Celula aux, int x, int y) {
		if (aux.desenvolvedor != null && aux.desenvolvedor.posicaox == x && aux.desenvolvedor.posicaoy == y) {
			this.velocidade++;
			aux.desenvolvedor.imagem = "-";
			aux.desenvolvedor = null;
	//		plano.quantidadeDesenvolvedores--;
			plano.listaDesenvolvedor.remove(aux.desenvolvedor);
			this.colisaoDevs++;
			System.out.println("\u001B[32m" + aux.planeta.nome + " foi aprimorado!!" + "\u001B[0m");
		}

		if (aux.bug != null && aux.bug.posicaox == x && aux.bug.posicaoy == y) {
			this.velocidade--;
			aux.bug.imagem = "-";
			aux.bug = null;
	//		plano.quantidadeBugs--;
			plano.listaBug.remove(aux.bug);
			this.colisaoBugs++;
			System.out.println("\u001B[31m" + aux.planeta.nome + " foi atacado!!" + "\u001B[0m");
		}
		
		if (this.velocidade == 0) {
			aux.planeta = null;
			aux.imagem = "-";
		}
	}
}
