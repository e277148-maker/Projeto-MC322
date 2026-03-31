package efeitos;

import batalhas.Batalha;
import batalhas.Evento;
import entidades.Entidade;

public class Cura extends Efeito {

    public Cura(String nome, Entidade dono, int acumulo, int efeito, Evento evento, Batalha batalha) {
        super(nome, dono, acumulo, efeito, evento, batalha);
    }

    @Override
    protected void aplicarEfeito(){
        int vidaDono = getDono().getVida();
        if (vidaDono < getDono().getVidaMaxima() - getEfeito()){
            getDono().setVida(vidaDono + getEfeito());        
        }
        else{
            getDono().setVida(getDono().getVidaMaxima());
        }
        
    }
    
}
