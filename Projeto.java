package projeto;

public class Projeto {
    public String nomeProjeto;
    public String descricao;
    public String dataInicio;
    public String dataFim;
    public String status; // planejado, em andamento, concluido
    public projeto.Usuario gerente; // Aqui guardamos o objeto do gerente

    public Projeto(String nome, projeto.Usuario gerenteResponsavel) {
        this.nomeProjeto = nome;
        this.gerente = gerenteResponsavel;
        this.status = "Planejado"; // Todo projeto comeca assim
        this.descricao = "Sem descricao ainda";
        this.dataInicio = "01/01/2026";
        this.dataFim = "31/12/2026";
    }
}
