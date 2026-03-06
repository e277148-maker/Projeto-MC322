public class inimigo {
    String nome;
    int vida;
    int escudo;
    
    void receberDano(int dano){
        if (dano > escudo){
            vida = vida - (dano - escudo);
        }
    }
    void atacar(heroi nomeHeroi, int ataque){
        nomeHeroi.receberDano(ataque);
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

