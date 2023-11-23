package persistencia;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import negocio.DadosRelatorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RelatorioDAO {

	public ArrayList<DadosRelatorio> selecionarTodosDadosRelatorios() {
		ArrayList<DadosRelatorio> dadosRelatorios = new ArrayList<DadosRelatorio>();
		String indices[] = enviarReport().split(", ");
		String [] informacoes = new String[indices.length];
		
		try {
			Connection conexao = new Conexao().getConexao();

			String query = "select * from javalar order by id desc";
			ResultSet dados = conexao.prepareStatement(query).executeQuery();

			while (dados.next()) {
				String nome = dados.getString("nome");
				int matricula = dados.getInt("matricula");
				String nome_arquivo	= dados.getString("nome_arquivo");
				
				for(int i=0;i<indices.length-1;i++) {
				informacoes[i] = dados.getString(indices[i]);
				}
				informacoes[indices.length-1] = dados.getString("dev_q4");

				DadosRelatorio dr = new DadosRelatorio(nome, matricula, nome_arquivo, informacoes);
				dadosRelatorios.add(dr);
			}
			conexao.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dadosRelatorios;
	}

	public void inserir(DadosRelatorio dr) {
//		String test = "insert into javalar (nome, matricula, nome_arquivo";
//		test += enviarReport() + ") values";

		try {
			String interString = "(";
			for (int i = 1; i <= 46; i++) {
				if (i < 46)
					interString += "?,";
				else
					interString += "?)";
			}

//			test += interString;

			Connection conexao = new Conexao().getConexao();

			PreparedStatement inserir = conexao.prepareStatement("insert into javalar (nome, matricula, nome_arquivo, " + enviarReport() + ") values" + interString);
			inserir.setString(1, dr.getNome());
			inserir.setInt(2, dr.getMatricula());
			inserir.setString(3, dr.getNome_arquivo());
			
			int auxt = 4;
			for (int j = 1; j <= 7; j++) {
				inserir.setInt(auxt, dr.planets.get(j).colisaoBugs);
				auxt++;
			}

			for (int j = 1; j <= 7; j++) {
				inserir.setInt(auxt, dr.planets.get(j).colisaoDevs);
				auxt++;
			}

			for (int j = 1; j <= 7; j++) {
				inserir.setInt(auxt, dr.planets.get(j).velocidade);
				auxt++;
			}

			for (int j = 1; j <= 7; j++) {
				inserir.setInt(auxt, (int) dr.planets.get(j).rotacao);
				auxt++;
			}

			for (int j = 1; j <= 7; j++) {
				inserir.setInt(auxt, dr.planets.get(j).anos);
				auxt++;
			}

			dr.plano.separarQuadrantes();

			for (int j = 0; j < 4; j++) {
				inserir.setInt(auxt, dr.plano.bugQ[j]);
				auxt++;
			}

			for (int j = 0; j < 4; j++) {
				inserir.setInt(auxt, dr.plano.devQ[j]);
				auxt++;
			}
			 inserir.executeUpdate();

			conexao.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Nao ha arquivos para ser lidos.", "Aviso",JOptionPane.WARNING_MESSAGE);
		//	 e.printStackTrace();
		}
	}

	private String enviarReport() {
		String[] nomePlanetas = new String[7];
		nomePlanetas[0] = "python";
		nomePlanetas[1] = "javascript";
		nomePlanetas[2] = "ruby";
		nomePlanetas[3] = "php";
		nomePlanetas[4] = "csharp";
		nomePlanetas[5] = "cmais";
		nomePlanetas[6] = "c";

		String[] nomeAux = new String[5];
		nomeAux[0] = "bug_";
		nomeAux[1] = "dev_";
		nomeAux[2] = "v_";
		nomeAux[3] = "d_";
		nomeAux[4] = "a_";

		String reportString = "";
		for (int i = 0; i < nomeAux.length; i++) {
			for (int j = 0; j < nomePlanetas.length; j++) {
				reportString += nomeAux[i] + nomePlanetas[j] + ", ";
			}
		}
		for (int i = 0; i < 2; i++) {
			for (int j = 1; j <= 4; j++) {

				reportString += nomeAux[i] + "q" + j;

				if (i == 1 && j == 4)
					reportString += " ";
				else
					reportString += ", ";
			}
		}
		return reportString;
	}
}
