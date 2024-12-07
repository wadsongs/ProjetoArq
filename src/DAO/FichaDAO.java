package DAO;

import Modal.Ficha;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FichaDAO {

    public void cadastrarFicha(Ficha ficha) {
        String sql = "INSERT INTO ficha_usuario (ficha_id, usuario_id) values (?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            // Define os parâmetros
            statement.setInt(1, ficha.getFicha_id());
            statement.setInt(2, ficha.getUsuario_id());


            // Executa o comando
            statement.executeUpdate();

            System.out.println("Ficha inserida com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao inserir ficha: " + e.getMessage());
        }
    }

    public void buscarFichasPorUsuario(int usuario_id) {

        String sql = "SELECT f.nome FROM ficha_usuario fu JOIN ficha f ON fu.ficha_id = f.id WHERE fu.usuario_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            // Define o parâmetro para o ID do usuário
            statement.setInt(1, usuario_id);

            // Executa a consulta
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {

                            String nome = resultSet.getString("nome");
                            System.out.println(nome);
                }
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar fichas: " + e.getMessage());
        }

    }
}
