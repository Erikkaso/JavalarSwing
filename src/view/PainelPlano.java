package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import negocio.Plano;

public class PainelPlano extends JPanel {
	public Plano p;
	
	public PainelPlano(Plano plano) {
		this.p = plano;
		criarPlano();
	  this.setBackground(Color.LIGHT_GRAY);
	}

	public void criarPlano() {		
		this.setLayout(new GridLayout(15,15));
		for(int i=0; i<p.listaCelulas.size();i++) {
			this.add(p.listaCelulas.get(i).label);
		}
		
	}
}
