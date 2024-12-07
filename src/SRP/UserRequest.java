package SRP;

public class UserRequest {
    private String cpf;
    private String senha;
    private String nome;

    public UserRequest(String cpf, String senha, String nome) {
        this.cpf = cpf;
        this.senha = senha;
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getSenha() {
        return senha;
    }

    public String getNome() {
        return nome;
    }

    public boolean isValid() {
        return cpf != null && !cpf.isEmpty() && senha != null && !senha.isEmpty();
    }
}
