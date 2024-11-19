package SRP;

public class UserService {
    private final UserProvider userProvider;

    public UserService(UserProvider userProvider) {
        this.userProvider = userProvider;
    }

    public void addUser(UserRequest request) {
        if (!request.isValid()) {
            throw new IllegalArgumentException("Dados do usuário são inválidos.");
        }

        // Verifica se o e-mail já existe no banco
        if (userProvider.existsByCpf(request.getCpf())) {
            throw new IllegalArgumentException("Cpf já está em uso.");
        }

        // Salva o usuário no banco
        userProvider.saveUser(request.getCpf(), request.getSenha());
    }
}
