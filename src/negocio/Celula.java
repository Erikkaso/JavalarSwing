package negocio;
//import robo.Aluno;
//import robo.Bug;
//import robo.Robo;

import javax.swing.JLabel;

public class Celula {
	public int posicaoX;
	public int posicaoY;
	public int id;
	public String imagem;
	public JLabel label;
	public Planetas planeta;	
	public Desenvolvedor desenvolvedor;
	public Bug bug;
	
	public Celula(int id, int y , int x, JLabel label) {
		posicaoX = x;
		posicaoY = y;
		this.id = id;
		this.label = label;
		label.setHorizontalTextPosition(JLabel.CENTER);
		desenvolvedor = null;
		imagem = "";
		bug = null;
	}
}
