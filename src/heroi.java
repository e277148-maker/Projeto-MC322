public class heroi {

    String nome;

    int vida;
    int escudo;
    int energia;

    boolean turno;

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
    void perderEnergia(int gasto){
        energia = energia - gasto;
    }
}