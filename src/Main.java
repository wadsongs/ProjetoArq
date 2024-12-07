import DAO.FichaDAO;
import Modal.Ficha;
import SRP.UserProvider;
import SRP.UserRequest;
import SRP.UserService;

public class Main {
    public static void main(String[] args) {

        //Cria um novo usuário
        UserProvider userProvider = new UserProvider();
        UserService userService = new UserService(userProvider);
        UserRequest request = new UserRequest("3455996", "3455996", "Wadson Gurgel");

        try {
            userService.addUser(request);
            System.out.println("Usuario adicionado!");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }

//        Realiza o login do Usuário
        Login loginUser = new Login();
        loginUser.login("3455996", "3455996");

        FichaDAO fichaInst = new FichaDAO();

//        Cadastro Ficha
        fichaInst.cadastrarFicha(new Ficha(1,11));

//        Visualização de Ficha
        fichaInst.buscarFichasPorUsuario(11);

    }
}