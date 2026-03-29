package efeitos;
import entidades.*;
import batalhas.*;

public class Veneno extends Efeito {

    //Construtor

    public Veneno(String nome, Entidade dono, int acumulo, int efeito, Evento evento, Batalha batalha) {
        super(nome, dono, acumulo, efeito, evento, batalha);
    }
    // Metodos

    @Override
    protected void aplicarEfeito(){
        getDono().receberDano(getEfeito());
    }

    
}
