package DAO;

import Modal.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDAO {
    public void criarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuario (nome, cpf, senha) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            // Define os parâmetros
            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getCpf());
            statement.setString(3, usuario.getSenha());

            // Executa o comando
            statement.executeUpdate();

            System.out.println("Usuário criado com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao criar usuário: " + e.getMessage());
        }
    }


}
