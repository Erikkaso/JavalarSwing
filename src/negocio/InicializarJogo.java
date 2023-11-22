package negocio;
import java.util.ArrayList;
import java.util.Scanner;

import persistencia.Conexao;
import view.JPrincipal;

public class InicializarJogo {


	public InicializarJogo() {

		new JPrincipal();
		new Conexao();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		while (ligado == true) {
//			
//			System.out.println("Informe a quantidade de Desenvolvedores:");
//			aux = input.nextInt();
//			p.quantidadeDesenvolvedores += aux;
//			for (int i = 0; i < aux; i++) {
//				p.listaDesenvolvedor.add(new Desenvolvedor(i, p));
//			}
//
//			System.out.println("Informe a quantidade de Bugs:");
//			aux = input.nextInt();
//			p.quantidadeBugs += aux;
//			for (int i = 0; i < aux; i++) {
//				p.listaBug.add(new Bug(i, p));
//			}
//			
//			System.out.println("\u001B[36m\t\t\t\t-=Instante "+instantes +"=-\u001B[0m");
//			System.out.println("Bem Vindo ao Observatorio do JavaLar, defina em qual momento deseja tirar uma foto");
//			aux = input.nextInt();
//			for (Planetas planets : planetas) {
//				planets.avancar(aux);
//			}
//			//////// relatorio
//
//			System.out.println("\n\nExistem: " + p.quantidadeDesenvolvedores
//					+ " Desenvolvedores no total\n\t\tPosicao dos Desenvolvedores");
//			for (Desenvolvedor desenvolvedor : p.listaDesenvolvedor) {
//				if (desenvolvedor != null) {
//					System.out.println("\t\t\tX: " + desenvolvedor.posicaox + " Y: " + desenvolvedor.posicaoy);
//				}
//			}
//
//			System.out.println("\n\nExistem: " + p.quantidadeBugs + " Bugs no total\n\t\tPosicao dos Bugs");
//			for (Bug bug : p.listaBug) {
//				if (bug != null) {
//					System.out.println("\t\t\tX: " + bug.posicaox + " Y: " + bug.posicaoy);
//				}
//			}
//
//			for (Planetas planetas2 : planetas) {
//				if (planetas2.posicaoy < 8)
//					System.out.println(planetas2.nome + " esta ao NORTE");
//
//				if (planetas2.posicaoy > 8)
//					System.out.println(planetas2.nome + " esta ao SUL");
//			}
//
//			p.criarGrade();
//			/////
//			System.out.println(
//					"Aperte 's' se deseja sair, caso queira ver mais um instante, aperte qualquer outra tecla.");
//			char aux2 = input.next().charAt(0);
//			if (aux2 == 's')
//				ligado = false;
//			else
//				instantes++;
//		}
//
//		System.out.println("\u001B[33m\t\t\t\t--==RELATORIO FINAL==--\u001B[0m");
//
//		for (int i = 1; i < planetas.size(); i++) {
//			float divisor = (float) (Math.pow(1 + i * 2, 2) - Math.pow(-1 + i * 2, 2));
//
//			System.out.println("Nome: " + planetas.get(i).nome + " - Rotacao: " + planetas.get(i).rotacao
//					+ " - Translacao: " + planetas.get(i).velocidade / divisor + " - se passaram "
//					+ planetas.get(i).rotacao + " horas e " + planetas.get(i).anos + " ano(s)" + "\n \t\tRESUMO:\n"
//					+ planetas.get(i).resumo + "\n");
//
//			if (planetas.get(i).velocidade <= 0) {
//				System.out.println("O planeta " + planetas.get(i).nome + " explodiu");
//				aux = -1;
//			} else if (i==7 && aux != -1)
//				System.out.println("Nenhum planeta explodiu");
//		}
//		System.out.println("Foram pedidos " + instantes + " instantes");
	}
}
