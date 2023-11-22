package negocio;
import java.util.ArrayList;

public class C extends Planetas{
	ArrayList<Orbita> posicoesOrbita;
	
	public C(Plano plano) {
		super(7, "C", 8, 1, plano, "C",10);
	
		posicoesOrbita = new ArrayList<>();
			
		super.mapear(posicoesOrbita, 1, 1, 15);
		super.resumo = "C é uma linguagem de programação de baixo nível que é amplamente usada para desenvolvimento de sistemas operacionais, drivers de hardware e programação embutida.\nEla é conhecida por sua eficiência e controle direto sobre o hardware.";
	}

	@Override
	public void avancar() {
		super.rotacao += 0.1*super.valor;
		super.contarGiro(posicoesOrbita, super.valor, super.velocidade, 56, "C", 7);		
	}

}
