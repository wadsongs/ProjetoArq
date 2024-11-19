import DAO.AlunoDAO;
import DAO.Cadastro;
import DAO.FuncionarioDAO;
import Modal.Aluno;
import SRP.UserProvider;
import SRP.UserRequest;
import SRP.UserService;

public class Main {
    public static void main(String[] args) {
//        Login login = new Login();
//
//        login.login("000", "11111");

        UserProvider userProvider = new UserProvider();
        UserService userService = new UserService(userProvider);
        UserRequest request = new UserRequest("3333", "3333");

        try {
            userService.addUser(request);
            System.out.println("Usuario adicionado!");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}