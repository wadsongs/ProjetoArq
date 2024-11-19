package SRP;

import java.sql.*;

public class UserProvider {
    // Dados de conexão
    String url = "jdbc:postgresql://localhost:5432/Gym01";
    String usuario = "postgres";
    String password = "5245112";

    public boolean existsByCpf(String cpf) {
        String query = "SELECT COUNT(*) FROM \"Usuario\" WHERE (cpf) = (?)";
        try (Connection conn = DriverManager.getConnection(url, usuario, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void saveUser(String cpf, String senha) {
        String query = "INSERT INTO \"Usuario\" (cpf, senha) VALUES (?, ?)";
        try (Connection conn = DriverManager.getConnection(url, usuario, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, cpf);
            stmt.setString(2, senha);
            stmt.executeUpdate();
            System.out.println("Usuário salvo com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}