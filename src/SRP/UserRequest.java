package SRP;

public class UserRequest {
    private String cpf;
    private String senha;

    public UserRequest(String cpf, String senha) {
        this.cpf = cpf;
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public String getSenha() {
        return senha;
    }

    public boolean isValid() {
        return cpf != null && !cpf.isEmpty() && senha != null && !senha.isEmpty();
    }
}
