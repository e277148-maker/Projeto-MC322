// Superclasse para representar uma entidade genérica no jogo, como um jogador ou um inimigo

public class Entidade {

    // Atributos
    private String nome;
    private String descricao;
    private int vida;
    private int escudo;

    // Construtor
    public Entidade(String nome, String descricao, int vida, int escudo) {

        this.nome = nome;
        this.descricao = descricao;

        this.vida = vida;
        this.escudo = escudo;

    }

    // Getters

    public String getNome(){
        return nome;
    }

    public int getVida(){
        return vida;
    }
    public int getEscudo(){
        return escudo;
    }

    public String getDescricao(){
        return descricao;
    }

    // Setters

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setVida(int vida){
        this.vida = vida;
    }

    public void setEscudo(int escudo){
        this.escudo = escudo;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    // Outros metodos

    void receberDano(int dano){

        int danoReal = dano - escudo;  // Escudo reduz o dano

        if (danoReal < 0) {

            danoReal = 0;  // Não pode ter dano negativo
        }

        escudo = escudo - dano;  // Escudo é consumido

        if (escudo < 0) {

            escudo = 0;

        }

        vida = vida - danoReal;

        if (vida < 0) {

            vida = 0;

        }

    }

    void ganharEscudo(int defesa){
        escudo += defesa;
    }

    boolean estarVivo(){

        if (vida > 0){
            return true;
        }

        else{
            return false;
        }

    }
}
