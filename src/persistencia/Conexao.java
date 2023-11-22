package persistencia;

import java.sql.*;

import java.sql.*;

public class Conexao {
	private String host;
	private String usuario;
	private String senha;
	private String banco;

	public Conexao() {

		this.host = "da_java.mysql.dbaas.com.br";//"127.0.0.1"; // localhost
		this.banco = "da_java";//"teste_bd";
		this.usuario = "da_java";//"root";
		this.senha = "Tecnicas*2023@";//"";
	}

	public Connection getConexao() {
		//String url="jdbc:mysql://" + this.host + "/" + this.banco +"?verifyServerCertificate=false&useSSL=true";
		String url="jdbc:mysql://" + this.host + ":3306/" + this.banco + "?enabledTLSProtocols=TLSv1.2&verifyServerCertificate=false&useSSL=true";
		try {
			System.out.println("conectando");
			return DriverManager.getConnection(url, usuario, senha);
		} catch (SQLException ex) {
			System.out.println("Conex�o com MYSQL n�o realizada");
			ex.printStackTrace();
		}
		return null;
	}

}