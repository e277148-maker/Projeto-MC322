// Classe abstrata para representar as cartas do jogo

public abstract class Carta {

    private String nome;
    private String descricao;
    private int custo;
    private int efeito;

    // Construtor
    public Carta(String nome, String descricao, int custo, int efeito){

        this.nome = nome;
        this.descricao = descricao;
        this.custo = custo;
        this.efeito = efeito;

    }

    // Getters

    public String getNome(){
        return nome;
    }

    public String getDescricao(){
        return descricao;
    }

    public int getCusto(){
        return custo;
    }

    public int getEfeito(){
        return efeito;
    }

    // Setters

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public void setCusto(int custo){
        this.custo = custo;
    }

    public void setEfeito(int efeito){
        this.efeito = efeito;
    }

    public abstract void usar(Heroi heroi, Inimigo inimigo);

    
}
