package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class JDBC {
		public static void main(String[] args) {
			String url = "jdbc:postgresql://localhost:5432/postgres";
			String usuario = "postgres";
			String senha = "Planet82";
			try {
				Connection conexao = DriverManager.getConnection(url,usuario,senha);
			if (conexao != null) {
				System.out.println("Conexao bem-sucedida!");
				
			} else {
				System.out.println("Falha na conexao.");
			}
			
			Statement statement = conexao.createStatement();
			String consultaSQL = "SELECT * FROM produto";
			ResultSet resultado = statement.executeQuery(consultaSQL);
			while (resultado.next()) {
			int id = resultado.getInt("id");
			String nome = resultado.getString("nome");
			double preco = resultado.getDouble("preco");
			System.out.println("ID: " + id + ", Nome: " + nome + ", Preço: " + preco );
			}
			resultado.close();
			statement.close();
			conexao.close();
			
		} catch (SQLException e) { 
			System.out.println("Erro na conexao com o banco de dados: " + e.getMessage());
			}			
		}
	
}
