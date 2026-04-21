package projeto;

public class Usuario {
    // Atributos que o professor pediu
    public String nome;
    public String cpf;
    public String cargo;
    public String perfil; // administrador, gerente ou colaborador
    public String login;
    public String senha;

    // Construtor: serve para criar o usuario com os dados principais ja preenchidos
    public Usuario(String nome, String cpf, String perfil) {
        this.nome = nome;
        this.cpf = cpf;
        this.perfil = perfil;
        // Valores padrao para o resto para nao dar erro
        this.cargo = "Funcionario";
        this.login = "user";
        this.senha = "123";
    }
}
