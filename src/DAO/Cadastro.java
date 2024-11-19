package DAO;

import java.sql.*;

public class Cadastro{

    public void newUser (String newcpf, String newsenha) {
        // Dados de conexão
        String url = "jdbc:postgresql://localhost:5432/Gym01";
        String usuario = "postgres";
        String senha = "5245112";

        // Query SQL para inserir o usuário
        String sql = "INSERT INTO \"Modal.Usuario\" (cpf, senha) VALUES ( ?, ?)";

        // Conexão e execução do INSERT
        try (Connection conexao = DriverManager.getConnection(url, usuario, senha);
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            // Substitui os placeholders (?) com os valores do usuário
            stmt.setString(1, newcpf);
            stmt.setString(2, newsenha);


            // Executa o comando SQL
            int linhasAfetadas = stmt.executeUpdate();
            System.out.println("Usuário inserido com sucesso! Linhas afetadas: " + linhasAfetadas);

        } catch (SQLException e) {
            System.out.println("Erro ao inserir usuário no banco de dados.");
            e.printStackTrace();
        }
    }
}
