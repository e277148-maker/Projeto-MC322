public class inimigo extends Entidade{

    private int ataque;

    // Getters

    public int getAtaque(){
        return ataque;
    }

    // Setters

    public void setAtaque(int ataque){
        this.ataque = ataque;
    }
    
    
    void atacar(heroi nomeHeroi){
        nomeHeroi.receberDano(ataque);
    }

}

