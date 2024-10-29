import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

    public static Connection connect() {
        Connection connection = null;
        try {
            // Informações da conexão
            String url = "jdbc:postgresql://localhost:5432/Gym01"; // URL de conexão
            String user = "postgres";  // Nome de usuário do PostgreSQL
            String password = "5245112";  // Senha do usuário

            // Estabelece a conexão com o banco de dados
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão estabelecida com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o PostgreSQL: " + e.getMessage());
        }
        return connection;
    }

    public static void main(String[] args) {
        // Testa a conexão
        Connection conn = connect();
        if (conn != null) {
            try {
                conn.close();  // Fecha a conexão
                System.out.println("Conexão fechada.");
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
    }
}
