public class heroi {
    String nome;
    int vida;
    int escudo;
    int energia;
    boolean turno;
    
    void receberDano(int dano){
        if (dano > escudo){
            vida = vida - (dano - escudo);
        }
    }
    void ganharEscudo(int defesa){
        escudo = escudo + defesa;
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