package negocio;
import java.util.ArrayList;

public class Python extends Planetas {
	ArrayList<Orbita> posicoesOrbita;

	public Python(Plano plano) {
		super(1, "Python", 8, 7, plano, "P",4);

		posicoesOrbita = new ArrayList<>();

		super.mapear(posicoesOrbita, 7, 7, 3);
		super.resumo = "Python é uma linguagem de programação de alto nível conhecida por sua simplicidade e legibilidade.\nÉ amplamente utilizado em desenvolvimento web, análise de dados, aprendizado de máquina e automação.";
	}

	@Override
	public void avancar() {
		super.rotacao += 24*super.valor;
		
		super.contarGiro(posicoesOrbita, super.valor, super.velocidade, 8, "P", 1);
	}

}
