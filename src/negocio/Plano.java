package negocio;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class Plano {
	public ArrayList<Celula> listaCelulas;
	public ArrayList<Planetas> listaPlanetas = new ArrayList<>();
	public ArrayList<Bug> listaBug = new ArrayList<>();
//	int quantidadeBugs;
	public ArrayList<Desenvolvedor> listaDesenvolvedor = new ArrayList<>();
//	int quantidadeDesenvolvedores;
	public int[] bugQ;
	public int[] devQ;

	public Plano() {
		bugQ = new int[4];
		devQ = new int[4];
		Border borda = BorderFactory.createLineBorder(Color.black, 1);
		listaCelulas = new ArrayList<Celula>();

		int contador = 1;
		for (int i = 1; i <= 15; i++) {
			for (int j = 1; j <= 15; j++) {
				JLabel celulaLabel = new JLabel();
				// celulaLabel.setForeground(Color.BLUE);////****
				celulaLabel.setPreferredSize(new Dimension(40, 40));
				celulaLabel.setHorizontalAlignment(JLabel.CENTER);
				celulaLabel.setBorder(borda);

				Celula celula = new Celula(contador, i, j, celulaLabel);
				listaCelulas.add(celula);
				contador++;
			}
		}
		listaPlanetas.add(new Java(this));
		listaPlanetas.add(new Python(this));
		listaPlanetas.add(new JavaScript(this));
		listaPlanetas.add(new RubyOnRails(this));
		listaPlanetas.add(new Php(this));
		listaPlanetas.add(new CSharp(this));
		listaPlanetas.add(new CPlus(this));
		listaPlanetas.add(new C(this));
	}
	
	public void separarQuadrantes() {
		for (Bug bug : listaBug) {
			if(bug.posicaox < 8 && bug.posicaoy < 8)
				bugQ[0]++;
			
			if(bug.posicaox > 8 && bug.posicaoy < 8)
				bugQ[1]++;
			
			if(bug.posicaox < 8 && bug.posicaoy > 8)
				bugQ[2]++;
			
			if(bug.posicaox > 8 && bug.posicaoy > 8)
				bugQ[3]++;
		}
		
		for (Desenvolvedor dev : listaDesenvolvedor) {
			if(dev.posicaox < 8 && dev.posicaoy < 8)
				devQ[0]++;
			
			if(dev.posicaox > 8 && dev.posicaoy < 8)
				devQ[1]++;
			
			if(dev.posicaox < 8 && dev.posicaoy > 8)
				devQ[2]++;
			
			if(dev.posicaox > 8 && dev.posicaoy > 8)
				devQ[3]++;
		}
	}
}
