package negocio;
import java.util.ArrayList;

public class CSharp extends Planetas {
	ArrayList<Orbita> posicoesOrbita;

	public CSharp(Plano plano) {
		super(5, "C#", 8, 3, plano, "C#",1);

		posicoesOrbita = new ArrayList<>();
		
		super.mapear(posicoesOrbita, 3, 3, 11);
		super.resumo = "C# (C Sharp) é uma linguagem de programação desenvolvida pela Microsoft.\nÉ comumente usada para desenvolvimento de software Windows, jogos com Unity e aplicativos corporativos.";
	}

	@Override
	public void avancar() {
		super.rotacao += 4*super.valor;
		super.contarGiro(posicoesOrbita, super.valor, super.velocidade, 40, "C#", 5);
	}

}
