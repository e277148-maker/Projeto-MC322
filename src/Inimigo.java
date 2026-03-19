// Subclasse para representar um inimigo do jogo, que é um tipo específico de entidade

public class Inimigo extends Entidade{

    private int dano_ataque;

    // Construtor
    public Inimigo(String nome, String descricao, int vida, int escudo, int dano_ataque) {

        super(nome, descricao, vida, escudo);
        this.dano_ataque = dano_ataque;

    }

    // Getters

    public int getAtaque(){
        return dano_ataque;
    }

    // Setters

    public void setAtaque(int ataque){
        this.dano_ataque = ataque;
    }

    void atacar(Heroi nomeHeroi){
        nomeHeroi.receberDano(dano_ataque);
    }

}

