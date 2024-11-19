import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


public class Login {

    public void login(String login, String senha) {
        String url = "jdbc:postgresql://localhost:5432/Gym01";
        String user = "postgres";
        String password = "5245112";


        // Query SQL para verificar o login e a senha
        String sql = "SELECT * FROM \"Usuario\" WHERE cpf = ? AND senha = ?";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            // Definir parâmetros do PreparedStatement
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, senha);

            // Executar a consulta
            ResultSet resultSet = preparedStatement.executeQuery();

            // Verificar se existe algum resultado
            if (resultSet.next()) {
                System.out.println("Login bem-sucedido! Usuário encontrado.");
            } else {
                System.out.println("Login ou senha incorretos.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao realizar login.");
        }
    }
}