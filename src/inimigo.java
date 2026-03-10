public class inimigo {
    String nome;
    int vida;
    int escudo;
    int ataque;
    
    void receberDano(int dano){
        if (dano > escudo){
            vida = vida - (dano - escudo);
        }
    }
    void atacar(heroi nomeHeroi){
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

