package negocio;
import java.util.ArrayList;

public class Php extends Planetas {
	ArrayList<Orbita> posicoesOrbita;

	public Php(Plano plano) {
		super(4, "PHP", 8, 4, plano, "Php",2);
		
		posicoesOrbita = new ArrayList<>();
		
		super.mapear(posicoesOrbita, 4, 4, 9);
		super.resumo = "PHP é uma linguagem de script amplamente utilizada em desenvolvimento web.\nÉ especialmente adequada para criar páginas web dinâmicas e interativas, pois pode ser incorporada diretamente em código HTML.";
	}

	@Override
	public void avancar() {
		super.rotacao += 60*super.valor;
		super.contarGiro(posicoesOrbita, super.valor, super.velocidade, 32, "Php", 4);
	}

}
