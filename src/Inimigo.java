public class Inimigo {

    String nome;

    int vida;
    int escudo;
    int ataque;
    
    void receberDano(int dano){

        int danoReal = dano - escudo;

        if (danoReal < 0) {

            danoReal = 0;
        }

        escudo = escudo - dano;

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


    void atacar(Heroi nomeHeroi){
        nomeHeroi.receberDano(ataque);
    }

    boolean estarVivo(){

        if (vida > 0){

            return true;

        } else {

            return false;

        }
    }
}

